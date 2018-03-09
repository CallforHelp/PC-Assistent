package bginfo;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;



public class BgInfoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 376621476984946157L;
	private JPanel contentPane;
	private final BG_Info bg = new BG_Info();
	private WebsiteReader web = new WebsiteReader();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	           //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	        } catch (UnsupportedLookAndFeelException ex) {
	            ex.printStackTrace();
	        } catch (IllegalAccessException ex) {
	            ex.printStackTrace();
	        } catch (InstantiationException ex) {
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }
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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 414, 600);
		setLocation(430,45);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(5, 65, 389, 15);
		textPane_2.setToolTipText("Uberschrift");
		textPane_2.setText("***************************************************************************");
		textPane_2.setForeground(Color.BLUE);
		textPane_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrs = new JTextArea();
		txtrs.setEditable(false);
		txtrs.setBounds(81, 26, 30, 16);
		txtrs.setText("3S");
		txtrs.setToolTipText("3S");
		
		JTextArea txtrBginfo = new JTextArea();
		txtrBginfo.setEditable(false);
		txtrBginfo.setBounds(17, 26, 44, 16);
		txtrBginfo.setToolTipText("3S");
		txtrBginfo.setText("BG_Info");
		
		JTextArea txtrSchulsupportservicesHitecEv = new JTextArea();
		txtrSchulsupportservicesHitecEv.setEditable(false);
		txtrSchulsupportservicesHitecEv.setBounds(17, 48, 276, 16);
		txtrSchulsupportservicesHitecEv.setToolTipText("3S");
		txtrSchulsupportservicesHitecEv.setText("Schul-Support-Services HiTEC e.V.");
		
		JTextArea txtrPcinfo = new JTextArea();
		txtrPcinfo.setEditable(false);
		txtrPcinfo.setBounds(17, 86, 60, 17);
		txtrPcinfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrPcinfo.setToolTipText("3S");
		txtrPcinfo.setText("PC_Info");
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(5, 109, 389, 15);
		textPane.setToolTipText("Uberschrift");
		textPane.setText("***************************************************************************");
		textPane.setForeground(Color.BLUE);
		textPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrHostName = new JTextArea();
		txtrHostName.setEditable(false);
		txtrHostName.setBounds(17, 130, 66, 16);
		txtrHostName.setToolTipText("3S");
		txtrHostName.setText("Host Name ");
		
		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setEditable(false);
		txtrUserName.setBounds(17, 173, 64, 16);
		txtrUserName.setToolTipText("3S");
		txtrUserName.setText("User Name");
		
		JTextArea txtrOsVersion = new JTextArea();
		txtrOsVersion.setEditable(false);
		txtrOsVersion.setBounds(17, 151, 94, 16);
		txtrOsVersion.setToolTipText("3S");
		txtrOsVersion.setText("Os Version ");
		
		JTextArea txtrOsArchitektur = new JTextArea();
		txtrOsArchitektur.setEditable(false);
		txtrOsArchitektur.setBounds(17, 195, 77, 16);
		txtrOsArchitektur.setToolTipText("3S");
		txtrOsArchitektur.setText("OS Architektur");
		
		JTextArea txtrMusterImages = new JTextArea();
		txtrMusterImages.setEditable(false);
		txtrMusterImages.setBounds(17, 217, 82, 16);
		txtrMusterImages.setToolTipText("3S");
		txtrMusterImages.setText("Muster Images");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(133, 130, 3, 16);
		textArea_1.setToolTipText("3S");
		textArea_1.setText(":");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(133, 173, 12, 16);
		textArea_2.setToolTipText("3S");
		textArea_2.setText(":");
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(133, 195, 12, 16);
		textArea_3.setToolTipText("3S");
		textArea_3.setText(":");
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(133, 217, 12, 16);
		textArea_4.setToolTipText("3S");
		textArea_4.setText(":");
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(133, 151, 12, 16);
		textArea_5.setToolTipText("3S");
		textArea_5.setText(":");
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(5, 239, 389, 15);
		textPane_1.setToolTipText("Uberschrift");
		textPane_1.setText("***************************************************************************");
		textPane_1.setForeground(Color.BLUE);
		textPane_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrNetzwerk = new JTextArea();
		txtrNetzwerk.setEditable(false);
		txtrNetzwerk.setBounds(17, 260, 60, 21);
		txtrNetzwerk.setToolTipText("3S");
		txtrNetzwerk.setText("Netzwerk");
		txtrNetzwerk.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(5, 293, 389, 15);
		textPane_3.setToolTipText("Uberschrift");
		textPane_3.setText("***************************************************************************");
		textPane_3.setForeground(Color.BLUE);
		textPane_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		
		JTextArea txtrIpAdresse = new JTextArea();
		txtrIpAdresse.setEditable(false);
		txtrIpAdresse.setBounds(17, 314, 94, 16);
		txtrIpAdresse.setToolTipText("3S");
		txtrIpAdresse.setText("IP Adresse");
		
		JTextArea txtrSubnetMask = new JTextArea();
		txtrSubnetMask.setEditable(false);
		txtrSubnetMask.setBounds(17, 336, 94, 16);
		txtrSubnetMask.setToolTipText("3S");
		txtrSubnetMask.setText("Subnet Mask");
		
		JTextArea txtrMacAdresse = new JTextArea();
		txtrMacAdresse.setEditable(false);
		txtrMacAdresse.setBounds(17, 358, 94, 16);
		txtrMacAdresse.setToolTipText("3S");
		txtrMacAdresse.setText("Mac Adresse");
		
		JTextArea txtrDomain = new JTextArea();
		txtrDomain.setEditable(false);
		txtrDomain.setBounds(17, 380, 94, 16);
		txtrDomain.setToolTipText("3S");
		txtrDomain.setText("Domain");
		
		JTextArea txtrDefaultGateway = new JTextArea();
		txtrDefaultGateway.setEditable(false);
		txtrDefaultGateway.setBounds(17, 402, 128, 16);
		txtrDefaultGateway.setToolTipText("3S");
		txtrDefaultGateway.setText("Default Gateway");
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(156, 314, 12, 16);
		textArea.setToolTipText("3S");
		textArea.setText(":");
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(156, 336, 12, 16);
		textArea_6.setToolTipText("3S");
		textArea_6.setText(":");
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(156, 358, 12, 16);
		textArea_7.setToolTipText("3S");
		textArea_7.setText(":");
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(156, 380, 12, 16);
		textArea_8.setToolTipText("3S");
		textArea_8.setText(":");
		
		JTextArea txtrDhcpServer = new JTextArea();
		txtrDhcpServer.setEditable(false);
		txtrDhcpServer.setBounds(17, 424, 73, 16);
		txtrDhcpServer.setToolTipText("3S");
		txtrDhcpServer.setText("DHCP Server");
		
		JTextArea txtrDnsServer = new JTextArea();
		txtrDnsServer.setEditable(false);
		txtrDnsServer.setBounds(17, 446, 64, 16);
		txtrDnsServer.setToolTipText("3S");
		txtrDnsServer.setText("DNS Server");
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setBounds(157, 402, 12, 16);
		textArea_9.setToolTipText("3S");
		textArea_9.setText(":");
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBounds(157, 424, 12, 16);
		textArea_10.setToolTipText("3S");
		textArea_10.setText(":");
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setBounds(157, 446, 12, 16);
		textArea_11.setToolTipText("3S");
		textArea_11.setText(":");
		
		JTextArea txtrHostNameinhalt = new JTextArea();
		txtrHostNameinhalt.setEditable(false);
		txtrHostNameinhalt.setBounds(148, 130, 150, 16);
		txtrHostNameinhalt.setToolTipText("3S");
		txtrHostNameinhalt.setText(bg.getLocalHost());
		
		JTextArea txtrOsVersioninhalt = new JTextArea();
		txtrOsVersioninhalt.setEditable(false);
		txtrOsVersioninhalt.setBounds(157, 151, 134, 16);
		txtrOsVersioninhalt.setToolTipText("3S");
		txtrOsVersioninhalt.setText(bg.getOSversion());
		
		JTextArea txtrUserNameInhalt = new JTextArea();
		txtrUserNameInhalt.setEditable(false);
		txtrUserNameInhalt.setBounds(157, 173, 134, 16);
		txtrUserNameInhalt.setToolTipText("3S");
		txtrUserNameInhalt.setText(bg.getUserName());
		
		JTextArea txtrOsArchitektur_1 = new JTextArea();
		txtrOsArchitektur_1.setEditable(false);
		txtrOsArchitektur_1.setBounds(157, 195, 134, 16);
		txtrOsArchitektur_1.setToolTipText("3S");
		txtrOsArchitektur_1.setText(bg.getOSArchitecture());
		
		JTextArea txtrMusterImages_1 = new JTextArea();
		txtrMusterImages_1.setEditable(false);
		txtrMusterImages_1.setBounds(157, 217, 134, 16);
		txtrMusterImages_1.setToolTipText("3S");
		txtrMusterImages_1.setText(bg.getMusterImages());
		
		JTextArea txtrIpAdresseinahlt = new JTextArea();
		txtrIpAdresseinahlt.setEditable(false);
		txtrIpAdresseinahlt.setBounds(174, 314, 135, 16);
		txtrIpAdresseinahlt.setToolTipText("3S");
		txtrIpAdresseinahlt.setText(bg.getLocalAdresse());
		
		JTextArea txtrSubnetMaskinhalt = new JTextArea();
		txtrSubnetMaskinhalt.setEditable(false);
		txtrSubnetMaskinhalt.setBounds(174, 336, 120, 16);
		txtrSubnetMaskinhalt.setToolTipText("3S");
		txtrSubnetMaskinhalt.setText(bg.getSubnetMask());
		
		JTextArea txtrMacAdresseinhalt = new JTextArea();
		txtrMacAdresseinhalt.setEditable(false);
		txtrMacAdresseinhalt.setBounds(175, 358, 149, 16);
		txtrMacAdresseinhalt.setToolTipText("3S");
		txtrMacAdresseinhalt.setText(bg.getMacAddress());
		
		JTextArea txtrDomaininhalt = new JTextArea();
		txtrDomaininhalt.setEditable(false);
		txtrDomaininhalt.setBounds(174, 380, 120, 16);
		txtrDomaininhalt.setToolTipText("3S");
		txtrDomaininhalt.setText(bg.getMachindomain());
		
		JTextArea txtrDefaultGatewayinhalt = new JTextArea();
		txtrDefaultGatewayinhalt.setEditable(false);
		txtrDefaultGatewayinhalt.setBounds(175, 402, 92, 16);
		txtrDefaultGatewayinhalt.setToolTipText("3S");
		txtrDefaultGatewayinhalt.setText(bg.getDefaultgateway());
		
		JTextArea txtrDhcpServerinhalt = new JTextArea();
		txtrDhcpServerinhalt.setEditable(false);
		txtrDhcpServerinhalt.setBounds(175, 424, 92, 16);
		txtrDhcpServerinhalt.setToolTipText("3S");
		txtrDhcpServerinhalt.setText(bg.getDHCPServer());
		
		JTextArea txtrDnsServerinhalt = new JTextArea();
		txtrDnsServerinhalt.setEditable(false);
		txtrDnsServerinhalt.setBounds(175, 446, 92, 16);
		txtrDnsServerinhalt.setToolTipText("3S");
		txtrDnsServerinhalt.setText(bg.getDNSServer());
		
		JTextArea txtrTimetobiuld = new JTextArea();
		txtrTimetobiuld.setBounds(281, 48, 113, 16);
		txtrTimetobiuld.setToolTipText("3S");
		txtrTimetobiuld.setText(bg.timetoBuild());
		contentPane.setLayout(null);
		contentPane.add(txtrNetzwerk);
		contentPane.add(txtrDefaultGateway);
		contentPane.add(txtrDnsServer);
		contentPane.add(txtrDhcpServer);
		contentPane.add(textArea_10);
		contentPane.add(txtrDhcpServerinhalt);
		contentPane.add(textArea_9);
		contentPane.add(txtrDefaultGatewayinhalt);
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
		contentPane.add(textPane_1);
		contentPane.add(txtrBginfo);
		contentPane.add(txtrs);
		contentPane.add(txtrTimetobiuld);
		contentPane.add(txtrSchulsupportservicesHitecEv);
		contentPane.add(txtrHostName);
		contentPane.add(txtrOsVersion);
		contentPane.add(txtrMusterImages);
		contentPane.add(txtrOsArchitektur);
		contentPane.add(txtrUserName);
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
		contentPane.add(txtrPcinfo);
		contentPane.add(textPane);
		contentPane.add(textPane_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\banih\\git\\Call-for-a-Help\\prototype\\src\\bginfo\\images\\3s_logo.png"));
		lblNewLabel.setBounds(27, 474, 325, 90);
		contentPane.add(lblNewLabel);
		
		JButton btnChat = new JButton("Chat");
		btnChat.setBounds(278, 399, 116, 24);
		contentPane.add(btnChat);
		btnChat.setForeground(Color.RED);
		btnChat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnChat.setBackground(Color.WHITE);
		
		JButton btnFehlerMelden = new JButton("Fehler Melden ");
		btnFehlerMelden.setBounds(278, 443, 116, 24);
		contentPane.add(btnFehlerMelden);
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(16, 0, 230, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Datei");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setBackground(Color.WHITE);
		mnNewMenu.add(mntmBeenden);
		
		JMenu mnNewMenuBearbeiten = new JMenu("Bearbeiten");
		mnNewMenuBearbeiten.setBackground(Color.WHITE);
		menuBar.add(mnNewMenuBearbeiten);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Kopie");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COPY, InputEvent.CTRL_MASK));
		mntmNewMenuItem_3.setBackground(Color.WHITE);
		mnNewMenuBearbeiten.add(mntmNewMenuItem_3);
		
		JMenuItem mntmEinfgen = new JMenuItem("Einfügen");
		mntmEinfgen.setBackground(Color.WHITE);
		mntmEinfgen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PASTE, InputEvent.CTRL_MASK));
		mnNewMenuBearbeiten.add(mntmEinfgen);
		
		JMenu mnInfo = new JMenu("Info");
		menuBar.add(mnInfo);
		
		JMenuItem mntmbers = new JMenuItem("über 3s");
		mntmbers.setSelectedIcon(new ImageIcon("C:\\Users\\banih\\git\\Call-for-a-Help\\prototype\\src\\bginfo\\images\\3s_logo.png"));
		mntmbers.setHorizontalAlignment(SwingConstants.CENTER);
		mntmbers.setBackground(Color.WHITE);
		mnInfo.add(mntmbers);
		
	}
}
