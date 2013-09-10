package com.sdz.test;

// An abstrat class is a superclass, it cannot be instantiated. See Main how to use it. 
public abstract class Animal {
	protected String color;
	protected int weight;
	
	// a protected method cannot be modified in extension classes.
	protected void drink()			
	{
		System.out.println("I drink water");
	}
	
	// an abstract method must be redefined in an extension class
	abstract void eat();			// abstract method: it has no contents.
	abstract void move();
	abstract void sound();

	// public methods are ok too.
	public String toString(){
	    String str = "I'm a " + this.getClass() + ", color: " + this.color + ", weight: " + this.weight;
	    return str;
	}
}
