package src.c4h;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;



public class BgInfoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Global Variable
	 */
	//private static final long serialVersionUID = 376621476984946157L;
	private JPanel contentPane;
	private final BG_Info bg = new BG_Info();
	
	private WebsiteReader web = new WebsiteReader();

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public BgInfoFrame() throws IOException {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BgInfoFrame.class.getResource("images/bulb.png")));
		setBackground(Color.WHITE);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 635);
		setLocation(430,45);
		
		contentPane = new JPanel();
		
		contentPane.setVerifyInputWhenFocusTarget(false);
		contentPane.setPreferredSize(new Dimension(6, 10));
		contentPane.setOpaque(false);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(5, 76, 381, 15);
		textPane_2.setBackground(Color.WHITE);
//		textPane_2.setToolTipText("Uberschrift");
		textPane_2.setText("***************************************************************************");
		textPane_2.setForeground(Color.BLUE);
		textPane_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrs = new JTextArea();
		txtrs.setEditable(false);
		txtrs.setBounds(164, 11, 29, 24);
		txtrs.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		txtrs.setBackground(Color.WHITE);
		txtrs.setText("3S");
		txtrs.setToolTipText("3S");
		
		JTextArea txtrSchulsupportservicesHitecEv = new JTextArea();
		txtrSchulsupportservicesHitecEv.setBounds(47, 32, 287, 31);
		txtrSchulsupportservicesHitecEv.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		txtrSchulsupportservicesHitecEv.setBackground(Color.WHITE);
		txtrSchulsupportservicesHitecEv.setToolTipText("3S");
		txtrSchulsupportservicesHitecEv.setText("Schul-Support-Services HiTEC e.V.");
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(5, 109, 381, 15);
		textPane.setBackground(Color.WHITE);
//		textPane.setToolTipText("Uberschrift");
		textPane.setText("***************************************************************************");
		textPane.setForeground(Color.BLUE);
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrHostName = new JTextArea();
		txtrHostName.setBounds(17, 130, 94, 16);
		txtrHostName.setBackground(Color.WHITE);
//		txtrHostName.setToolTipText("3S");
		txtrHostName.setText("Host Name ");
		
		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setBounds(17, 173, 94, 16);
		txtrUserName.setBackground(Color.WHITE);
		txtrUserName.setText("User Name");
		
		JTextArea txtrOsVersion = new JTextArea();
		txtrOsVersion.setBounds(17, 151, 94, 16);
		txtrOsVersion.setBackground(Color.WHITE);
//		txtrOsVersion.setToolTipText("3S");
		txtrOsVersion.setText("Os Version ");
		
		JTextArea txtrOsArchitektur = new JTextArea();
		txtrOsArchitektur.setBounds(17, 195, 94, 16);
		txtrOsArchitektur.setBackground(Color.WHITE);
//		txtrOsArchitektur.setToolTipText("3S");
		txtrOsArchitektur.setText("OS Architektur");
		
		JTextArea txtrMusterImages = new JTextArea();
		txtrMusterImages.setBounds(17, 217, 108, 24);
		txtrMusterImages.setBackground(Color.WHITE);
//		txtrMusterImages.setToolTipText("3S");
		txtrMusterImages.setText("Muster Images");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(133, 130, 3, 16);
		textArea_1.setBackground(Color.WHITE);
//		textArea_1.setToolTipText("3S");
		textArea_1.setText(":");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(133, 173, 12, 16);
		textArea_2.setBackground(Color.WHITE);
//		textArea_2.setToolTipText("3S");
		textArea_2.setText(":");
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(133, 195, 12, 16);
		textArea_3.setBackground(Color.WHITE);
//		textArea_3.setToolTipText("3S");
		textArea_3.setText(":");
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(133, 217, 12, 16);
		textArea_4.setBackground(Color.WHITE);
//		textArea_4.setToolTipText("3S");
		textArea_4.setText(":");
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(133, 151, 12, 16);
		textArea_5.setBackground(Color.WHITE);
//		textArea_5.setToolTipText("3S");
		textArea_5.setText(":");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(5, 277, 381, 15);
		textPane_1.setBackground(Color.WHITE);
