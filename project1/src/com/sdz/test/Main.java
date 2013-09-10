package com.sdz.test;
/*
 * http://www.siteduzero.com/informatique/tutoriels/apprenez-a-programmer-en-java/...
 *  ....droits-d-acces-entre-les-packages, part 2, section 4.
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// References to classes within the package. Public id invalid, only final would be OK
		// in main.
		 A a = new A();
		 B b = new B();
		
		// Defining a COW object, with Cow on the right side (instantiated) and Animal (inherited) 
		Animal c = new Cow("White and Black",600);	
		System.out.println("I'm cow c, "+c.color+" ,"+c.weight+" kilos");
		c.eat();			// call eat method in Animal class
		c.drink();			// call drink method in Animal class

		
		// Second method
		Cow c2 = new Cow("Red",450);	
		System.out.println("I'm cow c2, "+c2.color+" ,"+c2.weight+" kilos");
		c2.eat("... I like fresh grass");		// call eat method in Cow class
		c2.drink();							// call drink method in Animal class
		
		// Third method with obj notation.
		Object obj = new Cow("Blue",512);	
		Cow c3 = (Cow)obj;
		System.out.println("I'm cow c3, "+c3.color+" ,"+c3.weight+" kilos");
		c3.eat("...I can eat hay or grass");	// call eat method in Cow class
		c3.drink();							// call drink method in Animal class
		
		// Test Felines
		  Cat f1 = new Cat("Gris bleuté", 20);
		    f1.drink();						// call drink method in Animal class
		    f1.eat("cream");				// call eat method in Cat class
		    f1.move();						// call move method in Feline class
		    f1.sound();						// call sound method in cat class 
		    System.out.println(f1.toString());	// call toString in Animal class
		    
		  Tiger f2 = new Tiger("Yellow and black stripes", 70);
			    f2.drink();
			    f2.eat();					// call eat in Animal class.
			    f2.move();
			    f2.sound();
			    System.out.println(f2.toString());
			    
		// Test Canines
			    Dog d1 = new Dog("curly",5);
			    d1.drink();					// call Animal class
			    d1.eat("I love meat");		// call Canine method
			    d1.move();					// call Canine method
			    d1.sound();					// call Canine method
			    System.out.println(d1.toString());	// Animal method
			    d1.doKiss();						// Rexx method
			    d1.doBrave();						// Rexx method
			    d1.doHug();							// rexx method
			    // using a Rexx dog I cannot use the Animal or Canine methods
			    Rexx r1 = new Dog();
			    r1.doKiss();
			    r1.doBrave();
			    r1.doHug();
			    
	}


}



