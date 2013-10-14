
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
  
import javax.swing.JButton;
   
public class Button12 extends JButton implements MouseListener {
  private String name;
  private Color color1 = Color.blue;		// Define color attributes
  private Color color2 = Color.cyan;        // the mouse methods work on
  public Button12(String str){
    super(str);
    this.name = str;
    // the Button12 object listens to itself
    this.addMouseListener(this);
  }
         
  // Methods added using the Source Override-implements facility
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void mousePressed(MouseEvent e) {
	color1 = Color.DARK_GRAY; color2 = Color.cyan;
}

public void mouseReleased(MouseEvent e) {	
if((e.getY() > 0 && e.getY() < this.getHeight()) && (e.getX() > 0 && e.getX() < this.getWidth())){
		 color1 = Color.blue; color2 = Color.cyan; 		// original colors
		 name = "Button clicked #1";					// change name
		  }
else {			// user clicked outside the button 
	 	color1 = Color.blue; color2 = Color.black; 		// other colors
	 	name = "Button clicked #2";
	}
}

public void mouseEntered(MouseEvent e) {
	color1 = Color.yellow; color2 = Color.cyan;	
}

public void mouseExited(MouseEvent e) {
	color1 = Color.blue; color2 = Color.cyan;		// original colors
}

// This method is automatically called each time the button redraws itself.
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp = new GradientPaint(0, 0, color1, 0, 20, color2, true);
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    g2d.setColor(Color.white);
    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/ 2 /4), (this.getHeight() / 2) + 5);
  }        
}
