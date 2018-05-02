package src.c4h;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Window.Type;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class DynamicalGuiForC4H {

	private JFrame frmCh;
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicalGuiForC4H window = new DynamicalGuiForC4H();
					window.frmCh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DynamicalGuiForC4H() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCh = new JFrame();
		frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(DynamicalGuiForC4H.class.getResource("/src/c4h/images/bulb.png")));
		frmCh.getContentPane().setBackground(SystemColor.activeCaption);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel = new JPanel();
		pcInfoPanel = new JPanel();
		pcInfoPanel.setForeground(SystemColor.activeCaption);
		fehlerMeldenPanel = new JPanel();
		fehlerMeldenPanel.setForeground(SystemColor.activeCaption);
		chatModulPanel = new JPanel();
		chatModulPanel.setForeground(SystemColor.activeCaption);
		
		//BackGroundPane backGroundPane = new BackGroundPane("/testGui/images/pcinfo.png");
		
		//frmCh.setContentPane(backGroundPane);
		frmCh.setBackground(SystemColor.windowText);
		frmCh.setVisible(true);
		frmCh.setTitle("C4H");
		//frmCh.setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		frmCh.setBounds(100, 100, 993, 647);
		frmCh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		tabbedPane.setBackground(SystemColor.activeCaption);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(221, 49, 746, 552);
		tabbedPane.addTab("Pc Information", (Icon) null, pcInfoPanel, null);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setForegroundAt(0, SystemColor.text);
		tabbedPane.addTab("Fehlermelden", (Icon) null, fehlerMeldenPanel, null);
		tabbedPane.setForegroundAt(1, SystemColor.text);
		tabbedPane.addTab("Chat", (Icon) null, chatModulPanel, null);
		tabbedPane.setForegroundAt(2, SystemColor.text);
		tabbedPane.setBackgroundAt(0, SystemColor.activeCaption);
		tabbedPane.setBackgroundAt(2, SystemColor.activeCaption);
		tabbedPane.setBackgroundAt(1, SystemColor.activeCaption);
		
		pcInfoPanel.setBorder(null);
		pcInfoPanel.setBackground(SystemColor.activeCaption);
		pcInfoPanel.setLayout(null);
		
		JLabel titel = new JLabel("PC INFORMATION");
		titel.setHorizontalAlignment(SwingConstants.CENTER);
		titel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		titel.setForeground(UIManager.getColor("ComboBox.buttonHighlight"));
		titel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		titel.setBounds(217, 11, 319, 79);
		pcInfoPanel.add(titel);
		
		label = new JLabel("SYSTEM INFORMATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(null);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		label.setBounds(102, 101, 160, 40);
		pcInfoPanel.add(label);
		
		label_1 = new JLabel("NETWORK INFORMATION");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(null);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		label_1.setBounds(487, 101, 160, 40);
		pcInfoPanel.add(label_1);
		
		systemInfo = new DefaultListModel<>();
		systemInfo.addElement(null);
		systemInfo.addElement(null);
		systemInfo.addElement(null);
		systemInfo.addElement(null);
		systemInfo.addElement(null);
		systemInfo.addElement(null);
		
		pcInfoList = new JList<>(systemInfo);
		pcInfoList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		pcInfoList.setForeground(SystemColor.window);
		  
		pcInfoList.setBackground(SystemColor.activeCaption);
		pcInfoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pcInfoList.setSelectionForeground(SystemColor.text);
		pcInfoList.setSelectionBackground(SystemColor.text);
		pcInfoList.setBounds(36, 152, 309, 357);
		pcInfoPanel.add(pcInfoList);
		
		netzwerkInfo = new DefaultListModel<>();
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		netzwerkInfo.addElement(null);
		
		netzwekList = new JList<>(netzwerkInfo);
		netzwekList.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		netzwekList.setForeground(SystemColor.window);
		
		netzwekList.setBackground(SystemColor.activeCaption);
		netzwekList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		netzwekList.setSelectionForeground(SystemColor.text);
		netzwekList.setSelectionBackground(Color.WHITE);
		netzwekList.setBounds(418, 152, 309, 357);
		pcInfoPanel.add(netzwekList);
		
		
		fehlerMeldenPanel.setBorder(null);
		fehlerMeldenPanel.setBackground(SystemColor.activeCaption);
		fehlerMeldenPanel.setLayout(null);
		
		JLabel lblHierKommtEin = new JLabel("HIER KOMMT EIN BROWSER");
		lblHierKommtEin.setHorizontalAlignment(SwingConstants.CENTER);
		lblHierKommtEin.setForeground(Color.WHITE);
		lblHierKommtEin.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblHierKommtEin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblHierKommtEin.setBounds(192, 179, 403, 141);
		fehlerMeldenPanel.add(lblHierKommtEin);
		
		chatModulPanel.setBorder(null);
		chatModulPanel.setBackground(SystemColor.activeCaption);
		chatModulPanel.setLayout(null);
		
		JLabel lblHierKommtEin_1 = new JLabel("HIER KOMMT EIN CHATMODUL");
		lblHierKommtEin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHierKommtEin_1.setForeground(Color.WHITE);
		lblHierKommtEin_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 24));
		lblHierKommtEin_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblHierKommtEin_1.setBounds(192, 179, 403, 141);
		chatModulPanel.add(lblHierKommtEin_1);
		
		
		
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(16, 49, 195, 369);
		panel.setLayout(null);
		pcInfoButton = new JButton("PC INFORMATION");
		pcInfoButton.setForeground(SystemColor.text);
		pcInfoButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		pcInfoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		pcInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		pcInfoButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		panel.add(pcInfoButton);
		pcInfoButton.setBackground(SystemColor.activeCaption);
		pcInfoButton.setBounds(16, 34, 162, 64);
		
		pcInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked pcinfobutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-3);
			}
		});
		FehlerButton = new JButton("Fehler melden");
		FehlerButton.setForeground(SystemColor.text);
		FehlerButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		FehlerButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		panel.add(FehlerButton);
		FehlerButton.setBackground(SystemColor.activeCaption);
		FehlerButton.setBounds(16, 123, 162, 64);
		chatButton = new JButton("CHAT");
		chatButton.setForeground(SystemColor.text);
		chatButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		chatButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		panel.add(chatButton);
		chatButton.setBackground(SystemColor.activeCaption);
		chatButton.setBounds(16, 198, 162, 64);
		
		chatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked pcinfo Chatbutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
			}
		});
		
		Beenden = new JButton("Beenden");
		Beenden.setForeground(SystemColor.text);
		Beenden.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 17));
		Beenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("schlie�en");
				frmCh.setVisible(false);
			}
			
		});
		Beenden.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		Beenden.setBounds(16, 280, 162, 64);
		panel.add(Beenden);
		Beenden.setBorder(new EtchedBorder(EtchedBorder.RAISED, SystemColor.activeCaption, SystemColor.inactiveCaption));
		Beenden.setBackground(SystemColor.activeCaption);
		
		FehlerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("clicked pcinfo Fehlerbutton");
				tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-2);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 967, 22);
		frmCh.getContentPane().add(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		mnDatei.setBackground(SystemColor.activeCaption);
		mnDatei.setForeground(SystemColor.text);
		mnDatei.setBorder(null);
		menuBar.add(mnDatei);
		
		JMenuItem mntmPcInformation = new JMenuItem("Pc Information");
		mntmPcInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mntmPcInformation.setBackground(SystemColor.activeCaption);
		mnDatei.add(mntmPcInformation);
		
		JMenuItem mntmFehlerMelden = new JMenuItem("Fehler melden ");
		mntmFehlerMelden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));
		mnDatei.add(mntmFehlerMelden);
		
		JMenuItem mntmChat = new JMenuItem("Chat");
		mntmChat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnDatei.add(mntmChat);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.ALT_MASK));
		mnDatei.add(mntmBeenden);
		
		JMenu mnInfo = new JMenu("Info");
		mnInfo.setBackground(SystemColor.activeCaption);
		mnInfo.setForeground(SystemColor.text);
		menuBar.add(mnInfo);
		
		JMenuItem mntmberUns = new JMenuItem("\u00FCber uns");
		mnInfo.add(mntmberUns);
		
		JMenuItem mntmOnlineHilfe = new JMenuItem("Online Hilfe");
		mnInfo.add(mntmOnlineHilfe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(16, 429, 195, 172);
		frmCh.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogo = new JLabel("LOGO");
		lblLogo.setForeground(SystemColor.text);
		lblLogo.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(32, 41, 113, 76);
		panel_1.add(lblLogo);
	}
}
