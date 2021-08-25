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
import com.amdocs.training.dao.EnrollDAO;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.Enroll;
public class EnrollDAOImpl implements EnrollDAO {

	DataSource dataSource = DataSourceUtil.dataSource();
	public boolean saveEnroll(Enroll enroll) {
		String query = "insert into enroll values(?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setObject(1, enroll.getCourse_id());
			ps.setString(2, enroll.getCourse_name());
			ps.setObject(3, enroll.getUser_id());
			ps.setString(4, enroll.getName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Course> getEnrolledCourses(int id) {
		
		List<Course> list = new ArrayList<Course>();
		CourseDAO c_dao = new CourseDAOImpl();
		String query = "select * from enroll where user_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course = c_dao.getCourseById(rs.getInt(2));
				System.out.println(course+""+rs.getInt(2));
				list.add(course);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Enroll> findAll() {
		List<Enroll> list = new ArrayList<Enroll>();
		String sql = "select * from enroll";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Enroll enroll = new Enroll();
				enroll.setCourse_id(rs.getInt(1));
				enroll.setCourse_name(rs.getString(2));
				enroll.setUser_id(rs.getInt(3));
				enroll.setName(rs.getString(4));
				list.add(enroll);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteEnroll(int user_id, int course_id) {

		String query = "delete from enroll where user_id= ? and course_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);
			ps.setInt(2, course_id);
			int rs = ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}