package com.mafrel.service;

import java.util.ArrayList;

import com.mafrel.model.User;

public class UserCrudImpl implements UserCrud {

	
	ArrayList<User> user= new ArrayList<User>();
	@Override
	public User addUser(User u) {
		
		
		
		
		User us=new User();
		us.setName(u.getName());
		us.setAddress(u.getAddress());
		us.setAge(u.getAge());		
/*		
		User us2=new User();
		us2.setName("sarjib");
		us2.setAddress("npl");
		us2.setAge(18);		
		user.add(us2);
		
		User us3=new User();
		us3.setName("jack");
		us3.setAddress("hbry");
		us3.setAge(54);		
		user.add(us3);
*/		
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

	@Override
	public ArrayList<User> listAllUsers() {		
		return user;
	}

}
