package src.c4h;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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

public class C4HBrowserIntegration{
	private JFXPanel jfxPanel;
	private WebEngine engine;
    
	private JPanel panel = new JPanel();
    
    private JButton buttonReload = new JButton("Aktualisieren");
    private JProgressBar progressBar = new JProgressBar();

 
    public C4HBrowserIntegration(JPanel fehlermeldenpanel) {
    	fehlermeldenpanel.add(panel);
    	initComponents();
    }

    private void initComponents() {
    	jfxPanel = new JFXPanel();
    
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
        
    	jfxPanel.setBounds(0, 0, 787, 604);
    	jfxPanel.setBackground(new Color(255,255,255,255));
    	panel.setBackground(Color.WHITE);
    	panel.setLayout(null);

 
    	panel.setBounds(200, 40, 787, 656);
    	buttonReload.setBounds(10, 613, 180, 30);
    	panel.add(buttonReload);

    	buttonReload.addActionListener(al);
    	progressBar.setBounds(597, 615, 180, 30);
    	panel.add(progressBar);

    	progressBar.setPreferredSize(new Dimension(150, 18));
    	progressBar.setStringPainted(true);

    	progressBar.setPreferredSize(new Dimension(150, 18));
    	progressBar.setStringPainted(true);

    	panel.add(jfxPanel);
        
               
    }
 
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
