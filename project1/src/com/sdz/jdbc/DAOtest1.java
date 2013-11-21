package com.sdz.jdbc;

/**
 * <b>DAOtest1	This test program extracts data from the School tables using a DAO pattern</b>
 * <ul></ul>
 * A unique connection to the table is set up through the JDBCConnect class in the same
 * package. JDBCConnect getInstance method makes sure the same connect is reused.
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class DAOtest1 { 
public static void main(String[] args) {
  // Create an EleveDAO instance and FIND 4 Eleve objects 
  DAO<Eleve> eleveDao = new EleveDAO(JDBCConnect.getInstance());
  for(int i = 1; i < 5; i++){
    Eleve eleve = eleveDao.find(i);
    System.out.println("Elève N°" + eleve.getId() + "  - " + eleve.getNom() + " " + eleve.getPrenom());
  }
    
  System.out.println("\n********************************\n");
    
  // Create a ProfesseurDAO instance and FIND Professeur objects.
  DAO<Professeur> profDao = new ProfesseurDAO(JDBCConnect.getInstance());
  for(int i = 4; i < 8; i++){
    Professeur prof = profDao.find(i);
    System.out.println(prof.getNom() + " " + prof.getPrenom() + " enseigne : ");
    for(Matiere mat : prof.getListMatiere())
      System.out.println("\t * " + mat.getNom());
  }
    
  System.out.println("\n********************************\n");
    
  // Create a ClasseDAO instance and Find the eleventh Classe object
  DAO<Classe> classeDao = new ClasseDAO(JDBCConnect.getInstance());
  Classe classe = classeDao.find(11);
    
  System.out.println("Classe de " + classe.getNom());
  System.out.println("\nListe des élèves :");
  for(Eleve eleve : classe.getListEleve())
    System.out.println("  - " + eleve.getNom() + " " + eleve.getPrenom());
    
  System.out.println("\nListe des professeurs :");
  for(Professeur prof : classe.getListProfesseur())
    System.out.println("  - " + prof.getNom() + " " + prof.getPrenom());
  
} // End of main

} // End of DAOtest1