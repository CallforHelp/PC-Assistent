package src.c4h;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
/**
 * Ein Dialogue fur Firmeninfo.
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
    	//setUndecorated(true);
    	setUndecorated(true);
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DIALOG.class.getResource("images/bulb.png")));
    	
    
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DIALOG.class.getResource("images/3s_logo.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		//setBounds(100, 100, 680, 350);
		setSize(670, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(10, 103, 654, 91);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(C4H_DIALOG.class.getResource("/src/c4h/images/3s_logo_text3.png")));
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2021 Hamburger Informatik Technologie-Center e.V. (HITeC).");
		lblCopyright.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(127, 229, 448, 14);
		getContentPane().add(lblCopyright);
		
		JLabel lblAlleRechteVorbehalten = new JLabel("Alle Rechte vorbehalten. ");
		lblAlleRechteVorbehalten.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblAlleRechteVorbehalten.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlleRechteVorbehalten.setBounds(212, 254, 296, 21);
		getContentPane().add(lblAlleRechteVorbehalten);
		
		C4H_BLINK_LABEL lblNewLabel = new C4H_BLINK_LABEL("C4H - Call For Help ");
		lblNewLabel.setText("C4H - Call For Help v.1.2.1");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBlinking(true);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(212, 51, 279, 27);
		getContentPane().add(lblNewLabel);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x+90, y-25);
	
		
	}
}
