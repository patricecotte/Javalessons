import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * This example shows how set up a slider and a progress bar
 */

//CTRL + SHIFT + O pour générer les imports nécessaires

public class SliderProgress extends JFrame{
  // create two panels	
  private JPanel pansldr = new JPanel();
  private JPanel panpbar = new JPanel();
  
  // A slider and its label 
  private JSlider slide = new JSlider();
  private JLabel label = new JLabel("Valeur actuelle : 30");  
  
  // the progress bar and button and a thread for its execution
  private JProgressBar bar =  new JProgressBar();			
  private JButton launch = new JButton("launch");
  private Thread t;
  
  public SliderProgress(){
    this.setSize(250, 150);
    this.setTitle("Slider nad Progress bar");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Customize the slider and label   
    slide.setMaximum(100);
    slide.setMinimum(0);
    slide.setValue(30);
    slide.setPaintTicks(true);
    slide.setPaintLabels(true);
    slide.setMinorTickSpacing(10);
    slide.setMajorTickSpacing(20);
    slide.addChangeListener(new ChangeListener(){
      public void stateChanged(ChangeEvent event){
        label.setText("Valeur actuelle : " + ((JSlider)event.getSource()).getValue());
      }
    });      
    
    // Customize the progress bar and button 
    bar.setMaximum(500);
    bar.setMinimum(0);
    bar.setStringPainted(true);
    launch.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
          t = new Thread(new Progression());
          t.start();            
        }
      }); 
    
    // populate the two panels
    pansldr.add(slide, BorderLayout.CENTER);
    pansldr.add(label, BorderLayout.SOUTH);
    panpbar.add(bar, BorderLayout.CENTER);
    panpbar.add(launch, BorderLayout.SOUTH); 
    
    // Populate the Container with the panels
    this.getContentPane().add(pansldr, BorderLayout.CENTER);
    this.getContentPane().add(panpbar, BorderLayout.SOUTH);      
  }   
  
  /*
   * Progression is executed by thread t
   */
  class Progression implements Runnable{   
	    public void run(){
	      launch.setEnabled(false);
	          
	      for(int val = 0; val <= 500; val++){
	        bar.setValue(val);
	        try {
	          t.sleep(10);
	        } catch (InterruptedException e) {
	          // TODO Auto-generated catch block
	        e.printStackTrace();
	        }
	      }
	      launch.setEnabled(true);
	    }   
	  }
  
  /*
   * Entry point 
   */
  public static void main(String[] args){
    SliderProgress slide = new SliderProgress();
    slide.setVisible(true);
  }   
}
