package com.tap.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {
	
	private SessionFactory sessionfactory;
	
	@Autowired
	public ForgotPasswordDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public boolean resetPasswordByEmail(String email, String newpassword) {
		Session session=null;
		Transaction transaction=null;
		String hql="update RegisterEntity set password=:newpassword,loginAttempt="+0+"where email=:email";
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("newpassword", newpassword);
			query.setParameter("email", email);
			int i=query.executeUpdate();
			transaction.commit();
			if(i==1) {
				return true;
			}else {
				return false;
			}
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}

}
