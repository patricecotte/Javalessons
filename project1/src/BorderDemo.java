import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/*
 * BorderDemo example shows a number of borders with various appearances
 */
//CTRL + SHIFT + O pour g�n�rer les imports n�cessaires
public class BorderDemo extends JFrame{
 
  // Create an array of Strings that will become the 
  private String[] list = {   
    "Bevel Border", 
    "Etched Border", 
    "Line Border", 
    "Matted Border", 
    "Raised Bevel Border", 
    "Title Border",
    "Compound Border"
  };
 
  // Create an array of borders
  private Border[] listBorder = {   
    BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.red),
    BorderFactory.createEtchedBorder(Color.BLUE, Color.GRAY),
    BorderFactory.createLineBorder(Color.green),
    BorderFactory.createMatteBorder(5, 2, 5, 2, Color.MAGENTA),
    BorderFactory.createRaisedBevelBorder(),
    BorderFactory.createTitledBorder("Titre"),
    BorderFactory.createCompoundBorder(
      BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.blue), 
      BorderFactory.createMatteBorder(5, 2, 5, 2, Color.MAGENTA)
    )
  };
 
  public BorderDemo(){      
    this.setTitle("Les bordures font la f�te !");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(550, 200);
 
    // add labels to the panel, associating a border to each label
    JPanel pan = new JPanel();
    for(int i = 0; i < list.length; i++){      
      JLabel lib = new JLabel(list[i]);
      lib.setPreferredSize(new Dimension(150, 50));
      lib.setBorder(listBorder[i]);
      lib.setAlignmentX(JLabel.CENTER);
      lib.setHorizontalAlignment(JLabel.CENTER);
      pan.add(lib);
    }
 
    this.getContentPane().add(pan);
  }  
 
  public static void main(String[] args){
    BorderDemo demo = new BorderDemo();
    demo.setVisible(true);
  }   
}

