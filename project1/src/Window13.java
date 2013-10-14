import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window13 extends JFrame implements ActionListener, MouseListener{
/*
 * Window13 is invoked by the Sdz13 class. Window13 implements Panel12, an extension
 * of JPanel class that contains an animation, 2 standard JButton objects in a standard 
 * JPanel object and a standard JLabel object.
 * It also implements the ActionListener interface. 
 * 
 * Window13 combines the MouseListener and the ActionListener. Both interfaces are 
 * implemented in the Window13 object. In the Sdz12 example MouseListener is implemented
 * in the Button12 object
 */
		  private Panel12 pan12 = new Panel12();			// animated panel
		  private JPanel container = new JPanel();			// panel for a container
		  private JPanel south = new JPanel(); 				// panel for buttons
		  private JButton b13_1 = new JButton("Start animation");
		  private JButton b13_2 = new JButton("Stop animation");  
		  private JLabel label = new JLabel("This JLabel object");  
		  	  
		  private int count1 = 0; private int count2 = 0;
		  // variables for the go() method
		  private boolean animated = true;
		  private boolean backX, backY;
		  private int x, y;
		   
		  public Window13(){
		    this.setTitle("An animation, 2 buttons in a BorderLayout and a label");
		    this.setSize(600, 400);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    
		    // create a BorderLayout object
		    container.setLayout(new BorderLayout());
		    container.add(pan12, BorderLayout.CENTER);  // Set pan12 centered
		    
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
		    
		    // Customize our label
		    Font police = new Font("Tahoma", Font.BOLD, 16);
		    label.setFont(police);
		    label.setForeground(Color.blue);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    
		    // Yet another BorderLayout specificaton.
		    container.add(label, BorderLayout.NORTH);
		    
		    // Show resulting window
		    this.setContentPane(container);
		    this.setVisible(true);    
		    go();
		  }
		   
		/* 
		 * Note this single method covers all possible actions!(non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
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
		
		// This method animates the window

		private void go(){  
	
		    System.out.println("Go method ");
		    
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
		    }
		  } // end of go method

		/*
		 * Internal classes: B13_1_Listener, B13_2__Listener apply to one of the two buttons
		 */
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
		
}	// end of Window13 class

