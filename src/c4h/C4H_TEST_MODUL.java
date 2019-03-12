package src.c4h;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class C4H_TEST_MODUL {

	public JFrame frmTestingBorad;
	public JTextField textField;
	private JLabel lblTestingModulCh;
	private JCheckBox chckbxc4H;
	private JCheckBox chckbxTestWeb;
	private JButton buttonReset;
	String url="http://fehlermeldung.3s-hamburg.de/test";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public C4H_TEST_MODUL() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		frmTestingBorad = new JFrame();
		frmTestingBorad.setTitle("Testing Borad beta 1.0");
		frmTestingBorad.setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_TEST_MODUL.class.getResource("/src/c4h/images/3s_logo_c4h.png")));
		frmTestingBorad.setBounds(100, 100, 347, 259);
		frmTestingBorad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestingBorad.getContentPane().setLayout(null);
		
		textField= new JTextField();
		
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(167, 123, 117, 29);
		frmTestingBorad.getContentPane().add(textField);
		textField.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			    	textField.setBackground(Color.WHITE);
			    	char c = e.getKeyChar();
			    	if (textField.getText().length() == 4) {
			    		e.consume();
		            }
			    	
			    	if (!((c >= '0') && (c <= '9') ||
			    			(c == KeyEvent.VK_BACK_SPACE) ||
			    			(c == KeyEvent.VK_DELETE))) {
			    		textField.setSelectedTextColor(Color.RED);
			    		e.consume();
			    	}
			    }
		});
		
		JLabel lblNewLabel = new JLabel("Schulnummer?");
		lblNewLabel.setBounds(40, 125, 117, 23);
		frmTestingBorad.getContentPane().add(lblNewLabel);
		
		JButton btnBesttigen = new JButton("Bestaetigen");
		btnBesttigen.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		btnBesttigen.setBounds(167, 180, 117, 29);
		frmTestingBorad.getContentPane().add(btnBesttigen);
		
		lblTestingModulCh = new JLabel("Testing Modul C4H");
		lblTestingModulCh.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTestingModulCh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestingModulCh.setBounds(88, 11, 160, 40);
		frmTestingBorad.getContentPane().add(lblTestingModulCh);
		
		chckbxc4H = new JCheckBox("C4H Web Borowser");
		chckbxc4H.setBounds(40, 58, 147, 23);
		frmTestingBorad.getContentPane().add(chckbxc4H);
		
		chckbxTestWeb = new JCheckBox("C4H Testbereich");
		chckbxTestWeb.setSelected(true);
		
		chckbxTestWeb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					chckbxc4H.setSelected(false);
				}
				if(e.getStateChange()==0)
					chckbxc4H.setSelected(true);
				
			}
		});
		chckbxTestWeb.setBounds(40, 88, 132, 23);
		frmTestingBorad.getContentPane().add(chckbxTestWeb);
		
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		buttonReset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		buttonReset.setBounds(40, 180, 117, 29);
		frmTestingBorad.getContentPane().add(buttonReset);
		
		chckbxc4H.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==1) {
					chckbxTestWeb.setSelected(false);
				}
				if(e.getStateChange()==0) {
					chckbxTestWeb.setSelected(true);
				}
			}
		});
	
		
		btnBesttigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				if(textField.getText().equals("")|textField.getText().equals(null))
					textField.setBackground(Color.RED);
				else {
					if (chckbxc4H.isSelected()) {
						url="http://fehlermeldung.3s-hamburg.de";
					}
					System.out.println(url);
					C4H_DYNAMIC_GUI gui = new C4H_DYNAMIC_GUI(textField.getText(), url);
					if(gui.frmCh.isEnabled()){
						gui.frmCh.setVisible(false);
						gui= new C4H_DYNAMIC_GUI(textField.getText(), url);
					}
					gui.frmCh.setVisible(true);
					gui.chatPanel.setVisible(false);
				}
				
			}
		});
		frmTestingBorad.setVisible(true);
	}
}
