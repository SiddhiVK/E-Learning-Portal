package com.amdocs.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;

public class UserDAOJUnitTest {
	static User user = null;
	static UserDAO dao = null;
	
	@BeforeAll
	public static void init() {
		user = new User();
		dao = new UserDAOImpl();
	}
	
	@Test
	public void test_insert_user_success() {
		User u = new User(13,"Rachel",1234,"rachel@fashion.com","Paris","20-8-21","Nooo","hot.jpg");
		assertEquals(true,dao.saveUser(u));
	}
}
