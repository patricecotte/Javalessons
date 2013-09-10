package com.sdz.test;

public class Cow extends Animal{

	public Cow(){};
	
	public Cow(String color, int weight){
		this.color=color;
		this.weight=weight;
	}
	
	void moo(){
		System.out.println("I'm a cow and I moo");
	}
	
	void eat(String food){
		System.out.println(food);
	}
	
	// implement abstrac methods of animal
	void eat(){};
	void move(){};
	void sound(){};
}
