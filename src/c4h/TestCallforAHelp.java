package src.c4h;


import java.awt.EventQueue;
import java.io.IOException;
import java.net.SocketException;

/**
 * 
 * Eine Testklasse zur Verwendung eines Tests 
 * Jede Funktion wird erweitert 
 * Es ist ein Einfacher Test  
*/

public class TestCallforAHelp {

	

	public static void main(String[] args) throws SocketException, IOException {
		TestCallforAHelp start = new TestCallforAHelp();
		try {
			start .testBG_Info();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void testBG_Info() throws Exception {
		BG_Info BG = new BG_Info();
		BG.printBGinfo();
	}
	
	

}
