import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class ColorChooserDemo2 {
	public static void  main (String[] args){ 
	JFrame guiFrame = new JFrame();
	
	//An instance of the JColorChooser class is created and passed to
	//the createDialog method. This instance is combined with a JDialog object.
	final JColorChooser colorChooser = new JColorChooser();
	JDialog dialog = JColorChooser.createDialog(guiFrame,
	                   "Set Text Area color", false, colorChooser
	                    , new ActionListener()
	                      {
	                        @Override
	                         public void actionPerformed(ActionEvent event)
	                          {
	                           //this actionListener is for the OK button
	                            System.out.println("\nI can feel my color being changed to "
	                                   + colorChooser.getColor());
	                
	                          }
	                       }
	                     , new ActionListener()
	                       {
	                         @Override
	                          public void actionPerformed(ActionEvent event)
	                         {
	                          //this actionListener is for the cancel button
	                          System.out.println("\nCancel button clicked..");
	                       }
	                      }
	                        );
		dialog.setVisible(true);
		
	 } // End of main
	 
	 
} // End of class
