import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
/*
 * This example shows how use a JTable component
 */

public class Table extends JFrame {
	JPanel pan = new JPanel();
	private JTable tableau;
	private JButton change = new JButton("Changer la taille");
	private JButton retablir = new JButton("Rétablir");
 
  public Table(){
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JTable");
    this.setSize(300, 120);
 
    //Note we use the generic obejct type "Object"
    Object[][] data = {
      {"Cysboy", "28 ans", "1.80 m"},
      {"BZHHydde", "28 ans", "1.80 m"},
      {"IamBow", "24 ans", "1.90 m"},
      {"FunMan", "32 ans", "1.85 m"}
    };
 
    //Column names
    String  title[] = {"Pseudo", "Age", "Taille"};
    this.tableau = new JTable(data, title);
    
    // Add the buttons to the panel
    retablir.setEnabled(false);
    pan.add(change);
    pan.add(retablir);
 
    // Finally add objects to the contentPane
    
    //We add a ScollPane to the ContentPane, which automatically 
    //adds the columne headers. Alternatively the headers can be added
    //programatically.
    
    // this.getContentPane().add(new JScrollPane(tableau));
    
    //Set the headers in the North (above the table)
    this.getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
    //Set the table in the center
    this.getContentPane().add(tableau, BorderLayout.CENTER);
    this.getContentPane().add(pan, BorderLayout.SOUTH);
    
    /*
     * Add button listeners and their method changeSize
     */
    change.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {            
          changeSize(200, 80);
          change.setEnabled(false);
          retablir.setEnabled(true);
        }         
      });
   
      retablir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
   
          changeSize(75, 16);
          change.setEnabled(true);
          retablir.setEnabled(false);
        }         
      });
  }   
 
  /**
   * Change la taille d'une ligne et d'une colonne
   * J'ai mis deux boucles afin que vous puissiez voir 
   * comment parcourir les colonnes et les lignes
   */
  public void changeSize(int width, int height){
    //Nous créons un objet TableColumn afin de travailler sur notre colonne
    TableColumn col;
    for(int i = 0; i < tableau.getColumnCount(); i++){
      if(i == 1){
        //On récupère le modèle de la colonne
        col = tableau.getColumnModel().getColumn(i);
        //On lui affecte la nouvelle valeur
        col.setPreferredWidth(width);
      }
    }            
    for(int i = 0; i < tableau.getRowCount(); i++){
      //On affecte la taille de la ligne à l'indice spécifié !
      if(i == 1)
        tableau.setRowHeight(i, height);
      }
    }
  
  /*
   * The entry point builds and displays a Table object
   */
  public static void main(String[] args){
    Table fen = new Table();
    fen.setVisible(true);
  }
  
} // End of Table class