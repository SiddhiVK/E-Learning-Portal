package com.amdocs.training.client;

import com.amdocs.training.dao.EnrollDAO;
import com.amdocs.training.dao.impl.EnrollDAOImpl;
import com.amdocs.training.model.Enroll;
public class EnrollClient {
public static void main(String[] args) {
	
		EnrollDAO dao = new EnrollDAOImpl();
		Enroll enroll = new Enroll(101,"abc",2,"pqr");
		if(dao.saveEnroll(enroll)) {
			System.out.println("Enrolled Successfully");
		}
		else {
			System.out.println("Error Cannot Enroll");
		}
	}
}