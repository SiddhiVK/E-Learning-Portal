package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.FeedbackDAO;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Feedback;
public class FeedbackDAOImpl implements FeedbackDAO {

	DataSource dataSource = DataSourceUtil.dataSource();
	public boolean saveFeedback(Feedback feedback) {
		String query = "insert into feedback values(?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, feedback.getUser_id());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setObject(4, feedback.getFeedback_id());
			ps.setString(5, feedback.getFeedback());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Feedback getFeedbackById(int id) {

		Feedback feedback = new Feedback();
		String query = "select * from feedback where f_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				feedback.setFeedback_id(rs.getInt(1));
				feedback.setUser_id(rs.getInt(2));
				feedback.setName(rs.getString(3));
				feedback.setEmail(rs.getString(4));
				feedback.setFeedback(rs.getString(5));
				return feedback;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Feedback> findAll() {
		List<Feedback> list = new ArrayList<Feedback>();
		String sql = "select * from feedback";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Feedback feedback = new Feedback();
				feedback.setUser_id(rs.getInt(1));
				feedback.setName(rs.getString(2));
				feedback.setEmail(rs.getString(3));
				feedback.setFeedback_id(rs.getInt(4));
				feedback.setFeedback(rs.getString(5));
				list.add(feedback);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteFeedback(int id) {

		String query = "delete from feedback where f_id= ?";
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
	public boolean updateFeedback(String s) {
		return false;
	}

}
