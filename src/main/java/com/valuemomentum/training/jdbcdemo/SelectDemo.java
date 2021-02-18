package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			System.out.println("Connecting to database..");
			con=DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/mysqljdbc","root","Dpinky@09");
		
			stmt=con.createStatement();
		
			rs=stmt.executeQuery("select * from candidates");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
			                    rs.getString(3)+" "+rs.getDate(4)+" "+
						rs.getString(5)+" "+rs.getString("email"));
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
