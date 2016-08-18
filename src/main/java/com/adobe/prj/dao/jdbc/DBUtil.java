/**
 * 
 */
package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rahujai
 * @author danchara
 *
 */

public class DBUtil {

	private static String URL = ConfigReader.getString("DB_URL"); //$NON-NLS-1$
	private static String USER = ConfigReader.getString("DB_USER"); //$NON-NLS-1$
	private static String PWD = ConfigReader.getString("DB_PWD"); //$NON-NLS-1$

	public static Connection getConnection() throws SQLException {
		
		System.out.println(URL+" "+USER+" "+PWD);
		return DriverManager.getConnection(URL, USER, PWD);
	}
	
	public static void releaseStatement(Statement smt){
		if(smt!= null){
			try{
				smt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void releaseConnection(Connection con){
		if(con!= null){
			try{
				con.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(){
		Connection con = null;
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(con!=null){
			System.out.println("Successfully connected to mysql!!");
		}
	}

}


