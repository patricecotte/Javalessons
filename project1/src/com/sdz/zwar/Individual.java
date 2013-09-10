package com.sdz.zwar;

import com.sdz.zwar.*;

public abstract class Individual {
 
  //define default behaviors by creating specific interface related objects. 
  protected FightSpirit fightSpirit = new Pacifist();
  protected Care care = new NoCare();
  protected Move move = new Walk();    
     
  //default constructor
  public Individual(){}
     
  //constructor with parameters for defining various individuals
  public Individual(FightSpirit fightSpirit, Care care, Move move) {
    this.fightSpirit = fightSpirit;
    this.care = care;
    this.move = move;
  }
     
  /*
   * Methods owned by the Individual class
   */
  public void domove(){
    move.move();				// polymorphic object
  }
 
  // fight method
  public void dofight(){
    fightSpirit.fight();		// polymorphic object
  }
     
  //care method
  public void docare(){
    care.care();				// polymorphic object
  }
 
  /*
  * Setters for overriding FightSpirit, Care and Move
  */
 
  public void setFightSpirit(FightSpirit fightSpirit) {
    this.fightSpirit = fightSpirit;
  }
 
  public void setCare(Care care) {
    this.care = care;
  }
 
  public void setMove(Move move) {
    this.move = move;
  } 
}


