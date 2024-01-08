package com.app.dao;

import pojos.Owner;
import pojos.Team;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		String mesg = "Adding team failed";
		// 1.Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		// 3. try-save team details, commit,
		// catch: runtime exc: rollback tx, throws e
		try {
			Serializable teamId = session.save(newTeam);
			tx.commit();
			mesg = "Adding team details with ID : " + teamId;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

		return mesg;
	}

	@Override
	public String addTeamDetailsWithOwner(String email) {

		String mesg = "Adding team failed";
		String jpql = "select o from Owner o where o.email =:email";

		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			Owner owner=session.createQuery(jpql,Owner.class).setParameter("email", email).getSingleResult();
			System.out.println("Enter the details of team as String name, String abbreviation, Owner teamOwner, int maxAge, double battingAvg, int wicketsTaken");
			Scanner sc = new Scanner(System.in);
			Team team=new Team(sc.next(),sc.next(),owner,sc.nextInt(),sc.nextDouble(),sc.nextInt());
			Serializable teamId = session.save(team);
			tx.commit();
			mesg = "Adding team details with ID : " + teamId;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;

		}

		return mesg;
	}

	@Override
	public String updateAgeAndAvgByName(String name, int age, double avg) {
		String msg;
		String jpql = "select t from Team t where t.name =:name";
		Session session = getFactory().getCurrentSession();
		// Begin a transaction
		Transaction tx = session.beginTransaction();

		Team team = null;
		try {
			team = session.createQuery(jpql, Team.class).setParameter("name", name).getSingleResult();
			team.setMaxAge(age);
			team.setBattingAvg(avg);
			tx.commit();
			msg = "Updated details with Name= " + name;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getTeamIdAndAbbreviation() {
		List<Team> list;// data doesn't exist
		String jpql = "select new pojos.Team(id,abbreviation) from Team t";
		// Get session from Session factory
		Session session = getFactory().getCurrentSession();

		// Begin a transaction
		Transaction tx = session.beginTransaction();

		try {
			list = session.createQuery(jpql, Team.class).getResultList();
			// list: List of PERSISTENT entities
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return list;
	}

	@Override
	public Team getTeamById(Integer id) {
		Team team = null;// Data doesn't exist as of now

		// Get session from session factory
		Session session = getFactory().getCurrentSession();
		// Begin a transaction
		Transaction tx = session.beginTransaction();

		try {
			//
			team = session.get(Team.class, id);// up casting
			// in case of valid id, team : PERSISTENT, part of L1 cache, exist in DB

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return team;
	}

	@Override
	public List<Team> getTeamByAgeAndWickets(int age, int wicket) {
		List<Team> list = null;

		String jpql = "select t from Team t where t.maxAge < :age and t.wicketTaken > :wicket";

		// Get session from session factory
		Session session = getFactory().getCurrentSession();
		// Begin a transaction
		Transaction tx = session.beginTransaction();

		try {

			list = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("wicket", wicket)
					.getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return list;
	}

	@Override
	public String deleteById(Integer id) {
		String msg = "";

		Session session = getFactory().getCurrentSession();
		// Begin a transaction
		Transaction tx = session.beginTransaction();

		Team team = null;
		try {
			team = session.get(Team.class, id);
			if (team != null) {
				session.delete(team);
				msg = "Deleted Team details of :" + team.getName();
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

}
