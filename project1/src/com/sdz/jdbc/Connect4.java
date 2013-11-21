package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * <b>Connect4	This program shows how update a row in a table</b>
 * <ul></ul>
 * This example uses two statements, one fixe, the other prepared with dynamic overrides
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class Connect4 {
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

	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      //On autorise la mise à jour des données 
	      //Et la mise à jour de l'affichage
	      state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	      prepare = conn.prepareStatement("UPDATE professeur set prof_prenom = ? "+"WHERE prof_nom = 'MAMOU'");

	      //On va chercher une ligne dans la base de données
	      query = "SELECT prof_nom, prof_prenom FROM professeur "+"WHERE prof_nom ='MAMOU'";         

	      //On exécute la requête (in state), print the results
	      res = state.executeQuery(query);
	      res.first();
	      System.out.println("\n\tDONNEES D'ORIGINE : ");
	      System.out.println("\t-------------------");
	      System.out.println("\tNOM : " + res.getString("prof_nom") + " - PRENOM : " +  res.getString("prof_prenom"));

	      //Male the prepared request complete and execute it
	      prepare.setString(1, "Gérard");
	      prepare.executeUpdate();

	      //execute again the state Statement and print out
	      res = state.executeQuery(query);
	      res.first();
	      System.out.println("\n\t\t APRES MAJ : ");
	      System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));
	                  
	      //perfrom an update
	      prepare.setString(1, "Daniel");
	      prepare.executeUpdate();
	         
	      //execute again the state Statement and print again
	      res = state.executeQuery(query);
	      res.first();
	      System.out.println("\n\t\t REMISE A ZERO : ");
	      System.out.println("\t\t * NOM : " + res.getString("prof_nom") + " - PRENOM :" + res.getString("prof_prenom"));

	      prepare.close();
	      res.close();
	      state.close();         
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }      
	  }
	
} // End of Connect4 class