//		textPane_1.setToolTipText("Uberschrift");
		textPane_1.setText("***************************************************************************");
		textPane_1.setForeground(Color.BLUE);
		textPane_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrNetzwerk = new JTextArea();
		txtrNetzwerk.setEditable(false);
		txtrNetzwerk.setWrapStyleWord(true);
		//txtrNetzwerk.setDropMode(DropMode.ON);
		txtrNetzwerk.setForeground(Color.RED);
		txtrNetzwerk.setBounds(133, 289, 94, 21);
		txtrNetzwerk.setBackground(Color.WHITE);
//		txtrNetzwerk.setToolTipText("3S");
		txtrNetzwerk.setText("Netzwerk");
		txtrNetzwerk.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(5, 315, 381, 15);
		textPane_3.setBackground(Color.WHITE);
//		textPane_3.setToolTipText("Uberschrift");
		textPane_3.setText("***************************************************************************");
		textPane_3.setForeground(Color.BLUE);
		textPane_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrIpAdresse = new JTextArea();
		txtrIpAdresse.setBounds(17, 336, 94, 16);
		txtrIpAdresse.setBackground(Color.WHITE);
//		txtrIpAdresse.setToolTipText("3S");
		txtrIpAdresse.setText("IP Adresse");
		
		JTextArea txtrSubnetMask = new JTextArea();
		txtrSubnetMask.setBounds(17, 358, 94, 16);
		txtrSubnetMask.setBackground(Color.WHITE);
//		txtrSubnetMask.setToolTipText("3S");
		txtrSubnetMask.setText("Subnet Mask");
		
		JTextArea txtrMacAdresse = new JTextArea();
		txtrMacAdresse.setBounds(17, 380, 94, 16);
		txtrMacAdresse.setBackground(Color.WHITE);
//		txtrMacAdresse.setToolTipText("3S");
		txtrMacAdresse.setText("Mac Adresse");
		
		JTextArea txtrDomain = new JTextArea();
		txtrDomain.setBounds(17, 402, 94, 16);
		txtrDomain.setBackground(Color.WHITE);
//		txtrDomain.setToolTipText("3S");
		txtrDomain.setText("Domain");
		
		JTextArea txtrDefaultGateway = new JTextArea();
		txtrDefaultGateway.setBounds(17, 424, 128, 16);
		txtrDefaultGateway.setBackground(Color.WHITE);
//		txtrDefaultGateway.setToolTipText("3S");
		txtrDefaultGateway.setText("Default Gateway");
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(156, 336, 12, 16);
		textArea.setBackground(Color.WHITE);
//		textArea.setToolTipText("3S");
		textArea.setText(":");
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(156, 358, 12, 16);
		textArea_6.setBackground(Color.WHITE);
//		textArea_6.setToolTipText("3S");
		textArea_6.setText(":");
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(156, 380, 12, 16);
		textArea_7.setBackground(Color.WHITE);
//		textArea_7.setToolTipText("3S");
		textArea_7.setText(":");
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(156, 402, 12, 16);
		textArea_8.setBackground(Color.WHITE);
//		textArea_8.setToolTipText("3S");
		textArea_8.setText(":");
		
		JTextArea txtrDhcpServer = new JTextArea();
		txtrDhcpServer.setBounds(17, 446, 116, 16);
		txtrDhcpServer.setBackground(Color.WHITE);
//		txtrDhcpServer.setToolTipText("3S");
		txtrDhcpServer.setText("DHCP Server");
		
		JTextArea txtrDnsServer = new JTextArea();
		txtrDnsServer.setBounds(17, 468, 116, 16);
		txtrDnsServer.setBackground(Color.WHITE);
//		txtrDnsServer.setToolTipText("3S");
		txtrDnsServer.setText("DNS Server");
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setBounds(157, 424, 12, 16);
		textArea_9.setBackground(Color.WHITE);
//		textArea_9.setToolTipText("3S");
		textArea_9.setText(":");
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBounds(157, 446, 12, 16);
		textArea_10.setBackground(Color.WHITE);
//		textArea_10.setToolTipText("3S");
		textArea_10.setText(":");
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setBounds(157, 468, 12, 16);
		textArea_11.setBackground(Color.WHITE);
//		textArea_11.setToolTipText("3S");
		textArea_11.setText(":");
		
		JTextArea txtrHostNameinhalt = new JTextArea();
		txtrHostNameinhalt.setBounds(148, 130, 150, 16);
		txtrHostNameinhalt.setBackground(Color.WHITE);
