package src.c4h;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class DynamicalGuiForC4H {

	public JFrame frmCh;
	JTabbedPane tabbedPane;
	JButton pcInfoButton;
	JButton FehlerButton;
	JButton chatButton;
	private JPanel panel;
	private JPanel fehlerMeldenPanel;
	private JPanel pcInfoPanel;
	private JPanel chatModulPanel;
	private JButton Beenden;
	private JLabel label;
	private JLabel label_1;
	private DefaultListModel<String> systemInfo;
	private DefaultListModel<String> netzwerkInfo;
	private JList<String> netzwekList;
	private JList <String>pcInfoList;
	
	private final BG_Info bg = new BG_Info();	
	private WebsiteReader web = new WebsiteReader();

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public DynamicalGuiForC4H() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("deprecation")
	public void initialize() throws IOException  {
		
		frmCh = new JFrame();
		frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(DynamicalGuiForC4H.class.getResource("images/bulb.png")));
		frmCh.getContentPane().setBackground(new Color(0, 0, 0));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel = new JPanel();
		pcInfoPanel = new JPanel();
		pcInfoPanel.setForeground(new Color(0, 0, 128));
		fehlerMeldenPanel = new JPanel();
		fehlerMeldenPanel.setForeground(new Color(0, 0, 128));
		chatModulPanel = new JPanel();
		chatModulPanel.setForeground(new Color(0, 0, 128));
		
		
		
		frmCh.setBackground(new Color(0, 0, 255));
		frmCh.setVisible(false);
		frmCh.setTitle("C4H");
		frmCh.setBounds(100, 100, 993, 698);
		
		frmCh.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		frmCh.getContentPane().setLayout(null);
		frmCh.getContentPane().add(tabbedPane);
		frmCh.getContentPane().add(panel);
		
		pcInfoPanel.setInheritsPopupMenu(true);
		pcInfoPanel.setIgnoreRepaint(true);
		pcInfoPanel.setAutoscrolls(true);
		
		fehlerMeldenPanel.setAutoscrolls(true);
		fehlerMeldenPanel.setInheritsPopupMenu(true);
		fehlerMeldenPanel.setIgnoreRepaint(true);
		
		chatModulPanel.setInheritsPopupMenu(true);
		chatModulPanel.setIgnoreRepaint(true);
		chatModulPanel.setAutoscrolls(true);
		
		tabbedPane.setInheritsPopupMenu(true);
		tabbedPane.setIgnoreRepaint(true);
		tabbedPane.setAutoscrolls(true);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.setBackground(new Color(230, 230, 250));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(221, 49, 746, 588);
		tabbedPane.addTab("PC INFORMATION", (Icon) null, pcInfoPanel, null);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setForegroundAt(0, new Color(255, 255, 255));
		tabbedPane.addTab("FEHLER MELDEN", (Icon) null, fehlerMeldenPanel, null);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setForegroundAt(1, new Color(255, 255, 255));
		tabbedPane.addTab("CHAT", (Icon) null, chatModulPanel, null);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setForegroundAt(2, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(0, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(2, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(1, new Color(0, 0, 128));
		
		pcInfoPanel.setBorder(null);
		pcInfoPanel.setBackground(new Color(169, 169, 169));
		pcInfoPanel.setLayout(null);
		
		JLabel titel = new JLabel("PC INFORMATION");
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		titel.setForeground(UIManager.getColor("ComboBox.buttonHighlight"));
		titel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		titel.setBounds(217, 11, 319, 79);
		pcInfoPanel.add(titel);
		
		label = new JLabel("SYSTEM INFORMATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(null);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		label.setBounds(79, 101, 206, 40);
		pcInfoPanel.add(label);
		
		label_1 = new JLabel("NETWORK INFORMATION");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(null);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		label_1.setBounds(422, 101, 216, 40);
		pcInfoPanel.add(label_1);
		
		systemInfo = new DefaultListModel<>();
		systemInfo.addElement("HostName        : "+ bg.getLocalHost());
		systemInfo.addElement("User Name       : "+ bg.getUserName());
		systemInfo.addElement("SchulNummer   : "+ bg.getSchulNummer());
		systemInfo.addElement("OS Version       : "+ bg.getOSversion());
		systemInfo.addElement("OS Architektur  : "+ bg.getOSArchitecture());
		systemInfo.addElement("Muster Images  : "+ bg.getMusterImages());
		systemInfo.addElement(null);
		
		pcInfoList = new JList<>(systemInfo);
		pcInfoList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pcInfoList.setForeground(new Color(255, 255, 255));
		  
		pcInfoList.setBackground(new Color(169, 169, 169));
		pcInfoList.setSelectionForeground(new Color(255, 255, 255));
		pcInfoList.setSelectionBackground(new Color(135, 206, 250));
		pcInfoList.setBounds(38, 152, 309, 222);
		pcInfoPanel.add(pcInfoList);
		
		netzwerkInfo = new DefaultListModel<>();
		netzwerkInfo.addElement("Adresse local     : "+ bg.getLocalAdresse());
		netzwerkInfo.addElement("Subnet Mask      : "+ bg.getSubnetMask());
		netzwerkInfo.addElement("MAC Adresse     : "+ bg.getMacAddress());
		netzwerkInfo.addElement("Machine Domain : "+ bg.getMachindomain());
		netzwerkInfo.addElement("Default Gateway : "+ bg.getDefaultgateway());
		netzwerkInfo.addElement("DHCP Server      : "+ bg.getDHCPServer());
		netzwerkInfo.addElement("DNS Server        : "+ bg.getDNSServer());
		
		netzwekList = new JList<>(netzwerkInfo);
		netzwekList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		netzwekList.setForeground(new Color(255, 255, 255));
		
		netzwekList.setBackground(new Color(169, 169, 169));
		netzwekList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		netzwekList.setSelectionForeground(new Color(255, 255, 255));
		netzwekList.setSelectionBackground(new Color(255, 255, 255));
		netzwekList.setBounds(380, 152, 309, 222);
		pcInfoPanel.add(netzwekList);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(DynamicalGuiForC4H.class.getResource("images/3s_logo-2.png")));
		lblNewLabel.setBounds(38, 386, 651, 146);
		pcInfoPanel.add(lblNewLabel);
		
		
		fehlerMeldenPanel.setBorder(null);
		fehlerMeldenPanel.setBackground(new Color(192, 192, 192));
		fehlerMeldenPanel.setLayout(null);
		
		JLabel lblHierKommtEin = new JLabel("HIER KOMMT EIN BROWSER HIN");
		lblHierKommtEin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					web.openWebSiteExample();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblHierKommtEin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHierKommtEin.setForeground(Color.WHITE);
		lblHierKommtEin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblHierKommtEin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblHierKommtEin.setBounds(192, 179, 403, 141);
		fehlerMeldenPanel.add(lblHierKommtEin);
		chatModulPanel.setBackground(new Color(169, 169, 169));
		chatModulPanel.setLayout(null);
		
		JLabel lblHierKommtEin_1 = new JLabel("HIER KOMMT EIN CHATMODUL");
		lblHierKommtEin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHierKommtEin_1.setForeground(Color.WHITE);
		lblHierKommtEin_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblHierKommtEin_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblHierKommtEin_1.setBounds(192, 179, 403, 141);
		chatModulPanel.add(lblHierKommtEin_1);
		
		
		
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBackground(new Color(169, 169, 169));
		panel.setBounds(16, 94, 195, 369);
		panel.setLayout(null);
		pcInfoButton = new JButton("PC INFORMATION");
		pcInfoButton.setEnabled(false);
		pcInfoButton.setForeground(new Color(0, 0, 0));
		pcInfoButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pcInfoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		pcInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(pcInfoButton);
		pcInfoButton.setBackground(new Color(0, 0, 128));
		pcInfoButton.setBounds(6, 34, 183, 64);
		
		pcInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked pcinfobutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-3);
			}
		});
		FehlerButton = new JButton("FEHLER MELDEN");
		FehlerButton.setEnabled(false);
		FehlerButton.setForeground(new Color(0, 0, 0));
		FehlerButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(FehlerButton);
		FehlerButton.setBackground(new Color(0, 0, 128));
		FehlerButton.setBounds(6, 123, 183, 64);
		chatButton = new JButton("CHAT");
		chatButton.setEnabled(false);
		chatButton.setForeground(new Color(0, 0, 0));
		chatButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(chatButton);
		chatButton.setBackground(new Color(0, 0, 128));
		chatButton.setBounds(6, 198, 183, 64);
		
		chatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked Chatbutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
				
			}
		});
		
		Beenden = new JButton("BEENDEN");
		Beenden.setEnabled(false);
		Beenden.setForeground(new Color(0, 0, 0));
		Beenden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Beenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("schliessen");
				frmCh.setVisible(false);
			}
			
		});
		Beenden.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		Beenden.setBounds(6, 280, 183, 64);
		panel.add(Beenden);
		Beenden.setBackground(new Color(0, 0, 128));
		
		FehlerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked pcinfo Fehlerbutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-2);
				try {
					web.openWebSiteExample();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		menuBar.setFocusTraversalKeysEnabled(true);
		menuBar.setDoubleBuffered(true);
		menuBar.setAutoscrolls(true);
		menuBar.setBackground(new Color(153, 153, 153));
		menuBar.setBounds(0, 0, 977, 22);
		frmCh.getContentPane().add(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setFocusCycleRoot(true);
		mnDatei.setFocusPainted(true);
		mnDatei.setFont(new Font("Arial", Font.PLAIN, 12));
		mnDatei.setBackground(new Color(255, 255, 255));
		mnDatei.setForeground(new Color(255, 255, 255));
		mnDatei.setBorder(null);
		menuBar.add(mnDatei);
		
		JMenuItem mntmPcInformation = new JMenuItem("Pc Information");
		mntmPcInformation.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmPcInformation.setForeground(new Color(0, 0, 128));
		mntmPcInformation.setFont(new Font("Arial", Font.PLAIN, 15));
		mntmPcInformation.setBorder(null);
		mntmPcInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mntmPcInformation.setBackground(new Color(255, 255, 255));
		mnDatei.add(mntmPcInformation);
		
		JMenuItem mntmFehlerMelden = new JMenuItem("Fehler melden ");
		mntmFehlerMelden.setBackground(new Color(255, 255, 255));
		mntmFehlerMelden.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmFehlerMelden.setForeground(new Color(0, 0, 128));
		mntmFehlerMelden.setFont(new Font("Arial", Font.PLAIN, 15));
		mntmFehlerMelden.setBorder(null);
		mntmFehlerMelden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		mnDatei.add(mntmFehlerMelden);
		
		JMenuItem mntmChat = new JMenuItem("Chat");
		mntmChat.setBorder(null);
		mntmChat.setBackground(new Color(255, 255, 255));
		mntmChat.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmChat.setForeground(new Color(0, 0, 128));
		mntmChat.setFont(new Font("Arial", Font.PLAIN, 15));
		mntmChat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnDatei.add(mntmChat);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setBorder(null);
		mntmBeenden.setBackground(new Color(255, 255, 255));
		mntmBeenden.setHorizontalTextPosition(SwingConstants.CENTER);
		mntmBeenden.setForeground(new Color(0, 0, 128));
		mntmBeenden.setFont(new Font("Arial", Font.PLAIN, 15));
		mntmBeenden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mnDatei.add(mntmBeenden);
		
		JMenu mnInfo = new JMenu("Info");
		mnInfo.setFont(new Font("Arial", Font.PLAIN, 13));
		mnInfo.setBackground(new Color(153, 153, 153));
		mnInfo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnInfo);
		
		JMenuItem mntmberUns = new JMenuItem("\u00FCber uns");
		mntmberUns.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));
		mntmberUns.setForeground(new Color(0, 0, 128));
		mntmberUns.setBackground(new Color(255, 255, 255));
		mntmberUns.setFont(new Font("Arial", Font.PLAIN, 15));
		mnInfo.add(mntmberUns);
		
		JMenuItem mntmOnlineHilfe = new JMenuItem("Online Hilfe");
		mntmOnlineHilfe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		mntmOnlineHilfe.setForeground(new Color(0, 0, 128));
		mntmOnlineHilfe.setBackground(new Color(255, 255, 255));
		mntmOnlineHilfe.setFont(new Font("Arial", Font.PLAIN, 15));
		mnInfo.add(mntmOnlineHilfe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(169, 169, 169));
		panel_1.setBounds(16, 489, 195, 96);
		frmCh.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		lblLogo.setForeground(new Color(255, 255, 255));
		lblLogo.setBounds(42, 22, 98, 48);
		panel_1.add(lblLogo);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(new Color(105, 105, 105));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label_2.setBounds(29, 608, 175, 29);
		frmCh.getContentPane().add(label_2);
		label_2.setText(bg.timetoBuild());
		
		
	}
}
