
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window10 extends JFrame{
		 
		  CardLayout cl = new CardLayout();		// Use a CardLayout object
		  JPanel content = new JPanel();		// Use a JPanel object

		  String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};
		  int indice = 0;
		 
		  public Window10(){
		    this.setTitle("CardLayout");
		    this.setSize(300, 120);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		         
		    //Create 3 JPanel objects and an array of names
		    JPanel card1 = new JPanel();
		    card1.setBackground(Color.blue);        
		    JPanel card2 = new JPanel();
		    card2.setBackground(Color.red);     
		    JPanel card3 = new JPanel();
		    card3.setBackground(Color.green);
		 
			// Create an additional JPanel for buttons
		    JPanel buttonPane = new JPanel();
		    
		    // Create two JButton objects with their action
		    JButton button = new JButton("Next container");
		    // Specify an action for this button: invoke method 'next' for the CardLayout,
		    // which sets the focus on the next JPanel
		    button.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        cl.next(content);
		      }
		    });
		         
		    JButton button2 = new JButton("Container on its index");
		    button2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){               
		        if(++indice > 2)
		          indice = 0;
		        cl.show(content, listContent[indice]);
		      }
		    });
		         
		    // Add the JButton objects to JPanel buttonPane
		    buttonPane.add(button);
		    buttonPane.add(button2);
		    
		    // Set the CardLayout and add Cardx JPanels to content JPanel object.
		    // Only one Card will be visible at one time. 
		    content.setLayout(cl);
		    content.add(card1, listContent[0]);
		    content.add(card2, listContent[1]);
		    content.add(card3, listContent[2]);
		    
		    // Set the pair of buttons a BorderLayout
		    // Set the content JPanel a BorderLayout
		    this.getContentPane().add(buttonPane, BorderLayout.NORTH);
		    this.getContentPane().add(content, BorderLayout.CENTER);
		    this.setVisible(true);
		  } 
} // End of class 

