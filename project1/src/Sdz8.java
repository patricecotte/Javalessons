import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;


public class Sdz8 {

	/**
	 * Sdz8 - Use swing to generate a graphical interface
	 */
	public static void main(String[] args) {
		 
		Window w = new Window();			// Create standard Window
		Jwin  jw = new Jwin(); 				// Create JWindow
		Jdlg  jd = new Jdlg();				// Create JDialog
		
	 

	} // End of main

} // End of class sdz8

class Window extends JFrame{
	//Constructor
	public Window() {
	JFrame Window = new JFrame();			// Create Window
    Window.setTitle("My beautiful Window"); // Set its title
    Window.setSize(400, 100);				// Set its size
    Window.setLocationRelativeTo(null);		// Go center
    // Set Close behavior
    Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Window.setVisible(true);				// Display Window
	}

} // End of class Window - no border , non dragabble

class Jwin extends JWindow{
	//Constructor
	public Jwin(){
	JWindow Jwin = new JWindow(); 
    Jwin.setSize(400, 100);				// Set its size
    Jwin.setLocation(10,100);			// Set position
	Jwin.setVisible(true);				// Display Window
	}
} // End of class Jwin 
	
class Jdlg extends JDialog{
		//Constructor
		public Jdlg(){
		JDialog Jdlg = new JDialog();			// Create Window
	    Jdlg.setTitle("My beautiful Dialog"); 	// Set its title
	    Jdlg.setSize(400, 100);					// Set its size
	    Jdlg.setLocation(400,200);				// set position
	    // Set Close behavior
	    Jdlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Jdlg.setVisible(true);					// Display Window
		}

} // End of class Jdlg - non resizable


