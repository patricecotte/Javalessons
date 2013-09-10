package com.sdz.test2;
/*
 * http://www.siteduzero.com/informatique/tutoriels/apprenez-a-programmer-en-java/...
 *  ....droits-d-acces-entre-les-packages, part 2, section 4.
 */

import com.sdz.test.A;		// Import necessary to access A in another package.
import com.sdz.test.B;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// References to classes within the package. Public id invalid, only final would be OK
		// in main.
		A a = new A();
		B b = new B();
	}

}
