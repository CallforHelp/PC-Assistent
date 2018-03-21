package bginfo;


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
		start .testBG_Info();
		//start.testCallForaHelpGui();
		//start.testBgInfoFrame();
		//start.testWebsiteReader();
	}

	@SuppressWarnings("unused")
	private void testWebsiteReader() {
		WebsiteReader web = new WebsiteReader();
		//web.openWebSiteExample();
		//web.webScraperExample();
		web.startFIleInput();
		
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

	private void testCallForaHelpGui() {
		CallForaHelpGUI start=new CallForaHelpGUI();
		try {
			start.createshowGui();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unused")
	private void testBG_Info() throws SocketException, IOException {
		BG_Info BG = new BG_Info();
		System.out.println("3S");
		System.out.println("BG_Info");
		System.out.println("time to build :"+ BG.timetoBuild());
		
		System.out.println("Schul-Support-Services HiTEC e.V.");
		System.out.println("********************************");
		System.out.println("            PC Info");
		System.out.println("********************************");
		
		System.out.println("Host Name     :"+ BG.getLocalHost());
		System.out.println("User Name     :"+ BG.getUserName());
		System.out.println("SchulNummer   :"+ BG.getSchulNummer());
		System.out.println("OS Version    :"+ BG.getOSversion());
		System.out.println("OS Architektur:"+ BG.getOSArchitecture());
		System.out.println("Muster Images :"+ BG.getMusterImages());
		
		System.out.println("********************************");
		System.out.println("            NETZWERK");
		System.out.println("********************************");
		
		System.out.println("Adresse local  :"+ BG.getLocalAdresse());
		System.out.println("Subnet Mask    :"+ BG.getSubnetMask());
		System.out.println("MAC Adresse    :"+ BG.getMacAddress());
		System.out.println("Machine Domain :"+ BG.getMachindomain());
		System.out.println("Default Gateway:"+ BG.getDefaultgateway());
		System.out.println("DHCP Server    :"+ BG.getDHCPServer());
		System.out.println("DNS Server     :"+ BG.getDNSServer());
		
	}
	
	

}
