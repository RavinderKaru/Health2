package com.Service;

public class Validation {
	public static boolean validateUname(String uname) {
		String pattern = "^[A-Z][a-z0-9_-]+{3,15}$";
		System.out.println("k");
		return uname.matches(pattern);
	}

	public static boolean validateEmail(String email) {
		String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(pattern);
	}

	public static boolean validatePass(String pass) {
		
		String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
		return pass.matches(pattern);
	}

	public static boolean validatePhoneN(String Pn) {
		String pattern = "(0/91)?[7-9][0-9]{9}";
		return Pn.matches(pattern);
	}

	public static boolean validateSec(String sec) {
		String pattern = "[a-zA-Z]+{5,15}$";
		System.out.println("y");
		return sec.matches(pattern);
	}

}
