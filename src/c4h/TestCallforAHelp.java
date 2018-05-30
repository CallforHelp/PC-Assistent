package src.c4h;


import java.awt.EventQueue;

/**
 * Eine Testklasse zur Verwendung eines Tests 
 * Jede Funktion wird erweitert 
 * Es ist ein Einfacher Test
 *   
*/

/**
 * @author bani
 *
 */
public class TestCallforAHelp {

	

	/**
	 * @param args
	 * @throws Throwable
	 */
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
	

	/**
	 * @throws Throwable
	 */
	@SuppressWarnings("unused")

	private void testWebsiteReader() throws Throwable {
		WebsiteReader web = new WebsiteReader();
		web.openWebSiteExample();
	}

	/**
	 * 
	 */
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
					e.printStackTrace();
				}
			}
		});
		
	}
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void testCallForaHelpGui() {
		CallForaHelpGUI start=new CallForaHelpGUI();
		try {
			start.createshowGui();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @throws Throwable
	 */
	@SuppressWarnings("unused")
	private void testBG_Info() throws Throwable {
		BG_Info BG = new BG_Info();
		BG.printBGinfo();
	}
	/**
	 * @throws Throwable
	 */
	@SuppressWarnings("unused")
	private void startDynamicGUI() throws Throwable {
		DynamicalGuiForC4H window =new DynamicalGuiForC4H();
		window.frmCh.setVisible(true);
		
	}
	/**
	 * @throws Throwable
	 */
	private void startBrowser() throws Throwable {
	}
	

}
