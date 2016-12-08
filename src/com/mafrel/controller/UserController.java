package com.mafrel.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mafrel.model.User;
import com.mafrel.service.UserCrud;
import com.mafrel.service.UserCrudImpl;

@Path("/UserService")
public class UserController {
	
	
	UserCrud us=new UserCrudImpl();
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> listUsers(){		
		return us.listAllUsers();
	}
	
	@GET
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findUserById(@PathParam("userid") int id){
		System.out.println(id);
		return us.findUserById(id);
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
