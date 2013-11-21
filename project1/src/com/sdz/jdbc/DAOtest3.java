package com.sdz.jdbc;

/**
 * <b>DAOtest3	This program accesses the School data base through a factory of DAO objects</b>
 * <ul></ul>
 * @author cotpa01
 * @version 1.0
 */
public class DAOtest3 {

public static void main(String[] args) {
  System.out.println("");
  AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
  //On r�cup�re un objet faisant le lien entre la base et nos objets 
  DAO<Eleve> eleveDao = adf.getEleveDAO();
    
  for(int i = 1; i < 5; i++){
    //On fait notre recherche
    Eleve eleve = eleveDao.find(i);
    System.out.println("\tELEVE N�" + eleve.getId() + " - NOM : " + eleve.getNom() + " - PRENOM : " + eleve.getPrenom());
  }      
    
  System.out.println("\n\t************************************");
    
  //On fait de m�me pour une classe
  DAO<Classe> classeDao = adf.getClasseDAO();
  //On cherche la classe ayant pour ID 10
  Classe classe = classeDao.find(10);
    
  System.out.println("\tCLASSE DE " + classe.getNom());
    
  //On r�cup�re la liste des �l�ves
  System.out.println("\n\tCelle-ci contient " + classe.getListEleve().size() + " �l�ve(s)");
  for(Eleve eleve : classe.getListEleve())
    System.out.println("\t\t - " + eleve.getNom() + " " + eleve.getPrenom());
    
  //De m�me pour la liste des professeurs
  System.out.println("\n\tCelle-ci a " + classe.getListProfesseur().size() + " professeur(s)");      
  for(Professeur prof : classe.getListProfesseur()){
    System.out.println("\t\t - Mr " + prof.getNom() + " " + prof.getPrenom() + " professeur de :");
       
    //Tant qu'� faire, on prend aussi les mati�res
    for(Matiere mat : prof.getListMatiere())
      System.out.println("\t\t\t * " + mat.getNom());
  }
    
  System.out.println("\n\t***********************************");
    
  //Un petit essai sur les mati�res
  DAO<Matiere> matiereDao = adf.getMatiereDAO();
  Matiere mat = matiereDao.find(2);
  System.out.println("\tMATIERE " + mat.getId() + " : " + mat.getNom());      
}
}