import java.util.Scanner;


public class Sdz1 {

	/**
	 * Class name 	= Sdz1
	 * Purpose		= Java lesson 1: Basics, variables, tables
	 * 					reading, writing to the console
	 * 					if, while structures
	 * 					loops 
	 * Version		= 1.0
	 * Dependencies	= none
	 */
	
	// Part 1 - Variables and operators
	// -----------------------------------------------------------------------
	byte a = 10; byte b1;  byte b2 = 2, b3 = 3;
	short vitesseMax = 32000; short vitesseMin;
	long anneeLumiere = 9460700000000000L;  // Note the uppercase L
	float pi = 3.141592653f;				// Note the lowercase f
											// Note the lowercase d
	double division = 0.333333333333333333333333333333333333333333334d;
	char c = 'C';							// Note the simple quotes
	
	// String is a complex type = object. It can be declared in a number of ways:
	// 1. Like a simple variable; Note the double quotes though.
	// 2. Using a the String() method.
	// Strings can be declared initialized or uninitilized.
		String str1 = "My name is";		
		String strNumber2 = new String("Patrice");
		String str3;
		String strNumber4 = new String();
		
	// Declaring variables with operators. Note operators should be used with
	// variables of same type.
		static int num1 = 1+3 ; int num2 = 2 * 6; int num3 = num2/num1; 
	
	// Tables 
	// Syntax	type name[] = {element1, ... element n};
	//	or		type name[] = new type[number];
	//  or		type[n] name= new type
	//
	int 	intTable[] 	= {1,2,3,4,5};
	char 	charTable[]	= {'a','b','c'};
	String 	strTable[] 	= {"a","b","c"}; 
	
	// This table has a first dimension of 2 and a second dimension of 6
	int	intTable2 [] [] = {{1,2,3,4,5,6},{7,8,9,10,11,12}};
		
		
	// Naming:
	// - a class name should start with an uppercase.
	// - variable names start with a lowercase, if compound the appended names
	// start with an uppercase, no underscore.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sdz1 program welcomes you");
		System.out.println("\nMy name is");
		System.out.println("Patrice \"the pirate\".");
		
	// below are examples of assignments
		num1 = num1 + 1;		// 4+1=5
		num1 +=1;				// 5+1=6
		num1++;					// 6+1=7
		++num1; 				// 7+1=8
		System.out.println("\nnum1: "+num1);	// prints 8.
		
	// Operators -,* and / can be used also as above.
		int resultat = num1/num1;
		System.out.println("Résultat:"+resultat);
		
	// Variable cast. A conversion may be required when the source and target variables
	// are of different types.
		int i=123;
		float j = (float)i;		// (float) indicates the desired conversion
		double k = (double)i;	// Cast is actually not needed because
		double l = i;			// a double always contains an integer.
		double m = (double)(j/i);
		System.out.println("i: "+i+",j: "+j+",k: "+k+",l: "+l+",m: "+m);
		
	// The conversion to a String requires the use of a method belonging to the
	// String object. Note an Integer also has methods to convert from a string.
		int n=12; String s = new String(); s = s.valueOf(n);
		int o = Integer.valueOf(n).intValue();
		System.out.println("number :"+n+" has been convered into string: "+s);
		System.out.println("string :"+j+" has been convered into integer: "+o);
				
	// Java 7 enhanced representation
		double nombre = 1000000000000d; double nombre2 = 1_000_000_000_000d; 
		int x = 0xFF; int y = 0b1111_1111; 
				
