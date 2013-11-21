package com.sdz.jdbc;

/**
 * <b>AbstractDAOFactory	This is the factory of factories</b>
 * <ul></ul>
 * This abstract class supports two factories, DAO and XML, though at this point
 * the XMLFactory3 factory is only dummy classes.
 * @author cotpa01
 * @version 1.0
 */
public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int XML_DAO_FACTORY = 1;

  //Retourne un objet Classe interagissant avec la BDD
  public abstract DAO getClasseDAO();
   
  //Retourne un objet Professeur interagissant avec la BDD
  public abstract DAO getProfesseurDAO();
   
  //Retourne un objet Eleve interagissant avec la BDD
  public abstract DAO getEleveDAO();
   
  //Retourne un objet Matiere interagissant avec la BDD
  public abstract DAO getMatiereDAO();
   
  //Méthode permettant de récupérer les Factory
  public static AbstractDAOFactory getFactory(int type){
    switch(type){
      case DAO_FACTORY:
        return new DAOFactory3();
      case XML_DAO_FACTORY: 
        return new XMLFactory3();
      default:
        return null;
    }
  }
}