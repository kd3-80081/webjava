package test;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.app.dao.PlayerDaoImpl;


import pojos.Player;

public class AddPlayerDetails {

	public static void main(String[] args) {
		try(SessionFactory sf= getFactory()) {
			//create dao instance
		PlayerDaoImpl dao = new PlayerDaoImpl();
		//Player plyr=new Player("Virat","Kohli","1988-12-12",10.0,10);
		
		//dao.addPlayerDetails(1,plyr);
			
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
