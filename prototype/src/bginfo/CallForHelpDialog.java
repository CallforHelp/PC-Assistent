package bginfo;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class CallForHelpDialog extends JDialog {
/**
	 * 
	 */
	private static final long serialVersionUID = -6961734509536439873L;
/**
	 * 
	 */

/**
	 * Create the dialog.
	 */
	public CallForHelpDialog() {
	
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CallForHelpDialog.class.getResource("/bginfo/images/3s_logo.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 494, 247);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(73, 24, 330, 91);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(CallForHelpDialog.class.getResource("/bginfo/images/3s_logo.png")));
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2018 Hamburger Informatik Technologie-Center e.V. (HITeC).");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(20, 151, 468, 14);
		getContentPane().add(lblCopyright);
		
		JLabel lblAlleRechteVorbehalten = new JLabel("Alle Rechte vorbehalten. ");
		lblAlleRechteVorbehalten.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlleRechteVorbehalten.setBounds(40, 176, 390, 21);
		getContentPane().add(lblAlleRechteVorbehalten);
	}
}
