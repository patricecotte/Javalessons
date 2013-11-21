import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
/*
 * This example shows how build trees and display them 
 * Use the UImanager to force the system's look and feel
 * User custom icons in the tree 
 */

//CTRL + SHIFT + O pour générer les imports nécessaires
 
public class TreeModel extends JFrame {
  private JTree arbre, arbre2, arbre3;
  private DefaultMutableTreeNode racine;
  //On va créer deux modèles d'affichage
  private  DefaultTreeCellRenderer[] tCellRenderer = new  DefaultTreeCellRenderer[3];
 
  public TreeModel(String lookAndFeel){
    this.setSize(600, 350);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Les arbres");
    //On invoque la méthode de construction de l'arbre
    initRenderer();
    listRoot();
    
    try {
    	  //Use the the « look and feel » of the system
    	  UIManager.setLookAndFeel(lookAndFeel);
    	  //let every component repaint using the « look and feel » of the sytem
    	  SwingUtilities.updateComponentTreeUI(this);
    	}
    	catch (InstantiationException e) {}
    	catch (ClassNotFoundException e) {}
    	catch (UnsupportedLookAndFeelException e) {}
    	catch (IllegalAccessException e) {}   
    this.setVisible(true);
  }
 
  private void initRenderer(){
    //Instanciation
    this.tCellRenderer[0] = new  DefaultTreeCellRenderer();
    //Initialisation des images pour les actions fermer, ouvrir et pour les feuilles
    this.tCellRenderer[0].setClosedIcon(new ImageIcon("D:/Eclipse4/cotpa01/workspace/project1/src/images/green_arrow.jpg"));
    this.tCellRenderer[0].setOpenIcon(new ImageIcon("D:/Eclipse4/cotpa01/workspace/project1/src/images/violet_square.jpg"));
    this.tCellRenderer[0].setLeafIcon(new ImageIcon("D:/Eclipse4/cotpa01/workspace/project1/src/images/blue_star.jpg"));
 
    this.tCellRenderer[1] = new  DefaultTreeCellRenderer();
    this.tCellRenderer[1].setClosedIcon(null);
    this.tCellRenderer[1].setOpenIcon(null);
    this.tCellRenderer[1].setLeafIcon(null);
  }
 
  private void listRoot(){      
    this.racine = new DefaultMutableTreeNode();       
    int count1 = 0;
    for(File file : File.listRoots()){
      DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
      try {
        for(File nom : file.listFiles()){
          DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom.getName()+"\\");               
          lecteur.add(this.listFile(nom, node));               
        }
      } catch (NullPointerException e) {}
 
      this.racine.add(lecteur);
      ++count1; if (count1 > 2) break;	// Stop after 2 units
    }
    //Nous créons, avec notre hiérarchie, un arbre
    arbre = new JTree(this.racine);
    arbre.setRootVisible(false);
    //On définit le rendu pour cet arbre
    arbre.setCellRenderer(this.tCellRenderer[0]);
 
    arbre2 = new JTree(this.racine);
    arbre2.setRootVisible(false);
    arbre2.setCellRenderer(this.tCellRenderer[1]);
 
    arbre3 = new JTree(this.racine);
    arbre3.setRootVisible(false);
 
    JSplitPane split = new JSplitPane(   JSplitPane.HORIZONTAL_SPLIT, 
      new JScrollPane(arbre2), 
      new JScrollPane(arbre3));
    split.setDividerLocation(200);
       
    JSplitPane split2 = new JSplitPane(   JSplitPane.HORIZONTAL_SPLIT, 
      new JScrollPane(arbre), 
      split);
    split2.setDividerLocation(200);
    this.getContentPane().add(split2);
  }
 
  private DefaultMutableTreeNode listFile(File file, DefaultMutableTreeNode node){
    int count = 0;
 
    if(file.isFile())
      return new DefaultMutableTreeNode(file.getName());
    else{
      File[] list = file.listFiles();
      if(list == null)
        return new DefaultMutableTreeNode(file.getName());
 
      for(File nom : list){
        count++;
        //Pas plus de 5 enfants par noeud
        if(count < 5){
          DefaultMutableTreeNode subNode;
          if(nom.isDirectory()){
            subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
            node.add(this.listFile(nom, subNode));
          }else{
            subNode = new DefaultMutableTreeNode(nom.getName());
          }
          node.add(subNode);
        }
      }
      return node;
    }
  }
 
  /*
   * Entry point 
   */
  public static void main(String[] args){
	  
	  //Create an array of the system's lookandfeels
	    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	    TreeModel fen;
	  //Open as many instances as the number of system lookandfeels
	    for(int i = 0; i < looks.length; i++){
	       fen = new TreeModel(looks[i].getClassName());      
	    }   
  } // End of main   
  
} // End of lcass TreeModel
