	/**
	 * Sdz4 tests List and Map collections
	 * - LinkeList implements the LinkedList class from the Java libraries
	 * 		* add, get, listIterator, listIterator.hasNext, listIterator.next
	 * - ArrayList implements the LinkedList class from the Java libraries
	 * 		* add, get
	 * Other methods are remove(int i); isEmpty(); removeAll(); contains(Object element);
	 * - Map implements a number of java methods: put, elements, hasMoreElements, nextElement 
	 *  contains(value), isEmpty(), containsValue(value), containsKey(key), put(Key, value), 
	 *  elements(), keys()
	 *  - Set implements their java classes and methods: iterator, hasnext(), next(). 
	 *  The toArray() method creates an array from a Hashset.   
	 *  - Genericity
	 *  - Genericy and collections
	 *  - Genericiy, collections and inheritance.
	 */
	
// LinkedList collections.
import java.util.LinkedList;			
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
// Map collections
import java.util.Enumeration;	
import java.util.Hashtable;
// Set collections
import java.util.HashSet;
import java.util.Iterator;

public class Sdz4 {


	public static void main(String[] args) {
	    // Linked list
	    List l = new LinkedList();					// Create LinkeList
	    l.add(12);									// Add 3 elements
	    l.add("Dilbert !");
	    l.add(12.20f);
	 
	    for(int i = 0; i < l.size(); i++)
	    {
	      // Use the get method on the index
	      System.out.println("Element with index " + i + " = " + l.get(i));
	 
	      System.out.println("\nWalking through the List using an iterator");
	      System.out.println("------------------------------------------");
	      
	      // Use the listIterator method to get the list elements
	      ListIterator li = l.listIterator();
	 
	      while(li.hasNext())
	        System.out.println(li.next());
	    }
	    
	     // Array list
	     ArrayList al = new ArrayList();			// Create the array
	     al.add(12);								// add 4 entries
	     al.add("I'm a string !");
	     al.add(12.20f);							// f means floating number
	     al.add('d');
	                 
	     
	     System.out.println("\nWalking through an Array ");
	     System.out.println("------------------------");
	      
	     for(int i = 0; i < al.size(); i++)
	     {
	    	 // get method 
	       System.out.println("entry at rank " + i + " = " + al.get(i));
	     }  
	     
	     // Map - note the keys are discontinuous. 
	     Hashtable ht = new Hashtable();			// Create a Map collection
	     ht.put(1, "printemps");					// Add 4 elements to it
	     ht.put(10, "été");
	     ht.put(12, "automne");
	     ht.put(45, "hiver");
	  
	     Enumeration e = ht.elements();
	     
	     System.out.println("\nWalking through a Hash table ");
	     System.out.println("------------------------");
	  
	     while(e.hasMoreElements())
	       System.out.println(e.nextElement());
	     
	     // Set methods are very much like LinkedList methods 
	     HashSet hs = new HashSet();				// Create a hashset
	     hs.add("Mr Jones");						// add 3 elements
	     hs.add(12);
	     hs.add('d');
	  
	     
	     System.out.println("\nUsing an interator to get the objects LIFO");
	     System.out.println("-----------------------------------------");
	     Iterator it = hs.iterator();				// get the set contents
	     while(it.hasNext())
		        System.out.println(it.next());
	     
	     while(it.hasNext())
	       System.out.println(it.next());
	   
	     System.out.println("\nHash objects are retrieved FILO");
	     System.out.println("-------------------------------");
	      
	     // Making an Array from the Hashtable
	     Object[] obj = hs.toArray();
	     for(Object o : obj)
	       System.out.println(o);    
	     
	     
	     // Working with Generic objects: the Solo class
	     Solo<Integer> val = new Solo<Integer>();
	     val.setValue(99);
	     Solo<String> valS = new Solo<String>("TOTOTOTO");
	     Solo<Float> valF = new Solo<Float>(12.2f);
	     Solo<Double> valD = new Solo<Double>(12.202568); 

	     System.out.println("\nObjects based on the generic Solo class");
	     System.out.println("---------------------------------------");
	      	     
	     System.out.println("Solo val ...."+val.getValue());
	     System.out.println("Solo valS...."+valS.getValue());
	     System.out.println("Solo valF ..."+valF.getValue());
	     System.out.println("Solo valD ..."+valD.getValue());
	     
	     // Working with Generic objects: the Duo class
	     Duo<String, Boolean> dual = new Duo<String, Boolean>("toto", true);
	     Duo<Double, Character> dual2 = new Duo<Double, Character>(12.2585, 'C');
	     System.out.println("\nObjects based on the generic Duo class");
	     System.out.println("--------------------------------------");
	     System.out.println("Values for dual : val1 = " + dual.getValue1() + ", val2 = " + dual.getValue2());                  
	     System.out.println("Values for dual2: val1 = " + dual2.getValue1() + ", val2 = " + dual2.getValue2()); 

	     // Use Genericity on collections. These predefined objects are GENERIC actually! 
	     System.out.println("List of Strings");
	     System.out.println("------------------------------");
	     List<String> strList= new ArrayList<String>();
	     strList.add("One string");
	     strList.add("A second string");
	     strList.add("One more");
	     strList.add("The last one");
	    
	     for(String str : strList)
	       System.out.println(str);
	    
	     System.out.println("\nList of floats");
	     System.out.println("------------------------------");
	                    
	     List<Float> fltList = new ArrayList<Float>();
	     fltList.add(12.25f);
	     fltList.add(15.25f);
	     fltList.add(2.25f);
	     fltList.add(128764.25f);
	                    
	     for(float f : fltList)
	       System.out.println(f);  
	     
	     // Genericity, collections and inheritance
	     List<Voiture> listVoiture = new ArrayList<Voiture>();
	     listVoiture.add(new Voiture());
	     listVoiture.add(new Voiture());
	    
	     List<Object> listVoitureSP = new ArrayList<Object>();
	     listVoitureSP.add(new Object());
	     listVoitureSP.add(new Object());
	    
	     affiche(listVoiture);   
	     
	  } //  End of main


static void affiche(List<? super Voiture> list){
	  for(Object v : list)
	    System.out.print(v.toString());
	}
	


} // End of class


