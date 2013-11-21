


import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.security.auth.callback.Callback;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
/*
 * ColorChooserMain runs ColorChooserDemo on a thread
 * Also other examples of calls 
 */
public class ColorChooserMain {

	private String CCmain = "Main";
	
	// pass the caller' reference to callee

	/*
	 * Below the Getter and Setter for CCmain. 
	 */
	public String getCCmain() {
		return CCmain;
	}


	public void setCCmain(String cCmain) {
		CCmain = cCmain;
	}

	/*
	 * Entry point 
	 */
	public static void main(String[] args) throws Exception {

		JFrame jf = new JFrame();
		Color jfcolor = null;
		ColorChooserMain ccm = new ColorChooserMain();
		
		
		// Print CCMain and change it.
		System.out.println("CCMain initial value: "+ccm.getCCmain());
		ccm.setCCmain("Mainchanged");
		
		ColorChooserDemo jfccd = new ColorChooserDemo();
		
		System.out.println("CCMain new value: "+ccm.getCCmain());
		System.out.println("Demo string: "+jfccd.getGetRimplstring());
		jfccd.setRimplstring("RimplChanged");
		/*
		 * Threading  ---------------------------------------------- start
		*/
		
		Thread t = new Thread(jfccd.new RunImpl(jfccd, jfcolor));
		t.start();

		jf.add(jfccd);
		jf.pack();
		jf.setVisible(true);
		/*
		------------------------------------------------------------ end
		*/ 
		
		/* Threading passing caller's reference */
		ColorChooserDemo jfccd2 = new ColorChooserDemo();
		jfccd2.setCcm(ccm);
		Thread t2 = new Thread(jfccd2.new RunImpl2(ccm));
		t2.start();
		
		/*
		 * call service -------------------------------------------- start
		  
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Color> jfccdout = executor.submit(jfccd.new Task());
        System.out.println(jfccdout.get()); // Prints "result" after 2 secs.

        // Or if you have multiple tasks.
        // List<Future<String>> futures = executor.invokeAll(Arrays.asList(new Task()));
        // for (Future<String> future : futures) {
        //     System.out.println(future.get());
        // }

        executor.shutdown(); // Important!
        System.out.println("newcolor afer callable: "+jfccdout); 
        ---------------------------------------------------------- end 
        */
        
        // Callbacks examples with the interface instream 
        Caller caller = ccm.new Caller();

        Fruit apple = ccm.new Apple(); // Apple version of Fruit

        Fruit banana = ccm.new Banana(); // Banana version of Fruit

        caller.register(apple); // displays "Callback - Apple"

        caller.register(banana); // displays "Callback - Banana"
        

	} // End of main

	/*
	 * Implement a listener on the Demo class
	 */
	public void ccdNotifyccm (String message) {
		System.out.println("ccd event detected"+message);
	}
	
	
	/*
	 *  Implement a callback mechanism
	 */
	
	interface Fruit {

		void callback_method();

		}

	public class Apple implements Fruit {

			public void callback_method() {

				System.out.println("Callback - Apple");

			}

		}

		public class Banana implements Fruit {

			public void callback_method() {

				System.out.println("Callback - Banana");

			}

		}


	public class Caller {

		public void register(Fruit fruit) {

			fruit.callback_method();

		}

	} // end of Caller class

	
} // End of class ColorChooser
