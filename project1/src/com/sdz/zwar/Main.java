package com.sdz.zwar;

public class Main {
	 public static void main(String[] args) {

     Individual[] tPers = {new Warrior(), new Civilian()}; 
    
     for(int i = 0; i < tPers.length; i++){
      System.out.println("\nInstance of " + tPers[i].getClass().getName());
      System.out.println("*****************************************");
      tPers[i].dofight();
      tPers[i].domove();
      tPers[i].docare();
    }       
  }
}
