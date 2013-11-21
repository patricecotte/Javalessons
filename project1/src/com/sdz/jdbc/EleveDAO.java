package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <b>EleveDAO		extends abstract DAO class, the foundation of our DAO pattern to access
 * the School database</b>
 * <ul></ul>
 * <li>EleveDAO sets the DAO generic type to Eleve
 * <li>It inherits the connect object from DAO  
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */

public class EleveDAO extends DAO<Eleve> {
public EleveDAO(Connection conn) {
  super(conn);
}

public boolean create(Eleve obj) {	// Can't create
  return false;
}

public boolean delete(Eleve obj) {	// Can't delete
  return false;
}
 
public boolean update(Eleve obj) {	// Can't update
  return false;
}

public Eleve find(int id) {
  // Create an instance of the associated object
  Eleve eleve = new Eleve();      
    
  try {
    ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE,
      ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
    if(result.first())
      // Instantiate an object with the output of Find
      eleve = new Eleve(
        id,
        result.getString("elv_nom"),
        result.getString("elv_prenom"
      ));         
  } catch (SQLException e) {
    e.printStackTrace();
  }
  // Return the object
  return eleve;
}
} // End of EleveDAO class
