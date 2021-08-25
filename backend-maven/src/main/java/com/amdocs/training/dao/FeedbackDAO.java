package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Feedback;

public interface FeedbackDAO {
	boolean saveFeedback(Feedback feedback);

	List<Feedback> findAll();

}
