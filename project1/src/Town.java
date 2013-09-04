
public class Town {

	/*
	 * Name			Town
	 * Version		1.0
	 * Purpose		Defines the Town object
	 * Dependencies Because an Exception class has been inserted in Sdz3
	 * 		Try .. catch blocks must be used when instantiating Town
	 */
	
	// VARIABLES --------------------------------------------------------
	// The below variables are instantiated variables, which means a set
	// of these variables is created for each instance of the class. They are
	// created private (default is public) so that main cannot change any property
	// using a form such as townx.townName="xxxxx"
	//
	// Other variables can be
	// - class variables, one set that all the instances of the class share
	// - local variables, these are work variables.
	protected String townName;
	protected String countryName;
	protected int	inhabitantsNumber;
	protected char category;
	
	protected static int pubNumInstances = 0;		// public static variable
	protected static int prvNumInstances = 0;		// private static variable 
	
	// CONSTRUCTORS ----------------------------------------------------
	// A constructor has the same name as the class it instantiates.
	// It receives no parameter.
	// It returns void. DO NOT SET VOID in the declaration though.
	// DO NOT TYPE the variables!!!!
	public Town(){
		townName= "none";
		countryName="none";
		inhabitantsNumber=0;
		this.setCategory();				// calls a private method
		pubNumInstances++;				// increment instances
		prvNumInstances++;				// 			on each call 
	}
	
	// Create an overload for Town so that objects can be created with variables and exceptions
	public Town(String Tname, String Cname, int Nbr)
			throws  InhabitantsNumberException, TownNameException
	{
		if(Nbr< 0)
		      throw new InhabitantsNumberException(Nbr);   // use alternate Exception class 
		    else
		    {
		townName=Tname;
		countryName=Cname;
		inhabitantsNumber=Nbr;
		this.setCategory();		  		// calls a private method
		pubNumInstances++;				// increment instances
		prvNumInstances++;				// 			on each call 
		    }
		
		if(Tname.length() < 3)
			    throw new TownNameException("The name of a town cannot be lesser than 3 characters! " + Tname);
			  else
			  {
			    pubNumInstances++;  
			    prvNumInstances++;
			 
			    townName = Tname;
			    countryName = Cname;
			    inhabitantsNumber = Nbr;
			    this.setCategorie();
			  }  
	}
	
	private void setCategorie() {
		// TODO Auto-generated method stub
		
	}

	// ACCESSORS and MUTATORS access variables in a Town object.
	// Accessors have a return type the same type as the extraced variable
	// Mutators return nothing - void
	// Naming:	Accessors = Getters, their name should start with get.
	//			Mutators = Setters, their name should start with set.
	// This conforms to the principle of encapsulation.
	// ---------------------------------------------------------------------
	public String getName(){
		return townName;
	}
	
	public String getCountryName(){
		return countryName;
	}
	
	public int getInhabitantsNumber(){
		return inhabitantsNumber;
	}
	
	public char getCategory(){
		return category;
	}
	
	// note, method is declared static. It will be used with the Town class
	// object (to retrieve a calls variable), not a particular instance!
	public static int getPrvNumInstances(){
		return prvNumInstances;
	}
	
	public void setName(String pName){
		townName=pName;
	}
	
	public void setCountryName(String pCname){
		countryName=pCname;
	}
	
	public void setInhabitants(int pNum){
		inhabitantsNumber=pNum;
	}
	
	// private method for the constructor.
	private void setCategory(){
		/*
		 * This private method is executed by the constuctor and sets a category
		 * depending on the number of inhabitants.
		 */
		int bounds[]		= {0,10000,100000,10000000,10000000,100000000};
		char categories[] 	= {'?','A','B','C','D','E','F'};
		
		int i = 0;
		this.category='*';
		while(i < bounds.length && this.inhabitantsNumber >= bounds[i]) {
			this.category=categories[i];
			i++;
		}
	}	
	
	// public methods that manipulates town objects.
	// townInfo gets the information for one object
	// compare compares two objects.
	public String townInfo(){
		return "\ntown "+this.townName+" in "+this.countryName+" is a town in category "+this.category;
	}
	
	public String compare(Town t1){
		String str = new String();
		if(this.inhabitantsNumber > t1.inhabitantsNumber) {
			str = "\n"+this.townName+" is a bigger town than "+t1.townName;
		}
		else str = "\n"+t1.townName+" is a bigger town than "+this.townName;
		
		return str;
	}
	
	
} // End of class 


// An extension can be placed in the same source as the class it extends
// A difference with the C++ language is a Java class cannot inherit several classes
// Note the Capital MUST implement the Exception class for Town!
// ----------------------------------------------------------------------------------
class Capital extends Town{
	/*
	 * Class name	Capital
	 * version		1.0
	 * Usage		Define a subset of Town
	 * Dependencies	Town
	 */
	
	private String monument;			// An addition to Town
	
	// Default and instantiating constructors.
	public Capital(){
		super();						// copy mom's objects 
		monument="none";				// initialize variable
	}
	
	public Capital(String Tname, String CName, int Nbr, String monmt)
	throws InhabitantsNumberException, TownNameException {
		super(Tname, CName, Nbr);
		this.monument=monmt;
	}
	
	// getters and setters
	public String getMonument(){
		return this.monument;
	}
	
	public void setMonument(String pMonum){
		this.monument=pMonum;
	}
	
	// Methods can also invoke super() to call the base class method
	public String townInfo(){
		return super.townInfo()+"\n and has this monument:"+this.monument;
	}
	
	// final methods cannot be overloaded or redefined.
	public final  int mymethod(){
		// statements
		return 0;
		}

} // End of class

/*
 * Exceptions for the Town class 
 */
class InhabitantsNumberException extends Exception{ 
	  public InhabitantsNumberException(){
	    System.out.println("Can't instantiate a Town object with a negative number of inhabitants!");
	  }  
	  
	  // This second constructor allows to use the Exception passing parameters to it.
	  public InhabitantsNumberException(int num)
	  {
	    System.out.println("Instantiation with a negative number.");
	    System.out.println("\t => " + num);
	  }
} // End of class

class TownNameException extends Exception { 
	  public TownNameException(String message){
	    super(message);
	  }        
	}





