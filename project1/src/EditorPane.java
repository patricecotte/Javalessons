import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
// HTML capabilities ... 
import javax.swing.text.html.HTMLEditorKit;
/*
 * This is an example on how set an editor with HTML capabilities.
 */

public class EditorPane extends JFrame {
  private JEditorPane editorPane, apercu;
  private JTabbedPane onglet = new JTabbedPane();
    
  public EditorPane(){
    this.setSize(600, 400);
    this.setTitle("Conteneur éditable");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    editorPane = new JEditorPane();
    editorPane.setText(" <HTML><HEAD></HEAD><BODY></BODY></HTML> ");
       
    apercu = new JEditorPane();
    apercu.setEditable(false);
       
    onglet.addTab("Editeur HTML", new JScrollPane(editorPane));
    onglet.addTab("Aperçu", new JScrollPane(apercu));
    onglet.addChangeListener(new ChangeListener(){
 
      public void stateChanged(ChangeEvent e) {            
        FileWriter fw = null;            
        try {
          fw = new FileWriter(new File("C:/temp/eclipsetmp.html"));
          fw.write(editorPane.getText());
          fw.close();
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        try {
          File file = new File("C:/temp/eclipsetmp.html");
          // This is where the HTML source display 
          apercu.setEditorKit(new HTMLEditorKit());               
          apercu.setPage(file.toURL());
        } catch (IOException e1) {
          e1.printStackTrace();
        }             
      }            
    });
       
    this.getContentPane().add(onglet, BorderLayout.CENTER);
    this.setVisible(true);
    
  } // End of EditorPane
    
  /*
   * Entry point 
   */
  public static void main(String[] args){
    EditorPane fen = new EditorPane();
  }   
} // End of EditorPane class
