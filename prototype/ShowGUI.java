package prototype;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ShowGUI {
	
	public void createshowGui() {
		//FEHLER 	
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}
		final PopupMenu popup = new PopupMenu();
		
		final TrayIcon trayIcon =
                new TrayIcon(createImage("images/bulb.gif", "tray icon"));
        
        final SystemTray tray = SystemTray.getSystemTray();
        
        //Hinzufuegen(start) the Icon_tray 
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        Menu BG_Info_Menu = new Menu("BG_INFO");
        MenuItem Fehler_Meldung_Menu_Item = new MenuItem("Fehler Meldung");
        popup.add(Fehler_Meldung_Menu_Item);
        popup.add(BG_Info_Menu);
        
        //MenuListe Einsetzen
        trayIcon.setPopupMenu(popup);
        
        //actions
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BG_Info bg = new BG_Info();
                try {
					JOptionPane.showMessageDialog(null,
					       bg.printBGINFO());
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        Fehler_Meldung_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//todo hier
			}
		});
        
	}
	
	 //Obtain the image URL
	protected static Image createImage(String path, String description) {
    	URL imageURL = ShowGUI.class.getResource(path);
    	if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }

}