
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sdz9 {

	/**
	 * Sdz9 - An example with an animmation 
	 */
	public static void main(String[] args) {
		 
	    Window1 w = new Window1();			// Create standard Window1=JFrame

	} // End of main

} // End of class Sdz9


class Window1 extends JFrame{
	//Constructor
	public Window1() {
	JFrame Window1 = new JFrame();			// Create Window1
	JButton b1 = new JButton("OK");			// Create an OK button 
	JButton b2 = new JButton("Cancel");		// Cancel button
	
    Window1.setTitle("My beautiful Animated Window1"); // Set its title
    Window1.setSize(400, 400);				// Set its size
    Window1.setLocationRelativeTo(null);		// Go center
    
	// Create a panel
    Pane pan1 = new Pane();				// Insert a JPanel object
    pan1.setBackground(Color.ORANGE);		// Set its color (AWT package)
    Window1.setContentPane(pan1); 		    // link panel and frame
    
    // Set a BorderLayout
    Window1.setLayout(new BorderLayout());	// an AWT object
    Window1.getContentPane().add(new JButton("CENTER"),BorderLayout.CENTER);
    Window1.getContentPane().add(new JButton("NORTH"),BorderLayout.NORTH);	
    Window1.getContentPane().add(new JButton("SOUTH"),BorderLayout.SOUTH);
    Window1.getContentPane().add(new JButton("EAST"),BorderLayout.EAST);
    Window1.getContentPane().add(new JButton("WEST"),BorderLayout.WEST);
    
    // Set a GridLayout object (an AWT object) and buttons. 
    // Window1.setLayout(new GridLayout(4, 4));
    GridLayout gl = new GridLayout(4,4);
    gl.setHgap(10); // Space between buttons, please
    gl.setVgap(10);
    Window1.setLayout(gl);
    Window1.getContentPane().add(new JButton("1"));
    Window1.getContentPane().add(new JButton("2"));
    Window1.getContentPane().add(new JButton("3"));
    Window1.getContentPane().add(new JButton("4"));
    Window1.getContentPane().add(new JButton("5"));
    
    // Add a BoxLayout (SWING) - the input object is a panel 
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
    pan2.add(new JButton("Box button 1"));
    pan3.setLayout(new BoxLayout(pan3, BoxLayout.LINE_AXIS));
    pan3.add(new JButton("Box button 2"));
    pan3.add(new JButton("Box button 3"));
    pan4.setLayout(new BoxLayout(pan4, BoxLayout.PAGE_AXIS));
    pan4.add(pan2); pan4.add(pan3);
    Window1.getContentPane().add(pan4);
    
	// Add the OK button; it is automatically centered. Note b1 and b2
    // buttons are hidden by the BorderLayout objects.
    // GridLayout overrides BorderLayout, so all buttons appear now as a grid
	pan1.add(b1);							
	Window1.getContentPane().add(b2);
	
    // Set Close behavior and show window
    Window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Window1.setVisible(true);				// Display Window1
	pan1.go();							// repaint window for ever

	}
	

} // End of class Window1  

// Class Panel is defined with two variables for the coordinates of the object
 class Pane extends JPanel {
	  private int posX = -50;
	  private int posY = -50;
	 
	  public void paintComponent(Graphics g){
	//Set the next object's color
		    g.setColor(Color.white);		
	//Make a rectangle the size of the window
		    g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
	//Set the next object's color
		    g.setColor(Color.red);
	//Draw the circle over the rectangle 
		    g.fillOval(posX, posY, 50, 50);
	  }
	 
	  public int getPosX() {
	    return posX;
	  }
	 
	  public void setPosX(int posX) {
	    this.posX = posX;
	  }
	 
	  public int getPosY() {
	    return posY;
	  }
	 
	  public void setPosY(int posY) {
	    this.posY = posY;
	  }        
	    
	  public void go(){
		  boolean FwdX = true;			// Booleans
		  boolean FwdY = true;			// for the forwards/backwards move
		
		  for(;;) {   // loop for ever
		 //   for(int i = -50; i < this.getWidth(); i++){  one time loop
		      int x = this.getPosX(), y = this.getPosY();
		      if (FwdX)   x++;
		      	else x--;
		      if (FwdY) y++;
		      	else y--;
		      this.setPosX(x);
		      this.setPosY(y);
		      this.repaint();  			// call paintComponents with new coordinates 
		      try {
		        Thread.sleep(10);		// Make it wait 10 seconds before next loop
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		      // Reset positions when the the window dimensions have been met
		      if(x == this.getWidth() || y == this.getHeight()){
		      /*    this.setPosX(-50);
		          this.setPosY(-50);
		      */
		    	 FwdX=false; FwdY=false;
		        }
		      if (x == -50 || y == -50) {
		    	  FwdX=true; FwdY=true;
		      }
		    } // end of for
	} // End of go 
	  
} // End of class Pane
