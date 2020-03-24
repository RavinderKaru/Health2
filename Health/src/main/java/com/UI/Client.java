package com.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Service.Service;
import com.Service.Validation;

import Exception.UserException;

public class Client {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			
			Service ser=new Service();
			
			while(true) {
				
				System.out.println("*********WELCOME TO HEALTH CARE SYSTEM*********");
				
				System.out.println("==============MENU====================");
		        
				System.out.println("1. Sign Up ");
		        
				System.out.println("2. Sign In(Already Created Account)");
		        
				System.out.println("3. EXIT");
		        
				System.out.println("Enter your choice");
		 
		        String ch=sc.next();
		        
		        try
		        
		        {
		        	if(!ch.matches("[0-9]*"))
		        	{
		        		throw  new UserException();
		        	}
		        }
		        
		        catch (UserException e) 
		        {
		        	System.out.println(e.toString());
				}
		        
			
			 
					switch (ch) {
					
					case "1":
					
						System.out.println("Welcome  USER Please fill your details");
						
						ser.userRegister();
						
						break;
					case "2":
							
						ser.userLogin();
		                
						break;
					case "3":
						
						System.out.println("your successfully LOGGED OUT");
						
						ser.userLogin();
						
						break;
		            default:
		            	  
		            	System.out.println("Invalid choice and enter again");
		            	 
		            	break;
			        }
				}
				

		    }
	    }
	


