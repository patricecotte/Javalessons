package com.sdz.jdbc;


import java.util.HashSet;
import java.util.Set;

public class Professeur {
  //	Data:	ID, name, first name and subjects
  private int id = 0;
  private String nom = "";
  private String prenom = "";
  private Set<Matiere> listMatiere = new HashSet<Matiere>();

  // Constructor
  public Professeur(int id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public Professeur(){}

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

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Set<Matiere> getListMatiere() {
    return listMatiere;
  }

  public void setListMatiere(Set<Matiere> listMatiere) {
    this.listMatiere = listMatiere;
  }

  //Ajoute une matière à un professeur
  public void addMatiere(Matiere matiere){
    this.listMatiere.add(matiere);
  }

  //Retire une matière à un professeur
  public void removeMatiere(Matiere matiere){
    this.listMatiere.remove(matiere);
  }
  
} // End of Matiere class