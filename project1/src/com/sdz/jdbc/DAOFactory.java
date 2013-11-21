package com.sdz.jdbc;

import java.sql.Connection;

/**
 * <b>DAOFactory	This is the factory tha works together with the DAO pattern to access
 * the School database</b>
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */

public class DAOFactory {
	// DAOFactory creates the Connection object
protected static final Connection conn = JDBCConnect.getInstance();   
 
/**
* Retourne un objet Classe interagissant avec la BDD
* @return DAO
*/
public static DAO getClasseDAO(){
  // Create a ClasseDAO object passin the connector and return it 	
  return new ClasseDAO(conn);
}

/**
* Retourne un objet Professeur interagissant avec la BDD
* @return DAO
*/
public static DAO getProfesseurDAO(){
  return new ProfesseurDAO(conn);
}

/**
* Retourne un objet Eleve interagissant avec la BDD
* @return DAO
*/
public static DAO getEleveDAO(){
  return new EleveDAO(conn);
}

/**
* Retourne un objet Matiere interagissant avec la BDD
* @return DAO
*/
public static DAO getMatiereDAO(){
  return new MatiereDAO(conn);
}   
}