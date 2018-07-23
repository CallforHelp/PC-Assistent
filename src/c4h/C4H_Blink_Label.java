package src.c4h;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
 
public class C4H_Blink_Label extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private static final int BLINKING_RATE = 500; // in ms

  private boolean blinkingOn = true;
  
  public C4H_Blink_Label(String text) {
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
    private C4H_Blink_Label bl;
    private Color bg;
    private Color fg;
    private boolean isForeground = true;
    
    public TimerListener(C4H_Blink_Label bl) {
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
}