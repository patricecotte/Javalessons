import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooserDemo1 {

	public static void main(String[] args) {
		//A JFrame is used to act as the parent component
		JFrame guiFrame = new JFrame();

		Color selectedColor = JColorChooser.showDialog(guiFrame, "Pick a Color"
		                , Color.GREEN);
		System.out.println("chosen color:"+selectedColor);
	}

}
