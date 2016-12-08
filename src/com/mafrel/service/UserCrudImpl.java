package com.mafrel.service;

import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mafrel.model.User;

public class UserCrudImpl implements UserCrud {
	
	
	
	

	@Override
	public User addUser(User u) {

		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session session= sf.openSession();
		
		session.save(u);
		session.close();
		
		return u; 
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(int id) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mafrel.service.UserCrud#listAllUsers()
	 */
	@Override
	public ArrayList<User> listAllUsers() {		

		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf= conf.buildSessionFactory();
		Session session= sf.openSession();
		
		String sql= "select {user.*} from user";
		SQLQuery query= session.createSQLQuery(sql);
		query.addEntity("user", User.class);
		ArrayList results=(ArrayList) query.list();
		
		return results;
	}

	@Override
	public User findUserById(int id) {
		
		return null;
	}

}
