package com.Service;

import com.DTO.User;

public interface IService {
	public boolean register(String key,User u);
	
		public boolean userRegister(); 

		public boolean userLogin();			

		public boolean forgotPass();

		public boolean changePass(String userId);
		
		public boolean updateProfile(String userId);
		
		
		public boolean viewProfile(String userId);
		

}
