package com.valuemomentum.training.jdbcdemo;

import java.sql.*;
import java.sql.Connection;
public class BatchDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con;	
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		     System.out.println("Connection to database");
		con=DriverManager.getConnection(
		    "jdbc:mysql://localhost:3306/mysqljdbc","root","Dpinky@09");

		Statement stmt = con.createStatement();
		
		//create batch
		stmt.addBatch("insert into candidate_skills values(100,5)");
		stmt.addBatch("update skills set name='Ajax' where id=3");
		stmt.addBatch("delete from candidates where id=80");
		
		//disable auto=commit mode
		con.setAutoCommit(false);
		try
		{     
		     stmt.executeBatch();
		     con.commit();
		     System.out.println("batch is succesfully executed");
		     
		}
		 catch(Exception e )
	      {
	       
		try
		{
			con.rollback();
			System.out.println("batch is failed");
			System.out.println("exception is"+e);
		}
		catch(Exception e1 )
	      {
	        System.out.println("Exception is"+e1);
	     }

	}

   }
}
