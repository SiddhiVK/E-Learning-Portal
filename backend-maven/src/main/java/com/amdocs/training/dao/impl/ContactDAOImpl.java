package com.amdocs.training.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.dao.ContactDAO;
import com.amdocs.training.db.DataSourceUtil;
import com.amdocs.training.model.Contact;
public class ContactDAOImpl implements ContactDAO {

	DataSource dataSource = DataSourceUtil.dataSource();
	public boolean saveContact(Contact contact) {
		String query = "insert into contact values(?,?,?,?,?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, contact.getUser_id());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getPhone());
			ps.setString(5, contact.getMessage());
			ps.setObject(6, contact.getContact_id());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Contact getContactById(int id) {

		Contact contact = new Contact();
		String query = "select * from contact where contact_id= ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				contact.setContact_id(rs.getInt(1));
				contact.setUser_id(rs.getInt(2));
				contact.setName(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setPhone(rs.getLong(5));
				contact.setMessage(rs.getString(6));
				return contact;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Contact> findAll() {
		List<Contact> list = new ArrayList<Contact>();
		String sql = "select * from contact";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Contact contact = new Contact();
				contact.setUser_id(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmail(rs.getString(3));
				contact.setPhone(rs.getLong(4));
				contact.setMessage(rs.getString(5));
				contact.setContact_id(rs.getInt(6));
				list.add(contact);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
