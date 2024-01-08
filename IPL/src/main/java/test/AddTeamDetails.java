package test;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;
import pojos.Team;

import static utils.HibernateUtils.getFactory;
public class AddTeamDetails {

	public static void main(String[] args) {
		try(SessionFactory sf= getFactory()) {
				//create dao instance
			TeamDaoImpl dao = new TeamDaoImpl();
			//String name, String abbreviation, String owner, int maxAge, double battingAvg, int wicketTaken
			Team team=new Team("Mumbai Indian","MM",19,78.2,10);
			System.out.println("Team ID : " + dao.addTeamDetails(team));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
