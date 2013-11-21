
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
 
 class SplitFrame extends JFrame {
  //On déclare notre objet JSplitPane
  private JSplitPane split1;
  private JSplitPane split2;
  private JSplitPane split3;
  
  private JTextArea textPane = new JTextArea();   			// An editor
  private JScrollPane scrollPane = new JScrollPane(textPane);	// Set it in a scrolling pane
 
  public SplitFrame(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneur");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600, 300);
 
  
    //On crée deux conteneurs de couleurs différentes
    JPanel pan1 = new JPanel();
    pan1.setBackground(Color.blue);
       
    JPanel pan2 = new JPanel();
    pan2.setBackground(Color.red);
       
    JPanel pan3 = new JPanel();
    pan3.setBackground(Color.YELLOW);
    
    // The panel with the editor and the scollpane. The size must be on the scrollpane
    // in order to get the sliders. 
    JPanel pan4 = new JPanel();
    pan4.setBackground(Color.PINK);
    scrollPane.setPreferredSize(new Dimension(500,100));
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    pan4.add(scrollPane);
    
    //On construit enfin notre séparateur
    split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pan1, pan2);
    pan1.setPreferredSize(new Dimension(300,100));
    split1.setPreferredSize(new Dimension(600,100));
    split1.setOneTouchExpandable(true);
    split1.setDividerSize(8);
    
    pan3.setPreferredSize(new Dimension(600,50));
    split2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pan3, pan4);
    split2.setOneTouchExpandable(true);
    split2.setDividerSize(8);
    
    split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, split1, split2);
    split3.setOneTouchExpandable(true);
    split3.setDividerSize(15);
       
    //On le passe ensuite au content pane de notre objet SplitFrame
    //placé au centre pour qu'il utilise tout l'espace disponible
    //this.getContentPane().add(split1, BorderLayout.NORTH);
    //this.getContentPane().add(split2, BorderLayout.CENTER);
    this.getContentPane().add(split3, BorderLayout.CENTER);
    this.setVisible(true);
  }
    
  public static void main(String[] args){
    SplitFrame fen = new SplitFrame();
  }
}