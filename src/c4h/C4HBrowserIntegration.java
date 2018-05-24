package src.c4h;

import static javafx.concurrent.Worker.State.FAILED;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
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
import javax.swing.SwingConstants;

public class C4HBrowserIntegration{
 
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    // = new JPanel(new BorderLayout());
    
    @SuppressWarnings("unused")
	private JFrame frame;
    private JPanel panel = new JPanel();
    
    private final JButton btnGo = new JButton("Aktualisieren");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
    
  
 
    public C4HBrowserIntegration(JFrame Frame, JPanel fehlermeldenpanel) {
    	     this.frame = Frame;
    	     fehlermeldenpanel.add(panel);
    	     initComponents();
    	     createScene();
        
    }

    
    private void initComponents() {
    	

        ActionListener al = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                loadURL(txtURL.getText());
           }
        };
    	jfxPanel.setBounds(0, 30, 787, 604);
        

    	jfxPanel.setBackground(new Color(255,255,255,255));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

 
        panel.setBounds(200, 40, 787, 656);
        btnGo.setBounds(635, 0, 152, 30);
        panel.add(btnGo);
        
        // 
        btnGo.addActionListener(al);
        progressBar.setBounds(0, 637, 787, 18);
        panel.add(progressBar);
        
//  
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
            
//  
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
        txtURL.setBackground(Color.WHITE);
        txtURL.setBounds(667, 0, 60, 30);
        panel.add(txtURL);
        txtURL.setEnabled(false);
        txtURL.setPreferredSize(new Dimension(10, 20));
        txtURL.addActionListener(al);
        txtURL.setEditable(false);
        txtURL.setVisible(false);
        
      //  topBar.add(scrollBar, BorderLayout.WEST);
        panel.add(jfxPanel);
        
               
    }
 
    private void createScene() {
    	Platform.runLater(new Runnable() {
        @Override 
        public void run() {
        	
        	WebView view = new WebView();
        	Group root = new Group();  
        	Scene scene = new Scene(root,80,20);
        	//Scene scene = new Scene(view);
        
            view.setFontScale(1);
            view.setZoom(0.75);
            ObservableList<Node> children = root.getChildren();
            children.add(view);

            engine = view.getEngine();
            engine.titleProperty().addListener(new ChangeListener<String>() {        
            	@Override
            	public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
            		SwingUtilities.invokeLater(new Runnable() {
            			@Override 
                        public void run() {
            				panel.setToolTipText(newValue);
                        }
                    });
                }
            });
            engine.locationProperty().addListener(new ChangeListener<String>() {
            	@Override
            	public void changed(ObservableValue<? extends String> ov, String oldValue, final String newValue) {
            		SwingUtilities.invokeLater(new Runnable() {
            			@Override 
            			public void run() {
            				txtURL.setText(newValue);
                        }
                    });
                }
            });
                
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

                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {
 
                            public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                                if (engine.getLoadWorker().getState() == FAILED) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override public void run() {
                                            JOptionPane.showMessageDialog(
                                                    panel,
                                                    (value != null) ?
                                                    engine.getLocation() + "\n" + value.getMessage() :
                                                    engine.getLocation() + "\nUnexpected error.",
                                                    "Loading error...",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    });
                                }
                            }
                        });
                //jfxPanel.setScene(new Scene(view));
                jfxPanel.setScene(scene);
            }
        });
    }
 
    public void loadURL(final String url) {
       
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
                String tmp = toURL(url);
 
                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
                engine.load(tmp);
            }
        });

    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
                return null;
        }
    }
}
