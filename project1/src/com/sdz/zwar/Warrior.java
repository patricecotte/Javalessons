package com.sdz.zwar;

import com.sdz.zwar.*;

public class Warrior extends Individual {  
	  public Warrior(){
	    this.fightSpirit = new Fight_with_sword();
	    this.move = new Drive();
	  }
	  public Warrior(FightSpirit spirit, Care care, Move move) {
	    super(spirit, care, move);
	  }
	}