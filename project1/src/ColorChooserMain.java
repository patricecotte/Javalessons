


import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


public class ColorChooserMain {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Color jfcolor = null;
		ColorChooserDemo jfccd = new ColorChooserDemo();
		Thread t = new Thread(jfccd.new RunImpl(jfccd, jfcolor));
		t.start();
//		System.print.out("chosen color: "+thiscolor);
		jf.add(jfccd);
		jf.pack();
		jf.setVisible(true);
	} // End of main

} // End of class
