package com.mafrel.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mafrel.model.User;
import com.mafrel.service.UserCrud;
import com.mafrel.service.UserCrudImpl;

@Path("/UserService")
public class UserController {
	
	
	UserCrud us=new UserCrudImpl();
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public void listUsers(){
		
		Configuration conf= new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sf=conf.buildSessionFactory();
		Session session= sf.openSession();
		
		User user=new User();
		
		
		session.save(user);
		
		
		
		/*us.addUser(user);
		return us.listAllUsers();*/
		
	}
	
	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User u){
		us.addUser(u);
		return u;
	}
}
