package com.sdz.controller;

import java.util.ArrayList;
import com.sdz.model.AbstractModel;
/**
 * <b>AbstractControler:	the Abstract class for the Calculator's controller </b>
 * <ul>
 * <li> - Window1
 * <li>	- to be specified
 * </ul>
 * @author cotpa01
 * @version 1.0
 */
public abstract class AbstractControler {

	// Data areas
  protected AbstractModel calc;
  protected String operateur = "", nbre = "";
  protected ArrayList<String> listOperateur = new ArrayList<String>();

  public AbstractControler(AbstractModel cal){
    this.calc = cal;
    //On d�finit la liste des op�rateurs
    //Afin de s'assurer qu'ils sont corrects
    this.listOperateur.add("+");
    this.listOperateur.add("-");
    this.listOperateur.add("*");
    this.listOperateur.add("/");
    this.listOperateur.add("=");
   }
   
  /**
   * 	Methods for this controller
   */
  //D�finit l'op�rateur
  public void setOperateur(String ope){
    this.operateur = ope;
    control();
  }
   
  //D�finit le nombre
  public void setNombre(String nombre){
    this.nbre = nombre;
    control();
  }
   
  //Efface
  public void reset(){
    this.calc.reset();
  }
   
  /**
   * 	Generic control method all other methods call me! 
   */
  abstract void control();
  
} // End of AbstractController class
