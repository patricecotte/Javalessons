package com.sdz.jdbc;


import java.sql.Connection;
import com.sdz.jdbc.JDBCConnect;
/**
 * <b>DAO		The abstract class in the DAO setup about School database </b>
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 * @param <T>
 */

public abstract class DAO<T> {
  // The Connection object that supports the dialog between the application 
  // and the DBMS.
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
}