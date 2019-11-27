package src.c4h;


import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Eine GUI dient zur Nutzung der App und ein Aktive IconTray ist Sichbar f&uuml;r den USER.
 * 
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_GUI_TRAY_ICON {
/**
 * Aktive Icon im SystemTry mit einen sichbaren Icon.
 * das tool h&auml;ngt sich im SystemProzess l&auml;sst sich nicht beenden.  
 * Ein Menu F&uuml;hrung zur bedienung ist auch vorhanden(pc-information, support,chat)
 * @throws Throwable IconTray
 */
	static TrayIcon trayIcon    = new TrayIcon(createImage("images/bulb.png", "trayIcon"));  
	
	public void createshowGui(){

		
		final PopupMenu          popup       = new PopupMenu();		
		final SystemTray         tray        = SystemTray.getSystemTray();
		final C4H_WEBSITE_START  web         = new C4H_WEBSITE_START();
		final C4H_DYNAMIC_GUI    window      = new C4H_DYNAMIC_GUI();
	
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}
		trayIcon.setToolTip("Schul-Support-Service - Call for Help");
		
		//Hinzufuegen(start) the Icon_tray 
		try {
			tray.add(trayIcon);
			if(window.bg.getState()==false||!window.bg.pruefeSchulnr()) {
				trayIcon.setImage(createImage("images/bulbred2.png", "trayIcon"));
				trayIcon.setToolTip("Schul-Support-Service - Call for Help:\n "+window.bg.toolTipFehlerHinweisText+ " Korrigieren");
				//System.out.println("Schulnummer"+bg.getSchulNummer()+" ist :"+ bg.pruefeSchulnr());
			}
		}catch(Throwable e2) {
    		System.out.println("TrayIcon could not be added."+e2.getMessage());
    		return;
    	}
            
    	MenuItem BG_Info_MenuItem = new MenuItem("PC Information");
    	MenuItem Fehler_Meldung_Menu_Item = new MenuItem("Support");
    	MenuItem Chat_Menu_Item = new MenuItem("Chat");
    	MenuItem fwt_Menu_Item = new MenuItem("Fernwartung");
    	
    	fwt_Menu_Item.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			try {
					web.openWebSite("www.ntrglobal.com/code");
				} catch (Throwable e1) {
					System.out.println(e1);
				}
    		}
		});
       
/*
    	MenuItem Beenden_Menu_Item = new MenuItem("Beenden");
    	popup.add(Beenden_Menu_Item);
    	Beenden_Menu_Item.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			System.exit(0);
    		}
		});
*/
    	
    	
    	popup.add(BG_Info_MenuItem);
    	popup.add(Fehler_Meldung_Menu_Item);
    	popup.add(Chat_Menu_Item);
    	popup.add(fwt_Menu_Item);
        
        
        //MenuListe Einsetzen
    	trayIcon.setPopupMenu(popup);
        
    	//action
    	trayIcon.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e ) {
    			if(e.getButton()==MouseEvent.BUTTON1) {
    				try {
						window.setlist();
						if(window.bg.getState()== false||!window.bg.pruefeSchulnr()) {
							trayIcon.setImage(createImage("images/bulbred2.png", "trayIcon"));
							trayIcon.setToolTip("Schul-Support-Service - Call for Help:\n "+window.bg.toolTipFehlerHinweisText + " Korrigieren");
							//System.out.println("Schulnummer"+bg.getSchulNummer()+" ist :"+ bg.pruefeSchulnr());
						}else {
							trayIcon.setImage(createImage("images/bulb.png", "trayIcon"));
							trayIcon.setToolTip("Schul-Support-Service - Call for Help");
						}
							
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    				window.frmCh.setVisible(true);
    				window.PcInfoPanel.setVisible(true);
    				window.FehlerMeldenPanel.setVisible(false);
    				window.chatPanel.setVisible(false);
    				
    			}
			
    		}
    	});
       
    	trayIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C4H_DIALOG dialog = new C4H_DIALOG();
				dialog.setVisible(true);
				Timer timer = new Timer(3000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
						dialog.dispose();
					}
				});
				timer.setRepeats(false);
				timer.start();
			}	
		});
        
    	BG_Info_MenuItem.addActionListener(new ActionListener() {
    		@Override
			public void actionPerformed(ActionEvent e) {
				//todo hier
				try {
					window.bg.printBGinfo();
					window.frmCh.setVisible(true);
					window.PcInfoPanel.setVisible(true);
					window.FehlerMeldenPanel.setVisible(false);
					window.chatPanel.setVisible(false);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}	
			}
		});
        
    	Fehler_Meldung_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frmCh.setVisible(true);
				window.FehlerMeldenPanel.setVisible(true);
				window.chatPanel.setVisible(false);
				window.PcInfoPanel.setVisible(false);
				window.startBrowser();
			}
		});
        
    	Chat_Menu_Item.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			window.frmCh.setVisible(true);
    			window.chatPanel.setVisible(true);
    			window.PcInfoPanel.setVisible(false);
    			window.FehlerMeldenPanel.setVisible(false);
    		}
    	});
	}
	/**
	 * F&uuml;r die realisierung einens Icon f&uuml;r C4H
	 * @param path fuer ein Icon
	 * @param description Zeichen oder hinweis 
	 * @return neues Foto(Icon)
	 */
		protected static Image createImage(String path, String description) {
			URL imageURL = C4H_GUI_TRAY_ICON.class.getResource(path);
			if (imageURL == null) {
				System.err.println("Resource not found: " + path);
				return null;
			} else {
				return (new ImageIcon(imageURL, description)).getImage();
			}
		}
}