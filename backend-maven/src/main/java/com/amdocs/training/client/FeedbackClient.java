package com.amdocs.training.client;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.dao.impl.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;

public class FeedbackClient {

	public static void main(String[] args) {
		FeedbackDAO dao = new FeedbackDAOImpl();
		Feedback feedback = new Feedback(101,"ankit","ankit@gmail.com",1,"good");
		if(dao.saveFeedback(feedback)) {
		System.out.println("Feedback Added Successfully");
		}
		else {
		System.out.println("Error Cannot Insert");
		}

	}

}
