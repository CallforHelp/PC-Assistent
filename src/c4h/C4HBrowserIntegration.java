package src.c4h;

import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
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
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JScrollBar;

  
public class C4HBrowserIntegration{
 
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    // = new JPanel(new BorderLayout());
    
    @SuppressWarnings("unused")
	private JFrame frame;
    private JPanel panel = new JPanel();
    
    private JPanel statusBar= new JPanel();
    private JPanel topBar   =new JPanel();
    
    private final JButton btnGo = new JButton("Go");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
    private final JScrollBar scrollBar = new JScrollBar();
    
  
 
    public C4HBrowserIntegration(JFrame Frame, JPanel fehlermeldenpanel) {
    	     this.frame = Frame;
    	     fehlermeldenpanel.add(panel);
        initComponents();
    }

    
    private void initComponents() {
    	

        ActionListener al = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                loadURL(txtURL.getText());
           }
        };
    	jfxPanel.setBounds(0, 23, 433, 259);
        

    	jfxPanel.setScene(null);
    	jfxPanel.setBackground(new Color(240,240,240,240));

      
        btnGo.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        btnGo.setBounds(405, 0, 45, 23);

// 
        btnGo.addActionListener(al);
        txtURL.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
        txtURL.setBounds(0, 0, 405, 23);
        txtURL.setPreferredSize(new Dimension(10, 20));
        txtURL.addActionListener(al);
        txtURL.setEditable(false);
        topBar.setBounds(0, 0, 450, 23);
        topBar.setLayout(null);
//  

    //    topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL);
        topBar.add(btnGo);
        statusBar.setBounds(300, 277, 150, 23);
        statusBar.setLayout(null);
        panel.setLayout(null);
    
//  
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
//  

    //    topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL, BorderLayout.CENTER);
        topBar.add(btnGo, BorderLayout.EAST);
// 
//        statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
      
        statusBar.add(progressBar, BorderLayout.EAST);

 
        panel.add(topBar);
        
      //  topBar.add(scrollBar, BorderLayout.WEST);
        panel.add(jfxPanel);
        scrollBar.setBounds(433, 23, 17, 252);
        
        panel.add(scrollBar);
        panel.add(statusBar);
        progressBar.setBounds(0, 0, 150, 23);
        statusBar.add(progressBar);
        
//  
         progressBar.setPreferredSize(new Dimension(150, 18));
         progressBar.setStringPainted(true);
        
        panel.add(scrollBar, BorderLayout.EAST);
        
                createScene();
    }
 
    private void createScene() {
      
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
 
                WebView view = new WebView();
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
                jfxPanel.setScene(new Scene(view));
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
