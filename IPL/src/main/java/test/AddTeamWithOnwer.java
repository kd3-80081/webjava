package test;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;


import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;



public class AddTeamWithOnwer {

	public static void main(String[] args) {
		try(SessionFactory sf= getFactory()) {

			TeamDao tDao=new TeamDaoImpl();
			
		System.out.println(tDao.addTeamDetailsWithOwner("naveen@xyz.com"));
			
	} catch (Exception e) {
		e.printStackTrace();
	}

	}


}
