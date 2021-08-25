package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.CourseDAO;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Course;

public class CourseDAOImpl implements CourseDAO {

	DataSource dataSource = DataSourceUtil.dataSource();
	public boolean saveCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setObject(1, course.getCourse_id());
			ps.setString(2, course.getCourse_name());
			ps.setInt(3, course.getCourse_fees());
			ps.setString(4, course.getCourse_desc());
			ps.setString(5, course.getCourse_resource());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Course getCourseById(int id) {

		Course course = new Course();
		String query = "select * from course where course_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				course.setCourse_id(rs.getInt(1));
				course.setCourse_name(rs.getString(2));
				course.setCourse_fees(rs.getInt(3));
				course.setCourse_desc(rs.getString(4));
				course.setCourse_resource(rs.getString(5));
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Course> findAll() {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Course course = new Course();
				course.setCourse_id(rs.getInt(1));
				course.setCourse_name(rs.getString(2));
				course.setCourse_fees(rs.getInt(3));
				course.setCourse_desc(rs.getString(4));
				course.setCourse_resource(rs.getString(5));
				list.add(course);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateCourse(Course course) {
		String query = "update course set course_name = ?,course_fees=?,course_desc=?,course_resource=? where course_id=?";
		
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, course.getCourse_name());
			ps.setInt(2, course.getCourse_fees());
			ps.setString(3, course.getCourse_desc());
			ps.setString(4, course.getCourse_resource());
			ps.setObject(5, course.getCourse_id());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteCourse(int id) {

		String query = "delete from course where course_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			System.out.println(rs);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
