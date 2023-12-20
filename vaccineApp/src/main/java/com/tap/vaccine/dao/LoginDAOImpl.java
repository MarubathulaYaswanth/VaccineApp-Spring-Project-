package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {
	
	private SessionFactory sessionfactory;
	
	@Autowired
	public LoginDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) {
		System.out.println("login by email");
		Session session=null;
		RegisterEntity entity=null;
		String hql="from RegisterEntity r where r.email='"+email+"'";
		try {
			session=sessionfactory.openSession();
			Query<RegisterEntity> query=session.createQuery(hql);
			entity=(RegisterEntity) query.uniqueResult();
			if(entity!=null) {
				return entity;
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public int updateLoginAttempt(String email,int loginAttempt) {
		Transaction transaction = null;
		Session session=null;
		int i=0;
		String hql="update RegisterEntity set loginAttempt=:login where email=:email";
		try {
			System.out.println("sessionlogin opened");
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("login",loginAttempt+1);
			query.setParameter("email", email);
			i=query.executeUpdate();
			transaction.commit();
			System.out.println("sessionlogin close");
			return i;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			transaction.rollback();
			return i;
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}

}
