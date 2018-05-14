package src.c4h;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
import javax.swing.border.EtchedBorder;

public class DynamicalGuiForC4H {

	public JFrame frmCh;
	public JPanel PcInfoPanel;
	public JPanel FehlerMeldenPanel;
	public JPanel chatPanel;
	 public JPanel Buttonpanel;
	
	private DefaultListModel<String> systemInfo;
	private DefaultListModel<String> netzwerkInfo;
	
	
	JList<String> list=null;
	@SuppressWarnings("rawtypes")
	private JList pcInfoList;
	@SuppressWarnings("rawtypes")
	private JList netzwekList;
	private SftpConnection sftpClient;
	
	private final BG_Info bg = new BG_Info();	
	//private WebsiteReader web = new WebsiteReader();

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public DynamicalGuiForC4H() throws IOException {
		initialize();
		try {
			this.sftpClient= new SftpConnection("wswham_2", "GXD2iRx$", "3s-hamburg.de", "22");
			sftpClient.uploadFileWithSchoolNumber();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize() throws IOException{
		
		
		frmCh = new JFrame();
		
		//PANELS
		
	
		Buttonpanel = new JPanel();
		PcInfoPanel = new JPanel();
		FehlerMeldenPanel = new JPanel();
		chatPanel = new JPanel();
		
		//BUTTONS
	
		JButton pcInfoButton = new JButton("PC INFORMATION");
		JButton fehlermeldenButton = new JButton("FEHLER MELDEN");
		JButton btnChat = new JButton("CHAT");
		
		//LABELS
		JLabel logoLabel = new JLabel("");
		JLabel titelLabel = new JLabel("");
		JLabel systemInfoLabel = new JLabel("System Information");
		JLabel lblNetzwerkInformation = new JLabel("Netzwerk Information");
		
		
		
		
		
		//button
		pcInfoButton.setBounds(10, 82, 207, 81);
		fehlermeldenButton.setBounds(10, 215, 207, 81);
		btnChat.setBounds(10, 346, 207, 81);
		
		//Panel
		Buttonpanel.setBackground(new Color(240,240,240));
		Buttonpanel.setBounds(0, 39, 227, 630);
		Buttonpanel.setLayout(null);
		Buttonpanel.add(btnChat);
		Buttonpanel.add(pcInfoButton);
		Buttonpanel.add(fehlermeldenButton);
		
		
		PcInfoPanel.setBounds(227, 39, 760, 630);
		PcInfoPanel.setBackground(new Color(240,240,240,240));
		PcInfoPanel.setLayout(null);
		PcInfoPanel.setVisible(true);
		PcInfoPanel.add(titelLabel);
		
		FehlerMeldenPanel.setBounds(227, 39, 760, 630);
		FehlerMeldenPanel.setLayout(null);
		FehlerMeldenPanel.setVisible(true);
		
		chatPanel.setBounds(227, 39, 760, 630);
		chatPanel.setLayout(null);
		chatPanel.setVisible(true);
		
		//MENU
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuDatei = new JMenu("Datei");
		JMenu menuBearbeiten = new JMenu("Bearbeiten");
		JMenu mnInfo = new JMenu("INFO");
		
		
		//MENU ITEM
		JMenuItem pcInfoItem = new JMenuItem("PC Information");
		JMenuItem fehlerMeldenItem = new JMenuItem("Fehler Melden");
		JMenuItem uberUnsItem = new JMenuItem("\u00FCber uns");
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		JMenuItem exitItem = new JMenuItem("Beenden");
		
		
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 987, 40);
		menuBar.add(menuDatei);
		menuBar.add(menuBearbeiten);
		menuBar.add(mnInfo);
		mnInfo.add(uberUnsItem);
		
		menuDatei.add(pcInfoItem);
		menuDatei.add(fehlerMeldenItem);
		menuDatei.add(exitItem);
		
		
		menuBearbeiten.add(mntmNewMenuItem_3);
		menuBearbeiten.add(mntmNewMenuItem_4);
		
		//LABEL Settings
		logoLabel.setBounds(10, 455, 207, 164);
		Buttonpanel.add(logoLabel);
		
		
		titelLabel.setBounds(146, 0, 446, 60);
		titelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titelLabel.setFont(new Font("Algerian", Font.PLAIN, 29));
		titelLabel.setText("PC Information");
		
		systemInfoLabel.setFont(new Font("Algerian", Font.PLAIN, 18));
		systemInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemInfoLabel.setBounds(86, 107, 217, 32);
		PcInfoPanel.add(systemInfoLabel);
		
		lblNetzwerkInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetzwerkInformation.setFont(new Font("Algerian", Font.PLAIN, 18));
		lblNetzwerkInformation.setBounds(397, 107, 238, 32);
		PcInfoPanel.add(lblNetzwerkInformation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(86, 56, 641, 2);
		PcInfoPanel.add(separator);
		
		// FRAME SETTINGS
		frmCh.setResizable(false);
		frmCh.setForeground(Color.BLACK);
		frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(DynamicalGuiForC4H.class.getResource("images/bulb.png")));
		frmCh.setBackground(Color.WHITE);
		frmCh.setTitle("C4H");
		frmCh.setBounds(100, 100, 966, 698);
		frmCh.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmCh.getContentPane().setBackground(new Color(240,240,240));
		frmCh.getContentPane().setIgnoreRepaint(true);
		frmCh.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
		frmCh.getContentPane().setLayout(null);
		frmCh.getContentPane().add(menuBar);
		frmCh.getContentPane().add(Buttonpanel);
		frmCh.getContentPane().add(PcInfoPanel);
		
		JLabel logo3sLabel = new JLabel("");
		logo3sLabel.setIcon(new ImageIcon(DynamicalGuiForC4H.class.getResource("/src/c4h/images/3s_logo.png")));
		logo3sLabel.setBounds(209, 467, 339, 126);
		PcInfoPanel.add(logo3sLabel);
		
		
		frmCh.getContentPane().add(FehlerMeldenPanel);
		frmCh.getContentPane().add(chatPanel);
		
		
		//HANDLING FOR MENU ITEMS 
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("beenden");
				frmCh.setVisible(false);
			}
		});
		
		//HANDLING FOR BUTTONS
		
		pcInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(true);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(false);
				
			}
		});
		
		
		
		fehlermeldenButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(true);
				chatPanel.setVisible(false);
			}
		});
		
		
		
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PcInfoPanel.setVisible(false);
				FehlerMeldenPanel.setVisible(false);
				chatPanel.setVisible(true);
			}
		});
		
		
		JButton btnHierKommtEin = new JButton("Hier Kommt ein Browser");
		btnHierKommtEin.setBounds(191, 257, 264, 55);
		FehlerMeldenPanel.add(btnHierKommtEin);
		
		JLabel logolabelfehlermelden = new JLabel("");
		logolabelfehlermelden.setIcon(new ImageIcon(DynamicalGuiForC4H.class.getResource("/src/c4h/images/3s_logo-2.png")));
		logolabelfehlermelden.setBounds(209, 467, 339, 126);
		FehlerMeldenPanel.add(logolabelfehlermelden);
		
		JButton btnHierKommtEin2 = new JButton("Hier Kommt ein CHAT Fenster");
		btnHierKommtEin2.setBounds(191, 257, 264, 55);
		chatPanel.add(btnHierKommtEin2);
		
		JLabel logolabelchat = new JLabel("");
		logolabelchat.setIcon(new ImageIcon(DynamicalGuiForC4H.class.getResource("/src/c4h/images/3s_logo-2.png")));
		logolabelchat.setBounds(209, 467, 339, 126);
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
		systemInfo.addElement("SchulNummer   : "+ bg.getSchulNummer());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Version       : "+ bg.getOSversion());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("OS Architektur  : "+ bg.getOSArchitecture());
		systemInfo.addElement("                                          ");
		systemInfo.addElement("Muster Images  : "+ bg.getMusterImages());
		
		pcInfoList= new JList(systemInfo);
		pcInfoList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		pcInfoList.setBackground(new Color(240,240,240,240));
		pcInfoList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pcInfoList.setForeground(Color.BLACK);
		pcInfoList.setSelectionForeground(new Color(0, 0, 255));
		pcInfoList.setSelectionBackground(Color.LIGHT_GRAY);
		pcInfoList.setBounds(55, 150, 309, 278);
		PcInfoPanel.add(pcInfoList);
		
		netzwerkInfo = new DefaultListModel<>();
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Locale IP Adresse     : "+ bg.getLocalAdresse());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("SUBNETZMASKE      : "+ bg.getSubnetMask());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("MAC Adresse     : "+ bg.getMacAddress());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Machine Domain : "+ bg.getMachindomain());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("Default Gateway : "+ bg.getDefaultgateway());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("DHCP Server      : "+ bg.getDHCPServer());
		netzwerkInfo.addElement("                                          ");
		netzwerkInfo.addElement("DNS Server        : "+ bg.getDNSServer());
		
		netzwekList = new JList(netzwerkInfo);
		netzwekList.setValueIsAdjusting(true);
		netzwekList.setSelectionForeground(new Color(0, 0, 255));
		netzwekList.setSelectionBackground(Color.LIGHT_GRAY);
		netzwekList.setForeground(Color.BLACK);
		netzwekList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		netzwekList.setBackground(new Color(240,240,240,240));
		netzwekList.setBounds(374, 150, 309, 278);
		PcInfoPanel.add(netzwekList);
		
	}
}
