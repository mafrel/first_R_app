package com.mafrel.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session session=sf.openSession();
		
		Query query=session.createQuery("delete user where id= :id");
		query.setParameter("id", id);
		int result= query.executeUpdate();

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
		
		//String sql= "select * from user";
		Query query= session.createQuery("from user");
		ArrayList results=(ArrayList) query.list();
		return results;
	}

	@Override
	public User findUserById(int id) {
		
		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf= conf.buildSessionFactory();
		Session session=sf.openSession();
		
		Query sql= session.createQuery("from user where id= :id");
		sql.setParameter("id", id);
		User result=(User) sql.list();
		return result;
		
		
	}

}
