package com.sdz.test;


	// An abstract class can extend an abstract class.
	public abstract class Canine extends Animal{
		void move()
		{
			System.out.println("I move in groups");
		}
			
		void eat(String food){
			System.out.println(food);
		}
	}

