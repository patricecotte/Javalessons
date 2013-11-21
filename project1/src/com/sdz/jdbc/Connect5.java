package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * <b>Connect5	This program follows the singleton pattern </b>
 * <ul></ul>
 * Connect5 is set up with a private constructor so that only one occurrence
 * of the connection can be established.
 * <ul></ul>
 * @author cotpa01
 * @version 0.1
 */

public class Connect5{
//URL, user paswd and connection areas
private static String url = "jdbc:postgresql://localhost:5432/School";
private static String user = "postgres";
private static String passwd = "juin2012";
private static Connection connect;
private static PreparedStatement prepare;
private static Statement state;
private static DatabaseMetaData meta;
 
//private constructor
private Connect5(){
  try {
    connect = DriverManager.getConnection(url, user, passwd);
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
 
//This method creates a connection if none exists
 public static Connection getInstance(){
  if(connect == null){
	System.out.println("Hello, a connection to database "+url+" has been established.");
    new Connect5();
  }
  else System.out.println("A connection exists and will be used");
  return connect;   
}   
 
 /*
  * 	Main
  */


 public static void main(String[] args) {
   try {
     //Nous appelons quatre fois la méthode getInstance()
     prepare = Connect5.getInstance().prepareStatement("SELECT * FROM classe WHERE cls_nom = ?");

     state = Connect5.getInstance().createStatement();

     Connect5.getInstance().setAutoCommit(false);

     meta = Connect5.getInstance().getMetaData();
        
   } catch (SQLException e) {
     e.printStackTrace();
   }

}
} // End of class Connect5