package com.sdz.test;

public class Dog extends Canine implements Rexx{
		 public Dog(){		 
		  }
		 
		 // implement the Animal methods
		  public Dog(String color, int weight){
		    this.color = color;
		    this.weight = weight;
		  }
		         
		  public void sound() {
		    System.out.println("I bark");
		  } 
		  
		  // implement the Animal and Canine methods
		  public void eat(String food)
		  {
			  System.out.println("A dog eats "+food);
		  }
		  
		  public void eat()
		  {
			  
		  }
		  
		  // Implement the Rexx methods
		  public void doHug() {
			    System.out.println("I hug my master");               
			  }
			 
		  public void doBrave() {
			    System.out.println("nothing scares me");
			  }
			 
		  public void doKiss() {
			    System.out.println("a lick is a lick!");
		 	}
	}

