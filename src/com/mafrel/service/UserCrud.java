package com.mafrel.service;
import java.util.ArrayList;

import com.mafrel.model.*;

public interface UserCrud {
	
	User addUser(User u);
	void deleteUser(int id);
	void updateUser(int id);
	ArrayList<User> listAllUsers();
	User findUserById(int id);
}
