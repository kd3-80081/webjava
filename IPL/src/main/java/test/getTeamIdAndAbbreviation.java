package test;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;
import pojos.Team;

public class getTeamIdAndAbbreviation {

	public static void main(String[] args) {
		List<Team> list=null;
		try(SessionFactory sf= getFactory()) {
			//create dao instance
		TeamDaoImpl dao = new TeamDaoImpl();
			list=dao.getTeamIdAndAbbreviation();
			list.forEach(System.out::println);
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
