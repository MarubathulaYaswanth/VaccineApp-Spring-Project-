package com.tap.vaccine.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccine.entity.MemberEntity;

@Component
public class AddMemberDAOImpl implements AddMemberDAO{
	
	private SessionFactory sessionfactory;
	
	@Autowired
	public AddMemberDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public boolean saveMember(MemberEntity entity) {
		System.out.println("save member");
		Session session=null;
		Transaction transaction=null;
		boolean isDataValid=false;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.save(entity);
			transaction.commit();
			isDataValid=true;
		}
		catch(HibernateException exception) {
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isDataValid;
	}

	@Override
	public List<MemberEntity> getMemberData(String email) {
		Session session=null;
		String hql="from MemberEntity where refEmail=:email";
		try {
			session=sessionfactory.openSession();
			Query<MemberEntity> query=session.createQuery(hql);
			query.setParameter("email", email);
			List<MemberEntity> resultList=query.getResultList();
			return resultList;
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public int updateMemberCount(String refemail,int membercount) {
		System.out.println("update membercount");
		Session session=null;
		Transaction transaction=null;
		String hql="update RegisterEntity set memberCount=:membercount where email=:refemail";
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("membercount", membercount+1);
			query.setParameter("refemail", refemail);
			int i=query.executeUpdate();
			transaction.commit();
			return i;
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public MemberEntity getMemberData(int id) {
		Session session=null;
		try {
			session=sessionfactory.openSession();
			MemberEntity entity=session.get(MemberEntity.class, id);
			return entity;
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public boolean editMember(MemberEntity entity) {
		System.out.println("Edit dao");
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return true;
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public boolean deleteMember(MemberEntity entity) {
		Session session=null;
		Transaction transaction=null;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
			return true;
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public int decreseMemberCount(String refemail, int memberCount) {
		System.out.println("update membercount");
		Session session=null;
		Transaction transaction=null;
		String hql="update RegisterEntity set memberCount=:membercount where email=:refemail";
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter("membercount", memberCount-1);
			query.setParameter("refemail", refemail);
			int i=query.executeUpdate();
			transaction.commit();
			return i;
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

}
