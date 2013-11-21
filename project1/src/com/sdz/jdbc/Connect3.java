package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * <b>Connect4	This program desmontrates how update a row in a table</b>
 * <ul></ul>
 * This example only uses simple statements.
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
	
public class Connect3 {
	/**
	 * Data 	Define the standard JDCB objects
	 * 
	 */
	private static Connection conn;
	private static Statement state;
	private static PreparedStatement prepare;
	private static ResultSet res;
	private static String url, user, passwd, query;
	
	/**
	 * 
	 * @param args	none
	 */
	  public static void main(String[] args) {
	    try {
	      Class.forName("org.postgresql.Driver");
	      url = "jdbc:postgresql://localhost:5432/School";
	      user = "postgres";
	      passwd = "juin2012";

	      //Set up a connection in update
	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

	      //Run a request, print the result
	      query = "SELECT prof_id, prof_nom, prof_prenom FROM professeur " + "WHERE prof_nom = 'MAMOU'";         
	      res = state.executeQuery(query);
	      res.first();
	      System.out.println("NOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom"));

	      //Update the row and validate it
	      res.updateString("prof_nom", "COURTEL");
	      res.updateString("prof_prenom", "Angelo");
	      res.updateRow();

	      //On affiche les modifications
	      System.out.println("*********************************");
	      System.out.println("APRES MODIFICATION : ");
	      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom") + "\n");

	      //Revert the change and validate
	      res.updateString("prof_nom", "MAMOU");
	      res.updateString("prof_prenom", "Daniel");
	      res.updateRow();

	      //Done
	      System.out.println("*********************************");
	      System.out.println("APRES REMODIFICATION : ");
	      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " + res.getString("prof_prenom") + "\n");

	      res.close();
	      state.close();

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	

}  // Ensd of class Connect3
