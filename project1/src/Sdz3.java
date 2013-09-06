
public class Sdz3 {

	/**
	 * Sdz3 depends on Town class. 
	 * Chapter2, section Exception. Thow an exception when the number of inhabitants is negative
	 */
	public static void main(String[] args) {

	// Create a Town object. In this syntax
	// - Town is the type of object town1 (with an initial lowercase).
	//   It must match the return type of method Town.
	// - new indicates to the JVM to create the object.
	// Because of the exception and the try..catch hides the objects bein created we must
	// first create the objects nulls, then override them within the try..catch
	Town town  = new Town();
	
	Town town1 = null;
	Town town2 = null;
		
	try {
	 town1 = new Town("Paris", "France", 2000000);
		} catch (InhabitantsNumberException e){}
	
	try {
	 town2 = new Town("Lyon", "France", 1000000);
		} catch (InhabitantsNumberException e){}
	
	
	// interestingly objects within obejct town1 are not visible but the
	// object itself can be printed. Gives something like Town@734d246
	System.out.println(town1);
	
	// Use the accessor and mutators against town1 Object
	System.out.println("\nTown: "+town1.getName()+"\nCountry: "+town1.getCountryName()+"\nInhab.:"+town1.getInhabitantsNumber()+"\nCategory: "+town1.getCategory());
	town1.setName("Paris");
	town1.setCountryName("Texas, USA");
	town1.setInhabitants(19999900);

	System.out.println("\nTown: "+town1.getName()+"\nCountry: "+town1.getCountryName()+"\nInhab.:"+town1.getInhabitantsNumber()+"\nCategory: "+town1.getCategory());
	
	// run the public method towninfo and compare in Town class
	System.out.println(town1.townInfo());
	System.out.println(town2.townInfo());
	System.out.println("Number of towns in our table: "+Town.getPrvNumInstances());
	System.out.println(town1.compare(town2));
	
	// check out derived class Capital works Ok.
	Capital cap = null;							// Create cap 
	try {
		cap = new Capital("Paris","France",-1,"La tour Eiffel");
		} catch (InhabitantsNumberException e){} 
	System.out.println(cap.townInfo());
	
	// show townInfo is polymorphic. This means it can (apparently) return different 
	// results based on the parameters it has been passed.
	Town[] table 	= new Town[6]; 			// create a table
	String [] tab1 	= {"Omaha","Plano","Reno","San Francicso","Washington","Salt Lake City"};
	int [] tab2		= {1,2,3,4,5,6};
	
	for (int i=0; i<6; i++) {
		if(i<3) {
			Town T = null;				// create a Town object
			try{						// override it
				T = new Town(tab1[i],"United States",tab2[i]);
				} catch (InhabitantsNumberException e){}
			table[i] = T;
		}
		else {
			Capital C = null;			// Create a Capital object
			try{						// override it
				C = new Capital(tab1[i],"United States",tab2[i],"Capitol");
			} catch (InhabitantsNumberException e){}
			table[i] = C;
		}
		
	}
	System.out.println(table[4].townInfo()+"\n");
	System.out.println(table[1].townInfo()+"\n");
	for (Town t:table) System.out.println(t.townInfo());
	
	
	} //  End of main	

} // End of class

