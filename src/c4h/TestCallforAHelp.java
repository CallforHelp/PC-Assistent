package src.c4h;


import java.awt.EventQueue;

/**
 * 
 * Eine Testklasse zur Verwendung eines Tests 
 * Jede Funktion wird erweitert 
 * Es ist ein Einfacher Test  
*/

public class TestCallforAHelp {

	

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Throwable{
		
		TestCallforAHelp start = new TestCallforAHelp();
		//start.startDynamicGUI();
		//start .testBG_Info();
		//start.testCallForaHelpGui();
		//start.testBgInfoFrame();
		//start.testWebsiteReader();
		start.startBrowser();
	}

		//start.testBgInfoFrame();
		//start.testWebsiteReader();
	

	@SuppressWarnings("unused")

	private void testWebsiteReader() throws Throwable {
		WebsiteReader web = new WebsiteReader();
		web.openWebSiteExample();
		//web.webScraperExample();
		//web.startFIleInput();
		
	}
	@SuppressWarnings("unused")

	private void testBgInfoFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BgInfoFrame frame = new BgInfoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}
	@SuppressWarnings("unused")
	private void testCallForaHelpGui() {
		CallForaHelpGUI start=new CallForaHelpGUI();
		try {
			start.createshowGui();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unused")
	private void testBG_Info() throws Throwable {
		BG_Info BG = new BG_Info();
		BG.printBGinfo();
	}
	@SuppressWarnings("unused")
	private void startDynamicGUI() throws Throwable {
		DynamicalGuiForC4H window =new DynamicalGuiForC4H();
		window.frmCh.setVisible(true);
		
	}
	private void startBrowser() throws Throwable {
		// TODO Auto-generated method stub
		BG_Info bg = new BG_Info();
		DynamicalGuiForC4H gui = new DynamicalGuiForC4H();
		gui.FehlerMeldenPanel.setVisible(true);
		C4HBrowserIntegration browser;
		browser = new C4HBrowserIntegration(gui.frmCh,gui.FehlerMeldenPanel);
        try {
			browser.loadURL("fehlermeldung.3s-hamburg.de"+"?schulnummer="+bg.getSchulNummer());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: "+e);
		}
		
        /*JPanel panel =new JPanel();
		FehlerMeldenPanel.add(panel);
		JFXPanel jfxPanel = new JFXPanel();
		panel.add(jfxPanel);
		// Creation of scene and future interactions with JFXPanel
		// should take place on the JavaFX Application Thread
		Platform.runLater(() -> {
			 WebView webView = new WebView();
			 jfxPanel.setScene(new Scene(webView));
			 webView.getEngine().load(URL);
		   
		});*/
	}
	

}
