package src.c4h;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
/**
 * Ein Dynmaischen Gui der Verschiedene m&ouml;glichkeiten besitz f&uuml;r den User 
 * Einfach design inklusive Nutzung
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_DYNAMIC_GUI {
	/**
	 * URL fuer und FehlermeldenscriptScript
	 */
	public String URL = "http://fehlermeldung.3s-hamburg.de";
	
	private C4H_BROWSER_INTEGRATION browser ;
	private C4H_WEBSITE_START web = new C4H_WEBSITE_START();
	
	/**
	 * FrameC4H
	 */
	public JFrame frmCh;
	/**
	 * PcInfo_Panel
	 */
	public JPanel PcInfoPanel;
	/**
	 * FehlermeldenPanel
	 */
	public JPanel FehlerMeldenPanel;
	/**
	 * chatPanel
	 */
	public JPanel chatPanel;
	/**
	 * panel fuer bedienungsbutton
	 */
	public JPanel Buttonpanel;
	/**
	 * PcInformationbutton
	 */
	JButton pcInfoButton = new JButton("PC INFORMATION");
	/**
	 * Supportbutton
	 */
	JButton fehlermeldenButton = new JButton("SUPPORT");
	/**
	 * Chatbutton
	 */
	JButton chatButton = new JButton("CHAT");

	/**
	 * Allgemeine Model fue eine Liste PcInfo
	 */
	private DefaultListModel<String> systemInfo;
	/**
	 * Allgemeine Model fue eine Liste Netzwerk
	 */
	private DefaultListModel<String> netzwerkInfo;
	
	/**
	 * ALggemeine Liste
	 */
	JList<String> list=null;
	/**
	 * NetzwerkListe
	 */
	@SuppressWarnings("rawtypes")
	private JList pcInfoList;
	/**
	 * Liste Oc Info
	 */
	@SuppressWarnings("rawtypes")
	private JList netzwekList;
	/**
	 * Objekt zur erstellung und anzeigen von Pc_information 
	 */
	private final C4H_PC_INFO_KLASSE bg = new C4H_PC_INFO_KLASSE();	

	/**
	 * Konstruktor zur Laufzeit Start vom GUI UND SFTP Verbindung falls es nötig ist 
	 * @throws Throwable Hostname
	 */
	public C4H_DYNAMIC_GUI() throws Throwable {
		initialize();
		connectToSftp();	
	}

	/**
	 * SFTP Verbindung zur Speicherung der Information zur zwecke der Fehlermeldung
	 * @throws Throwable Connection Verbindung
	 */
	private void connectToSftp() throws Throwable {
		// TODO Auto-generated method stub
		C4H_SFTP_TO_USE sftpClient=null;
		try {
			sftpClient= new C4H_SFTP_TO_USE("","","","");
			sftpClient.uploadFileWithSchoolNumber();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"is wrong UserID");
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable ation
	 * @throws InterruptedException time  
	 */
	public void initialize() throws Throwable{
		
		frmCh = new JFrame();
		frmCh.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCh.setType(Type.POPUP);
		frmCh.setResizable(false);
		frmCh.setBounds(100, 100, 997, 750);
		
		//PANELS
		Buttonpanel = new JPanel();
		Buttonpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Buttonpanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		PcInfoPanel = new JPanel();
		PcInfoPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		PcInfoPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		FehlerMeldenPanel = new JPanel();
		FehlerMeldenPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		FehlerMeldenPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		chatPanel = new JPanel();
		chatPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		chatPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//BUTTONS
	
		//LABELS
		JLabel logoLabel = new JLabel("");
		logoLabel.setBackground(Color.WHITE);
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setIcon(new ImageIcon(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/Oemlogo.png")));
		logoLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JLabel titelLabel = new JLabel("");
		JLabel systemInfoLabel = new JLabel("System Information");
		JLabel lblNetzwerkInformation = new JLabel("Netzwerk Information");
		
		//button
		pcInfoButton.setBounds(10, 83, 175, 75);
		fehlermeldenButton.setBounds(10, 215, 175, 75);
		
		//Panel
		Buttonpanel.setBackground(Color.WHITE);
		Buttonpanel.setBounds(0, 40, 200, 670);
		Buttonpanel.setLayout(null);
		Buttonpanel.add(pcInfoButton);
		Buttonpanel.add(fehlermeldenButton);
		
		
		PcInfoPanel.setBounds(200, 40, 787, 670);
		PcInfoPanel.setBackground(Color.WHITE);
		PcInfoPanel.setLayout(null);
		PcInfoPanel.add(titelLabel);
		
		FehlerMeldenPanel.setBounds(200, 40, 787, 670);
		FehlerMeldenPanel.setBackground(new Color(240,240,240));
		FehlerMeldenPanel.setLayout(new BorderLayout());
		
		chatPanel.setBounds(200, 40, 787, 670);
		chatPanel.setBackground(Color.BLACK);
		chatPanel.setLayout(null);
		chatPanel.setVisible(true);
		
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenu menuDatei = new JMenu("Allgemein");
		JMenu menuBearbeiten = new JMenu("Bearbeiten");
		
		
		//MENU ITEM
		JMenuItem pcInfoItem = new JMenuItem("PC Information");
		pcInfoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(true);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(false);
				pcInfoButton.setEnabled(true);
			}
		});
		
		
		JMenuItem fehlerMeldenItem = new JMenuItem("Support");
		fehlerMeldenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(true);
				chatPanel.setVisible(false);
				fehlermeldenButton.setEnabled(true);
				startBrowser();
			}
		});
		
		
		JMenuItem kopierenItem = new JMenuItem("Kopieren");
		JMenuItem einfuegenItem = new JMenuItem("Einf\u00FCgen");
		
		JMenuItem exitItem = new JMenuItem("Beenden");
		
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCh.setVisible(false);
			}
		});
		
		
		menuBar.setBounds(0, 0, 991, 40);
		menuBar.add(menuDatei);
		menuBar.add(menuBearbeiten);
		
		menuDatei.add(pcInfoItem);
		menuDatei.add(fehlerMeldenItem);
		
		JMenuItem chatItem = new JMenuItem("Chat");
		chatItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(true);
				chatButton.setEnabled(true);
				
			}
		});
		
		menuDatei.add(chatItem);
		
		JMenuItem FernwartungMenuItem = new JMenuItem("Fernwartung");
		FernwartungMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("fernwartung Starten");
				try {
					web.openWebSite("www.ntrglobal.com/code");
				} catch (Throwable e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		
		menuDatei.add(FernwartungMenuItem);
		menuDatei.add(exitItem);
		
		
		menuBearbeiten.add(kopierenItem);
		menuBearbeiten.add(einfuegenItem);
		
		
		
		chatButton.setBounds(10, 346, 175, 75);
		Buttonpanel.add(chatButton);
		
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(true);
				
				
			}
		});
		
		//LABEL Settings
		logoLabel.setBounds(10, 461, 175, 184);
		Buttonpanel.add(logoLabel);
		
		
		titelLabel.setBounds(183, 11, 377, 60);
		titelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titelLabel.setFont(new Font("Algerian", Font.PLAIN, 29));
		titelLabel.setText("PC Information");
		
		systemInfoLabel.setFont(new Font("Algerian", Font.PLAIN, 18));
		systemInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemInfoLabel.setBounds(105, 107, 217, 32);
		PcInfoPanel.add(systemInfoLabel);
		
		lblNetzwerkInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetzwerkInformation.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblNetzwerkInformation.setBounds(480, 107, 238, 32);
		PcInfoPanel.add(lblNetzwerkInformation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 767, 2);
		
		PcInfoPanel.add(separator);
		frmCh.setForeground(Color.BLACK);
		frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DYNAMIC_GUI.class.getResource("images/bulb.png")));
		frmCh.setBackground(Color.WHITE);
		frmCh.setTitle("C4H");
		
		frmCh.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmCh.getContentPane().setBackground(new Color(240,240,240));
		frmCh.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		frmCh.getContentPane().setLayout(null);
		frmCh.getContentPane().add(menuBar);
		
		JMenu mnInfo = new JMenu("INFO");
		mnInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		mnInfo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnInfo);
		
		JMenuItem uberUnsItem = new JMenuItem("\u00FCber uns");
		uberUnsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				C4H_DIALOG test = new C4H_DIALOG();
				test.setVisible(true);
			}
		});
		uberUnsItem.setVerticalTextPosition(SwingConstants.TOP);
		uberUnsItem.setHorizontalTextPosition(SwingConstants.LEFT);
		uberUnsItem.setHorizontalAlignment(SwingConstants.LEFT);
		
		mnInfo.add(uberUnsItem);
		frmCh.getContentPane().add(Buttonpanel);
		frmCh.getContentPane().add(PcInfoPanel);
		frmCh.getContentPane().add(FehlerMeldenPanel);
		
		JLabel logo3sLabel = new JLabel("");
		logo3sLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logo3sLabel.setIcon(new ImageIcon(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/3s_logo.png")));
		logo3sLabel.setBounds(151, 519, 466, 126);
		PcInfoPanel.add(logo3sLabel);

		
		frmCh.getContentPane().add(chatPanel);
		
		
		//HANDLING FOR MENU ITEMS 
		
		//HANDLING FOR BUTTONS
		
		pcInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(true);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(false);
				
			}
		});
		browser = new C4H_BROWSER_INTEGRATION(FehlerMeldenPanel);
		fehlermeldenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(true);
				chatPanel.setVisible(false);
				
				startBrowser();
			}
		});
		JButton btnHierKommtEin2 = new JButton("Hier Kommt ein CHAT Fenster");
		btnHierKommtEin2.setSize(225,75);
		int xPosbreite= (chatPanel.getWidth()-btnHierKommtEin2.getWidth())/2;
		int yPoshoehe= (chatPanel.getHeight()-btnHierKommtEin2.getHeight())/2;
		btnHierKommtEin2.setBounds(xPosbreite, yPoshoehe, 225, 75);
		chatPanel.add(btnHierKommtEin2);
		
		JLabel logolabelchat = new JLabel("");
		logolabelchat.setHorizontalAlignment(SwingConstants.CENTER);
		logolabelchat.setIcon(new ImageIcon(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/3s_logo-2.png")));
		logolabelchat.setBounds(151, 519, 466, 126);
		chatPanel.add(logolabelchat);
		
		
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frmCh.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frmCh.getHeight()) / 2);
	    frmCh.setLocation(x, y);
		
		systemInfo = new DefaultListModel<>();
		
		systemInfo.addElement("                                          ");
		systemInfo.addElement("HostName        : "+ bg.getLocalHost());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("User Name       : "+ bg.getUserName());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("SchulNummer  : "+ bg.getSchulNummer());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Version       : "+ bg.getOSversion());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Architektur  : "+ bg.getOSArchitecture());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("Muster Images   : "+ bg.getMusterImages());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("Rechner Typ     : "+ bg.getRechnertypen());
		
		pcInfoList= new JList<String>(systemInfo);
		pcInfoList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		pcInfoList.setBackground(Color.WHITE);
		pcInfoList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pcInfoList.setForeground(Color.BLACK);
		pcInfoList.setSelectionForeground(new Color(0, 0, 255));
		pcInfoList.setSelectionBackground(Color.LIGHT_GRAY);
		pcInfoList.setBounds(55, 150, 309, 278);
		PcInfoPanel.add(pcInfoList);
		
		netzwerkInfo = new DefaultListModel<>();
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Locale IP Adresse       : "+ bg.getLocalAdresse());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("SUBNETZMASKE     : "+ bg.getSubnetMask());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("MAC Adresse             : "+ bg.getMacAddress());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Machine Domain      : "+ bg.getMachindomain());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Default Gateway       : "+ bg.getDefaultgateway());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("DHCP Server           : "+ bg.getDHCPServer());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("DNS Server             : "+ bg.getDNSServer());
		
		netzwekList = new JList<String>(netzwerkInfo);
		netzwekList.setValueIsAdjusting(true);
		netzwekList.setSelectionForeground(new Color(0, 0, 255));
		netzwekList.setSelectionBackground(Color.LIGHT_GRAY);
		netzwekList.setForeground(Color.BLACK);
		netzwekList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		netzwekList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		netzwekList.setBackground(Color.WHITE);
		netzwekList.setBounds(446, 150, 309, 278);
		PcInfoPanel.add(netzwekList);
		
	}

	/**
	 * Starten und öffnen des Scripts mit dne richtigen Parameter
	 * 
	 */
	public void startBrowser(){
		try {
			browser.createScene(URL+"?schulnummer="+bg.getSchulNummer()+"&pcname="+bg.getLocalHost());
		
		} catch (Throwable e) {
			System.out.println("Exception: "+e);
		}
	}
}
