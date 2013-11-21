package com.sdz.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfesseurDAO extends DAO<Professeur> {
public ProfesseurDAO(Connection conn) {
  super(conn);
}

public boolean create(Professeur obj) {
  return false;
}

public boolean delete(Professeur obj) {
  return false;
}

public boolean update(Professeur obj) {
  return false;
}
 
public Professeur find(int id) {
  // Instantiate a Professeur object
  Professeur professeur = new Professeur();            
  try {
    ResultSet result = this.connect.createStatement(
      ResultSet.TYPE_SCROLL_INSENSITIVE, 
      ResultSet.CONCUR_READ_ONLY
    ).executeQuery(
      "SELECT * FROM professeur "+
      "LEFT JOIN j_mat_prof ON jmp_prof_k = prof_id " + 
      "AND prof_id = "+ id +
      " INNER JOIN matiere ON jmp_mat_k = mat_id"
    );
    if(result.first()){
      professeur = new Professeur(id, result.getString("prof_nom"), result.getString("prof_prenom"));
      result.beforeFirst();
      // instantatiate a MatiereDAO object passing the current connect
      MatiereDAO matDao = new MatiereDAO(this.connect);
          
      while(result.next())
        professeur.addMatiere(matDao.find(result.getInt("mat_id")));
    }
  } catch (SQLException e) {
    e.printStackTrace();
  }
  // Retunr the object
  return professeur;   
}


} // End of the ProfesseurDAO class