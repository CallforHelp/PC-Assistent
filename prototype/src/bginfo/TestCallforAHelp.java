package bginfo;

import java.io.IOException;
import java.net.SocketException;

public class TestCallforAHelp {

	

	public static void main(String[] args) {
		TestCallforAHelp start = new TestCallforAHelp();
		try {
			start .testBG_Info();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start.testCallForaHelpGui();
		start.testBgInfoFrame();
		start.testWebsiteReader();
	}

	private void testWebsiteReader() {
		
	}

	private void testBgInfoFrame() {
		
	}

	private void testCallForaHelpGui() {
		
	}

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
		System.out.println("SchulNummer    :"+ BG.getSchulNummer());
		
	}
	
	

}
