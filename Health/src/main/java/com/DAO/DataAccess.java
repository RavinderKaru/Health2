package com.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DTO.CollectionUtil;
import com.DTO.User;
import com.Service.Validation;

public class DataAccess  {
	
	User u;

	Scanner sc = new Scanner(System.in);

	public boolean register(String key, User u) {
		
		CollectionUtil.user.put(key, u);
		
		if (CollectionUtil.user.get(key).getUserName() != null)
			
			return true;
		return false;
	}

	public boolean userRegister() {
		System.out.println("----REGISTRATION MODULE----");
		boolean g = false;
		long count = 0;//UserID KEY
		while (true) {
		
			System.out.println("Enter Your Name");

			String uname = sc.next();

			boolean checkuname = Validation.validateUname(uname);

			if (checkuname) {

				while(true) {
					
					System.out.println("Enter Your Email");
					
					String uemail = sc.next();
					
					boolean checkemail = Validation.validateEmail(uemail);// validating Email
					
					if (checkemail) {
					
						while(true) {
					
							System.out.println("Enter Password");
					
							String upass = sc.next();
					
							boolean checkpass = Validation.validatePass(upass);// validating password
					
							if (checkpass) {
						
								while(true) {
						
							
									System.out.println("Cofirm Password");
						
									String confirmPass = sc.next();
									
									if (confirmPass.equals(upass)) {
							
							
										while(true) {
							
								
											System.out.println("Enter  Phone Number");
							
								
											String upNumber = sc.next();
							
								
											boolean checkPn = Validation.validatePhoneN(upNumber);// validating phone number
							
											if (checkPn) {
								
												while(true) {
								
													System.out.println("Enter your NICK/favourite sports name");
								
													String sec = sc.next();
								
													boolean checksec = Validation.validateSec(sec);
								
													if (checksec) {
									
														while(true) {
									
															System.out.println("Select GENDER\n 1.Male\n 2.Female ");
									
															String ug = sc.next();
									
															BigInteger b = BigInteger.valueOf(Long.parseLong(upNumber));
									

									
															String key = "U" + (++count);
									
															if (ug.equals("1")) {
										
																u = new User(key, uname, upass, uemail, b, "USER", sec, "Male");
										
																register(key, u);
										
																System.out.println(" You are successfully registered");
										
																System.out.println("You are redirected to LOGIN PAGE");
										
																return userLogin();																							
															
															} else if (ug.equals("2")) {										
															
																u = new User(key, uname, upass, uemail, b, "USER", sec, "FeMale");										
																
																register(key, u);
																
																System.out.println(" You are successfully registered");
																
																System.out.println("You are redirected to LOGIN PAGE");
																
																return userLogin();
															
															} 
															
															else {
															
																System.out.println("Wrong input");
															
															}
														} 
													}else {
									
														System.out.println(" please enter valid answer");
								
													}
												} 
											}
											else {
												System.out.println(" please  enter Valid phone Number");
											}
										} 
					
									}else {
							
										System.out.println("Password not Matched");	
									}
								}
					
							}else {
						
								System.out.println(" Enter valid Password to meet criteria");
							}
						}
					}
					else {
					
						System.out.println("please enter valid EMAIL");
					}
				}
			}		
			else {
				
				System.out.println("Enter valid Username");

			}
			 
			return g;}
		
	}

	public boolean userLogin() {
		
		System.out.println("----LOGIN MODULE----");
		
		boolean g = false;
		
		System.out.println("NOTE:ENTER 1. to LOG IN ADMIN\n ENTER 2. Forget Password");
		
		String ch=sc.next();
		
		if(ch.equals("2"))
		{
			forgotPass();
		}
		while(true)
			{
			System.out.println("Enter Email");
		
			String uemail = sc.next();
		
			System.out.println("Enter Password");
		
			String upass = sc.next();
					
			for (User u : CollectionUtil.user.values()) {
			
				if (u.getUserEmail().equals(uemail)) {
				
				
					if (u.getUserPassword().equals( upass)) {

					
						if (u.getUserRole().equals("USER")) {
						
							System.out.println("You are successfully Logged In");
						
							System.out.println("MAKE APPOINTMENT");
						
							System.out.println("CHECK APPOITMENT STATUS");
												
							g = modules(u.getUserId());
						
							return g;
					
						} else if (u.getUserRole().equals("ADMIN") && ch.equals("1")) {
						
							System.out.println("ADMIN logged In");
						
							System.out.println("-----------------");
						
							System.out.println("Add Center");
						
							System.out.println("Remove Center");
						
							System.out.println("Add Test");
						
							System.out.println("Remove Test");
						
						
							g =modules(u.getUserId());
						
							return g;
					
						}
				
					} 
							
					else {
					
						System.out.println("Please Enter valid password");
				
					}
			
				} else {
				
					System.out.println("Email does not exists enter again ");
			
				}

		
			
			
				return g;}}
		//
	
	}

	public boolean forgotPass() {
		
		System.out.println("--------FORGOT PASSWORD-------");
		
		boolean g = false;
		
		while(true)
		{
		
			System.out.println(" Enter your  Registered Email");
		
			String uemail = sc.next();
		
		
			for (User u : CollectionUtil.user.values()) {
			
				if (uemail.equals(u.getUserEmail())) {
				
					while(true)
				
					{
					
					
						System.out.println("Enter your nick/favourite Sports name");
					
						String usec = sc.next();
				
						if (usec.equals(u.getUserSec())) {
					
							g = newPass(u.getUserId());
					
							return g;
				
						} else {
					
							System.out.println("Your security answer is wrong ");
					
							return g;
				
						}
			
					} }else {
				
						System.out.println("EMAIL does not exists");
				
						return g;
			
					}
		
			}
		
		
		}


	}

