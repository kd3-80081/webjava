package test;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.app.dao.OwnerDao;
import com.app.dao.OwnerDaoImpl;
import com.app.dao.PlayerDaoImpl;

import pojos.Owner;

public class AddOwner {

	public static void main(String[] args) {
		try(SessionFactory sf= getFactory()) {
			//create dao instance
		Owner owner=new Owner("Naveen","Kumar","naveen@xyz.com");
		OwnerDao oDao=new OwnerDaoImpl();
		System.out.println(oDao.addOwner(owner));
			
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
