
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Window11 extends JFrame{
	/*
	 * Example of a GridBagLayout. More properties can be set that the below
	 * code does not use:
	 * - anchor
	 * - fill 
	 * - insets
	 * - ipadx, ipady
	 */
 
  public Window11(){
    this.setTitle("GridBagLayout");
    this.setSize(300, 160);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
 
    //Define 8 'cells', each cell is a JPanel object
    JPanel cell1 = new JPanel();
    cell1.setBackground(Color.YELLOW);
    cell1.setPreferredSize(new Dimension(60, 40));      
    JPanel cell2 = new JPanel();
    cell2.setBackground(Color.red);
    cell2.setPreferredSize(new Dimension(60, 40));
    JPanel cell3 = new JPanel();
    cell3.setBackground(Color.green);
    cell3.setPreferredSize(new Dimension(60, 40));
    JPanel cell4 = new JPanel();
    cell4.setBackground(Color.black);
    cell4.setPreferredSize(new Dimension(60, 40));
    JPanel cell5 = new JPanel();
    cell5.setBackground(Color.cyan);
    cell5.setPreferredSize(new Dimension(60, 40));
    JPanel cell6 = new JPanel();
    cell6.setBackground(Color.BLUE);
    cell6.setPreferredSize(new Dimension(60, 40));
    JPanel cell7 = new JPanel();
    cell7.setBackground(Color.orange);
    cell7.setPreferredSize(new Dimension(60, 40));
    JPanel cell8 = new JPanel();
    cell8.setBackground(Color.DARK_GRAY);
    cell8.setPreferredSize(new Dimension(60, 40));
         
    // One more JPanel object, the container. 
    JPanel content = new JPanel();
    content.setPreferredSize(new Dimension(300, 120));
    content.setBackground(Color.WHITE);
    // Add a layout manager (GridBagLayout) to the container
    content.setLayout(new GridBagLayout());
         
    // Need an additional GridBagConstraints object
    GridBagConstraints gbc = new GridBagConstraints();
         
    // Define (x,0) ranking pair for each cell; note we add to the content
    // a cell (JPanel object) along with a GridBagConstraints version
    gbc.gridx = 0;
    gbc.gridy = 0;
    //La taille en hauteur et en largeur
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    content.add(cell1, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    content.add(cell2, gbc);
    //---------------------------------------------
    gbc.gridx = 2;      
    content.add(cell3, gbc);        
    //---------------------------------------------
    // End of line with cell 4: REMAINDER
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 3;  
    content.add(cell4, gbc);
    /* 
     * now do more cells
    */
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;			// number of columns used horizontally
    gbc.gridheight = 2;			// number of columns used vertically
    // cell 5 replicates VERTICALLY
    gbc.fill = GridBagConstraints.VERTICAL;
    content.add(cell5, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    gbc.gridheight = 1;
    // cell 6 replicates HORIZONTALLY
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    content.add(cell6, gbc);
    //---------------------------------------------
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    content.add(cell7, gbc);
    //---------------------------------------------
    gbc.gridx = 3;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    content.add(cell8, gbc);
    //---------------------------------------------
    // Add content JPanel to JFrame's Pane
    this.setContentPane(content);
    this.setVisible(true);      
  }
} // End of class Window11 