	public boolean changePass(String userId) {
		
		System.out.println("------CHANGE PASSWORD----");
		
		boolean g = false;
		
		User us=CollectionUtil.getDetails().get(userId);
		
		if(us!=null)//UNIT TESTING
		
		{
		
			while(true)
		{
		
				System.out.println("Enter old PASSWORD");
		
				String userOpass = sc.next();
		
				if (userOpass.equals(CollectionUtil.user.get(userId).getUserPassword())) {
		
					return newPass(userId);	
		
				}else {
			
					System.out.println("Old password is wrong");
		
				}
		
				return g;}
		
		}
		
		return g;
		
		//return false;}
	
	}
	
	public boolean newPass(String userId)
	
	{
		
		System.out.println("------NEW PASSWORD---");boolean b=false;
	
		User us=CollectionUtil.getDetails().get(userId);
	
		if(us!=null)//UNIT TESTING
	
		{
		
			while(true)
		
			{
		
				System.out.println("Enter New PASSWORD");
		
				String userNpass = sc.next();
		
				boolean checkpass = Validation.validatePass(userNpass);
		
				if (checkpass) {
			
					while(true) {
			
						System.out.println("Confirm PASSWORD");
			
						String userCpass = sc.next();
			
						if (userCpass.equals(userNpass)) {
				
							CollectionUtil.user.get(userId).setUserPassword(userNpass);
				
							System.out.println("Your PAssword changed Successfully");
				
							b=userLogin();
				
							return b;
				
			
						} else {
				
							System.out.println(" new and confirm password should be same");
				
							return b;
			
						}}
		
				} else {
			
					System.out.println("Enter valid password to meet criteria");
			
					return b;
		
				}
	
		
			}
	
		}
	
		return b;
	
	}

	public boolean updateProfile(String userId) {
		
		
		System.out.println("----UPDATE PROFILE-----");
		
		boolean b=false;
		
		User us=CollectionUtil.getDetails().get(userId);
		
		if(us!=null)
		
		{
		
			System.out.println("enter 1. to update your Email");
		
			System.out.println("enter 2. to upadte your phone number");
		
			System.out.println("enter 3. to update your Security Answer");
		
			String up = sc.next();
		
		
			switch (up) {
		
			case "1":
			
				System.out.println("Enter your new Email");
			
				String newEmail = sc.next();
			
				boolean checkE = Validation.validateEmail(newEmail);
			
				if (checkE) {

				
					CollectionUtil.user.get(userId).setUserEmail(newEmail);
				
					System.out.println("EMAIL Updated successfully");
				
					b=true;
			
				}

			
				break;
		
			case "2":
			
				System.out.println("enter your new phone number");
			
				String newph = sc.next();
			
				boolean checkP = Validation.validatePhoneN(newph);
			
				if (checkP) {
				
					CollectionUtil.user.get(userId).setUserContact(BigInteger.valueOf(Long.parseLong(newph)));
				
					System.out.println("Phone Number updated successfully");
				
					b= true;
			
				} else {
				
					System.out.println("Not valid Enter again");
			
				}
			
				break;
		
			case "3":
			
				System.out.println("enter your NEW NICK/favourite Sports name");
			
				String newsec = sc.next();
			
				boolean checkS = Validation.validateSec(newsec);
			
				if (checkS) {
				
					CollectionUtil.user.get(userId).setUserSec(newsec);
				
					System.out.println("Your response has been Updated");
				
					b= true;
			
				} else {
				
					System.out.println("Not valid Enter again");
			
				}
			
				break;
		
			default:
			
				System.out.println("please select valid input");

			
				break;
		
			}
		
		}
		
		return b;

	}

	public boolean modules(String userId) {
		
		boolean b=false;
		
		User us=CollectionUtil.getDetails().get(userId);
		
		
		if(us!=null)		
		
		{
			System.out.println("Enter 1. to CHANGE PASSWORD");
		
			System.out.println("Enter 2. to Update Profile");
		
			System.out.println("Enter 3. to View Profile");
		
			System.out.println("Enter 4. to LOGOUT");
		
			String choice = sc.next();
		
			switch (choice) {
		
			case "1":
			 
				b=changePass(userId);
			
				break;
		
			case "2":
			
				b= updateProfile(userId);
			
				break;
		
			case "3":
			
				b=viewProfile(userId);
			
				break;
		
			case "4":
			
				System.out.println("You are successfully LOGGED OUT");
			
				b=true;
			
				//System.exit(0); 
			
				break;
		
			default:
			
				System.out.println("Please enter valid Input");
			
				b=false;
			
				break;
		
			}
	}
		
		return b;}

	public boolean viewProfile(String userId) {
		
		System.out.println("----VIEW PROFILE------");
		
		boolean b=false;
		
			
		System.out.println("Your DETAILS");
		
		User user = CollectionUtil.getDetails().get(userId);
		
		if(user!=null)
			{
			System.out.println("ID   : " + user.getUserId());
			
			System.out.println("NAME : " + user.getUserName());
			
			System.out.println("EMAIL: " + user.getUserEmail());
			
			System.out.println("phone Number : " + user.getUserContact());
			
			System.out.println("Role :" + user.getUserRole());
			
			System.out.println("Gender :" + user.getUserGender());
			
			b=true;
			
			return b;
			}
		return b;
	}
}
