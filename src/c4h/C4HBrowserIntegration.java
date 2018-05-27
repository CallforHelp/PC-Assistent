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
	private Stage stage;
	private WebView browser;
	private String URL="";
    
    @SuppressWarnings("unused")
	private JFrame frame;
    private JPanel panel = new JPanel();
    
    private JButton btnGo;
    private JProgressBar progressBar;
    
  
 
    public C4HBrowserIntegration(JFrame Frame, JPanel fehlermeldenpanel,String URL) {
    	     frame = Frame;
    	     this.URL=URL;
    	     fehlermeldenpanel.add(panel);
    	     initComponents();
    }

    
    private void initComponents() {
    	jfxPanel = new JFXPanel();
    	createScene();
    	
    	btnGo = new JButton("Aktualisieren");
    	progressBar = new JProgressBar();

       
    	jfxPanel.setBounds(0, 30, 787, 604);
        

    	jfxPanel.setBackground(new Color(255,255,255,255));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

 
        panel.setBounds(200, 40, 787, 656);
        btnGo.setBounds(635, 0, 152, 30);
        panel.add(btnGo);
        
        // 
        
        progressBar.setBounds(0, 637, 787, 18);
        panel.add(progressBar);
        
//  
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
            
//  
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
        
      //  topBar.add(scrollBar, BorderLayout.WEST);
        panel.add(jfxPanel);
        ActionListener al = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
              //  loadURL(txtURL.getText());
                Platform.runLater(new Runnable() {
                    

					@Override
                    public void run() {
                        engine.reload();
                    }
                });
           }
        };
        btnGo.addActionListener(al);
        
               
    }
 
    private void createScene() {
    	Platform.runLater(new Runnable() {
    		@Override 
    		public void run() {
    			stage = new Stage();  
    			stage.setResizable(false);  
    			
    			Group root = new Group();  
    			Scene scene = new Scene(root,80,20);  
    			stage.setScene(scene);  
             
    			// Set up the embedded browser:
    			browser = new WebView();
    			engine = browser.getEngine();
    			engine.load(URL);
            
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
