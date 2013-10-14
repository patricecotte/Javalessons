

import javax.imageio.ImageIO;
import javax.swing.JDialog;	
import javax.swing.JWindow;
import javax.swing.JFrame;
import javax.swing.JPanel;
// JPanel related classes
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
// IO java routines for importing images
import java.io.File;
import java.io.IOException;


public class Sdz8 {

	/**
	 * Sdz8 - Use swing to generate a graphical interface. 
	 * There are three high-level objects: JDialog, JWindow and JFrame
	 */
	public static void main(String[] args) {
		 
		Window w = new Window();			// Create standard Window=JFrame
		Window w2 = new Window();			// Create another JFrame
		w2.setLocation(150,350);			// 		at a different location? Nope! 
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
	// Create a panel
    JPanel pan = new JPanel();				// Insert a JPanel object
    pan.setBackground(Color.ORANGE);		// Set its color (AWT package)
    Window.setContentPane(pan); 		    // link panel and frame
    // Create a Panel object - Note, Panel overrides the above JPanel 
    Window.setContentPane(new Panel());
    Window.setBackground(Color.BLUE);		// Set its color (AWT package)
    // Set Close behavior
    Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Window.setVisible(true);				// Display Window
    
	}

} // End of class Window  

// Class Jwin:  no border , non draggabble

class Jwin extends JWindow{
	//Constructor
	public Jwin(){
	JWindow Jwin = new JWindow(); 
    Jwin.setSize(400, 100);				// Set its size
    Jwin.setLocation(10,100);			// Set position
    // Add an Panel object
    Jwin.setContentPane(new Panel1());
    Jwin.setBackground(Color.RED);		// Set its color (AWT package)
    // show window
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
	    //
	    // Add an Panel object
	    Jdlg.setContentPane(new Panel());
	    Jdlg.setBackground(Color.YELLOW);		// Set its color (AWT package)
	    // Set Close behavior
	    Jdlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Jdlg.setVisible(true);					// Display Window
		}

} // End of class Jdlg - non resizable

// Panel - no constructor is needed for Panel, 
// 		we only invoke a Graphic method to create an object. 
// If the window is minimized, maximized or resized the Panel is executed again.
class Panel extends JPanel { 
	  public void paintComponent(Graphics g){
	    System.out.println("Creating a Panel after JPanel object !"); 
	    // Get the parent's dimensions and set up the oval dimensions so that it appears centered
	    // Set up other graphics
	    int x1 = this.getWidth()/4;
	    int y1 = this.getHeight()/4;                      
	    g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
	    g.drawOval(x1/2, y1/2, this.getWidth()/2, this.getHeight()/2);
	    g.drawRect(10, 10, 50, 60);   //x1, y1, width, height, arcWidth, arcHeight
	    g.fillRect(65, 65, 30, 40);
	    g.drawRoundRect(10, 10, 30, 50, 10, 10);
	    g.fillRoundRect(55, 65, 55, 30, 5, 5);
	    g.drawLine(0, 0, this.getWidth(), this.getHeight());  	// start coordinates, end coordinates
	    g.drawLine(0, this.getHeight(), this.getWidth(), 0);		
	    int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
	    int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
	    g.drawPolygon(x, y, 8);
	    // specify text properties (AWT package)
	    Font font = new Font("Courier", Font.BOLD, 16);
	    g.setFont(font);
	    g.setColor(Color.red);          
	    g.drawString("Hello there!", 140, 300);
	    // Add an image (AWT class+IO processing)
	    try {
	        Image img = ImageIO.read(new File("src/Java.JPG"));
	        g.drawImage(img, 0, 0, this);
	        //Pour une image de fond
	        //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      } catch (IOException e) {
	        // e.printStackTrace();  Ask for the trace if ou really want to see all the classes!
	    	  System.out.println("Unable to process the image file");
	      }                
	    }   
  
} // End of class Panel

// Panel1 sets up 2D objects 
class Panel1 extends JPanel{
	 public void paintComponent(Graphics g){
		    Graphics2D g2d = (Graphics2D)g;   

		    GradientPaint gp, gp2, gp3, gp4, gp5, gp6; 
		    gp = new GradientPaint(0, 0, Color.RED, 20, 0, Color.magenta, true);
		    gp2 = new GradientPaint(20, 0, Color.magenta, 40, 0, Color.blue, true);
		    gp3 = new GradientPaint(40, 0, Color.blue, 60, 0, Color.green, true);
		    gp4 = new GradientPaint(60, 0, Color.green, 80, 0, Color.yellow, true);
		    gp5 = new GradientPaint(80, 0, Color.yellow, 100, 0, Color.orange, true);
		    gp6 = new GradientPaint(100, 0, Color.orange, 120, 0, Color.red, true);
		 
		    g2d.setPaint(gp);
		    g2d.fillRect(0, 0, 20, this.getHeight());               
		    g2d.setPaint(gp2);
		    g2d.fillRect(20, 0, 20, this.getHeight());
		    g2d.setPaint(gp3);
		    g2d.fillRect(40, 0, 20, this.getHeight());
		    g2d.setPaint(gp4);
		    g2d.fillRect(60, 0, 20, this.getHeight());
		    g2d.setPaint(gp5);
		    g2d.fillRect(80, 0, 20, this.getHeight());
		    g2d.setPaint(gp6);
		    g2d.fillRect(100, 0, 40, this.getHeight());	 
	 }
} // end of class Panel1

