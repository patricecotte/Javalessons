

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
	
public class Sdz5 {

	/**
	 * Sdz5 - use of the java.nio classes vs the java.io classes. There is an buffer object
	 * for each type of data: IntBuffer, CharBuffer, ShortBuffer, ByteBuffer, DoubleBuffer,
	 * FloatBuffer and LongBuffer
	 * Try-with-resources (java 7)
	 * java.nio 2 library (java 7)
	 */
	
	public static void main(String[] args) {
		
		// Example of reading by buffer (java.nio) vs by byte (java.io)
		   FileInputStream fis;
		    BufferedInputStream bis;
		    FileChannel fc;
		 
		    try {
		      //Create a file object 
		      fis = new FileInputStream(new File("dictionnaire.txt")); 
		      bis = new BufferedInputStream(fis);
		       
		      long time = System.currentTimeMillis();		// start time
		       
		      while(bis.read() != -1);						// read til eof
		      
		      //Print out current time - start time
		      System.out.println("Elapsed time reading by byte : " + (System.currentTimeMillis() - time));
		             
		      //Create the same file object (!) and a channel
		      fis = new FileInputStream(new File("dictionnaire.txt"));
		      fc = fis.getChannel();
		      int size = (int)fc.size();						// get its size
		      ByteBuffer bBuff = ByteBuffer.allocate(size);     // create a sized buffer
		             
		      time = System.currentTimeMillis();				// start time
		      fc.read(bBuff);									// read
		      bBuff.flip();										// ?
		      //Print ouy current - start time
		      System.out.println("Elapsed time reading by buffer : " + (System.currentTimeMillis() - time));
		             
		      //we set up a byte buffer and so the array method applies and returns an 
		      //array of bytes from the buffer
		      byte[] tabByte = bBuff.array(); 					
		             
		    } catch (FileNotFoundException e1) {
		      e1.printStackTrace();
		    } catch (IOException e1) {
		      e1.printStackTrace();
		    }

		    
		    // Example of a try-with-resources. The resources witin () do not need
		    // a finally block, they are closed automatically. Java 7. 
		    System.out.println("\n\nTry with resources example");
		    System.out.println("-----------------------------");
		    try(FileInputStream fis2 = new FileInputStream("src/javaio.txt"); 
		    		FileOutputStream fos2 = new FileOutputStream("src/javaio2.txt")) {
		    		  byte[] buf = new byte[8];
		    		  int n = 0;
		    		  while((n = fis2.read(buf)) >= 0){
		    		    fos2.write(buf);       
		    		    for(byte bit : buf)
		    		      System.out.print("\t" + bit + "(" + (char)bit + ")");         
		    		    
		    		    System.out.println("");
		    		  }
		    		 
		    		  System.out.println("File copied !");
		    		         
		    		} catch (IOException e2) {
		    		  e2.printStackTrace();
		    		}
		    
		    
		  // Example with the java.nio 2 classes. First we use the file Object. 
		    System.out.println("\n\nGet the file information using the File object");
		    System.out.println("-------------------------------------------------");
		    File f = new File("src/Javaio.txt");
		 	System.out.println("\n\nComplete path : " + f.getAbsolutePath());
		 	System.out.println("File name : " + f.getName());
		 	System.out.println("Does it exist ? " + f.exists());
		 	System.out.println("Is a repertory? " + f.isDirectory());
		 	System.out.println("Is a file ? " + f.isFile());
		 	
		    // Now we use java.nio 2 (java 7)
		 	System.out.println("\n\nGet the file information using the java io 2 object");
		    System.out.println("-------------------------------------------------"); 
		 	Path path = Paths.get("src/Javaio.txt");    
		 	System.out.println("Chemin absolu du fichier : " + path.toAbsolutePath());
		 	System.out.println("Est-ce qu'il existe ? " + Files.exists(path));
		 	System.out.println("Nom du fichier : " + path.getFileName());
		 	System.out.println("Est-ce un répertoire ? " + Files.isDirectory(path));

		 	 
		 	//Get the list of directories in a collection of type Path using methods
		 	//of the FileSystems object as found by the JVM for the hosting system.
		 	Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		 	 
		 	//Now drill in the collection
		 	System.out.println("\n\nList the drives using the java io 2 object");
		    System.out.println("-------------------------------------------------"); 
		 	for(Path chemin : roots){
		 	  System.out.println(chemin);
		 	  //We list a directory using the DirectoryStream object from the Files object
		 	  //Use the try-with-resources on DirectoryStream. Filter to see only files on Unit C.
		 	  try(DirectoryStream<Path> listing = Files.newDirectoryStream(chemin, "C:*.*")){
		 	     
		 	    int i = 0;
		 	    for(Path nom : listing){
		 	      System.out.print("\t\t" + ((Files.isDirectory(nom)) ? nom+"/" : nom));
		 	      i++;
		 	      if(i%4 == 0)System.out.println("\n");
		 	    }
		 	         
		 	  } catch (IOException e3) {
		 	    e3.printStackTrace();
		 	  }
		 	}
		    
	} // End of main

} // End of class 
