package com.biz.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static Connection dbConn = null;
	
	static
	{
		try
		{
			Class.forName(DBContract.DB_DRIVER);
			dbConn = DriverManager.getConnection(DBContract.DB_URL, DBContract.DB_USER, DBContract.DB_PWD);
			System.out.println("db 연결 완료");
		}
		
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public static Connection getDBConnection()
	{
		return dbConn;
	}
	
	
	
}
