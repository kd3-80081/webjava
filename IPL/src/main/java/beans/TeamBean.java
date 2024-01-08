package beans;

import java.util.List;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;

import pojos.Team;

public class TeamBean {
	//dependency
	private TeamDao teamDao;
	
	public TeamBean() {
		teamDao=new TeamDaoImpl();
		System.out.println("Team bean and Dao created");
	}

	//List<Team> list =new ArrayList<Team>();

		
	public List<Team> displayTeamAbbreviation() {
		List<Team> list =teamDao.getTeamIdAndAbbreviation();
		System.out.println(list);
		return list;
	}
	
	
	

}
