package com.tap.vaccine.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class RegisterDAOImple implements RegisterDAO {
	
	private SessionFactory sessionfactory;
	private JavaMailSenderImpl javamailsender;
	
	@Autowired
	public RegisterDAOImple(SessionFactory sessionfactory, JavaMailSenderImpl javamailsender) {
		this.sessionfactory = sessionfactory;
		this.javamailsender = javamailsender;
	}


	@Override
	public boolean saveRegisterEntity(RegisterEntity entity) {
		
		Transaction transaction=null;
		Session session=null;
		boolean isDataValid=false;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.save(entity);
			entity.setLoginAttempt(0);
			entity.setMemberCount(0);
			SimpleMailMessage simplemailmessage=new SimpleMailMessage();
			simplemailmessage.setTo(entity.getEmail());
			simplemailmessage.setSubject("vaccineApp Registration Successful");
			simplemailmessage.setText("Register is successful "+entity.getEmail()+" & "+entity.getPassword()+" \nNote:use these credentials login to the app or portal");
			javamailsender.send(simplemailmessage);
			transaction.commit();
			isDataValid=true;
			
		}
		catch(Exception hibernate) {
			transaction.rollback();
			return false;
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isDataValid;
	}

}
