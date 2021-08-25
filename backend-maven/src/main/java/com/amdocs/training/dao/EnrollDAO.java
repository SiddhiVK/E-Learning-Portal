package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Course;
import com.amdocs.training.model.Enroll;

public interface EnrollDAO {
	boolean saveEnroll(Enroll enroll);

	List<Course> getEnrolledCourses(int id);

	List<Enroll> findAll();

	boolean deleteEnroll(int user_id,int course_id);
	
}
