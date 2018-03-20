package bginfo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Label;

public class CallForHelpDialog extends JDialog {
/**
	 * Create the dialog.
	 */
	public CallForHelpDialog() {
	
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CallForHelpDialog.class.getResource("/bginfo/images/3s_logo.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 494, 247);
		getContentPane().setLayout(null);
		
		JPanel TextInfopanel_1 = new JPanel();
		TextInfopanel_1.setBackground(Color.WHITE);
		TextInfopanel_1.setBounds(63, 0, 390, 140);
		getContentPane().add(TextInfopanel_1);
		TextInfopanel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bani\\Documents\\GitHub\\Call-for-a-Help\\prototype\\src\\bginfo\\images\\#kontaktgif.gif"));
		lblNewLabel.setBounds(22, 11, 358, 118);
		TextInfopanel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 25, 53, 91);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(CallForHelpDialog.class.getResource("/bginfo/images/3s_logo.png")));
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2018 Hamburger Informatik Technologie-Center e.V. (HITeC).");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(20, 151, 410, 14);
		getContentPane().add(lblCopyright);
		
		JLabel lblAlleRechteVorbehalten = new JLabel("Alle Rechte vorbehalten. ");
		lblAlleRechteVorbehalten.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlleRechteVorbehalten.setBounds(40, 176, 390, 21);
		getContentPane().add(lblAlleRechteVorbehalten);
	}
}
