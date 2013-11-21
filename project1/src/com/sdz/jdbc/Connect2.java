package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b>Connnect2		This example demonstrates the use of the preparedStatement</b>
 * <ul> The preparedStatement is precompiled and allows for dynamic overrides.</ul>
 * preparedStatement may throw SQL exceptions
 * @author cotpa01
 * @version 1.0
 */


public class Connect2 {
	/**
	 * Data		Define the standard object in JDBC programs. 
	 */
	private static Connection conn;
	// private static Statement state;
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
	      
	      /**
	       * Idenfity 	the database, and connet 
	       * Create 	state, the Statement Object
	       * Set up		query, a request with 2 placeholders marked ?
	       * 			prepare query		
	       * 			fill in placeholders depending on the data type	
	       * Execute
	       */
	      conn = DriverManager.getConnection(url, user, passwd);
	      //state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	         
	      query = "SELECT prof_nom, prof_prenom FROM professeur";
	      query += " WHERE prof_nom = ?";
	      query += " OR prof_id = ?";	         
	      //Prepare the statement, running a method of the connector. Placeholders
	      //are filled in using setString, a method of the PreparedStatement object
	      /**
	       * the PreparedStatement object 
	       * - allows the same two parameters as a simple statement, in addition to the query
	       * - use clearParameters() to reinitialize the prepared statement
	       */
	      prepare = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	      prepare.setString(1, "MAMOU");
	      prepare.setInt(2, 2);
	      System.out.println(prepare.toString());  // Show the request
	      res =  prepare.executeQuery();  
	      listResults();
	      res.close();
	      
	      //Modify placeholder #1 and print the request
	      prepare.setString(1, "TOTO");
	      System.out.println(prepare.toString());
	      res = prepare.executeQuery();
	      listResults();
	      res.close();
	      
	      //Modify placeholder #2 and print the request
	      prepare.setInt(2, 159753);
	      System.out.println(prepare.toString());
	      res = prepare.executeQuery();
	      listResults();
	         
	      //Release the objects
	      prepare.close();
	      res.close();
	      // state.close();

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	  } // End of main

/**
 * <b>listResults		This method lists forwards and backwards the ResultSet from an
 *  				executed query.</b>
 *  <ul>
 *  ResultSet positioning capabilities:
 *  <ul></ul>
 *  <li>vous positionner avant la première ligne de votre résultat : res.beforeFirst() ;
 *  <li>savoir si vous vous trouvez avant la première ligne : res.isBeforeFirst() ;
 *  <li>vous placer sur la première ligne de votre résultat : res.first() ;
 *  <li>savoir si vous vous trouvez sur la première ligne : res.isFirst() ;
 *  <li>vous retrouver sur la dernière ligne : res.last() ;
 *  <li>savoir si vous vous trouvez sur la dernière ligne : res.isLast() ;
 *  <li>vous positionner après la dernière ligne de résultat : res.afterLast() ;
 *  <li>savoir si vous vous trouvez après la dernière ligne : res.isAfterLast() ;
 *  <li>aller de la première ligne à la dernière : res.next() ;
 *  <li>aller de la dernière ligne à la première : res.previous() ;
 *  <li>vous positionner sur une ligne précise de votre résultat : res.absolute(5) ;
 *  <li>vous positionner sur une ligne par rapport à votre emplacement actuel : res.relative(-3).
 *  </ul><ul></ul>
 *  ResultSet getters getXXX are based on the data types:
 *  <ul></ul>
 *  <li>getBytes
 *  <li>getAscii
 *  <li>getInt
 *  <li>getString  ... etc
 *  <ul></ul>
 * @throws SQLException 
 */
	  
	public static void listResults() throws SQLException{
		 int i = 1;         
         
	      System.out.println("\n\t---------------------------------------");
	      System.out.println("\tLECTURE STANDARD.");
	      System.out.println("\t---------------------------------------");
	         
	      while(res.next()){
	        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));
	        //On regarde si on se trouve sur la dernière ligne du résultat
	        if(res.isLast())
	          System.out.println("\t\t* DERNIER RESULTAT !\n");
	        i++;
	      }
	         
	      //Une fois la lecture terminée, on contrôle si on se trouve bien à l'extérieur des lignes de résultat
	      if(res.isAfterLast())
	        System.out.println("\tNous venons de terminer !\n");
	         
	      System.out.println("\t---------------------------------------");
	      System.out.println("\tLecture en sens contraire.");
	      System.out.println("\t---------------------------------------");
	         
	      //On se trouve alors à la fin
	      //On peut parcourir le résultat en sens contraire
	      while(res.previous()){
	        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));

	        //On regarde si on se trouve sur la première ligne du résultat
	        if(res.isFirst())
	          System.out.println("\t\t* RETOUR AU DEBUT !\n");
	      }
	         
	      //On regarde si on se trouve avant la première ligne du résultat
	      if(res.isBeforeFirst())
	        System.out.println("\tNous venons de revenir au début !\n");
	         
	      System.out.println("\t---------------------------------------");
	      System.out.println("\tAprès positionnement absolu du curseur à la place N° "+ i/2 + ".");
	      System.out.println("\t---------------------------------------");
	      //On positionne le curseur sur la ligne i/2
	      //Peu importe où on se trouve
	      res.absolute(i/2);
	      while(res.next())
	        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+ res.getString("prof_prenom"));
	         
	      System.out.println("\t---------------------------------------");
	      System.out.println("\tAprès positionnement relatif du curseur à la place N° "+(i-(i-2)) + ".");
	      System.out.println("\t---------------------------------------");
	      //On place le curseur à la ligne actuelle moins i-2
	      //Si on n'avait pas mis de signe moins, on aurait avancé de i-2 lignes 
	      res.relative(-(i-2));
	      while(res.next())
	        System.out.println("\tNom : "+res.getString("prof_nom") +" \t prénom : "+res.getString("prof_prenom"));

	
	}  // End of listResults

} // End of Connect2 
