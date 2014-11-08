package dao;


import java.sql.*;

public class DBCon {
	
	static Connection conn=null;
	
	static{
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

	
	public static Connection getDBCon(){
		
		try{
		conn=DriverManager.getConnection

		("jdbc:oracle:thin:@172.17.12.128:1521:MTSDEV1","TRAINING","TRAINING");   
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		return conn;
	}
	
}