// Solo is a generic class. If public it needs to be in its own file.
 class Solo<T> {
	  
	  //private instantiation variable
	  private T value;
	         
	  //Default constructor
	  public Solo(){
	    this.value = null;
	  }
	 
	  //Fullfledged constructor
	  public Solo(T val){
	    this.value = val;
	  }
	         
	  //Method that sets the value
	  public void setValue(T val){
	    this.value = val;
	  }
	         
	  //Method that retrieves the value
	  public T getValue(){
	    return this.value;
	  }       
	} // End of class Solo
 
 // Duo is another example of a generic class. 
 class Duo<T, S> { 
	  //Variable d'instance de type T
	  private T value1;
	 
	  //Variable d'instance de type S
	  private S value2;
	         
	  //Constructeur par défaut
	  public Duo(){
	    this.value1 = null;
	    this.value2 = null;
	  }        
	 
	  //Constructeur avec paramètres
	  public Duo(T val1, S val2){
	    this.value1 = val1;
	    this.value2 = val2;
	  }
	         
	  //Méthodes d'initialisation des deux values
	  public void setValue(T val1, S val2){
	    this.value1 = val1;
	    this.value2 = val2;
	  }
	  
	  //Retourne la value T
	  public T getValue1() {
	    return value1;
	  }
	  
	  //Définit la value T
	  public void setValue1(T value1) {
	    this.value1 = value1;
	  }
	  
	  //Retourne la value S
	  public S getValue2() {
	    return value2;
	  }
	  
	  //Définit la value S
	  public void setValue2(S value2) {
	    this.value2 = value2;
	  }        
	} // End of class Duo. 
 
 class Voiture <V> {
	 private V value;
	 
	 // Default constructor 
	 public Voiture(){
		 this.value = null;
	 }
	 
	 public Voiture(V val){
		 this.value = val;
	 }
	 
	 public void setVoiture(V val){
		 this.value = val;	 
	 }
	 
	 public V getVoiture(){
		 return this.value;	 
	 }
	 
 } // End of class Voiture


