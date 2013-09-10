package com.sdz.test;

public class Tiger extends Feline{
	 public Tiger(){		 
	  }
	 
	  public Tiger(String color, int weight){
	    this.color = color;
	    this.weight = weight;
	  }
	         
	  void sound() {
	    System.out.println("I'm grawling loud!");
	  } 
	  
	  void eat(String food)
	  {
		  System.out.println("Tigers eat "+food);
	  }
	  
	  void eat()
	  {
		  
	  }

}
