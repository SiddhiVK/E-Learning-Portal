package com.amdocs.training.client;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

public class UserClient {

	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		User user = new User(11, "Chandler Bing", 9586234712L,"bing@chick.com","Next Door","1994-12-21","Janice","img6.jpg");
		if(dao.saveUser(user)) {
		System.out.println("User Added Successfully");
		}
		else {
		System.out.println("Error Cannot Insert");
		}

	}

}
