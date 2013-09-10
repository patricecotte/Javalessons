package com.sdz.test;

// An abstract class can extend an abstract class.
public abstract class Feline extends Animal{
	void move()
	{
		System.out.println("I move on my own");
	}
		
	void eat(String food){
		System.out.println(food);
	}
}