//		txtrHostNameinhalt.setToolTipText("3S");
		txtrHostNameinhalt.setText(bg.getLocalHost());
		
		JTextArea txtrOsVersioninhalt = new JTextArea();
		txtrOsVersioninhalt.setBounds(151, 151, 134, 16);
		txtrOsVersioninhalt.setBackground(Color.WHITE);
//		txtrOsVersioninhalt.setToolTipText("3S");
		txtrOsVersioninhalt.setText(bg.getOSversion());
		
		JTextArea txtrUserNameInhalt = new JTextArea();
		txtrUserNameInhalt.setBounds(151, 173, 134, 16);
		txtrUserNameInhalt.setBackground(Color.WHITE);
//		txtrUserNameInhalt.setToolTipText("3S");
		txtrUserNameInhalt.setText(bg.getUserName());
		
		JTextArea txtrOsArchitektur_1 = new JTextArea();
		txtrOsArchitektur_1.setBounds(151, 195, 134, 16);
		txtrOsArchitektur_1.setBackground(Color.WHITE);
//		txtrOsArchitektur_1.setToolTipText("3S");
		txtrOsArchitektur_1.setText(bg.getOSArchitecture());
		
		JTextArea txtrMusterImages_1 = new JTextArea();
		txtrMusterImages_1.setBounds(151, 217, 186, 16);
		txtrMusterImages_1.setBackground(Color.WHITE);
//		txtrMusterImages_1.setToolTipText("3S");
		txtrMusterImages_1.setText(bg.getMusterImages());
		
		JTextArea txtrIpAdresseinahlt = new JTextArea();
		txtrIpAdresseinahlt.setBounds(174, 336, 135, 16);
		txtrIpAdresseinahlt.setBackground(Color.WHITE);
//		txtrIpAdresseinahlt.setToolTipText("3S");
		txtrIpAdresseinahlt.setText(bg.getLocalAdresse());
		
		JTextArea txtrSubnetMaskinhalt = new JTextArea();
		txtrSubnetMaskinhalt.setBounds(174, 358, 120, 16);
		txtrSubnetMaskinhalt.setBackground(Color.WHITE);
//		txtrSubnetMaskinhalt.setToolTipText("3S");
		txtrSubnetMaskinhalt.setText(bg.getSubnetMask());
		
		JTextArea txtrMacAdresseinhalt = new JTextArea();
		txtrMacAdresseinhalt.setBounds(174, 380, 149, 16);
		txtrMacAdresseinhalt.setBackground(Color.WHITE);
//		txtrMacAdresseinhalt.setToolTipText("3S");
		txtrMacAdresseinhalt.setText(bg.getMacAddress());
		
		JTextArea txtrDomaininhalt = new JTextArea();
		txtrDomaininhalt.setBounds(174, 402, 149, 16);
		txtrDomaininhalt.setBackground(Color.WHITE);
//		txtrDomaininhalt.setToolTipText("3S");
		txtrDomaininhalt.setText(bg.getMachindomain());
		
		JTextArea txtrDefaultGatewayinhalt = new JTextArea();
		txtrDefaultGatewayinhalt.setBounds(175, 424, 128, 16);
		txtrDefaultGatewayinhalt.setBackground(Color.WHITE);
//		txtrDefaultGatewayinhalt.setToolTipText("3S");
		txtrDefaultGatewayinhalt.setText(bg.getDefaultgateway());
		
		JTextArea txtrDhcpServerinhalt = new JTextArea();
		txtrDhcpServerinhalt.setBounds(175, 446, 92, 16);
		txtrDhcpServerinhalt.setBackground(Color.WHITE);
//		txtrDhcpServerinhalt.setToolTipText("3S");
		txtrDhcpServerinhalt.setText(bg.getDHCPServer());
		
		JTextArea txtrDnsServerinhalt = new JTextArea();
		txtrDnsServerinhalt.setBounds(175, 468, 138, 16);
		txtrDnsServerinhalt.setBackground(Color.WHITE);
