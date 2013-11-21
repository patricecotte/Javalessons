package com.sdz.jdbc;

/**
 * <b>Eleve		This class describes a table in the School data base </b>
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class Eleve {
  //	Data:	 ID, name and first name
  private int id = 0;
  private String nom = "";
  private String prenom = "";
   
  // Constructor
  public Eleve(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }
  
  public Eleve(){};
  
  /**
   *    
   * Getters and setters
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }   
  
} // End of Eleve
