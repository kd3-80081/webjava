package beans;

import java.time.LocalDate;
import java.time.Period;

import com.app.dao.PlayerDaoImpl;
import com.app.dao.TeamDaoImpl;

import pojos.Player;
import pojos.Team;

public class PlayerBean {
	private String firstName;
	private String lastName;
	private String dob;
	private double battingAvg;
	private int wicketsTaken;
	private int myTeam;
	private PlayerDaoImpl pDao;
	private TeamDaoImpl tDao;
	private Team team;
	
	public PlayerBean() {
		pDao=new PlayerDaoImpl();
		tDao=new TeamDaoImpl();
	}

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public double getBattingAvg() {
		return battingAvg;
	}



	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}



	public int getWicketsTaken() {
		return wicketsTaken;
	}



	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}



	public Integer getMyTeam() {
		return myTeam;
	}



	public void setMyTeam(Integer myTeam) {
		this.myTeam = myTeam;
	}



	public PlayerDaoImpl getpDao() {
		return pDao;
	}



	public void setpDao(PlayerDaoImpl pDao) {
		this.pDao = pDao;
	}



	public TeamDaoImpl gettDao() {
		return tDao;
	}



	public void settDao(TeamDaoImpl tDao) {
		this.tDao = tDao;
	}



	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}



	//String firstName, String lastName, String dob, double battingAvg, int wicketsTaken
	public String addPlayer() {
		Player plyr=new Player(firstName,lastName,LocalDate.parse(dob),battingAvg,wicketsTaken);
		team=tDao.getTeamById(myTeam);
		int age= Period.between(plyr.getDob(), LocalDate.now()).getYears();
		
		
		if(plyr.getBattingAvg()<team.getBattingAvg() || plyr.getWicketsTaken()<team.getWicketsTaken() || age>team.getMaxAge()) {
			return "Player Not Eligible To Be In Team";
		}
		
			return pDao.addPlayerDetails(myTeam, plyr);

	}
}
