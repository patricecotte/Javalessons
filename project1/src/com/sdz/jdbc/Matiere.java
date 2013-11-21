package com.sdz.jdbc;

public class Matiere {
  //	Data:	ID and name
  private int id = 0;
  private String nom = "";

  // Constructor
  public Matiere(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Matiere(){}

  /*
   * 	Getters and setters
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
  
} // End of Matiere