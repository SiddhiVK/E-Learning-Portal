package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Admin;
public class AdminDAOImpl implements AdminDAO {
	
	DataSource dataSource = DataSourceUtil.dataSource();
	public boolean saveAdmin(Admin admin) {
		String query = "insert into admin values(?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setObject(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Admin getAdminById(int id) {

		String query = "select * from admin where admin_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmail(rs.getString(4));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmail(rs.getString(4));
				list.add(admin);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteAdmin(int id) {

		String query = "delete from admin where admin_id= ?";
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
	public boolean updateAdmin(String s) {
		return false;
	}

	public Admin validateAdmin(String username, String password) {
		Admin admin = new Admin();
		String query = "select * from admin where name= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setEmail(rs.getString(3));
				admin.setPassword(rs.getString(4));
				System.out.println("pass:"+rs.getString(4));
				if(password.equals(admin.getPassword())) {
					System.out.println("Valid!");
					return admin;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
