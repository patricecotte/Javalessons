package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b>Connect6 	Connect6 lets the JVM create the single connector</b>
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class Connect6 {

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
	  
	  //This definion lets the JVM create the only instance of the connector
	  private static Connect6 single = new Connect6();
	  private String name = "";
	  
	  
	  //The private contstuctor 
	  private Connect6(){
		  try {
			    connect = DriverManager.getConnection(url, user, passwd);
			  } catch (SQLException e) {
			    e.printStackTrace();
			  }
		  System.out.println("\t\tCRÉATION DE L'INSTANCE ! ! !");
	  }
	   
	  //Access the connector
	  public static Connect6 getInstance(){
	    if(single == null)
	    single = new Connect6();
	      
	    return single;
	  }
	   
	  //Access the name of the connector.
	  public String getName(){
	    return this.name;
	  }
	  
/*
 * 	Entry point
 */
public static void main(String[] args) {
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
	}


} // End of Connect6 class