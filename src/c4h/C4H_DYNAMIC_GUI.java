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
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;


import javax.swing.UIManager;

/**
 * Ein Dynmaisches Gui der verschiedene m&ouml;glichkeiten besitz f&uuml;r den User. 
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
	 * Objekt zur erstellung und anzeigen von Pc_information. 
	 */
	private C4H_PC_INFO_KLASSE bg = new C4H_PC_INFO_KLASSE();	

	/**
	 * Konstruktor zur Laufzeit Start vom GUI UND SFTP Verbindung falls es nötig ist. 
	 * @throws Throwable Hostname
	 */
	public C4H_DYNAMIC_GUI() throws Throwable {
		systemInfo = new DefaultListModel<>();
		netzwerkInfo = new DefaultListModel<>();
		initialize();
		connectToSftp();	
		
	}

	/**
	 * SFTP Verbindung zur Speicherung der Information zur zwecke der Fehlermeldung.
	 * @throws Throwable Connection Verbindung.
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
	 * @throws Throwable ation.
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
		logoLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		JLabel titelLabel = new JLabel("");
		titelLabel.setBackground(UIManager.getColor("Button.light"));
		titelLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		JLabel systemInfoLabel = new JLabel("System Information");
		systemInfoLabel.setBackground(UIManager.getColor("Button.light"));
		systemInfoLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		JLabel lblNetzwerkInformation = new JLabel("Netzwerk Information");
		lblNetzwerkInformation.setBackground(UIManager.getColor("Button.light"));
		lblNetzwerkInformation.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pcInfoButton.setBackground(UIManager.getColor("Button.light"));
		pcInfoButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pcInfoButton.setFont(new Font("Arial", Font.BOLD, 11));
		
		//button
		pcInfoButton.setBounds(10, 83, 175, 75);
		fehlermeldenButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		fehlermeldenButton.setFont(new Font("Arial", Font.BOLD, 11));
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
		chatPanel.setBackground(Color.WHITE);
		chatPanel.setLayout(null);
		chatPanel.setVisible(true);
		
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenu menuDatei = new JMenu("Allgemein");
		menuDatei.setSize(new Dimension(10, 0));
		menuDatei.setBorder(null);
		menuDatei.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		//MENU ITEM
		JMenuItem pcInfoItem = new JMenuItem("PC Information");
		pcInfoItem.setSize(new Dimension(10, 5));
		pcInfoItem.setFont(new Font("Arial", Font.BOLD, 12));
		pcInfoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(true);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(false);
				pcInfoButton.setEnabled(true);
			}
		});
		
		
		JMenuItem fehlerMeldenItem = new JMenuItem("Support");
		fehlerMeldenItem.setSize(new Dimension(10, 5));
		fehlerMeldenItem.setFont(new Font("Arial", Font.BOLD, 12));
		fehlerMeldenItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(true);
				chatPanel.setVisible(false);
				fehlermeldenButton.setEnabled(true);
				startBrowser();
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Beenden");
		exitItem.setFont(new Font("Arial", Font.BOLD, 12));
		
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCh.setVisible(false);
			}
		});
		
		
		menuBar.setBounds(0, 0, 991, 40);
		menuBar.add(menuDatei);
		
		menuDatei.add(pcInfoItem);
		menuDatei.add(fehlerMeldenItem);
		
		JMenuItem chatItem = new JMenuItem("Chat");
		chatItem.setSize(new Dimension(0, 5));
		chatItem.setFont(new Font("Arial", Font.BOLD, 12));
		chatItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(true);
				chatButton.setEnabled(true);
				
			}
		});
		
		menuDatei.add(chatItem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 5));
		menuDatei.add(separator_1);
		menuDatei.add(exitItem);
		
		JMenuItem AktualisierItem = new JMenuItem("Aktualisieren");
		AktualisierItem.setFont(new Font("Arial", Font.BOLD, 12));
		
		menuDatei.add(AktualisierItem);
		chatButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		chatButton.setFont(new Font("Arial", Font.BOLD, 11));
		
		
		
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
		
		
		titelLabel.setBounds(183, 11, 377, 50);
		titelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titelLabel.setFont(new Font("Arial", Font.BOLD, 29));
		titelLabel.setText("PC Information");
		
		systemInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		systemInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemInfoLabel.setBounds(90, 89, 238, 50);
		PcInfoPanel.add(systemInfoLabel);
		
		lblNetzwerkInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetzwerkInformation.setFont(new Font("Arial", Font.BOLD, 18));
		lblNetzwerkInformation.setBounds(480, 89, 238, 50);
		PcInfoPanel.add(lblNetzwerkInformation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 69, 767, 2);
		
		PcInfoPanel.add(separator);
		frmCh.setForeground(Color.BLACK);
		frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/Oemlogo.png")));
		frmCh.setBackground(Color.WHITE);
		frmCh.setTitle("C4H");
		
		frmCh.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmCh.getContentPane().setBackground(new Color(240,240,240));
		frmCh.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		frmCh.getContentPane().setLayout(null);
		frmCh.getContentPane().add(menuBar);
		
		JMenu mnInfo = new JMenu("Extras");
		mnInfo.setSize(new Dimension(20, 10));
		mnInfo.setBorder(null);
		mnInfo.setFont(new Font("Arial", Font.BOLD, 12));
		mnInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		mnInfo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnInfo);
		
		JMenuItem browserStartItem = new JMenuItem("Browser Starten");
		browserStartItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("BrowserStarten");
				try {
					if(!bg.pruefeSchulnr())
						//displayMessage("Die SchulNummer ist Fehlerhaft!!!"+bg.getSchulNummer(),"Schul Support Service\nTEAM C4H", MessageType.WARNING);
						web.openWebSite(URL);
					else
						web.openWebSite();
					
				} catch (Throwable e1) {
					System.out.println(e1);
				}
				
			}
		});
		browserStartItem.setSize(new Dimension(10, 5));
		browserStartItem.setFont(new Font("Arial", Font.BOLD, 12));
		mnInfo.add(browserStartItem);
		
		JMenuItem FernwartungMenuItem = new JMenuItem("Fernwartung");
		FernwartungMenuItem.setSize(new Dimension(10, 5));
		mnInfo.add(FernwartungMenuItem);
		FernwartungMenuItem.setFont(new Font("Arial", Font.BOLD, 12));
		
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
		JMenuItem downloadMenuItem = new JMenuItem("downloads");
		downloadMenuItem.setSize(new Dimension(10, 5));
		mnInfo.add(downloadMenuItem);
		downloadMenuItem.setFont(new Font("Arial", Font.BOLD, 12));
		
		downloadMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("download Starten");
				try {
					web.openWebSite(URL+"/downloads");
				} catch (Throwable e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		JMenu menu = new JMenu("Info");
		menu.setSize(new Dimension(20, 10));
		menuBar.add(menu);
		menu.setHorizontalTextPosition(SwingConstants.LEFT);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setFont(new Font("Arial", Font.BOLD, 12));
		menu.setBorder(null);
		
		JMenuItem c4hHilfeItem = new JMenuItem("C4H-Hilfe");
		c4hHilfeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("C4H Hilfe Browse");
				try {
					web.openWebSite(URL+"/hilfe");
				} catch (Throwable e1) {
					System.out.println(e1);
				}
				
			}
		});
		c4hHilfeItem.setVerticalTextPosition(SwingConstants.TOP);
		c4hHilfeItem.setHorizontalTextPosition(SwingConstants.LEFT);
		c4hHilfeItem.setHorizontalAlignment(SwingConstants.LEFT);
		c4hHilfeItem.setFont(new Font("Arial", Font.BOLD, 12));
		menu.add(c4hHilfeItem);
		
		JMenuItem faqItem = new JMenuItem("FAQ");
		faqItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("FAQ Browse");
				try {
					web.openWebSite(URL+"/faq");
				} catch (Throwable e1) {
					System.out.println(e1);
				}
				
			}
		});
		faqItem.setVerticalTextPosition(SwingConstants.TOP);
		faqItem.setHorizontalTextPosition(SwingConstants.LEFT);
		faqItem.setHorizontalAlignment(SwingConstants.LEFT);
		faqItem.setFont(new Font("Arial", Font.BOLD, 12));
		menu.add(faqItem);
		
		JMenuItem ueberC4HItem = new JMenuItem("\u00DCber-C4H");
		ueberC4HItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C4H_DIALOG dialog = new C4H_DIALOG();
				dialog.setVisible(true);
				Timer timer = new Timer(4000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
						dialog.dispose();
					}
				});
				timer.setRepeats(false);
				timer.start();
			}
		});
		ueberC4HItem.setVerticalTextPosition(SwingConstants.TOP);
		ueberC4HItem.setHorizontalTextPosition(SwingConstants.LEFT);
		ueberC4HItem.setHorizontalAlignment(SwingConstants.LEFT);
		ueberC4HItem.setFont(new Font("Arial", Font.BOLD, 12));
		menu.add(ueberC4HItem);
		
		frmCh.getContentPane().add(Buttonpanel);
		frmCh.getContentPane().add(PcInfoPanel);
		frmCh.getContentPane().add(FehlerMeldenPanel);
		
		JLabel logo3sLabel = new JLabel("");
		logo3sLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		logo3sLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logo3sLabel.setIcon(new ImageIcon(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/3s_logo.png")));
		logo3sLabel.setBounds(55, 461, 700, 184);
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
		C4H_Blink_Label blink = new C4H_Blink_Label("Hier Kommt ein CHAT Fenster");
		blink.setBlinking(true);
		blink.setBackground(new Color(240, 240, 240));
		blink.setHorizontalAlignment(SwingConstants.CENTER);
		blink.setHorizontalTextPosition(SwingConstants.CENTER);
		blink.setBounds(281, 297, 225, 75);
		
		chatPanel.add(blink);
		
		JLabel logolabelchat = new JLabel("");
		logolabelchat.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		logolabelchat.setHorizontalAlignment(SwingConstants.CENTER);
		logolabelchat.setIcon(new ImageIcon(C4H_DYNAMIC_GUI.class.getResource("/src/c4h/images/3s_logo-2.png")));
		logolabelchat.setBounds(55, 461, 700, 184);
		chatPanel.add(logolabelchat);
		
		
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frmCh.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frmCh.getHeight()) / 2);
	    frmCh.setLocation(x, y);
	    setlist();
		AktualisierItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setlist();
					 System.out.println(bg.getMusterImages());
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
	public void setlist() throws Throwable {
		
		systemInfo.removeAllElements();
		netzwerkInfo.removeAllElements();
		
		systemInfo.addElement("                                          ");
		systemInfo.addElement("HostName          : "+ bg.getLocalHost());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("User Name         : "+ bg.getUserName());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("SchulNummer   : "+ bg.getSchulNummer());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Version         : "+ bg.getOSversion());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Architektur   : "+ bg.getOSArchitecture());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("Muster Images   : "+ bg.getMusterImages());
		
		
		String value = WindowsReqistry.readRegistry("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\"
				+ "CurrentVersion\\OEMInformation", "Model");
		systemInfo.addElement("Muster Images   : "+ value);
		
		
		
		systemInfo.addElement("                                          ");
		systemInfo.addElement("Rechner Typ        : "+ bg.getRechnertypen());
		
		pcInfoList= new JList<String>(systemInfo);
		pcInfoList.setFont(new Font("Arial", Font.BOLD, 12));
		pcInfoList.setBackground(Color.WHITE);
		pcInfoList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pcInfoList.setForeground(Color.BLACK);
		pcInfoList.setSelectionForeground(new Color(0, 0, 255));
		pcInfoList.setSelectionBackground(Color.LIGHT_GRAY);
		pcInfoList.setBounds(55, 150, 309, 281);
		PcInfoPanel.add(pcInfoList);
		
		
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("Locale IP Adresse      : "+ bg.getLocalAdresse());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("Subnetzmaske            : "+ bg.getSubnetMask());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("MAC Adresse              : "+ bg.getMacAddress());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("Domain                         : "+ bg.getMachindomain());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("Default Gateway         : "+ bg.getDefaultgateway());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("DHCP Server               : "+ bg.getDHCPServer());
		netzwerkInfo.addElement("\n");
		netzwerkInfo.addElement("DNS Server                  : "+ bg.getDNSServer());
		
		netzwekList = new JList<String>(netzwerkInfo);
		netzwekList.setValueIsAdjusting(true);
		netzwekList.setSelectionForeground(new Color(0, 0, 255));
		netzwekList.setSelectionBackground(Color.LIGHT_GRAY);
		netzwekList.setForeground(Color.BLACK);
		netzwekList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		netzwekList.setFont(new Font("Arial", Font.BOLD, 12));
		netzwekList.setBackground(Color.WHITE);
		netzwekList.setBounds(446, 150, 309, 281);
		PcInfoPanel.add(netzwekList);
		
	}

	/**
	 * Starten und &ouml;ffnen des Scripts mit den richtigen Parameter.
	 * 
	 */
	public void startBrowser(){
		try {
			browser.createScene(URL+"?schulnummer="+bg.getSchulNummer()+"&pcname="+bg.getLocalHost()+"&ipadress="+bg.getLocalAdresse());
			
		} catch (Throwable e) {
			System.out.println("Exception: "+e);
		}
	}
}
