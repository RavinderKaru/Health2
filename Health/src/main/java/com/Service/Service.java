package com.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import com.DAO.DataAccess;
import com.DTO.CollectionUtil;
import com.DTO.User;

public class Service implements IService {
	Scanner sc = new Scanner(System.in);
	DataAccess d = new DataAccess();
	User u;
public boolean register(String key,User u)
{
	return d.register(key, u);
}
	public boolean userRegister() {//Registration details
			return d.userRegister();}

	public boolean userLogin() {
		return d.userLogin();
		
			}

	public boolean forgotPass() {
		return d.forgotPass();
			}

	public boolean changePass(String userId) {
		return d.changePass(userId);
			}
	
	public boolean updateProfile(String userId)
	{return d.updateProfile(userId);
		}
	
	
	public boolean viewProfile(String userId)
	{
	return d.viewProfile(userId);
	}
	
}




