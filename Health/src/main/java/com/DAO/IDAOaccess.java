package com.DAO;

import com.DTO.User;

public interface IDAOaccess {
	public boolean userRegister(); 

	public boolean userLogin();			

	public boolean forgotPass();

	public boolean changePass(String userId);
	
	public boolean updateProfile(String userId);
	
	public boolean register(String key, User u);
	public boolean viewProfile(String userId);
	

}
