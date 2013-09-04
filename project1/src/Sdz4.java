
/*
 * Sdz4 main class
 */
	public class Sdz4 {
		  public static void main(String args[]){
			  // prints the contents of the Language enum class 
			  // with a special treatment for the JAVA value
		    for(Language lang : Language.values()){
		      if(Language.JAVA.equals(lang))
		        System.out.println("I love : " + lang.toString());
		      else
		        System.out.println(lang);
		    }
		  }
}
