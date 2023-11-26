package com.anupnewproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.anupnewproject.model.UserModel;
public class MySqlImpl implements Dao 
{
	private String url = "jdbc:mysql://localhost:3306/";
	private String dbname = "users_db";
	private String dbusername = "root";
	private String dbuserpwd = "root";
	private Statement stmt;
	private PreparedStatement pms;
	private Connection con;
	
	private String insertUser = "insert into users_db.instauser values(?,?,?,?,?,?,?,?)";
	private String getUser = "select email,pwd from users_db.instauser where email = ? and pwd = ?";
	
	private String getUserProfile = "select * from users_db.instauser where email = ? and pwd = ?";
	private String updateProfile = "update users_db.instauser set name=? where email=?";
	private String deleteuserbyMob = "delete from users_db.instauser where mob = ? and pwd = ?";

	@Override
	public void initDB()throws SQLException
	{
		con  = DriverManager.getConnection(url+dbname,dbusername,dbuserpwd);
		stmt = con.createStatement();
	}
	@Override
	public void closeDB()throws SQLException 
	{
	  con.close();
	}
	@Override
	public int insert(UserModel us) throws SQLException 
	{
	   pms = con.prepareStatement(insertUser);
	   pms.setInt(1,0);
	   pms.setString(2,us.getName());
	   pms.setString(3,us.getEmail());
	   pms.setString(4,us.getMob());
	   pms.setString(5,us.getPwd());
	   pms.setString(6,us.getDob());
	   pms.setString(7,us.getGender());
	   pms.setString(8,us.getBio());
	   	   
	   int count = pms.executeUpdate();
	   
	   return count;
	}

	@Override
	public int update(String name, String email)throws SQLException 
	{
		pms = con.prepareStatement(updateProfile);
		pms.setString(1, name);
		pms.setString(2, email);
		
		int count = pms.executeUpdate();
		return count;
	}
	@Override
	public int deleteByMob(String mob, String pwd)throws SQLException 
	{
		pms = con.prepareStatement(deleteuserbyMob);
		pms.setString(1, mob);
		pms.setString(2, pwd);
		int count = pms.executeUpdate();
		return count;
	}

	@Override
	public UserModel Login(String email,String pwd)throws SQLException 
	{
		pms = con.prepareStatement(getUser);
		pms.setString(1,email);
		pms.setString(2, pwd);
		UserModel u1=null;
	    try
	    {
	    	ResultSet rs = pms.executeQuery();
	        rs.next();  
	        String userEmail = rs.getString(1);
		    String userPwd = rs.getString(2);
		    u1 = new UserModel();
		    u1.setEmail(userEmail);
		    u1.setPwd(userPwd);
	    }
	    
	    catch (Exception e)
	    {
	    	System.out.println("inputs didnot match");
		}
	    
		return u1;
	}
	
	@Override
	public UserModel getUserProfileByEmail(String email,String pwd)throws SQLException 
	{
		pms = con.prepareStatement(getUserProfile);
		pms.setString(1,email);
		pms.setString(2, pwd);	
		UserModel u1;
		try
		{
			ResultSet rs = pms.executeQuery();
			rs.next();	    
			u1 = new UserModel();
			u1.setName(rs.getString(2));
			u1.setEmail(rs.getString(3));
			u1.setMob(rs.getString(4));
			u1.setDob(rs.getString(6));
			u1.setGender(rs.getString(7));
			u1.setBio(rs.getString(8));
		}
		
		catch (Exception e) 
		{
			u1 = null;
			System.out.println("inputs didnot match");
		}
	    
		return u1;
	}
}