//		txtrDnsServerinhalt.setToolTipText("3S");
		txtrDnsServerinhalt.setText(bg.getDNSServer());
		
		JButton btnFehlerMelden = new JButton("Fehler Melden ");
		btnFehlerMelden.setBounds(17, 495, 116, 24);
		btnFehlerMelden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("action by clik");
				try {
					web.openWebSiteExample();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFehlerMelden.setBackground(Color.WHITE);
		btnFehlerMelden.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFehlerMelden.setForeground(Color.RED);
		
		JTextArea txtrTimetobiuld = new JTextArea();
		txtrTimetobiuld.setBounds(214, 89, 147, 16);
		txtrTimetobiuld.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txtrTimetobiuld.setBackground(Color.WHITE);
//		txtrTimetobiuld.setToolTipText("3S");
		txtrTimetobiuld.setText(bg.timetoBuild());
		
		JButton btnExit = new JButton("Chat");
		btnExit.setBounds(157, 495, 116, 24);
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 520, 356, 65);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(BgInfoFrame.class.getResource("/src/c4h/images/3s_logo.png")));
		
		JTextArea txtrSchulnummer = new JTextArea();
		txtrSchulnummer.setBounds(17, 244, 82, 16);
//		txtrSchulnummer.setToolTipText("3S");
		txtrSchulnummer.setText("SchulNummer");
		txtrSchulnummer.setBackground(Color.WHITE);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setBounds(133, 239, 12, 16);
//		textArea_13.setToolTipText("3S");
		textArea_13.setText(":");
		textArea_13.setBackground(Color.WHITE);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setBounds(156, 244, 134, 22);
//		textArea_14.setToolTipText("3S");
		textArea_14.setBackground(Color.WHITE);
		textArea_14.setText(bg.getSchulNummer());
		contentPane.setLayout(null);
		contentPane.add(btnFehlerMelden);
		contentPane.add(txtrDefaultGateway);
		contentPane.add(txtrDnsServer);
		contentPane.add(txtrDhcpServer);
		contentPane.add(textArea_10);
		contentPane.add(txtrDhcpServerinhalt);
		contentPane.add(textArea_9);
		contentPane.add(txtrDefaultGatewayinhalt);
		contentPane.add(btnExit);
		contentPane.add(textArea_11);
		contentPane.add(txtrDnsServerinhalt);
		contentPane.add(txtrIpAdresse);
		contentPane.add(txtrSubnetMask);
		contentPane.add(txtrMacAdresse);
		contentPane.add(txtrDomain);
		contentPane.add(textArea_8);
		contentPane.add(txtrDomaininhalt);
		contentPane.add(textArea_7);
		contentPane.add(txtrMacAdresseinhalt);
		contentPane.add(textArea_6);
		contentPane.add(txtrSubnetMaskinhalt);
		contentPane.add(textArea);
		contentPane.add(txtrIpAdresseinahlt);
		contentPane.add(textPane_3);
		contentPane.add(txtrs);
		contentPane.add(txtrTimetobiuld);
		contentPane.add(txtrSchulsupportservicesHitecEv);
		contentPane.add(txtrHostName);
		contentPane.add(txtrOsVersion);
		contentPane.add(txtrMusterImages);
		contentPane.add(txtrOsArchitektur);
		contentPane.add(txtrUserName);
		contentPane.add(txtrSchulnummer);
		contentPane.add(textArea_5);
		contentPane.add(txtrOsVersioninhalt);
		contentPane.add(textArea_2);
		contentPane.add(txtrUserNameInhalt);
		contentPane.add(textArea_4);
		contentPane.add(txtrMusterImages_1);
		contentPane.add(textArea_3);
		contentPane.add(txtrOsArchitektur_1);
		contentPane.add(textArea_1);
		contentPane.add(txtrHostNameinhalt);
		contentPane.add(textArea_13);
		contentPane.add(textArea_14);
		contentPane.add(textPane);
		contentPane.add(textPane_2);
		contentPane.add(lblNewLabel);
		contentPane.add(txtrNetzwerk);
		contentPane.add(textPane_1);
		
		JTextArea txtrPcinfo = new JTextArea();
		txtrPcinfo.setEditable(false);
		txtrPcinfo.setWrapStyleWord(true);
//		txtrPcinfo.setToolTipText("3S");
		txtrPcinfo.setText("PC_Info");
		txtrPcinfo.setForeground(Color.RED);
		txtrPcinfo.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		//txtrPcinfo.setDropMode(DropMode.ON);
		txtrPcinfo.setBackground(Color.WHITE);
		txtrPcinfo.setBounds(17, 86, 94, 21);
		contentPane.add(txtrPcinfo);
		
	}
}

