
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {

	/**
	 * Regex examples
	 */
	public static void main(String[] args) {
		// Work fields
		String input = "";
		String output = "";
		// Build an array of strings to work on
		String[] table1 = {"DSN=COTPA01.CLIST ,DISP=SHR", "DSN=COTPA01.CLIST   ,DISP=SHR",
				"DSN=COTPA01  .CLIST ,DISP=SHR   "
				};
		// This pattern is made of 
		// - group #1 is a word \w
		// - group #2 is one or more spaces (\s+). A single space would be \s
		// - group #3 is starts with either a period or a comma
		// Double slashes are for escaping.
		// Print out groups 1 and 2, that is, spaces are recursively removed from the result
		String pattern = "(\\w)(\\s+)([\\.,])";
		System.out.println("Remove spaces before commas and periods");
		System.out.println("---------------------------------------");
		for (int i = 0; i < table1.length; i++){
			System.out.println(table1[i].replaceAll(pattern, "$1$3")+"*"); 
		};
		// Note the elements in the table are not modified. 
		System.out.println(table1[0]);
		
		
		String[] table2 = {"<title>First title</title>","<Title>Second title</titlE>",
				"<i><titlex>Third</title></i>",
				"<title1><title2>Fourth</title></title>"};
		// This pattern is made of
		// - group 1, i can occur 0 or 1 time
		// - group 2 is about title. where the dor is any character; '*' means 0 to n occurences; '?' is the
		//	reluctant quantifier, that is, regex shoud find the smallest match.
		// - group 3 is any character (.) one or more times (+); use of (?) ??
		// - </title> is not a group, only fixed text.
		// Extract the text between the two title elements
		System.out.println("\nExtract text bewteen title. and /title tags");
		System.out.println("---------------------------------------");
		pattern = "(?i)(<title.*?>)(.+?)(</title>)";
		for (int i = 0; i < table2.length; i++){
			System.out.println(table2[i]+"  >>  "+table2[i].replaceAll(pattern, "$0")+" + "+
					table2[i].replaceAll(pattern, "$1")+" + "+
					table2[i].replaceAll(pattern, "$2")+" + "+
					table2[i].replaceAll(pattern, "$3"));
		};
		
		
		final String EXAMPLE_TEST = "This is my small example "
			      + "string which I'm going to " + "use for pattern matching.";
		// This example
		// - makes sure there is at least one word in the input string (matches says true)
		// - splits the input into words that are placed in the splitString table
		// - prints out the number of words, prints each of them on a separate line
		// - prints a copy of the input where spaces have been replaced by tabs
		System.out.println("\ncount words, repplace spaces with tabs");
		System.out.println("---------------------------------------");
	    System.out.println(EXAMPLE_TEST.matches("\\w.*"));
	    String[] splitString = (EXAMPLE_TEST.split("\\s+"));
	    System.out.println(splitString.length);// Should be 14
	    for (String string : splitString) {
	      System.out.println(string);
	    }
	    // Replace all whitespace with tabs
	    System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
	    
	    
	    // This example demonstrates the use of the java.util.regex.matcher and pattern classes
	    // In case you would like to ignore case sensitivity you could use this
	    // statement:
	    // 		Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
	    Pattern pattern1 = Pattern.compile("\\w+");
	    Matcher matcher = pattern1.matcher(EXAMPLE_TEST);
	    // Check all occurrences
		System.out.println("\nWith the help of the matcher and Pattern classes");
		System.out.println("------------------------------------------------");
	    while (matcher.find()) {
	      System.out.print("Start index: " + matcher.start());
	      System.out.print(" End index: " + matcher.end() + " ");
	      System.out.println(matcher.group());
	    }
	    // Now create a new pattern and matcher to replace whitespace with tabs
	    Pattern pattern2 = Pattern.compile("\\s+");
	    Matcher matcher2 = pattern2.matcher(EXAMPLE_TEST);
	    System.out.println(matcher2.replaceAll("\t"));
	    
	    // This example says whether a string contains jim or joe
		System.out.println("\nmatching a jim OR joe condition");
		System.out.println("------------------------------------------------");
	    String s = "humbapumpa jim";
	    System.out.println(s.matches(".*(jim|joe).*"));
	    s = "humbapumpa jom";
	    if (!s.matches(".*(jim|joe).*")) System.out.println("second test returns false");
	    s = "humbaPumpa joe";
	    System.out.println(s.matches(".*(jim|joe).*"));
	    s = "humbapumpa joe jim";
	    System.out.println(s.matches(".*(jim|joe).*"));
	    
	    // This example says whether a string looks like a phone number, either 7 numbers
	    // or 3 numbers-dash-4 numbers or 3 numbers-space-4 numbers
	    // - \d is any 0-9 number
	    // the brackets allow one dash or space, optionl because of ? 
	    System.out.println("\nmatching a phone number structure");
		System.out.println("------------------------------------------------");	    
	    String pattern3 = "\\d\\d\\d([-\\s])?\\d\\d\\d\\d";
	    String s3= "1245678901";	// tests false, too many numbers
	    if (!s3.matches(pattern3)) System.out.println("first test returns false");
	    s3 = "1234567";
	    System.out.println(s3.matches(pattern3));
	    s3 = "123 4567";
	    System.out.println(s3.matches(pattern3));
	    s3 = "123-4567";
	    System.out.println(s3.matches(pattern3));
	    s3 = "123 - 7654";			// will test false, more than 1 dash or space
	    System.out.println(s3.matches(pattern3));
	    
	    // Tests whether strings contain 3 numbers
	    System.out.println("\nmatching a string on its contents, 3 numbers in a row are requested");
		System.out.println("------------------------------------------------");	  
	    String s4= "1233";
	    System.out.println(test(s4));
	    s4= "0";
	    System.out.println(test(s4));
	    s4 = "29 Kasdkf 23 00 Kdsdf";   // tests false because there are never 3 numbers together
	    System.out.println(test(s4));
	    s4 = "99900234";
	    System.out.println(test(s4));
	    
	    // Tests whether a string is made of dots only.
	    System.out.println("\nlooking for dots");
		System.out.println("----------------");	
	    String pattern5 = "\\.+";       // any number of dots
	    String[] table5 = {".","..",".. ..", "a.b",".5"}; 
		for (int i = 0; i < table5.length; i++){
			System.out.println(table5[i].matches(pattern5)); 
		};
		
		// If a string is numeric with decimals all 0 , remove them
		String pattern6 = "[\\d,]*\\.0*[^1-9]";   	// figures+','+'.'+ zeroes + no other figure trailing
		String pattern7 = "([\\d,]*)(\\.0*)";  		// make two groups 
		String[] table6={"0.5","1.0","0.0","1.00","2,000.00","1,234,567.0000","1.05","0.11000","0.00222","0.003300"};
	    System.out.println("\nlooking for decimals all zeroes  ");
		System.out.println("-------------------------------");	
		for (int i = 0; i < table6.length; i++){
			if (table6[i].matches(pattern6)) {
				System.out.println("Number :"+table6[i]+" >>> "+table6[i].replaceAll(pattern7,"$1"));
			}
			else System.out.println("Non matching number:"+table6[i]);
		};
			
		
		// If a string is numeric with trailing 0s
		String pattern8 = "([\\d,]+\\.0*[1-9]+)(0+)";			//  dd,ddd.ddd00 or dd,ddd.00ddd00
	    System.out.println("\nlooking for zeroes after non 0 decimals");
		System.out.println("---------------------------------------");	
		for (int i = 0; i < table6.length; i++){
			if (table6[i].matches(pattern8)) {
				System.out.println("Number :"+table6[i]+" >>> "+table6[i].replaceAll(pattern8,"$1"));
			}
			else System.out.println("Non matching number:"+table6[i]);
		};
		
		// If a string is numeric with decimals all 0 , remove them
		String pattern9 = "([\\d,]*)(\\.0*[^1-9])";   	// figures+','+'.'+ zeroes + no other figure trailing
	    System.out.println("\nlooking for decimals all zeroes");
		System.out.println("-------------------------------");	
		for (int i = 0; i < table6.length; i++){
			if (table6[i].matches(pattern6)) {
				System.out.println("Number :"+table6[i]+" >>> "+table6[i].replaceAll(pattern9,"$1"));
			}
			else System.out.println("Non matching number:"+table6[i]);
		};
	    
	} // End of main
	
/*
 * This method returns false/true from testing a passed string against a pattern
 */
	public static boolean test (String s){
		// This pattern tests whether string s contains 3 numbers.
	    Pattern pattern = Pattern.compile("\\d{3}");
	    Matcher matcher = pattern.matcher(s);
	    if (matcher.find()){
	      return true; 
	    } 
	    return false; 
	  }
	
} // End of Regex class