	// Part 2 - reading, writing to the console
	// --------------------------------------------------------------------------
	// Create a Scanner object in order to read from the console (System.in).
	// 1. The System class (JRE) implements three objects; in, out and err.
	// 2. Scanner is a class in the java.util package; it handles an input stream
	// We define our Scanner object by instantiating the Scanner class. The 
	// resulting object 'sc' is furthermore defined as processing the System.in input
	// Our 'sc' object inherits the methods of the Scanner class, such as nextLine.
	// Another method nextInt limits the input to integers. Methods nextFloat, 
	// nextDouble allows to select different types of input.
		Scanner sc = new Scanner(System.in);    // create teh sc object
		System.out.println("Type in a word using the keyboard: ");
		System.out.println("Your input: "+sc.nextLine());
		System.out.println("Type in a number using the keyboard: ");
	// It user enters anything nut a number an exception is thrown.
		System.out.println("Your input: "+sc.nextInt());
		int num1 = sc.nextInt(); 	// ask a number again (no message!)
	// Note Scanner has no method to receive a Char. Also nextInt does NOT 
	// automatically clear the line so the programmer needs to empty it using
	// the nextLine method.
		sc.nextLine();		
		System.out.println("Type in a word using the keyboard: ");
		System.out.println("Your input: "+sc.nextLine());
		
	// Part 3 - Structures
	// --- operators ---------------------------------------------------------
	//			==		equal 			!=		not equal
	//			<		lesser than		<=		lesser or equal
	//			>		greater than	>=		greater or equal
	//			&&		and				||		or
	//			?		The third 
	// -----------------------------------------------------------------------

	// if else structure with one action per condition
		if (i<10) System.out.println("integer i < 10");
		else System.out.println("\ninteger i >= 10" );
	// if else structure with several actions per conditions.
		if (i > 10) System.out.println("integer i > 10");
		else
		{ if (i==0) System.out.println("i is 0!"); 
				else System.out.println("i between 0 and 10");
		}
	// consolidated else if
		if (i > 10) System.out.println("integer i > 10");
		else if (i==0) System.out.println("i is 0!"); 
		else System.out.println("i between 0 and 10");
	// complex condition
		if (i > 10 && i < 100) System.out.println("i is in the range 11-99");
		else System.out.println("i might be 0 to 10 or 100 and above");
				
	// switch - every condition is evaluated unless the break instruction 
	// terminates it. Note no braces within a case.
		switch (i)
		{ 
		case 0:	
			System.out.println("Switch has found i=0");
			break;
		case 10:
			System.out.println("Switch has detected i=10");
			break;
		default:
			System.out.println("Switch has not found the value of i");
		}
				
	// An example of ? usage. max is assigned x if the condition x<z is true
	// and z otherwise.
		int z = 100; 
		int max =  (x<z) ? x:z;
		System.out.println("x: "+x+",z: "+z+",max: "+max+"\n");
		
		
	// while construct. 
		char response = ' ';
		while (response != 'y' && response != 'n')
		{
			System.out.println("What is your response? (y/n)");
			response = sc.nextLine().charAt(0);
					}
		
		System.out.println("\n");	// skip 2 lines 
		
		int count = 1;
		while (count++ < 5) System.out.println("count="+count);
		
		System.out.println("\n");	// skip 2 lines 
		
		// compare while results. in this construct count is incremented
		// prior to comparing to the constant.
		count = 1;
		while (++count < 5) System.out.println("count="+count);
		
		// do while construct executes at least once. The while is a condition.
		
		response = ' ';
		do {
			System.out.println("What is your response? (y/n)");
			response = sc.nextLine().charAt(0);
		} while (response != 'y' && response != 'n');
		
				
		// for construct.
		for (count=1; count < 5; count++)
		{
			System.out.println("looped "+count+" times");
		}
		
		
		// Part 4 - tables. The first occurrence in a table has the index 0.
		// a table has specific attributes. Each entry can be accessed using
		// its index
		int intTab[] = {1,2,3,4,5,6};
		if (intTab.length > 0) {
		    count = 0;
			do{
				System.out.println("intTab["+count+"]="+intTab[count]);
				count++;
			} while (count < intTab.length);
		}
		
		// In the below setup the first dimension is 2, the second dimension is 5.		
		int firstNumbers [][] = {{0,2,4,6,8},{1,3,5,7,9}};
		int d1=0; int d2=0;
		while (d1<2)
		{
			while (d2<5)
				{System.out.println("Row "+d1+","+d2+": "+firstNumbers[d1][d2]);
				 d2++;
				}
			d1++; d2=0;
		}
		
// End of main
	}
// End of class
}


