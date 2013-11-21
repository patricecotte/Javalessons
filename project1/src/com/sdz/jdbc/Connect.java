package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * <b>Connect		A test program that shows how connect to a database</b>
 * <ul></ul>
 * The program executes simple SQL requests
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class Connect {
	
	public static void main(String[] args) {      
		try {
    Class.forName("org.postgresql.Driver");
    System.out.println("Driver O.K.");

    // The connection does not require pgAdminIII to start the data base
    // or some environment. 
    String url = "jdbc:postgresql://localhost:5432/School";
    String user = "postgres";
    String passwd = "juin2012";

    // The connection is performed by the below instruction. 
    // - The URL is in the format jdbc:web_location:port/DB
    Connection conn = DriverManager.getConnection(url, user, passwd);
    System.out.println("Connexion effective !");         
	
    /**
     * Initial request, list the School table
     */
	// List the School table
	// - create a statement object through which to execute SQL requests
	// - collect the result of the query
	// - and the metadata; the metadata are about the table structure
    //	(as opposed to the data =  the rows).
    // createStatement can be passed two parameters:
    // - parm #1: 	TYPE_FORWARD_ONLY (default)
    // - 			TYPE_SCROLL_INSENSITIVE
    // - 			TYPE_SCROLL_SENSITIVE
    // - parm #2:	CONCUR_READONLY
    // - 			CONCUR_UPDATABLE (default)
	 Statement state = conn.createStatement();
	 // Other commands are: INSERT, UPDATE, DELETE, CREATE
	 ResultSet result = state.executeQuery("SELECT * FROM classe");
	 ResultSetMetaData resultMeta = result.getMetaData();
	  
     // Print the header
	 System.out.println("\n**********************************");
     for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
         
     System.out.println("\n**********************************");
         
     // Print the data. Note the index starts at 1 (not 0!) 
     // A get method exists for each field type:
     //	- getArray(int colummnIndex) ;
     // - getAscii(int colummnIndex) ;
     // - getBigDecimal(int colummnIndex) ;
     // - getBinary(int colummnIndex) ;
     // - getBlob(int colummnIndex) ;
     // - getBoolean(int colummnIndex) ;
     // - getBytes(int colummnIndex) ;
     // - getCharacter(int colummnIndex) ;
     // - getDate(int colummnIndex) ;
     // - getDouble(int colummnIndex) ;
     // - getFloat(int colummnIndex) ;
     // - getInt(int colummnIndex) ;
     // - getLong(int colummnIndex) ;
     // - getObject(int colummnIndex) ;
     // - getString(int colummnIndex).
     
     while(result.next()){         
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
          System.out.print("\t" + result.getObject(i).toString() + "\t |");
           
        	// Print the separator 
        	System.out.println("\n---------------------------------");
     }
     
     // Terminate the request (not closing the state object)
     result.close();
     
     
     /**
      * Second request, list the Professeur table
      */
     ResultSet result2 = state.executeQuery("SELECT * FROM professeur");
     ResultSetMetaData resultMeta2 = result2.getMetaData();

     System.out.println("- Il y a " + resultMeta2.getColumnCount() + " colonnes dans cette table");
     for(int i = 1; i <= resultMeta2.getColumnCount(); i++)
       System.out.println("\t *" + resultMeta2.getColumnName(i));        

     System.out.println("Voici les noms et prénoms : ");
     System.out.println("\n---------------------------------");

     while(result2.next()){
       System.out.print("\t" + result2.getString("prof_nom") + "\t |");
       System.out.print("\t" + result2.getString("prof_prenom") + "\t |");
       System.out.println("\n---------------------------------");
     }

     result2.close();
        
     /**
      * Third request, Select from joined tables
      */
     String query = "SELECT prof_nom, prof_prenom, mat_nom FROM professeur";
     query += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
     query += " INNER JOIN matiere ON jmp_mat_k = mat_id ORDER BY prof_nom";

     ResultSet result3 = state.executeQuery(query);
     String nom = "";

     while(result3.next()){            
       if(!nom.equals(result3.getString("prof_nom"))){
         nom = result3.getString("prof_nom");
         System.out.println(nom + " " + result3.getString("prof_prenom") + " enseigne : ");
       }
       System.out.println("\t\t\t - " +  result3.getString("mat_nom"));
     }

     result3.close();
     
     /**
      * Fourth requet, Select from even more joined tables
      */
     
     String query4 = "SELECT prof_nom, prof_prenom, mat_nom, cls_nom FROM professeur";
     query4 += " INNER JOIN j_mat_prof ON jmp_prof_k = prof_id";
     query4 += " INNER JOIN matiere ON jmp_mat_k = mat_id";
     query4 += " INNER JOIN j_cls_jmp ON jcm_jmp_k = jmp_id";
     query4 += " INNER JOIN classe ON jcm_cls_k = cls_id AND cls_id IN(1, 7)";
     query4 += " ORDER BY cls_nom DESC, prof_nom";
        
     ResultSet result4 = state.executeQuery(query4);
     String nom4 = "";
     String nomClass4 = "";
        
     while(result4.next()){            
       if(!nomClass4.equals(result4.getString("cls_nom"))){
         nomClass4 = result4.getString("cls_nom");
         System.out.println("Classe de " + nomClass4 + " :");               
       }

       if(!nom.equals(result4.getString("prof_nom"))){
         nom4 = result4.getString("prof_nom");
         System.out.println("\t * " + nom4 + " " + result4.getString("prof_prenom") + " enseigne : ");
       }
       System.out.println("\t\t\t - " +  result4.getString("mat_nom"));
     }

     result.close();

     
     
     state.close();		// we've been reusing the same state object. 

     
 	} catch (Exception e) {
		// An invalid password throws an exception
		e.printStackTrace();
	}      
		
		
}	// End of main

	
} // end of class Connect