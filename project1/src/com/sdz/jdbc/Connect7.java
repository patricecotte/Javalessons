package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect7 {
	//URL, user paswd and connection areas
	  private static String url = "jdbc:postgresql://localhost:5432/School";
	  private static String user = "postgres";
	  private static String passwd = "juin2012";
	  private static String query;
	  private static Connection connect;
	  private static PreparedStatement prepare;
	  private static Statement state;
	  private static DatabaseMetaData meta;
	  private static ResultSet res;
	  
	  //This definion lets the JVM create a volatile connector instance
	  private volatile static Connect7 single;
	  private String name = "";

  private Connect7(){
	  try {
		    connect = DriverManager.getConnection(url, user, passwd);
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	  System.out.println("\t\tCRÉATION DE L'INSTANCE ! ! !");
  }
 
	   
  public static Connect7 getInstance(){
	    if(single == null){
	      synchronized(Connect7.class){
	        if(single == null)
	          single = new Connect7();
	      }
	    }      
	    return single;
	  }
	  
  public String getName(){
	    return this.name;
	  }


/*
 * 	Main entry point
 */
	  
   public static void main(String[] args){
	try {
    //The connection is performed by the JVM while creating Connect6, which sets up
    //the connect object. We only need to use it.
    prepare = connect.prepareStatement("SELECT * FROM classe WHERE cls_nom = ?");
    connect.setAutoCommit(false);
    meta = connect.getMetaData();
    query = "SELECT prof_nom, prof_prenom FROM professeur "+"WHERE prof_nom ='MAMOU'"; 
    state = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    res = state.executeQuery(query);
    res.first();
    System.out.println("\n\tDONNEES D'ORIGINE : ");
    System.out.println("\t-------------------");
    System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));

    // Dipose of the JDBC Objects.
    res.close();
    state.close();
    prepare.close();
    connect.close();
    
    	} catch (SQLException e) {
    		e.printStackTrace();
        	}	
    } // End of main

} // End of class Connect7

