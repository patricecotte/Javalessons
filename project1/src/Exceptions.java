
public class Exceptions {

	/**
	 * Chapter 2, section Exceptions.
	 * the try ... catch block; the try ... catch ... finally block
	 */
	public static void main(String[] args) {
		  int j = 20, i = 0;
		  try {
		    System.out.println(j/i);
		    // Catch arithmetic exceptions only!
		  } catch (ArithmeticException e) {
		    System.out.println("Can't divide by zero !"+e.getMessage());
		  }
		  System.out.println("caught you !");

		  // with finally the program is given an opportunity to perform some
		  // actions such as closing files.
		  try {
			    System.out.println(" =>" + (1/0));
			  } catch (ClassCastException e) {
				  System.out.println("---- CATCH ....");   // Does not show!
				  e.printStackTrace();
			  }
			  finally{
			    System.out.println("FINALLY is performed ahead of the trace...");
			  }
		  
	}

}
