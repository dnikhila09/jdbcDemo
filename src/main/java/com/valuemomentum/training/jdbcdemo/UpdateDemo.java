package com.valuemomentum.training.jdbcdemo;

 

import java.sql.*;
import java.util.*;

 

public class UpdateDemo
{
      public static void main(String[] args) {
    	  
   Connection con;
   PreparedStatement pstmt;
   Statement stmt;
   ResultSet rs;
   int cnt=0;
   String sqlUpdate;

   try
   {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Connection to database");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Dpinky@09");

      sqlUpdate= "UPDATE candidates "
               + "SET last_Name = ?" //?--> parameter operator
               + "where id= ?";
    
      pstmt=con.prepareStatement(sqlUpdate);
      //prepare data for update
      Scanner sc=new Scanner(System.in);
      System.out.println("enter employee id");
      int eid=sc.nextInt();
      System.out.println("enter emplyee name");
      String lastname=sc.next();

      pstmt.setString(1,lastname);
      pstmt.setInt(2,eid);

      int rowsAffected= pstmt.executeUpdate();
      System.out.println(String.format("Rows affected %d",rowsAffected));

      //reuse the prepared statement
       lastname="grohe";
       eid=101;
       pstmt.setString(1,lastname);
       pstmt.setInt(2,eid);
       rowsAffected= pstmt.executeUpdate();
       System.out.println(String.format("Rows affected %d",rowsAffected));
       con.close();

      }
       catch(Exception e )
      {
        System.out.println(e);
     }
   } 
}
