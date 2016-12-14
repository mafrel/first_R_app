package com.mafrel.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mafrel.model.User;
import com.mafrel.service.UserCrud;
import com.mafrel.service.UserCrudImpl;

@Path("/UserService/users")
public class UserController {
	
	
	UserCrud us=new UserCrudImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> listUsers(){		
		return us.listAllUsers();
	}
	
	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User findUserById(@PathParam("userid") int id){
		System.out.println(id);
		User u= us.findUserById(id);
		return u;
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User u){
		us.addUser(u);
		return u;
	}
	
	@DELETE
	@Path("/{userid}")
	public void deleteUser(@PathParam("userid") int uid){
		System.out.println("path param="+uid);
		us.deleteUser(uid);		
	}
	
	@PUT
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("userid") int uid, User u){
		us.updateUser(uid, u);
		u.setId(uid);
		return u;
	}
}
