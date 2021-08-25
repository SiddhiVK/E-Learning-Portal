package com.amdocs.training.client;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.model.Admin;

public class AdminClient {
	public static void main(String[] args) {
		
		AdminDAO dao = new AdminDAOImpl();
		Admin admin = new Admin(101,"admin1", "admin@123", "admin@gmail.com");
		if(dao.saveAdmin(admin)) {
		System.out.println("Admin Added Successfully");
		}
		else {
		System.out.println("Error Cannot Insert");
		}
	}
}
