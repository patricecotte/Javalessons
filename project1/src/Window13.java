import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.text.MaskFormatter;


public class Window13 extends JFrame implements ActionListener, MouseListener{
/*
 * Window13 is invoked by the Sdz13 class. Window13 implements Panel12, an extension
 * of JPanel class that contains an animation, 2 standard JButton objects in a standard 
 * JPanel object, a standard JLabel object, a JComboBox Combo box, 2 JCheckBoxes
 * 
 * Use of button groups makes on object reset the others in the group.
 * 
 * It also implements the ActionListener interface. 
 * 
 * Window13 combines the MouseListener and the ActionListener. Both interfaces are 
 * implemented in the Window13 object. In the Sdz12 example MouseListener is implemented
 * in the Button12 object
 */
		  private Panel12 pan12 = new Panel12();			// animated panel
		  private JPanel  pantext = new JPanel();			// panel for text objects
		  private JPanel container = new JPanel();			// panel for a container
		  private JPanel south = new JPanel(); 				// panel for buttons
		  private JButton b13_1 = new JButton("Start animation");
		  private JButton b13_2 = new JButton("Stop animation");  
		  private JLabel label = new JLabel("This JLabel object");  	  
		  private String[] combolist = {"Ball", "Triangle"};
		  private JComboBox<String> combo = new JComboBox<String>(combolist);
		  private ButtonGroup jcg = new ButtonGroup();				// Group
		  private JCheckBox check1 = new JCheckBox("Case 1");		//    	of two checkboxes
		  private JCheckBox check2 = new JCheckBox("Case 2");
		  private ButtonGroup jrg = new ButtonGroup();				// Group
		  private JRadioButton jr1 = new JRadioButton("Radio 1");	//		of two radio buttons
		  private JRadioButton jr2 = new JRadioButton("Radio 2");
		  private JRadioButton jr3 = new JRadioButton("Radio 3");
		  private String jrtitle = "Radios";
		  private Border greenborder = BorderFactory.createTitledBorder("Center Park");
		  
