package src.c4h;
/**
 * eigen Button Class für eine Persouml;nliche Struktur
 * @author helmi
 * 
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

class C4H_MY_BUTTON extends JButton {

    /**
     *Serialilesierung 
     */
	private static final long serialVersionUID = 1L;
	/**
	 * Hoverbackgroud
	 */
	private Color hoverBackgroundColor;
    /**
     * HoverBackgraound
     */
	private Color pressedBackgroundColor;
	/**
	 * Konstruktor
	 */
    public C4H_MY_BUTTON() {
        this(null);
    }
    
    /**
     * Kontruktor fuuml;r 
     * @param text
     */
    public C4H_MY_BUTTON(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }
    /**
     * Male die nouml;tige Komponennte
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
	/*	pcInfoButton.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		pcInfoButton.setBackground(null);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		pcInfoButton.setBackground(null);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		pcInfoButton.setBackground(null);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		pcInfoButton.setBackground(null);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		pcInfoButton.setBackground(new Color(3, 59, 90));
		
	}
});*/


 
    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}