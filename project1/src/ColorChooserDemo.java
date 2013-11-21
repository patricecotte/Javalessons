
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Callable;

import javax.security.auth.callback.Callback;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
 
/* ColorChooser.java requires no other files. */
public class ColorChooserDemo extends JPanel
                              implements ChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String getRimplstring = "Rimpl";
	ColorChooserDemo classReference;		 // The internal reference to this class
	ColorChooserMain ccdccm; 					 // the passed reference to caller

	
	public void setCcm(ColorChooserMain ccm) {
		ccdccm = ccm;
		System.out.println("setCcm: "+ccdccm);
	}
	
	public ColorChooserMain getCcm(){
		return ccdccm;
	}


	public String getGetRimplstring() {
		return getRimplstring;
	}


	public void setRimplstring(String getRstr) {
		this.getRimplstring = getRstr;
	}

	// Create the Color object
	Color newColor = null;

    protected JColorChooser tcc;
    // protected JLabel banner			/* no banner */
 
    public ColorChooserDemo() {
        super(new BorderLayout());
        classReference = this;
        
        // See what the Rimplstring contains
        System.out.println("Demo is executing ...Rimplstring = "+getGetRimplstring());
 
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
        	//System.out.println("Panelname "+oldPanels[i].getDisplayName());
  
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
        	else if (oldPanels[i].getDisplayName().equals("TSV") |
        			oldPanels[i].getDisplayName().equals("HSV")) {
             // Remove tsv = hsb chooser if desired
             tcc.removeChooserPanel(oldPanels[i]);
        	}
        	else if (oldPanels[i].getDisplayName().equals("TSL") |
        			oldPanels[i].getDisplayName().equals("HSL")) {
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
        
        // Add the caller's listener
        tcc.addMouseListener(new MouseListener()
        {

			@Override
			public void mouseClicked(MouseEvent e) {				
					try {
						String CallerID = classReference.getClass().getName();
						System.out.println("On mouse clicked caller is: "+CallerID+", "+ccdccm);
						ccdccm.ccdNotifyccm(CallerID);
					} catch (Exception e1) {
						//System.out.println("Can't get the caller");
					}			
				
			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
        });
        
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
    public static void createAndShowGUI(ColorChooserMain parmccm) {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new ColorChooserDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        // If parmccm is not null this is the caller reference
        if (parmccm != null) {
        	ColorChooserMain ccm = parmccm;
        	System.out.println("CreateAndShowGui: "+ccm);
        }
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
 
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(null);
            }
        });
    }
    
    /*
     * 	This runnable is for threading techniques
     */
    class RunImpl implements Runnable {
    	  private ColorChooserDemo ccd = null;
    	  private Color color;
    	  private String Rimplstring = "RunImpl";
		  
		  public RunImpl(ColorChooserDemo ccd, Color c){
    	    this.ccd= ccd;
    	    this.color = c;
    	  }
		  
    	  public void run() {
    	       /* System.out.println("Running thread");
    	        ccd.createAndShowGUI();
    	        */
    	  }                           
     } // End of Runimpl class   
    
    class RunImpl2 implements Runnable {
     	  private ColorChooserMain r2ccm = null;		// our slot for the caller's reference
		  public RunImpl2(ColorChooserMain ccm){
			  r2ccm = ccm; 
			  r2ccm.ccdNotifyccm("CCD notifies ccm in Runnable");
			  System.out.println("This ccm: "+ccm);
	    	  }
		  
		  public void run() {
			  //main(null);
			  createAndShowGUI(r2ccm);
	    	  }              
		  
	     } // End of Runimpl class   
    /*
     * This callable is for the execute technique
     */
    class Task implements Callable<Color> {
        public Color call() throws Exception {
            Thread.sleep(2000);
            return newColor;
        }
    }

    /*
     * This calls implements an interface
     */
    interface CallBack {
    	void callback();			// default method 
    	
    }
    
    public class ColorItem implements Callback {
    	void callback() {			// override method
    		System.out.println("callback run");
    	}
    }
 
} // End of class ColorChooser 


