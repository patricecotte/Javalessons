package com.sdz.test;

public class Cat extends Feline{
	 public Cat(){		 
	  }
	 
	  public Cat(String color, int weight){
	    this.color = color;
	    this.weight = weight;
	  }
	         
	  void sound() {
	    System.out.println("I'm meewing I'm lost!");    // Feline method
	  } 
	  
	  void eat(String food)			// implement Feline method
	  {
		  System.out.println("A cat eats "+food);
	  }
	  
	  void eat()					// implement Animal method
	  {
		  
	  }
}
