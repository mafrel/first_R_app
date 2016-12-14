package com.mafrel.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mafrel.model.User;

import antlr.collections.List;

public class UserCrudImpl implements UserCrud {

	@Override
	public User addUser(User u) {

		Session session = sessionInfo();
		session.save(u);
		session.close();
		
		return u; 
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionInfo();
		
		session.beginTransaction();
		User u= (User) session.get(User.class, id);
		session.delete(u);
		session.getTransaction().commit();
	}

	private Session sessionInfo() {
		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session session=sf.openSession();
		return session;
	}

	@Override
	public void updateUser(int id, User u) {
		Session session=sessionInfo();
		session.beginTransaction();
		Query query=session.createQuery("update User set name=:name, address=:address, age=:age where id=:id");
		query.setParameter("name", u.getName());
		query.setParameter("address", u.getAddress());
		query.setParameter("age", u.getAge());
		query.setParameter("id", id);
		query.executeUpdate();

	}

	@Override
	public ArrayList<User> listAllUsers() {		

		Session session = sessionInfo();
		
		ArrayList<User> result = (ArrayList<User>)session.createQuery("from User").list();
		session.close();
		return result;
	}

	@Override
	public User findUserById(int id) {
		
		Session session = sessionInfo();
		
		User u=session.get(User.class, id);
		return u;
	}

}
