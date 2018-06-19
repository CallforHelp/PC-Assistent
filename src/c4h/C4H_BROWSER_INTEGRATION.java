package src.c4h;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
/**
 * Eine Klasse Webbrowser in einer JAVA GUI 
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */

public class C4H_BROWSER_INTEGRATION{
	/**
	 * JFX PANEL Fuer HTML Seitem
	 */
	private JFXPanel jfxPanel;
	/**
	 * Darstellung einer Webseite
	 */
	private WebEngine engine;
    
	/**
	 * JPanel zur darstellung auf der APP
	 */
	private JPanel panel = new JPanel();
    
    /**
     * Aktualisierungsbutton
     */
    private JButton buttonReload = new JButton("Aktualisieren");
    /**
     * Progressbar
     */
    private JProgressBar progressBar = new JProgressBar();

 
    /**
     * Ein Konstruktor zum start undinitialisieren dieser Klasse
     * Es muss zur laufzeit den Panel aus der C4H app zur Verfügungstehen
     * damit die darstellung in der App ensteht
     * @param fehlermeldenpanel Panel from c4H Gui
     */
    public C4H_BROWSER_INTEGRATION(JPanel fehlermeldenpanel) {
    	fehlermeldenpanel.add(panel);
    	initComponents();
    }

    /**
     * Hier werden alle Kompnoennten realisiert
     * der Browser ist sehr einfach gestrickt 
     * Es dient nur zur script benutzung
     */
    private void initComponents() {
    	
    	jfxPanel = new JFXPanel();
    	jfxPanel.setBounds(0, 0, 787, 604);
    	jfxPanel.setBackground(new Color(255,255,255,255));
    	
    	panel.setBackground(Color.WHITE);
    	panel.setLayout(null);
    	panel.setBounds(200, 40, 787, 656);
    	
    	buttonReload.setBounds(10, 613, 180, 30);
    	panel.add(buttonReload);
    	
    	ActionListener al = new ActionListener() {
    		@Override 
    		public void actionPerformed(ActionEvent e) {
    			Platform.runLater(new Runnable() {
    				@Override
    				public void run() {
    				engine.reload();
    				}
    			});
    		}
    	};
    	buttonReload.addActionListener(al);
    	progressBar.setBounds(597, 615, 180, 30);
    	panel.add(progressBar);

    	progressBar.setPreferredSize(new Dimension(150, 18));
    	progressBar.setStringPainted(true);
    	progressBar.setPreferredSize(new Dimension(150, 18));
    	progressBar.setStringPainted(true);

    	panel.add(jfxPanel);
    	
    	JButton buttonBrowser = new JButton("Browse");
    	buttonBrowser.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			C4H_WEBSITE_START web = new C4H_WEBSITE_START();
    			try {
    				web.openWebSiteExample();
    			} catch (Throwable e) {
    				System.out.println(e.getMessage());
    			}
    		}
    	});
    	buttonBrowser.setBounds(317, 613, 180, 30);
    	panel.add(buttonBrowser);
        
               
    }
 
    /**
     * Create Scene ist ein Aufruf zur unser Fehlermeldung 
     *  @param url LoginPage
     */
    public void createScene(String url) {
    	Platform.runLater(new Runnable() {
        private Stage stage;
		private WebView browser;

		@Override 
        public void run() {
			stage = new Stage();  
            Group root = new Group();  
            Scene scene = new Scene(root,80,20);  
            stage.setScene(scene);  
             
            // Set up the embedded browser:
            browser = new WebView();
            engine = browser.getEngine();
            engine.load(url);
            browser.setFontScale(1);

            ObservableList<Node> children = root.getChildren();
            children.add(browser);             
            
            engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                progressBar.setValue(newValue.intValue());
                            }
                        });
                    }
             });
                jfxPanel.setScene(scene);
            }
        });
    }
}
