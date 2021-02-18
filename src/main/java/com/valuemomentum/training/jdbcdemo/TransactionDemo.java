package com.valuemomentum.training.jdbcdemo;

import java.sql.*;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
		Connection con;	
		Statement stmt;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	     System.out.println("Connection to database");
	  con=DriverManager.getConnection(
	    "jdbc:mysql://localhost:3306/mysqljdbc","root","Dpinky@09");
		
	  System.out.println("driver is loaded");
      stmt =con.createStatement();
      con.setAutoCommit(false);
      try
      {
     int i1=stmt.executeUpdate("INSERT INTO candidate_skills VALUES(100,4)");
	 int i2=stmt.executeUpdate("UPDATE skills set name='Ruby' where id=2");
	 int i3=stmt.executeUpdate("DELETE FROM candidates WHERE id=15");
	    con.commit();
	    System.out.println("Transaction is success");
      }//end of try
      catch(Exception e)
      {
    	  try
    	  {
    		  con.rollback();
    		  System.out.println("Transaction is failed");  
    	  }
          catch(Exception ex)
    	  {
        	  System.out.println(ex);
    	  }
      
      }//end of catch
      stmt.close();
      con.close();
      System.out.println("connection is closed");
      
		
      }
	}


