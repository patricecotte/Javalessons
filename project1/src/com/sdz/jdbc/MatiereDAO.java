package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <b>MatiereDAO		extends abstract DAO class, the foundation of our DAO pattern to access
 * the School database</b>
 * <ul></ul>
 * <li>MatiereDAO sets the DAO generic type to Matiere
 * <li>It inherits the connect object from DAO 
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class MatiereDAO extends DAO<Matiere> {
public MatiereDAO(Connection conn) {
  super(conn);
}

public boolean create(Matiere obj) {
  return false;
}

public boolean delete(Matiere obj) {
  return false;
}

public boolean update(Matiere obj) {
  return false;
}

public Matiere find(int id) {
  Matiere matiere = new Matiere();  // Get an instance of the Matiere object

  try {
    ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE, 
      ResultSet.CONCUR_READ_ONLY
    ).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
      if(result.first())
    	// instantiate a Matiere object with the output of Find
        matiere = new Matiere(id, result.getString("mat_nom"));         
  } catch (SQLException e) {
    e.printStackTrace();
  }
  return matiere;
}
}