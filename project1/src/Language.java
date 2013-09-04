/*
 * Enum class for sdz4 java class that defines a list of authorized languages.
 * It is a static list. Note the values are separated by commas.
 * 
 * Being a class it inherits the java.lang.Enum class
 */
public enum Language {
	  JAVA("Java Language") ,
	  C("C Language"),
	  CPlus("C++ Language"),
	  PHP("PHP Language");
	  
// Constructor
	  private String name="";
	  Language(String name){
		  this.name = name;
	  }
	  
// Publish name
	  public String toString(){
		  return this.name();
	  }
	  
// An Enum class can have its main.
	  public static void main(String args[]){
		    Language l1 = Language.JAVA;
		    Language l2 = Language.PHP;
		    
		  }
}
