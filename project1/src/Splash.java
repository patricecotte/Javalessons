import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/*
 * This example shows how build a splash screen that closes when
 * user clicks on it. 
 */
//CTRL + SHIFT + O pour générer les imports nécessaires
 
public class Splash extends JWindow{
 
  public static void main(String[] args){
    Splash wind = new Splash();
    // window - close action 
    wind.addMouseListener(new MouseListener() {
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mousePressed(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseClicked(MouseEvent e) {
			// Close application
			  System.exit(0);
		}
	});
	
    wind.setVisible(true);
  }
    
  public Splash(){      
    setSize(400, 300);
    setLocationRelativeTo(null);      
    JPanel pan = new JPanel();
    //JLabel img = new JLabel(new ImageIcon("planète.jpeg"));
    //img.setVerticalAlignment(JLabel.CENTER);
    //img.setHorizontalAlignment(JLabel.CENTER); 
    //pan.add(img);
    
    pan.setBorder(BorderFactory.createLineBorder(Color.blue));

    getContentPane().add(pan);
    
  }
  
} // End of Splash class
