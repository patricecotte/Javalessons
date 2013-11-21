
/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// ColorPicker3.java
//A quick test of the JColorChooser dialog. This example adds a custom
//preview pane.
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker3 extends JFrame {

  Color c;

  public ColorPicker3() {
    super("JColorChooser Test Frame");
    setSize(200, 100);
    final JButton go = new JButton("Show JColorChoser");
    final Container contentPane = getContentPane();
    go.addActionListener(new ActionListener() {
      final JColorChooser chooser = new JColorChooser();

      boolean first = true;

      public void actionPerformed(ActionEvent e) {
        if (first) {
          first = false;
          GrayScalePanel gsp = new GrayScalePanel();
          chooser.addChooserPanel(gsp);
          chooser.setPreviewPanel(new CustomPane());
        }
        JDialog dialog = JColorChooser.createDialog(ColorPicker3.this,
            "Demo 3", true, chooser, new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                c = chooser.getColor();
              }
            }, null);
        dialog.setVisible(true);
        contentPane.setBackground(c);
      }
    });
    contentPane.add(go, BorderLayout.SOUTH);
    // addWindowListener(new BasicWindowMonitor()); // 1.1 & 1.2
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public class CustomPane extends JPanel {
    JLabel j1 = new JLabel("This is a custom preview pane", JLabel.CENTER);

    JLabel j2 = new JLabel("This label previews the background",
        JLabel.CENTER);

    public CustomPane() {
      super(new GridLayout(0, 1));
      j2.setOpaque(true);
      add(j1);
      add(j2);
    }

    public void setForeground(Color c) {
      super.setForeground(c);
      if (j1 != null) {
        j1.setForeground(c);
        j2.setBackground(c);
      }
    }
  }

  public static void main(String args[]) {
    ColorPicker3 cp3 = new ColorPicker3();
    cp3.setVisible(true);
  }
}

//GrayScalePanel.java
//A simple implementation of the AbstractColorChooserPanel class. This class
//provides a slider and a textfield for picking out a shade of gray.
//

class GrayScalePanel extends AbstractColorChooserPanel implements
    ChangeListener, ActionListener {

  JSlider scale;

  JTextField percentField;

  // Set up our list of grays. We'll assume we have all 256 possible shades,
  // and we'll do it when the class is loaded.
  static Color[] grays = new Color[256];
  static {
    for (int i = 0; i < 256; i++) {
      grays[i] = new Color(i, i, i);
    }
  }

  public GrayScalePanel() {
    setLayout(new GridLayout(0, 1));

    // create the slider and attach us as a listener
    scale = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
    scale.addChangeListener(this);

    // Set up our display for the chooser
    add(new JLabel("Pick your shade of gray:", JLabel.CENTER));
    JPanel jp = new JPanel();
    jp.add(new JLabel("Black"));
    jp.add(scale);
    jp.add(new JLabel("White"));
    add(jp);

    JPanel jp2 = new JPanel();
    percentField = new JTextField(3);
    percentField.setHorizontalAlignment(SwingConstants.RIGHT);
    percentField.addActionListener(this);
    jp2.add(percentField);
    jp2.add(new JLabel("%"));
    add(jp2);
  }

  // We did this work in the constructor so we can skip it here.
  protected void buildChooser() {
  }

  // Make sure the slider is in sync with the other panels.
  public void updateChooser() {
    Color c = getColorSelectionModel().getSelectedColor();
    scale.setValue(toGray(c));
  }

  protected int toGray(Color c) {
    int r = c.getRed();
    int g = c.getGreen();
    int b = c.getBlue();
    // Grab the luminance the same way GIMP does...
    return (int) Math.round(0.3 * r + 0.59 * g + 0.11 * b);
  }

  // Pick a name for our tab in the chooser
  public String getDisplayName() {
    return "Gray Scale";
  }

  // No need for an icon.
  public Icon getSmallDisplayIcon() {
    return null;
  }

  public Icon getLargeDisplayIcon() {
    return null;
  }

  // And lastly, update the selection model as our slider changes.
  public void stateChanged(ChangeEvent ce) {
    getColorSelectionModel().setSelectedColor(grays[scale.getValue()]);
    percentField.setText(""
        + (100 - (int) Math.round(scale.getValue() / 2.55)));
  }

  public void actionPerformed(ActionEvent ae) {
    int val = 100 - Integer.parseInt(ae.getActionCommand());
    getColorSelectionModel().setSelectedColor(grays[(int) (val * 2.55)]);
  }
}

           
         
    
    
