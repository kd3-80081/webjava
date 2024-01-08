package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Owner;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
public class OwnerDaoImpl implements OwnerDao  {

	@Override
	public String addOwner(Owner owner) {
		String mesg="Adding onwer failed!!!!!!!!";

		Session session=getFactory().getCurrentSession();

		Transaction tx=session.beginTransaction();
		try {
			Serializable onwerId= session.save(owner);
			tx.commit();
			mesg = "Adding team details with ID : " + onwerId;
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
		
	}
	
}
