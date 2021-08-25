package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.Contact;

public interface ContactDAO {
	boolean saveContact(Contact contact);
	
	Contact getContactById(int id);

	List<Contact> findAll();

	boolean deleteContact(int id);
}
