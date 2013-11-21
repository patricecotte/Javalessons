import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/*
 * This example shows how build a number of tabs in a JFrame object. It shows how add or
 * remove tabs dynamically based on a button click. 
 */
	//CTRL + SHIFT + O pour générer les imports nécessaires
	 
	public class TabbedPane2 extends JFrame {
	  private JTabbedPane onglet;
	  //Compteur pour le nombre d'onglets
	  private int nbreTab = 0;
	  
	  // Should not return void (if user must see it!)
	  public TabbedPane2(){
	    this.setLocationRelativeTo(null);
	    this.setTitle("Gérer vos conteneurs");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(400, 200);
	       
	    //Création de plusieurs Panneau
	    Panneau[] tPan = {   new Panneau(Color.RED), new Panneau(Color.GREEN), new Panneau(Color.BLUE)};
	       
	    //Création de notre conteneur d'onglets
	    onglet = new JTabbedPane();
	    for(Panneau pan : tPan){
	      //Méthode d'ajout d'onglets
	      onglet.addTab("Onglet N°"+(++nbreTab), pan);
	    }
	    //On passe ensuite les onglets au content pane
	    this.getContentPane().add(onglet, BorderLayout.CENTER);
	       
	    //Ajout du bouton pour ajouter des onglets
	    JButton nouveau = new JButton("Ajouter un onglet");
	    nouveau.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        onglet.add("Onglet N°"+(++nbreTab), new Panneau(Color.DARK_GRAY));
	      }
	    });
	       
	    //Ajout du bouton pour retirer l'onglet sélectionné
	    JButton delete = new JButton("Effacer l'onglet");
	    delete.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        //On récupère l'index de l'onglet sélectionné
	        int selected = onglet.getSelectedIndex();
	        //S'il n'y a plus d'onglet, la méthode ci-dessus retourne -1
	        if(selected > -1)onglet.remove(selected);
	      }
	    });
	       
	    // Create a JPanel with two buttons SOUTH
	    JPanel pan = new JPanel();
	    pan.add(nouveau);				 
	    pan.add(delete);
	       
	    this.getContentPane().add(pan, BorderLayout.SOUTH);
	    this.setVisible(true);
	    
	  } // End of TabbedPane2
	  
	 /*
	  * Entry point
	  */
	  public static void main(String[] args){
	    TabbedPane2 fen = new TabbedPane2();
	  }   
	
	  /*
	   * Panneau class must be inside TabbedPane2.   
	  */
	  class Panneau extends JPanel{

		private static final long serialVersionUID = 1L;
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
	
} // End of class TabbedPane2
	
	