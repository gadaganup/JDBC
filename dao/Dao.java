package com.anupnewproject.dao;

import java.sql.SQLException;

import com.anupnewproject.model.UserModel;


public interface Dao 
{
	public void initDB()throws SQLException;
	   
	   public int insert(UserModel us)throws SQLException;
	   public UserModel Login(String email,String pwd)throws SQLException;
	   public int deleteByMob(String mob,String pwd)throws SQLException;
	   public int update(String name, String email)throws SQLException;
	   public UserModel getUserProfileByEmail(String Email, String pwd)throws SQLException;	     
	   public void closeDB()throws SQLException;
}
