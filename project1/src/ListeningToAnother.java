
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ListeningToAnother
{
    public ListeningToAnother()
    {
        final Another another = new Another(this);
        /**
         * method 1 - your idea of local registration
         * register listener on JButton from Another class
         * so we can listen for events generated in Another
         */
        another.getTarget().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("target's listener in ListeningToAnother");
            }
        });
        JButton show = new JButton("show dialog");
        show.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                another.showDialog();
            }
        });
        JPanel north = new JPanel();
        north.add(show);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(north, "North");
        f.setSize(200,100);
        f.setLocation(200,200);
        f.setVisible(true);
    }
 
    public void notifyEvent(String message)
    {
        System.out.println("caller = " + message);
    }
 
    public static void main(String[] args)
    {
        new ListeningToAnother();
    }
}
 
class Another
{
    ListeningToAnother listeningToAnother;
    Another classReference;
    JButton target;
    JDialog dialog;
 
    public Another(ListeningToAnother lta)
    {
        listeningToAnother = lta;
        classReference = this;
        target = new JButton("target");
        /**
         * method 2 - using a parent method
         * notify parent class of local action event
         */
        target.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String callerID = classReference.getClass().getName();
                listeningToAnother.notifyEvent(callerID);
            }
        });
        JPanel north = new JPanel();
        north.add(target);
        dialog = new JDialog(new Frame(), "Another Dialog", false);
        dialog.getContentPane().add(north, "North");
        dialog.setSize(200,100);
        dialog.setLocation(440, 200);
    }
 
    public void showDialog()
    {
        dialog.setVisible(true);
    }
 
    public JButton getTarget()
    {
        return target;
    }
}

