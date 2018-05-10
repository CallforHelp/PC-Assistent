package src.c4h;


import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;




public class CallForaHelpGUI {
	
	public void createshowGui() throws IOException {
	
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
				trayIcon.displayMessage("Die SchulNummer ist Fehlerhaft!!!!! "+bg.getSchulNummer(),
						"Schul Support Service\nTEAM C4H", MessageType.WARNING);
    	}catch(Throwable e2) {
                System.out.println("TrayIcon could not be added."+e2.getMessage());
                return;
    	}
            
        MenuItem BG_Info_MenuItem = new MenuItem("PC INFORMATION");
        MenuItem Fehler_Meldung_Menu_Item = new MenuItem("FEHLER MELDEN");
        MenuItem Chat_Menu_Item = new MenuItem("CHAT");
        
      /*  MenuItem Beenden_Menu_Item = new MenuItem("Beenden");
        popup.add(Beenden_Menu_Item);
        Beenden_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// todo hier
				System.exit(0);
				
			}
		});*/
        
        popup.add(BG_Info_MenuItem);
        popup.add(Fehler_Meldung_Menu_Item);
        popup.add(Chat_Menu_Item);
        
        
        //MenuListe Einsetzen
        trayIcon.setPopupMenu(popup);
        
   
        //actiion
        trayIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action by clik");
				CallForHelpDialog dialog = new CallForHelpDialog();
				dialog.setVisible(true);
			}
		});
        
        BG_Info_MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//todo hier
				try {
					bg.printBGinfo();
					//jframe.setVisible(true);
					window.frmCh.setVisible(true);
					//window.tabbedPane.setSelectedIndex(window.tabbedPane.getTabCount()-3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        
        Fehler_Meldung_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//window.tabbedPane.getSelectedIndex();
				window.frmCh.setVisible(true);
				//window.tabbedPane.setSelectedIndex(window.tabbedPane.getTabCount()-2);
				
				System.out.println("Connect to Webside");
			}
		});
        
       
        Chat_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//todo hier
				try {
					bg.printBGinfo();
					//jframe.setVisible(true);
					window.frmCh.setVisible(true);
					//window.tabbedPane.setSelectedIndex(window.tabbedPane.getTabCount()-1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
        
        
	}
	
	 //Obtain the image URL
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