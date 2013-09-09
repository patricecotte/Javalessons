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
	 *  java.io.File and Unit and File access. Other File methods; delete, mkdir
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
import java.util.Set;
// IO
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
	     ht.put(10, "�t�");
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
	     Car<String> v1 = new Car<String>("Volvo");
	     Car<String> v2 = new Car<String>("Peugeot");
	     // List<Car<String>> listCar = new ArrayList<Car<String>>();
	     // Car<String> v1 = new Car<String>("Volvo");
	     // Car<String> v2 = new Car<String>("Peugeot");
		 // listCar.add(new Car(v1));
		 // listCar.add(new Car(v2));
	     List<Car> listCar = new ArrayList<Car>();
	     listCar.add((Car<String>) v1);					// add is a method of List
	     listCar.add((Car<String>) v2);					// cast Car object
	    
	     List<Object> listCarSP = new ArrayList<Object>();
	   //  Car sp1 = new Car("VolvoSP");
	   //  Car sp2 = new Car("PeugeotSP");
	   //  listCarSP.add(new Object()); 
	     listCarSP.add("VolvoSP");			// add is a method of List
	     listCarSP.add("PeugeotSP");		
	    
	     showCar(listCar);   
	     showCar(listCarSP);
	     
	     listCar.add(new Car());            
	  //   listCarSP.add(new CarNoLicense());
	            
	     Garage garage = new Garage();
	     garage.add(listCar);