		  // A bigger choice of borders
		  private Border blackline = BorderFactory.createLineBorder(Color.black);
		  private Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.blue,
				  	Color.DARK_GRAY);
		  private Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED,
				  Color.MAGENTA,Color.DARK_GRAY);
		  private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		  private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		  private Border empty = BorderFactory.createEmptyBorder();
		  
		  // The below objects go to pantext panel
		  // private JTextField jtf = new JTextField("Name ");
		  // private JFormattedTextField jtf1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		  // private JFormattedTextField jtf2 = new JFormattedTextField(NumberFormat.getPercentInstance());
		  private MyTextField myjtf = new MyTextField("myjtf","");
		  private NumberFormat ii = NumberFormat.getIntegerInstance();
		  private NumberFormat pct= NumberFormat.getPercentInstance();
		  private MyTextField myjtf1 = new MyTextField(ii,"myjtf1","");
		  private MyTextField myjtf2 = new MyTextField(pct,"myjtf2","");
		  private JLabel label1 = new JLabel("Un JLabel field");

		  // Fonts
		  Font police = new Font("Tahoma", Font.BOLD, 16);
		  Font police1 = new Font("Rockwell", Font.BOLD, 14);
		  
		  private int count1 = 0; private int count2 = 0;
		  // variables for the go() method
		  private boolean animated = true;
		  private boolean backX, backY;
		  private int x, y;
		  private String shape = "Square"; 					// shape of the object
		  private int posX = -50;							// object position
		  private int posY = -50;
		  
		  private String buffer;							// buffer area
		  
		  public Window13(){
		    this.setTitle("An animation, 2 buttons in a BorderLayout and a label");
		    this.setSize(800, 400);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    
		    // create a BorderLayout object
		    container.setLayout(new BorderLayout());
		    
		    // Add objects to the pantext panel. This panel will be placed
		    // at the top of the container. 
		    container.add(pantext, BorderLayout.NORTH);		// set pantext at top
		    myjtf.setFont(police1);							// Add text objects					
		    myjtf.setPreferredSize(new Dimension(150, 30));
		    myjtf.setForeground(Color.BLUE);
		    myjtf.setText("Name");
		    myjtf1.setPreferredSize(new Dimension(150, 30));
		    myjtf1.setText("999$");
		    myjtf2.setPreferredSize(new Dimension(150, 30));
		    myjtf2.setText("0.5");
		    myjtf.addKeyListener(new TextListener());
		    myjtf1.addKeyListener(new TextListener());
		    myjtf2.addKeyListener(new TextListener());
		    myjtf.setPreferredSize(new Dimension(50, 30));
		    myjtf.addKeyListener(new TextListener());
		    pantext.add(myjtf);
		    pantext.add(myjtf1);
		    pantext.add(myjtf2);
		    pantext.add(label1);
		    label.setFont(police);							// Add another label 
		    label.setForeground(Color.blue);
		    label.setHorizontalAlignment(JLabel.RIGHT);
		    pantext.add(label);
		    
		    // Add objects to the pan12 panel 
		    container.add(pan12, BorderLayout.CENTER);  // Set pan12 centered
		    pan12.add(combo);							// add combo box to panel
		    combo.addItem("Square");
		    combo.addItem("Star");
		    combo.addItemListener(new ItemState());
		    combo.addActionListener(new ItemAction());
		    combo.setPreferredSize(new Dimension(100, 20));
		    combo.setForeground(Color.blue);		  
		    check1.addActionListener(new StateListener());	// add checkboxes
		    check2.addActionListener(new StateListener());
		    jcg.add(check1);								// to their group
		    jcg.add(check2);
		    check1.setSelected(true);
		    pan12.add(check1); 								// to the panel 
		    pan12.add(check2);
		    jr1.addActionListener(new StateListener());		// add radiobuttons
		    jr2.addActionListener(new StateListener());
		    jr3.addActionListener(new StateListener());	
		    jr3.setSelected(true);
		    jr1.setBorder(blackline); jr1.setBorderPainted(true);		// apply borders
		    jr2.setBorder(loweredbevel); jr2.setBorderPainted(true);
		    jr3.setBorder(raisedetched); jr3.setBorderPainted(true);
		    check1.setBorder(loweredetched);check1.setBorderPainted(true);
		    check2.setBorder(raisedbevel);check2.setBorderPainted(true);
		    jrg.add(jr1);
		    jrg.add(jr2);
		    jrg.add(jr3);
		   
		    pan12.setBorder(greenborder);
		    pan12.add(jr1); pan12.add(jr2); pan12.add(jr3);
		    
		    // Note BorderLayout spans over two panels (really?)
		    south.add(b13_1, BorderLayout.SOUTH);
		    south.add(b13_2, BorderLayout.SOUTH);
		    container.add(south, BorderLayout.SOUTH);

		    // Add listeners to the buttons; 'this' is the Window13 object
		    // b13_1.addActionListener(this);
		    b13_1.addActionListener(new B13_1_Listener());
		    // b13_2.addActionListener(this);
		    
		    // Define the internal classes B13_2_Listener and B13_2_Listener2 rather than Window13 
		    // implementation of ActionListener.
		    b13_2.addActionListener(new B13_2_Listener());   
		    b13_2.addActionListener(new B13_2_Listener2());
		    b13_1.addMouseListener(this);
		    b13_2.addMouseListener(this);
		    
		    // Show resulting window
		    this.setContentPane(container);
		    this.setVisible(true);    
		    //go();
		    // Threading instead or running the animation 
		    // is required to avoid freezing the application. 
		    PlayAnimation pa = new PlayAnimation();	
		    Thread t = new Thread(pa);
		    t.start();
		  }
		   
		/* 
		 * Implement the methods for the ActionListener interface.
		 */
		public void actionPerformed(ActionEvent arg0) {
			
			 if(arg0.getSource() == b13_1){
				 this.count1++;
				 label.setText("button 1 was clicked "+this.count1+" times");
		
			 }
			 if(arg0.getSource() == b13_2){
				 this.count2++;
			 	 label.setText("button 2 was clicked "+this.count2+" times");
			 }
		}

		/* 
		 * Implement the methods for the MouseListener interface.
		 */
		public void mouseClicked(MouseEvent me) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent me) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent me) {
			 if(me.getSource() == b13_1){
				 label.setForeground(Color.green);	
			 }
			 if(me.getSource() == b13_2){
				 label.setForeground(Color.red);	
			 }		
		}

		@Override
		public void mouseExited(MouseEvent me) {
			label.setForeground(Color.blue);	
			
		}
		
		/*
		* Methods that paint an object in the window
		* go				animate the object by changing its position and repainting
		* paintComponent	painter
		* -	draw			draws the object using the selected shape, default is "ball"  
		* 		
		*/

		private void go(){  
	
		    // System.out.println("Go method ");
		    
		    // Because the animated variable is a global variable
		    // it is watched by every method so when the button changes it
		    // to 'false' the go method sees it and stops repainting the
		    // window (and no 'stop' method is needed.
			
		    while(animated){
		    	  x = pan12.getPosX();
		    	  y = pan12.getPosY();
 
		    	    while(this.animated){
		    	      if(x < 1)backX = false;
		    	      if(x > pan12.getWidth()-50)backX = true;          
		    	      if(y < 1)backY = false;
		    	      if(y > pan12.getHeight()-50)backY = true;
		    	      if(!backX)pan12.setPosX(++x);
		    	      else pan12.setPosX(--x);
		    	      if(!backY) pan12.setPosY(++y);
		    	      else pan12.setPosY(--y);
		    	      pan12.repaint();
		    	 
		    	      try {
		    	        Thread.sleep(3);
		    	      } catch (InterruptedException e) {
		    	        e.printStackTrace();
		    	      }
		    	    } 
		    	    
   /*
   				  // Use paintComponent so that to change the shape
   				  // of the object.	
		    	  while(this.animated){
	
		    		  paintComponent(getGraphics());
		    	      try {
			    	        Thread.sleep(3);
			    	      } catch (InterruptedException e) {
			    	        e.printStackTrace();
			    	      }
		    	  }
  */ 
		    }
		  } // end of go method

		// Reminder: the Graphics object does not need to be declared. 
		private void draw(Graphics g){      
			System.out.println("shape :"+this.shape);
		    if(this.shape.equals("Ball")){
		      g.fillOval(posX, posY, 50, 50); 
		    }
		    if(this.shape.equals("Square")){
		      g.fillRect(posX, posY, 50, 50);
		    }
		    if(this.shape.equals("Triangle")){
		      //Calcul des sommets            
		      //Le sommet 1 se situe à la moitié du côté supérieur du carré
		      int s1X = posX + 25;
		      int s1Y = posY;
		      //Le sommet 2 se situe en bas à droite
		      int s2X = posX + 50;
		      int s2Y = posY + 50;
		      //Le sommet 3 se situe en bas à gauche
		      int s3X = posX;
		      int s3Y = posY + 50;      
		      //Nous créons deux tableaux de coordonnées
		      int[] ptsX = {s1X, s2X, s3X};
		      int[] ptsY = {s1Y, s2Y, s3Y};      
		      //Nous utilisons la méthode fillPolygon()
		      g.fillPolygon(ptsX, ptsY, 3);
		    }
		    if(this.shape.equals("Star")){      
		      //Pour l'étoile, on se contente de tracer des lignes dans le carré
		      //correspondant à peu près à une étoile...
		      //Mais ce code peut être amélioré !
		      int s1X = posX + 25;
		      int s1Y = posY;
		      int s2X = posX + 50;
		      int s2Y = posY + 50;        
		      g.drawLine(s1X, s1Y, s2X, s2Y);      
		      int s3X = posX;
		      int s3Y = posY + 17;
		      g.drawLine(s2X, s2Y, s3X, s3Y);      
		      int s4X = posX + 50;
		      int s4Y = posY + 17;
		      g.drawLine(s3X, s3Y, s4X, s4Y);            
		      int s5X = posX;
		      int s5Y = posY + 50;
		      g.drawLine(s4X, s4Y, s5X, s5Y);       
		      g.drawLine(s5X, s5Y, s1X, s1Y);  
		    }
		  }
		
		  public void paintComponent(Graphics g){
			    //On choisit une couleur de fond pour le rectangle
			    g.setColor(Color.white);
			    //On le dessine de sorte qu'il occupe toute la surface
			    g.fillRect(0, 0, this.getWidth(), this.getHeight());
			    //On redéfinit une couleur pour le rond
			    g.setColor(Color.red);
			    //On délègue la méthode de dessin à la méthode draw()
			    draw(g);      
			  }
		
		  public void setShape(String form){
			    this.shape = form;
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
		  
		/*
		 * Class PlayAnimation executes the go method in a separate thread.
		 * Chapter 3.   
		 */
		class PlayAnimation implements Runnable{
		    public void run() {
		      go();                   
		    }               
		  } 
		
		/*
		 * Internal classes:
		 * - ItemState controls the Combo box 
		 * - B13_1_Listener, B13_2__Listener apply to one of the two buttons
		 */

		// Listener for the Combo box
		  class ItemState implements ItemListener{
			   public void itemStateChanged(ItemEvent e) {
				      System.out.println("event triggered by: " + e.getItem());
				    } 
		  }
		  
		  class ItemAction implements ActionListener{
			    public void actionPerformed(ActionEvent e) {
			      System.out.println("ActionListener : action sur " + combo.getSelectedItem());
			      setShape(combo.getSelectedItem().toString());
			      //System.out.println("GetGraphics: "+getGraphics());  // returns the button graphics??  
			    }               
			  }
		  
		 //Internal class listening to button #1
		  class B13_1_Listener implements ActionListener{
	
		    public void actionPerformed(ActionEvent arg0) {
		      label.setText("Vous avez cliqué sur le bouton 1");   
		 	  animated = true;
			  b13_1.setEnabled(false);
			  b13_2.setEnabled(true);
			  // **** the invocation of go() here freezes the application!
			  // ***  a seperate thread would be needed to restart the animation
			  // go(); 
			  PlayAnimation pa = new PlayAnimation();
			  Thread t = new Thread(pa);
			  t.start();
		    }
		  }
			
		  //Internal class listening to button #2
		  class B13_2_Listener implements ActionListener{
	
		    public void actionPerformed(ActionEvent e) {
		      label.setText("you clicked on button #2"); 
		      animated = false;     
		      b13_1.setEnabled(true);
		      b13_2.setEnabled(false);
		    }
		  }  
		  
		  //Internal class also listening to button #2
		  class B13_2_Listener2 implements ActionListener{
	
		    public void actionPerformed(ActionEvent e) {
		      System.out.println("you clicked on button #2");    
		    }
		  }  	  
		
		  class StateListener implements ActionListener{
			  public void actionPerformed(ActionEvent e) {
				  final String obj = e.getSource().getClass().getSimpleName();
				  System.out.println("object: "+e.getSource().getClass().getSimpleName()); 
				  switch (obj){
				  	case "JCheckBox" :
				  		System.out.println("source : " + ((JCheckBox)e.getSource()).getText() +
			    		  " - état : " + ((JCheckBox)e.getSource()).isSelected());
				  		break;
				  	case "JRadioButton" :
				  		System.out.println("source : " + ((JRadioButton)e.getSource()).getText() +
			    		  " - état : " + ((JRadioButton)e.getSource()).isSelected());
				  		break;
				  	default : 
				  } // end of switch
			    }
		  }
		  
		  class TextListener implements KeyListener{


			public void keyTyped(KeyEvent e) {						
				//  System.out.println("Object name: "+e.getSource().getClass()+"Type of object: "+e.getSource().getClass().getSimpleName()
				//		  +"Object :"+e.getSource()); 
				
				// Note , we cast e.getSource() so that to get a MyTextField object
				// instead of a standard object and then its name.
				// Get the name and contents of the text area
				
				  MyTextField  this_obj = (MyTextField) e.getSource();
				  String this_name = this_obj.getJtfname();
				  String this_txt = this_obj.getText(); 
				  
				//  System.out.println("Object name: "+this_obj.getJtfname());
				  
				  switch (this_name) {
				  case "myjtf" :
					  System.out.println("Myjtf: "+this_txt);
					  break;
				  case "myjtf1" :
					  System.out.println("Myjtf1: "+this_txt);
					  if(!isNumeric(e.getKeyChar()))
					        myjtf1.setText(myjtf1.getText().replace(String.valueOf(e.getKeyChar()), ""));       
					  break;
				  case "myjtf2" :
					  System.out.println("Myjtf2: "+this_txt);
					  break;
				  default :  	  
				  } // end of switch
				  
				  buffer = buffer + Character.toString(e.getKeyChar());
		
			}

	
			public void keyPressed(KeyEvent e) {
				  System.out.println("Text object: "+e.getSource().getClass().getSimpleName()); 
				
			}

	
			public void keyReleased(KeyEvent e) {
				  System.out.println("Text object: "+e.getSource().getClass().getSimpleName()); 
				
			}
			
		     //Retourne true si le paramètre est numérique, false dans le cas contraire
		     private boolean isNumeric(char carac){
		     try {
		       Integer.parseInt(String.valueOf(carac));
		     }
		     catch (NumberFormatException e) {
		       return false;            
		     }
		     return true;
		     }   // End of isNumeric 
		     
		  } // End of class TextListener
			
  } // End of Window13()
		  
/*
 * This class overrides the JTextField class providing a field name so that
 * JTextfield objects can be distinguished
 * 
 * Note, this class cannot be internal  
 */
			
	class MyTextField extends JTextField{
				private String jtfname = null;			// a name for tour Text Object
				private String jtftext = null;			// initial text
						
				// Default constructor
				public  MyTextField() {
					super();							// inherit JTextField
					jtfname = null;						// no name
				}
				
				// Overload constructor with name and initial value
				public MyTextField(String v, String t){
					super(); 							// inherit JTextField
					jtfname = v;
					JTextField j = new JTextField(t);			
					
				}

				// Overload constructor with Format, name and initial value 
				public MyTextField(NumberFormat nf, String v, String t) {
					super();
					jtfname = v;
					jtftext = t;
					JFormattedTextField j = new JFormattedTextField(nf);
					j.setText(jtftext);
				}

				public String getJtfname() {
					return jtfname;
				}

				public void setJtfname(String jtfname) {
					this.jtfname = jtfname;
				}
		  
		  
}	// end of MyTextField

