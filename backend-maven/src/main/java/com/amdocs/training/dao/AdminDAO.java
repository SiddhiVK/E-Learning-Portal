package com.amdocs.training.dao;
import java.util.List;
import com.amdocs.training.model.Admin;

public interface AdminDAO {
	boolean saveAdmin(Admin admin);
	Admin getAdminById(int i);

	List<Admin> findAll();

	boolean deleteAdmin(int i);

	Admin validateAdmin(String username, String password);
}