//	     garage.add(listCarSP);  
	          

	     // Use the simple generic class box
	     Box<Integer> integerBox = new Box<Integer>();
	     Box<String> stringBox = new Box<String>();
	    
	     integerBox.add(new Integer(10));
	     stringBox.add(new String("Hello World"));
	     System.out.println("\n\nExample of a simple generic class Box");
	     System.out.println("----------------------------------------");
	     System.out.printf("Integer Value :%d\n\n", integerBox.get());
	     System.out.printf("String Value :%s\n", stringBox.get());
	     
	     // Use the generic Entry class
	     Entry<String, String> grade440 = new Entry<String, String>("mike", "A");
	     Entry<String, Integer> marks440 = new Entry<String, Integer>("mike", 100);
	     System.out.println("\n\nExample of a generic class with two attributes");
	     System.out.println("-------------------------------------------------");
	     System.out.println("grade toString: " + grade440.toString());
	     System.out.println("grade getKey  : " + grade440.getKey());
	     System.out.println("grade getValue: " + grade440.getValue());
	     System.out.println("marks: " + marks440);
	     
	
	     // Test the generic method PrintArray
	     // Create arrays of Integer, Double and Character
	     Integer[] intArray = { 1, 2, 3, 4, 5 };
	     Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
	     Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

	     System.out.println("\n\nExample of a generic method: printArray");
	     System.out.println("-------------------------------------------");
	     System.out.println( "Array integerArray contains:" );
	     printArray( intArray  ); // pass an Integer array

	     System.out.println( "\nArray doubleArray contains:" );
	     printArray( doubleArray ); // pass a Double array

	     System.out.println( "\nArray characterArray contains:" );
	     printArray( charArray ); // pass a Character array
	     
	     
	     // Usage of the java File object. Create the File object
	     File f = new File("src/Javaio.txt");
	 	 System.out.println("\n\nComplete path : " + f.getAbsolutePath());
	 	 System.out.println("File name : " + f.getName());
	 	 System.out.println("Does it exist ? " + f.exists());
	 	 System.out.println("Is a repertory? " + f.isDirectory());
	 	 System.out.println("Is a file ? " + f.isFile());
	    	    
	 	 /* listRoots returns File objects
	 	 System.out.println("Units at this machin's root : ");
	 	 for(File file : f.listRoots())
	 	    {
	 	    	System.out.println(file.getAbsolutePath());
	 	    	try {
	 	    		int i = 1;  
	 	    		//List files and repertories
	    	        for(File nom : file.listFiles()){
	    	          //Add "/" for a File
	    	          System.out.print("\t\t" + ((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()));
	    	          
	    	          // Looks like we have a number of variables ...
	    	          if((i%4) == 0){
	    	            System.out.print("\n");
	    	          }
	    	          i++;
	    	        }
	    	        System.out.println("\n");
	    	      } catch (NullPointerException n) {
	    	  //NullPointerException is generated when no subfolder exists
	    	      }
	    	    }       
	 	 */
	 	 
	 	// Work with file contents - FileInputStream anf FileOutputStream 
	 	// The below code is basic, using methods that are based on the UNICODE 1.
	 	// (Only a-z A_Z and numbers ASCII bytes)  
	    // Create objects outside try/catch
	      FileInputStream fis = null;
	      FileOutputStream fos = null;
	 
	      try {
	         fis = new FileInputStream(new File("src/Javaio.txt"));   // Input
	         fos = new FileOutputStream(new File("src/Javaio2.txt")); // Output (new)
	 
	         // Create a byte buffer to indicate how many bytes are written each loop
	         byte[] buf = new byte[8];
	 
	         // Read return code; -1 on EOF
	         int n = 0;
	 
	         // While not EOF read and write
		     System.out.println("\n\nExample using the File methods");
		     System.out.println("---------------------------------");
	         while ((n = fis.read(buf)) >= 0) {
	            // Write to fos object
	            fos.write(buf);
	            // Show the buffer (hex bit value + corresponding char value).
	            for (byte bit : buf) {
	               System.out.print("\t" + bit + "(" + (char) bit + ")");
	               System.out.println("");
	            }
	         }
	         System.out.println("File has been copied.");
	 
	      } catch (FileNotFoundException nf) {
	         // Trap input file's not there
	         nf.printStackTrace();
	      } catch (IOException nf) {
	         // Trap read-write errors
	         nf.printStackTrace();
	      } finally {
	         // Close File Streams when an exception is raised!
	         try {
	            if (fis != null)
	               fis.close();
	         } catch (IOException nf) {
	            nf.printStackTrace();
	         }
	 
	         try {
	            if (fos != null)
	               fos.close();
	         } catch (IOException nf) {
	            nf.printStackTrace();
	         }
	      }
	 
	    //  Compare the File method and Buffer methods 
	      FileInputStream fis2;				// Create our 4 objects
	      FileOutputStream fos2;
	      BufferedInputStream bis2;         // outside the try-catch structure
	      BufferedOutputStream bos2;
	      try {
	        fis2 = new FileInputStream(new File("Dictionnaire.txt"));
	        fos2 = new FileOutputStream(new File("Dictionnaire2.txt"));
	        bis2 = new BufferedInputStream(new FileInputStream(new File("Dictionnaire.txt")));
	        bos2 = new BufferedOutputStream(new FileOutputStream(new File("Dictionnaire3.txt")));
	        
	        byte[] buf = new byte[8];
	   
		     System.out.println("\n\nCompare the File and Buffered methods");
		     System.out.println("---------------------------------");
	        //Note the system clock, read until EOF and show the elapsed time.
	        long startTime = System.currentTimeMillis();
	        while(fis2.read(buf) != -1) {
	        		fos2.write(buf);}
	        System.out.println("FileInput/OutputStream read elapsed time: " + (System.currentTimeMillis() - startTime));
	                   
	        //Same using the BufferInputStream object and method.              
	        startTime = System.currentTimeMillis();
	        while(bis2.read(buf) != -1){
	        	 bos2.write(buf);
	        }
	        System.out.println("BufferedInput/OutputStream read elapsed time: " + (System.currentTimeMillis() - startTime));
	                   
	        //Close the file objects
	        fis2.close();
	        fos2.close();
	        bis2.close();
	        bos2.close();
	                   
	      } catch (FileNotFoundException e2) {
	        e2.printStackTrace();
	      } catch (IOException e2) {
	        e2.printStackTrace();
	      }       
	 	
	      
	    // Example with the DataInput/OuputStream.
	      DataInputStream dis;							// Set up two objects
	      DataOutputStream dos;
	      try {											// note the cascading instantiation
	        dos = new DataOutputStream(
	                new BufferedOutputStream(
	                  new FileOutputStream(
	                    new File("Dataio.txt"))));
	   
		    System.out.println("\n\nAn example with the DataInput/Output methods");
		    System.out.println("---------------------------------");
	        //In order to use this technique we need to know the structure of the record
	        dos.writeBoolean(true);
	        dos.writeByte(100);
	        dos.writeChar('C');
	        dos.writeDouble(12.05);
	        dos.writeFloat(100.52f);
	        dos.writeInt(1024);
	        dos.writeLong(123456789654321L);
	        dos.writeShort(2);
	        dos.close();
	               
	        //Read back our line 
	        dis = new DataInputStream(					// note the cascading instantiation
	                new BufferedInputStream(
	                  new FileInputStream(
	                    new File("Dataio.txt"))));
	               
	        System.out.println(dis.readBoolean());
	        System.out.println(dis.readByte());
	        System.out.println(dis.readChar());
	        System.out.println(dis.readDouble());
	        System.out.println(dis.readFloat());
	        System.out.println(dis.readInt());
	        System.out.println(dis.readLong());
	        System.out.println(dis.readShort());
	               
	      } catch (FileNotFoundException d) {
	        d.printStackTrace();
	      } catch (IOException d) {
	        d.printStackTrace();
	      }      
	      
	      
	    // Example with serializable objects
	      ObjectInputStream ois;					// create 2 objects
	      ObjectOutputStream oos;					// outside try-catch
	      try {
	        oos = new ObjectOutputStream(			// Inheritance ... 
	                new BufferedOutputStream(
	                  new FileOutputStream(
	                    new File("game.txt"))));
	               
	        //write Game objects into the text filer
	        oos.writeObject(new Game("Assassin Creed", "Adventure", 45.69));
	        oos.writeObject(new Game("Tomb Raider", "Plateform", 23.45));
	        oos.writeObject(new Game("Tetris", "Strategy", 2.50));
	        // and close the flow.
	        oos.close();
	               
	        //Read the objects
	        ois = new ObjectInputStream(
	                new BufferedInputStream(
	                  new FileInputStream(
	                    new File("game.txt"))));
	               
	        try {				
	          System.out.println("\n\nGame store :");
	          System.out.println("-------------------------\n");
	          System.out.println(((Game)ois.readObject()).toString());
	          System.out.println(((Game)ois.readObject()).toString());
	          System.out.println(((Game)ois.readObject()).toString());
	          // ClassNotFoundException when deserializing ... 
	        } catch (ClassNotFoundException g1) {
	          g1.printStackTrace();
	        }
	       
	        ois.close();		// close flow
	               
	      } catch (FileNotFoundException g2) {
	        g2.printStackTrace();
	      } catch (IOException g2) {
	        g2.printStackTrace();
	      }       
	      
	  // Example with the CharArrayRead/Write objects
	      CharArrayWriter cw = new CharArrayWriter();
	      CharArrayReader cr;
	           
	      try {
	        cw.write("Hello dummies");	     	// We write this buffer
	        System.out.println(cw);				// Implicit call to toString()
	               
	        //cw.close() has no effect on the stream; only cw.reset can delete it
	        cw.close();
	               
	        //Define cr; passing the result of toCharArray to cw
	        cr = new CharArrayReader(cw.toCharArray());
	        int i;
	        
	        String str = "";
	        while(( i = cr.read()) != -1)		// Copy all characters from cr to a string
	          str += (char) i;
	        System.out.println("\nAn example using CharArrayRead/Write");
	        System.out.println("-------------------------------------");
	        System.out.println(str);
	   
	      } catch (IOException c) {
	        c.printStackTrace();
	      }
	      
	      
	    // Same example with StrinRead/Write
	      StringWriter sw = new StringWriter();
	      StringReader sr;
	           
	      try {
	        sw.write("Hello dummies");
	        System.out.println(sw);
	               
	        //sw.close() has no effect on the stream, use sw.reset() to clear it.
	        sw.close();
	               
	        sr = new StringReader(sw.toString());         
	        int i ;
	        
	        String str = "";
	        while(( i = sr.read()) != -1)
	          str += (char) i;
	        System.out.println("\nAn example using StringRead/Write");
	        System.out.println("-------------------------------------");
	        System.out.println(str);
	   
	      } catch (IOException s) {
	        s.printStackTrace();
	      }
	      
	      
	  // An example with the FileWriter/Reader, PrintWriter/Reader objects
	      File file = new File("testFileWriter.txt");
	      FileWriter fw;
	      FileReader fr;
	           
	      try {
	        fw = new FileWriter(file);		// Create our object
	        System.out.println("\nAn example using FileRead/Write");
	        System.out.println("-------------------------------------");
	        String str = "Hello dear dummy friends !\n";
	        str += "\tHow are you ? \n";
	        
	        fw.write(str);					// write the string
	        fw.close();						// close the stream 
	               
	        fr = new FileReader(file);		// create our Read object
	        str = "";
	        int i = 0;
	        
	        while((i = fr.read()) != -1)	// read till EOF
	          str += (char)i;
	   
	        System.out.println(str);		// print string
	   
	      } catch (FileNotFoundException s2) {
	        s2.printStackTrace();
	      } catch (IOException s2) {
	        s2.printStackTrace();
	      }
	      
	  } //  End of main


