package com.sdz.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sdz.model.Clock;		// Clock object
import com.sdz.observer.*;		// interfaces

/*
 * Window1 sets up a Window
 */
public class Window1 extends JFrame{
	  private JLabel label = new JLabel(); 
	  private Clock clock;
	     
	  public Window1(){
	    //Set up a small non-resizable window
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setSize(200, 80);
	    
	    //Set up the clock
	    this.clock = new Clock();
	    //Set an observer on the clock (anonymous class)
	    this.clock.addObserver(new Observer(){
	        public void update(String hour) {
	          label.setText(hour);
	        }
	      });
	    
	    //Set up the label
	    Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
	    this.label.setFont(police);
	    this.label.setHorizontalAlignment(JLabel.CENTER);
	    this.label.setForeground(Color.RED);
	    //add the label to the Pane
	    this.getContentPane().add(this.label, BorderLayout.CENTER);
	    this.setVisible(true);
	    
	    //Start the clock; run is an infinite loop that extracts the time
	    //from the system for ever.
	    this.clock.run();
	    
	  } // End of Window1
	 
	  /*
	   * Starting point
	   */
public static void main(String[] args){
	    Window1 w = new Window1();
	  } // End of main 
	  
} // End of class Window1	
	

