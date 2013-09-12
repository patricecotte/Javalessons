import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Sdz7 {

	/**
	 * Sdz7  is about dynamic instantiation
	 */
	public static void main(String[] args) {
		
	// In this example we create a Pair object without using 
	// the 'new' operator
		
	String clname = Pair.class.getName();     		// Get Pair class name           
	  try {
		    Class cl = Class.forName(clname);		// Create a Class
		    Object o = cl.newInstance();			// Instantiate cl
		 
		    //Create types = an array of classes for the constructors
		    Class[] types = new Class[]{String.class, String.class};
		    //Get the constructor from types.
		    Constructor ct = cl.getConstructor(types);
		 
		    //Instantiate object o2 with the above oveloaded constructor !
		    Object o2 = ct.newInstance(new String[]{"Hi ", "there!"} );
		    
		    //Use method toString - no parameters expected
		    Method m = cl.getMethod("toString", null);
		    //Use method invoke to execute on the object (first parm) the specified method (second parm)
		    //or null if none.
		                                 
		    System.out.println("----------------------------------------");
		    System.out.println("Méthod " + m.getName() + " applied to o2: " +m.invoke(o2, null));
		    System.out.println("Méthod " + m.getName() + " applied to o: " +m.invoke(o, null));
		 
		  } catch (SecurityException e) {
		    e.printStackTrace();
		  } catch (IllegalArgumentException e) {
		    e.printStackTrace();
		  } catch (ClassNotFoundException e) {
		    e.printStackTrace();
		  } catch (InstantiationException e) {
		    e.printStackTrace();
		  } catch (IllegalAccessException e) {
		    e.printStackTrace();
		  } catch (NoSuchMethodException e) {
		    e.printStackTrace();
		  } catch (InvocationTargetException e) {
		    e.printStackTrace();
		  }
		
	

	} // End of main

} // End of class

// New class
 class Pair {
	 private String value1, value2;
	 
	 public Pair(){ // Default constructor
		 this.value1 = null; this.value2 = null;
		 
	 } // End of default constructor
	 
	 public Pair(String val1, String val2){
		 this.value1 = val1;  this.value2 = val2; 
	 } // End of constructor

	@Override
	public String toString() {
		return "Pair [value1=" + value1 + ", value2=" + value2
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	
	
} // End of class Pair