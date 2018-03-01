package bginfo;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class BgInfoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 376621476984946157L;
	private JPanel contentPane;
	private final BG_Info bg = new BG_Info();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BgInfoFrame frame = new BgInfoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public BgInfoFrame() throws IOException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 396, 635);
		setLocation(430,45);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setToolTipText("Uberschrift");
		textPane_2.setText("**********************************************************");
		textPane_2.setForeground(Color.BLUE);
		textPane_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrs = new JTextArea();
		txtrs.setText("3S");
		txtrs.setToolTipText("3S");
		
		JTextArea txtrBginfo = new JTextArea();
		txtrBginfo.setToolTipText("3S");
		txtrBginfo.setText("BG_Info");
		
		JTextArea txtrSchulsupportservicesHitecEv = new JTextArea();
		txtrSchulsupportservicesHitecEv.setToolTipText("3S");
		txtrSchulsupportservicesHitecEv.setText("Schul-Support-Services HiTEC e.V.");
		
		JTextArea txtrPcinfo = new JTextArea();
		txtrPcinfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrPcinfo.setToolTipText("3S");
		txtrPcinfo.setText("PC_Info");
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("Uberschrift");
		textPane.setText("**********************************************************");
		textPane.setForeground(Color.BLUE);
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrHostName = new JTextArea();
		txtrHostName.setToolTipText("3S");
		txtrHostName.setText("Host Name ");
		
		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setToolTipText("3S");
		txtrUserName.setText("User Name");
		
		JTextArea txtrOsVersion = new JTextArea();
		txtrOsVersion.setToolTipText("3S");
		txtrOsVersion.setText("Os Version ");
		
		JTextArea txtrOsArchitektur = new JTextArea();
		txtrOsArchitektur.setToolTipText("3S");
		txtrOsArchitektur.setText("OS Architektur");
		
		JTextArea txtrMusterImages = new JTextArea();
		txtrMusterImages.setToolTipText("3S");
		txtrMusterImages.setText("Muster Images");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setToolTipText("3S");
		textArea_1.setText(":");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setToolTipText("3S");
		textArea_2.setText(":");
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setToolTipText("3S");
		textArea_3.setText(":");
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setToolTipText("3S");
		textArea_4.setText(":");
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setToolTipText("3S");
		textArea_5.setText(":");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setToolTipText("Uberschrift");
		textPane_1.setText("**********************************************************");
		textPane_1.setForeground(Color.BLUE);
		textPane_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrNetzwerk = new JTextArea();
		txtrNetzwerk.setToolTipText("3S");
		txtrNetzwerk.setText("Netzwerk");
		txtrNetzwerk.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setToolTipText("Uberschrift");
		textPane_3.setText("**********************************************************");
		textPane_3.setForeground(Color.BLUE);
		textPane_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrIpAdresse = new JTextArea();
		txtrIpAdresse.setToolTipText("3S");
		txtrIpAdresse.setText("IP Adresse");
		
		JTextArea txtrSubnetMask = new JTextArea();
		txtrSubnetMask.setToolTipText("3S");
		txtrSubnetMask.setText("Subnet Mask");
		
		JTextArea txtrMacAdresse = new JTextArea();
		txtrMacAdresse.setToolTipText("3S");
		txtrMacAdresse.setText("Mac Adresse");
		
		JTextArea txtrDomain = new JTextArea();
		txtrDomain.setToolTipText("3S");
		txtrDomain.setText("Domain");
		
		JTextArea txtrDefaultGateway = new JTextArea();
		txtrDefaultGateway.setToolTipText("3S");
		txtrDefaultGateway.setText("Default Gateway");
		
		JTextArea textArea = new JTextArea();
		textArea.setToolTipText("3S");
		textArea.setText(":");
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setToolTipText("3S");
		textArea_6.setText(":");
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setToolTipText("3S");
		textArea_7.setText(":");
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setToolTipText("3S");
		textArea_8.setText(":");
		
		JTextArea txtrDhcpServer = new JTextArea();
		txtrDhcpServer.setToolTipText("3S");
		txtrDhcpServer.setText("DHCP Server");
		
		JTextArea txtrDnsServer = new JTextArea();
		txtrDnsServer.setToolTipText("3S");
		txtrDnsServer.setText("DNS Server");
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setToolTipText("3S");
		textArea_9.setText(":");
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setToolTipText("3S");
		textArea_10.setText(":");
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setToolTipText("3S");
		textArea_11.setText(":");
		
		JTextArea txtrHostNameinhalt = new JTextArea();
		txtrHostNameinhalt.setToolTipText("3S");
		txtrHostNameinhalt.setText(bg.getLocalHost());
		
		JTextArea txtrOsVersioninhalt = new JTextArea();
		txtrOsVersioninhalt.setToolTipText("3S");
		txtrOsVersioninhalt.setText(bg.getOSversion());
		
		JTextArea txtrUserNameInhalt = new JTextArea();
		txtrUserNameInhalt.setToolTipText("3S");
		txtrUserNameInhalt.setText(bg.getUserName());
		
		JTextArea txtrOsArchitektur_1 = new JTextArea();
		txtrOsArchitektur_1.setToolTipText("3S");
		txtrOsArchitektur_1.setText(bg.getOSArchitecture());
		
		JTextArea txtrMusterImages_1 = new JTextArea();
		txtrMusterImages_1.setToolTipText("3S");
		txtrMusterImages_1.setText(bg.getMusterImages());
		
		JTextArea txtrIpAdresseinahlt = new JTextArea();
		txtrIpAdresseinahlt.setToolTipText("3S");
		txtrIpAdresseinahlt.setText(bg.getLocalAdresse());
		
		JTextArea txtrSubnetMaskinhalt = new JTextArea();
		txtrSubnetMaskinhalt.setToolTipText("3S");
		txtrSubnetMaskinhalt.setText(bg.getSubnetMask());
		
		JTextArea txtrMacAdresseinhalt = new JTextArea();
		txtrMacAdresseinhalt.setToolTipText("3S");
		txtrMacAdresseinhalt.setText(bg.getMacAddress());
		
		JTextArea txtrDomaininhalt = new JTextArea();
		txtrDomaininhalt.setToolTipText("3S");
		txtrDomaininhalt.setText(bg.getMachindomain());
		
		JTextArea txtrDefaultGatewayinhalt = new JTextArea();
		txtrDefaultGatewayinhalt.setToolTipText("3S");
		txtrDefaultGatewayinhalt.setText(bg.getDefaultgateway());
		
		JTextArea txtrDhcpServerinhalt = new JTextArea();
		txtrDhcpServerinhalt.setToolTipText("3S");
		txtrDhcpServerinhalt.setText(bg.getDHCPServer());
		
		JTextArea txtrDnsServerinhalt = new JTextArea();
		txtrDnsServerinhalt.setToolTipText("3S");
		txtrDnsServerinhalt.setText(bg.getDNSServer());
		
		JButton btnFehlerMelden = new JButton("Fehler Melden ");
		btnFehlerMelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("action by clik");
			}
		});
		btnFehlerMelden.setBackground(Color.DARK_GRAY);
		btnFehlerMelden.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFehlerMelden.setForeground(Color.RED);
		
		JTextArea txtrTimetobiuld = new JTextArea();
		txtrTimetobiuld.setToolTipText("3S");
		txtrTimetobiuld.setText(bg.timetoBuild());
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtrBginfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtrs, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGap(169)
									.addComponent(txtrTimetobiuld)
									.addGap(34))
								.addComponent(txtrSchulsupportservicesHitecEv, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtrHostName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtrOsVersion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
										.addComponent(txtrMusterImages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtrOsArchitektur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtrUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(22)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrOsVersioninhalt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrUserNameInhalt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrMusterImages_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrOsArchitektur_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtrHostNameinhalt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
									.addGap(96))
								.addComponent(txtrPcinfo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrNetzwerk, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtrDefaultGateway, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrDnsServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtrDhcpServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textArea_11, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrDnsServerinhalt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textArea_10, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrDhcpServerinhalt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textArea_9, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtrDefaultGatewayinhalt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFehlerMelden, Alignment.LEADING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtrIpAdresse, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtrSubnetMask, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtrMacAdresse, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtrDomain, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_8, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrDomaininhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrMacAdresseinhalt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrSubnetMaskinhalt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtrIpAdresseinahlt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))))
							.addGap(53)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrTimetobiuld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(txtrBginfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrSchulsupportservicesHitecEv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrPcinfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrHostName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrHostNameinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrOsVersion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrOsVersioninhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrUserNameInhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrOsArchitektur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrOsArchitektur_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrMusterImages, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrMusterImages_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrNetzwerk, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrIpAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrIpAdresseinahlt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrSubnetMask, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrSubnetMaskinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrMacAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrMacAdresseinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrDomain, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrDomaininhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrDefaultGateway, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrDefaultGatewayinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrDhcpServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrDhcpServerinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtrDnsServer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrDnsServerinhalt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnFehlerMelden)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
