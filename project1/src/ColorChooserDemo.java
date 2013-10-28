
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 /*
  * This example shows 5 choosers:
  * - swatches	- for choosing among a gallery of swatches
  * - The HSV 	- hue, saturation and value - chooser
  * - The HSL	- hue, saturation and ligthness - chooser	(JDK 1.7)
  * - The RGB	- red, green , blue chooser 
  * - the CMYK	- cyan, magenta, yellow, k four colors chooser (JDK 1.7)
  * 
  * Use the addChooserPanel to add custom choosers
  * Use the removeChooserPanel to remove choosers.
  */
 
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
 
/* ColorChooserDemo.java requires no other files. */
public class ColorChooserDemo extends JPanel
                              implements ChangeListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Create the Color object
	Color newColor = null;

    protected JColorChooser tcc;
    // protected JLabel banner			/* no banner */
 
    public ColorChooserDemo() {
        super(new BorderLayout());
 
        /* Set up the banner at the top of the window
        banner = new JLabel("Welcome to the Tutorial Zone!",
                            JLabel.CENTER);
        banner.setForeground(Color.yellow);
        banner.setBackground(Color.blue);
        banner.setOpaque(true);
        banner.setFont(new Font("SansSerif", Font.BOLD, 24));
        banner.setPreferredSize(new Dimension(100, 65));
        */
        
        JPanel bannerPanel = new JPanel(new BorderLayout());
        
        /* add the banner to the bannerpanel
        bannerPanel.add(banner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));
        */
 
        //Set up color chooser for setting text color and remove choosers.
        //tcc = new JColorChooser(banner.getForeground());
        tcc = new JColorChooser(Color.BLUE);
        
        AbstractColorChooserPanel[] oldPanels = tcc.getChooserPanels();
        
        // Remove panels but RGB
        for (int i=0; i<oldPanels.length; i++) {
        	String clsName = oldPanels[i].getClass().getName();
  
        	if (clsName.equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
             // Remove swatch chooser if desired
             tcc.removeChooserPanel(oldPanels[i]);
        	}
        	/* 
        	else if (oldPanels[i].getDisplayName().equals("RGB")) {
             // Remove rgb chooser if desired
             tcc.removeChooserPanel(oldPanels[i]);
        	} 
        	*/ 
        	else if (oldPanels[i].getDisplayName().equals("TSV")) {
             // Remove tsv = hsb chooser if desired
             tcc.removeChooserPanel(oldPanels[i]);
        	}
        	else if (oldPanels[i].getDisplayName().equals("TSL")) {
        	 // Remove tsl = hsl panel
        	tcc.removeChooserPanel(oldPanels[i]);
        	}
        	else if (oldPanels[i].getDisplayName().equals("CMYK"))  {
           	 // Remove CMYK panel
           	tcc.removeChooserPanel(oldPanels[i]);
           	}
        }
      
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Text Color"));
        
        tcc.setPreviewPanel(new JPanel());		/* hide preview panel */
        /*tcc.setPreviewPanel(null);			   show previex panel */
 
        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
        
    }
 
    
    public void stateChanged(ChangeEvent e) {
        newColor = tcc.getColor();
        System.out.println("new color: "+newColor);
        // banner.setForeground(newColor);
    }
   
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new ColorChooserDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /*
     * 
     */
    class RunImpl implements Runnable {
    	  private ColorChooserDemo ccd = null;
    	  private Color color;
    	 
    	  public RunImpl(ColorChooserDemo ccd, Color c){
    	    this.ccd= ccd;
    	    this.color = c;
    	  }
    	  public void run() {
    	        System.out.println("Running thread");
    	        ccd.createAndShowGUI();
    	  }                           
     } // End of Runimpl class   
    
}


