package com.app.dao;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayerDetails(Integer teamId,Player newPlayer) {
		String msg="Adding Team Failed";
		// 1.Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		// 3. try-save team details, commit,
		// catch: runtime exc: rollback tx, throws e
		try {
			Team team=session.get(Team.class, teamId);
			if(team!=null) {
				team.addPlayer(newPlayer);
				msg = "Adding team details in Team ID : " +team.getName();
			}
			
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}
		return msg;
	}
	
}
