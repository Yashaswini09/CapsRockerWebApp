package com.caps.services;

import com.caps.beans.User;
import com.caps.dao.UserDAO;
import com.caps.dao.UserDAOJDBCImpl;

public class UserServicesImpl implements UserServices {

	UserDAO dao = new UserDAOJDBCImpl();
	
	@Override
	public boolean createProfile(User user) {
		return dao.createProfile(user);
	}

}
