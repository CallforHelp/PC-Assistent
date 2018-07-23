package src.c4h;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
 
public class BLINKLABEL extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private static final int BLINKING_RATE = 1000; // in ms

  private boolean blinkingOn = true;
  
  public BLINKLABEL(String text) {
    super(text);
    Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
    timer.setInitialDelay(0);
    timer.start();
  }
  
  public void setBlinking(boolean flag) {
    this.blinkingOn = flag;
  }
  public boolean getBlinking(boolean flag) {
    return this.blinkingOn;
  }

  
  private class TimerListener implements ActionListener {
    private BLINKLABEL bl;
    private Color bg;
    private Color fg;
    private boolean isForeground = true;
    
    public TimerListener(BLINKLABEL bl) {
      this.bl = bl;
      fg = bl.getForeground();
      bg = bl.getBackground();
    }
 
    public void actionPerformed(ActionEvent e) {
      if (bl.blinkingOn) {
        if (isForeground) {
          bl.setForeground(fg);
        }
        else {
          bl.setForeground(bg);
        }
        isForeground = !isForeground;
      }
      else {
        // here we want to make sure that the label is visible
        // if the blinking is off.
        if (isForeground) {
          bl.setForeground(fg);
          isForeground = false;
        }
      }
    }
    
  }
 
 /* // --- for testing 
  private static void createAndShowUI() {
    JFrame frame = new JFrame("BlinkLabel");
    final BLINKLABEL bl = new BLINKLABEL("I'm blinking!");
    
    frame.getContentPane().setLayout(new java.awt.FlowLayout());
   
    frame.getContentPane().add(bl);
    
    JButton b = new JButton("toogle blink");
    b.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
            bl.blinkingOn = !bl.blinkingOn;
          }
        });
    frame.getContentPane().add(b);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
 
  public static void main(String[] args)  {
    java.awt.EventQueue.invokeLater(new Runnable(){
      public void run(){
        createAndShowUI();
      }
    });
  }*/
  // ---
}