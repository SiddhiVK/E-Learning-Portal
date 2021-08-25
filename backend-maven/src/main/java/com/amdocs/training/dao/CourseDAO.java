package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Course;

public interface CourseDAO {
	boolean saveCourse(Course course);
	
	Course getCourseById(int i);

	List<Course> findAll();

	boolean deleteCourse(int i);

	boolean updateCourse(Course course);
}