static void showCar(List<? super Car> list){
	  for(Object v : list)
	  {
	    System.out.print("\n"+v.toString());
	  }
	} // End of method

//Generic method that can process different types of Arrays.
static < E > void printArray( E[] inputArray )
{
// Display array elements              
   for ( E element : inputArray ){        
      System.out.printf( "%s ", element );
   }
   System.out.println();
	}  // End of method


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
	         
	  //Constructeur par d�faut
	  public Duo(){
	    this.value1 = null;
	    this.value2 = null;
	  }        
	 
	  //Constructeur avec param�tres
	  public Duo(T val1, S val2){
	    this.value1 = val1;
	    this.value2 = val2;
	  }
	         
	  //M�thodes d'initialisation des deux values
	  public void setValue(T val1, S val2){
	    this.value1 = val1;
	    this.value2 = val2;
	  }
	  
	  //Retourne la value T
	  public T getValue1() {
	    return value1;
	  }
	  
	  //D�finit la value T
	  public void setValue1(T value1) {
	    this.value1 = value1;
	  }
	  
	  //Retourne la value S
	  public S getValue2() {
	    return value2;
	  }
	  
	  //D�finit la value S
	  public void setValue2(S value2) {
	    this.value2 = value2;
	  }        
	} // End of class Duo. 
 
 class Car <V> {
	 private V value;
	 
	 // Default constructor 
	 public Car(){
		 this.value = null;
	 }
	 
	 public Car(V val){
		 this.value = val;
	 }
	 
	 public void setCar(V val){
		 this.value = val;	 
	 }
	 
	 public V getCar(){
		 return this.value;	 
	 }
	 
 } // End of class Car
 
 class CarNoLicense <V> {
	 private V value;
	 
	 // Default constructor 
	 public CarNoLicense(){
		 this.value = null;
	 }
	 
	 public CarNoLicense(V val){
		 this.value = val;
	 }
	 
	 public void setCarNoLicense(V val){
		 this.value = val;	 
	 }
	 
	 public V getCarNoLicense(){
		 return this.value;	 
	 }
 } // End of class CarNoLicense	 
 
 class Garage {
	  List<Car> list = new ArrayList<Car>();
	 
	  public void add(List<? extends Car> listcar){
	    for(Car v : listcar)
	      list.add(v); 
	 
	    System.out.println("\n\nContenu de notre garage :");
	    System.out.println("------------------------");
	    for(Car v : list)
	      System.out.print("\n"+v.toString());       
	   }
 } // End of class Garage
 
 
 // Generic class Entry - the Entry class contains two attributes K and V
 class Entry<K, V> {
	 
	  private final K key;
	  private final V value;
	 
	  public Entry(K k,V v) {  
	    key = k;
	    value = v;   
	  }
	 
	  public K getKey() {
	    return key;
	  }
	 
	  public V getValue() {
	    return value;
	  }
	 
	  public String toString() { 
	    return "(" + key + ", " + value + ")";  
	  }
	}

// Simple generic class 
 class Box<T> {

	  private T t;

	  public void add(T t) {
	    this.t = t;
	  }

	  public T get() {
	    return t;
	  }

	}
 
 // A Serializable class implements Seializable
 class Game implements Serializable{
	  private String nom, style;
	  private double prix;
	  private transient Notice notice;
	     
	  public Game(String nom, String style, double prix) {
	    this.nom = nom;
	    this.style = style;
	    this.prix = prix;
	    this.notice = new Notice();			// Set the default notice
	  }
	     
	  public String toString(){
	    return "Nom du jeu : " + this.nom + "\nStyle de jeu : " + this.style + 
	    		"\nPrix du jeu : " + this.prix + "\n";
	  } 
	}
 
 // The Notice class
 class Notice {
	  private String language ;
	  // Default constructor - french notice
	  public Notice(){
	    this.language = "French";
	  }
	  // For other notices
	  public Notice(String lang){
	    this.language = lang;
	  }
	  public String toString() {
	    return "\t Notice is in : " + this.language + "\n";
	  }
	}

