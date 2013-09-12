import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Sdz6 {

	/**
	 * An example with a pattern decorator. 
	 * Class exploration
	 */
	public static void main(String[] args) {
		// Create a Pastry. Note
		// - All the layer objects are at the same level.
		// - ChocolateLayer is called twice.
		// - prepare is invoked recursively while going through the objects
	    Pastry pat = new ChocolateLayer(
                new ToffeeLayer(
                  new BisquitLayer(
                    new ChocolateLayer(
                      new Cake()))));
	    System.out.println(pat.prepare());
	    
	    // Explore the String class and extract information about it.
	    Class c = String.class;					// This is equivalent to giving a defining a nickname
	    Class c2 = new String().getClass();		// getClass is inherited from the Object class
	    
	    // These 3 prints will show super class java.lang.Object; Obejct has no super class 
	    System.out.println("Superclass of class " + String.class.getName() + " is : " + String.class.getSuperclass());
	    System.out.println("Superclass of class c is : " + c.getSuperclass());
	    System.out.println("Superclass of class c2 is : " + c2.getSuperclass());
	    System.out.println("Superclass of class " + Object.class.getName() + " is : " + Object.class.getSuperclass());
	    
	    // List the interfaces of the String class into an array of classes
	    Class[] faces = String.class.getInterfaces();
	    System.out.println("\n\n Interfaces for the String class");
	    System.out.println("-----------------------------------");
	    System.out.println("Found " + faces.length + " interfaces for class "+String.class.getName());
	    
	    for(int i = 0; i < faces.length; i++)
	      System.out.println(faces[i]);
	    
	    // List the methods of the 'c' String class. Method = java.lang.reflect.Method.
	    // Each 'm' entry contains the method prototype.
	    Method[] m = c.getMethods();

	    System.out.println("\n\n Methods for the 'c' String class");
	    System.out.println("-----------------------------------");
	    System.out.println("Il y a " + m.length + " méthods in this class");
	    
	    for(int i = 0; i < m.length; i++)
	      System.out.println(m[i]);
	    
	    // List the methods and the expected parameters
	    System.out.println("\n\n Methods and parameters for the 'c' String class");
	    System.out.println("-----------------------------------");

	    for(int i = 0; i < m.length; i++)
	    {
	      System.out.println(m[i]);
	   
	      Class[] p = m[i].getParameterTypes();		// Note this is an array of classes
	      for(int j = 0; j < p.length; j++)
	        System.out.println(p[j].getName());
	   
	      System.out.println("----------------------------------\n");
	    }
	    
	    // List fields for the 'c' String class
	    Field[] f = c.getDeclaredFields();
	    
	    System.out.println("\n\n Fields  for the 'c' String class");
	    System.out.println("-----------------------------------");
	    System.out.println("There are " + f.length + " fields in the 'c' String class");
	     
	    for(int i = 0; i < f.length; i++)
	      System.out.println(f[i].getName());
	    
	    // List the constructors for the class
	    Constructor[] construc = c.getConstructors();   
	    System.out.println("\n\n Constructors for the 'c' String class");
	    System.out.println("-----------------------------------------");
	    System.out.println("There are " + construc.length + " constructeurs in the 'c' String class");
	    
	    for(int i = 0; i < construc.length; i++){
	      System.out.println(construc[i].getName());
	   
	    Class[] param = construc[i].getParameterTypes();                        
	    for(int j = 0; j < param.length; j++)
	      System.out.println(param[j]);
	   
	    System.out.println("-----------------------------\n");
	    }
	    
	} // End of main

} // End of Sdz6 


/*
*  Objects are set set here. Usually they would be public objects each in its own java file.
*/ 

// The Pastry object is an abstract class that implements an abstract method
abstract class Pastry {
	  public abstract String prepare();    		
	}  // End of Pastry class

// Cake extends Pastry and redefines the prepare method
class Cake extends Pastry{
  public String prepare() {
    return "I am cake made of: \n";
  }
} // End of Cake class

// Layer is an abstract object that extends Pastry. It implements its prepare method.  
abstract class Layer extends Pastry{
	  protected Pastry pat;
	  protected String name;
	 
	 // Default constructor
	  public Layer(Pastry p){
	    pat = p;
	  }
	 
	  public String prepare() {
	    String str = pat.prepare();
	    return str + name;
	  }
	} // End of Layer class

// ChocolateLayer extends Layer and Pastry
class ChocolateLayer extends Layer{
	  public ChocolateLayer(Pastry p) {
	    super(p);
	    this.name = "\t- A Chocolate layer.\n";
	  }
	} // End of ChocolateLayer

// ToffeeLayer extends Layer and Pastry
class ToffeeLayer extends Layer{
	  public ToffeeLayer(Pastry p) {
	    super(p);
	    this.name = "\t- A Toffee layer.\n";
	  }
	} // End of ToffeeLayer

// BisquitLayer extends Layer and Pastry
class BisquitLayer extends Layer {
	  public BisquitLayer(Pastry p) {
	    super(p);
	    this.name = "\t- A Bisquit layer.\n";
	  }
	}

