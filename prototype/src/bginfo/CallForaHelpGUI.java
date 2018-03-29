package bginfo;

import java.awt.*;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;




public class CallForaHelpGUI {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createshowGui() throws IOException {
		//FEHLER 	
		final BG_Info bg = new BG_Info();
		final BgInfoFrame jframe = new BgInfoFrame();
		final WebsiteReader weblogin = new WebsiteReader();
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported");
			return;
		}
		
		final PopupMenu popup = new PopupMenu();
		
		final TrayIcon trayIcon =
                new TrayIcon(createImage("images/bulb.gif", "trayIcon"));
        
        final SystemTray tray = SystemTray.getSystemTray();
        
        //Hinzufuegen(start) the Icon_tray 
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        MenuItem BG_Info_MenuItem = new MenuItem("BGINFO");
        MenuItem Fehler_Meldung_Menu_Item = new MenuItem("Fehler Meldung");
        MenuItem Beenden_Menu_Item = new MenuItem("Beenden");
        
        popup.add(Fehler_Meldung_Menu_Item);
        popup.add(BG_Info_MenuItem);
        popup.add(Beenden_Menu_Item);
        
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

        Fehler_Meldung_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Connect to Webside
				try {
					weblogin.openWebSiteExample();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Connect to Webside");
			}
		});
        
        BG_Info_MenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//todo hier
				try {
					bg.printBGinfo();
					jframe.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        Beenden_Menu_Item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// todo hier
				System.exit(0);
				
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