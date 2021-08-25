package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.User;

public interface UserDAO {
	boolean saveUser(User user);

	User getUserById(int id);

	List<User> findAll();

	boolean deleteUser(int id);
	
	User validateUser(String username, String password);

	boolean updateUser(User user);
}
