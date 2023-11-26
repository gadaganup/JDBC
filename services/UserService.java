package com.anupnewproject.services;

import java.io.IOException;
import java.sql.SQLException;

import com.anupnewproject.dao.MySqlImpl;
import com.anupnewproject.model.UserModel;

public class UserService 
{
private MySqlImpl ms = new MySqlImpl();
	
	public void login(String entEmail,String entPwd) throws SQLException
	{	
		ms.initDB();
		
		UserModel u1  = ms.Login(entEmail,entPwd);
		if(u1 != null)
		{
			System.out.println("User Logged in");
		}
		else // ERROR EXISTS here
		{
			System.out.println("Invalid Email or Password");
		}	
		ms.closeDB();
	}
	
	public void editProfile(String email, String pwd, String name) throws SQLException 
	{
	 ms.initDB();
	 UserModel us1 = ms.Login(email,pwd);	 
	 if(us1 != null)
	 {
		 ms.update(name,email);
		 System.out.println("Profile updated");	 
	 }
	 else 
	 {
		 System.out.println("error while updating");
	 }
	}
	
	public void signup(UserModel us) throws SQLException
	{
		ms.initDB();
		int count = ms.insert(us);
		if(count > 0)
		{
			System.out.println("User Profile Created");
		}
		else
		{
			System.out.println("Error whil Creating User Profile");
		}
		
		ms.closeDB();
	}
	
	public void deleteProfilebyMob(String mob, String pwd) throws SQLException
	{
         ms.initDB();
		
        int count = ms.deleteByMob(mob,pwd);
		if(count > 0)
		{
			System.out.println("User Profile DELETED using mob");
		}
		else
		{
			System.out.println("Error while deleting User Profile");
		}
		
		ms.closeDB();
	  
	}
	
	public void showProfile(String email, String pwd)throws SQLException
	{
	    ms.initDB();
		UserModel u1  = ms.getUserProfileByEmail(email,pwd);
		if(u1 != null)
		{
			System.out.println(u1.toString());
		}
		else // Modifications to be done
		{
			System.out.println("Invalid Email or Password");
		}
		
		ms.closeDB();
	}

	
	public void logout() throws SQLException
	{
	  ms.closeDB();
	}
	
	

}
