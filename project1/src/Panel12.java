import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


// Class Panel is defined with two variables for the coordinates of the object
 class Panel12 extends JPanel {
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