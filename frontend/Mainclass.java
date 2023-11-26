package com.anupnewproject.frontend;
import java.util.Scanner;

import com.anupnewproject.model.UserModel;
import com.anupnewproject.services.UserService;

public class Mainclass 
{

	public static void main(String[] args) 
	{
	UserService us = new UserService();

	Scanner sc1 = new Scanner(System.in);
	
	System.out.println("1. Menu");
	System.out.println("Any key to Exit");
	
	String optn = sc1.next();
	
	if(optn.equals("1") == false)
	{
		System.out.println("Thank you");
		System.exit(0);
	}
	
	while(true)
	{
	  try
	  {
	  System.out.println("1. Signup");
	  System.out.println("2. Login");
	  System.out.println("3. Delete Profile");
	  System.out.println("4. Edit Profile");
	  System.out.println("5. Show Profile");
	  System.out.println("Any Key for Logout");
	  
	  String choice = sc1.next();
	 
	  switch(choice)
	  {
	  case "1" :UserModel u1 = new UserModel();
		        System.out.println("enter name "); 
		        u1.setName(sc1.next());
		        
		        System.out.println("enter email "); 
		        u1.setEmail(sc1.next());
		        
		        System.out.println("enter pwd "); 
		        u1.setPwd(sc1.next());
		        
		        System.out.println("enter mob "); 
		        u1.setMob(sc1.next());
		        
		        System.out.println("enter DOB "); 
		        u1.setDob(sc1.next());
		        
		        System.out.println("enter Gender "); 
		        u1.setGender(sc1.next()); 
		        
		        System.out.println("enter Bio "); 
		        u1.setBio(sc1.next()); 
		        
		        us.signup(u1);
		        
		        break;	
	  
	  case "2": System.out.println("enter email");
	            String entEmail = sc1.next();
	        
	            System.out.println("enter pwd");
	            String entPwd = sc1.next();
	    
		        us.login(entEmail,entPwd); 
	            break;
	            
	  case "3":System.out.println("enter mob");
	           String entmob = sc1.next();
	           
	           System.out.println("enter password");
	           String password = sc1.next();
	           
		       us.deleteProfilebyMob(entmob,password);
		        break;
		        
	  case "4":
		       System.out.println("enter your email");
	           String Email = sc1.next();
	           
	           System.out.println("enter password");
	           String pwd = sc1.next();
	           
	           System.out.println("enter name to be updated");
	           String newname = sc1.next();
		       
	           us.editProfile(Email,pwd,newname);
		       break;
		       
	  case "5" :
		        System.out.println("Enter your email");
		        String checkEmail = sc1.next();
		        
		        System.out.println("Enter password");
		        String checkpwd = sc1.next();
		  
		        us.showProfile(checkEmail,checkpwd);
		        break;
		        
	  default :System.out.println("User Logged Out"); 
		       System.exit(0);        
	  }	
	}
	  catch (Exception sqle) 
	  {
	  sqle.printStackTrace();
	  }
	 }
	}
}
