package src.c4h;


import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Ene GUI Klasse Dient zur Bedienung der App und ein Aktive IconTray ist Sichbar f&uuml;r den USER
 * 
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class CallForaHelpGUI {
/**
 * Aktive Icon im SystemTry mit einen sichbaren Icon
 * das tool h&auml;ngt sich im SystemProzess l&auml;sst sich nicht beenden  
 * Ein Menu F&uuml;hrung zur bedienung ist auch vorhanden(pc-information, support,chat)
 * @throws Throwable IconTray
 */
public void createshowGui() throws Throwable {
    DynamicalGuiForC4H window =  new DynamicalGuiForC4H();
    window.initialize();
		final BG_Info bg = new BG_Info();
		
		
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}
		
		final PopupMenu popup = new PopupMenu();
		final TrayIcon trayIcon =
                new TrayIcon(createImage("images/bulb.png", "trayIcon"));  
        final SystemTray tray = SystemTray.getSystemTray();
        
        //Hinzufuegen(start) the Icon_tray 
        try {
            tray.add(trayIcon);
            System.out.println("Schulnummer Aktuell: "+bg.getSchulNummer()+" ist :"+ bg.pruefeSchulnr());
            if(!bg.pruefeSchulnr())
				trayIcon.displayMessage("Die SchulNummer ist Fehlerhaft!!!"+bg.getSchulNummer(),
						"Schul Support Service\nTEAM C4H", MessageType.WARNING);
    	}catch(Throwable e2) {
                System.out.println("TrayIcon could not be added."+e2.getMessage());
                return;
    	}
            
        MenuItem BG_Info_MenuItem = new MenuItem("PC Information");
        MenuItem Fehler_Meldung_Menu_Item = new MenuItem("Support");
        MenuItem Chat_Menu_Item = new MenuItem("Chat");
        

       

      MenuItem Beenden_Menu_Item = new MenuItem("Beenden");
        popup.add(Beenden_Menu_Item);
        Beenden_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// todo hier
				System.exit(0);
				
			}
		});
        popup.add(BG_Info_MenuItem);
        popup.add(Fehler_Meldung_Menu_Item);
        popup.add(Chat_Menu_Item);
        
        
        //MenuListe Einsetzen
        trayIcon.setPopupMenu(popup);
        
   
        //action
        trayIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action by click");
				CallForHelpDialog dialog = new CallForHelpDialog();
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
					bg.printBGinfo();
					window.frmCh.setVisible(true);
					window.PcInfoPanel.setVisible(true);
					window.FehlerMeldenPanel.setVisible(false);
					window.chatPanel.setVisible(false);
					//window.tabbedPane.setSelectedIndex(window.tabbedPane.getTabCount()-3);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
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
	 * @param path
	 * @param description
	 * @return pic
	 * @wbp.parser.entryPoint
	 */
	protected static Image createImage(String path, String description) {
    	URL imageURL = CallForaHelpGUI.class.getResource(path);
    	if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}