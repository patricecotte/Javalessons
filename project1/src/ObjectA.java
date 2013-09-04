
public class ObjectA {

	/*
	 * Class name	ObjectA
	 * Version 		1.0
	 * Purpose		Java training - UML basics
	 * Dependencies	ObjectC class
	 */
	
	// Object A contains an Object C and up to 10 ObjectDs 
	protected Object C;
	protected ObjectD[] objD = new ObjectD[10];

	// Generated Getters and Setters
	public Object getC() {
		return C;
	}

	public void setC(Object c) {
		C = c;
	}

	// ObjectA authorizes multiple occurrences of ObjectD
	public ObjectD[] getObjectD(){
	    return objD;
	}	
// End of ObjectA 	
}

// ObjectB is an extension of ObjectA
class ObjectB extends ObjectA{
	/* 
	 * Class name	ObjectB
	 * Version		1.0
	 * Purposr		Java training - UML basics 
	 */
	
}