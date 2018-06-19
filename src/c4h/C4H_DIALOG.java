package src.c4h;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * Eine Dialogue was auch nur ein Paar sek. erscheint 
 * firmeninfo 
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_DIALOG extends JDialog {
	/**
	 * Serialisierung der Klasse
	 */
	private static final long serialVersionUID = -6961734509536439873L;
    /**
	 * Jdialog erstellen.
	 * 
	 */
	public C4H_DIALOG() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DIALOG.class.getResource("images/bulb.png")));
	
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DIALOG.class.getResource("images/3s_logo.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 494, 247);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(C4H_DIALOG.class.getResource("images/3s_logo.png")));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(10, 24, 458, 91);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(C4H_DIALOG.class.getResource("images/3s_logo.png")));
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2018 Hamburger Informatik Technologie-Center e.V. (HITeC).");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(20, 151, 468, 14);
		getContentPane().add(lblCopyright);
		
		JLabel lblAlleRechteVorbehalten = new JLabel("Alle Rechte vorbehalten. ");
		lblAlleRechteVorbehalten.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlleRechteVorbehalten.setBounds(40, 176, 390, 21);
		getContentPane().add(lblAlleRechteVorbehalten);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
	}
}
