
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/*
 * TabbedPane is an example on using tabbed windows 
 */
public class TabbedPane extends JFrame {
  private JTabbedPane onglet;
    
  public TabbedPane(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneurs");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 200);
       
    //Create an array of JPanel objects
    Panneau[] tPan = {   new Panneau(Color.RED), new Panneau(Color.GREEN), new Panneau(Color.BLUE)};
       
    //Create a tabs container associting a tab to each JPanel object
    onglet = new JTabbedPane();
    int i = 0;
    for(Panneau pan : tPan){
      //Méthode d'ajout d'onglet
      onglet.add("Onglet n° "+(++i), pan);
      //Vous pouvez aussi utiliser la méthode addTab
      //onglet.addTab("Onglet n° "+(++i), pan);
      // set an icon in each tab
      onglet.setIconAt((i - 1), new ImageIcon("D:/Eclipse4/cotpa01/workspace/project1/src/images/violet_square.jpg"));
 
    }
    //Set the tabs container in the frame's ContentPane obejct.
    this.getContentPane().add(onglet);
    this.setVisible(true);
    
  } // End of TabbedPane 
    
  /*
   * Entry point
   */
  public static void main(String[] args){
    TabbedPane fen = new TabbedPane();
  } // End of main   
  
  
  /*
   * Panneau class must be inside TabbedPane.   
  */
  class Panneau extends JPanel{
  	  private Color color = Color.white;
  	  private int COUNT = 0;
  	  private String message = "";
  	    
  	  // default constructor
  	  public Panneau(){}				
  	  
  	  // constructor allows a custom color
  	  public Panneau(Color color){
  	    this.color = color;
  	    this.message = "Contenu du panneau N°" + (++COUNT);
  	  }
  	  public void paintComponent(Graphics g){
  	    g.setColor(this.color);
  	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
  	    g.setColor(Color.white);
  	    g.setFont(new Font("Arial", Font.BOLD, 15));
  	    g.drawString(this.message, 10, 20);
  	  }
  	} 
  
} // End of TabbedPane class

