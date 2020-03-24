package com.DTO;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CollectionUtil {
	  public static	Map<String, User> user=new HashMap<String, User>();
	  static
	  {
		  user.put("U1234",new User("U1234", "Karuravinder", "Master$1", "karuravinder@gmail.com", new BigInteger("9908803484"), "USER", "Chinna", "Male"));
	  }
	  
	  public  static Map<String, User>getDetails()
	  {
		  return user;
	  }
	

}
