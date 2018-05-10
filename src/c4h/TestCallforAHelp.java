package src.c4h;


import java.awt.EventQueue;
import java.io.IOException;

/**
 * 
 * Eine Testklasse zur Verwendung eines Tests 
 * Jede Funktion wird erweitert 
 * Es ist ein Einfacher Test  
*/

public class TestCallforAHelp {

	

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		
		TestCallforAHelp start = new TestCallforAHelp();
		start.startDynamicGUI();
		//start .testBG_Info();
		//start.testCallForaHelpGui();
		//start.testBgInfoFrame();
		//start.testWebsiteReader();
	}

		//start.testBgInfoFrame();
		//start.testWebsiteReader();
	

	@SuppressWarnings("unused")

	private void testWebsiteReader() throws IOException {
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
		}
		
	}
	@SuppressWarnings("unused")
	private void testBG_Info() throws Exception {
		BG_Info BG = new BG_Info();
		BG.printBGinfo();
	}
	@SuppressWarnings("unused")
	private void startDynamicGUI() throws Exception {
		DynamicalGuiForC4H window =new DynamicalGuiForC4H();
		window.frmCh.setVisible(true);
		
	}
	
	

}
