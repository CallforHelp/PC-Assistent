package bginfo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class BG_Info {
	
	public static void main(String[] args) throws Exception {
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
		System.out.println("SchulNummer     :"+ BG.getSchulNr());
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
	private String getSchulNr() {
		String schulNr ="";
		return schulNr;
	}
	public String uberSchrift() {
		String s ="3S";
		
		return s;
	}
	
	public String timetoBuild() {
		String time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
		return time;
	}
	/*****************************************************************************************/
	/*****************************PC_INFO***************************************************/
	public String getUserName() {
		String userName = new Properties(System.getProperties()).getProperty("user.name");
		return userName;
	}
	public String getOSversion(){
		String OsVersion= new Properties(System.getProperties()).getProperty("os.name");
		return OsVersion;
	}
	
	public String getOSArchitecture(){
		String OsArch= new Properties(System.getProperties()).getProperty("os.arch");
		return OsArch;
	}
	public String getMusterImages() {
		String musterImages = "";
		String OsVersion= new Properties(System.getProperties()).getProperty("os.name");
		
		if (OsVersion.contains("10")) {
			musterImages= "CottonCandy W10";
			
		}else 
			if (OsVersion.contains("7"))
				musterImages= "CottonCandy W7";
		
		
		return musterImages;
	} 
	
	/*****************************************************************************************/
	/*****************************NETZWERK***************************************************/
	
	public String getLocalAdresse() throws UnknownHostException {
		String result ="";
		result= result + InetAddress.getLocalHost().getHostAddress();
		return result;
		
	}
	public String getMacAddress() throws SocketException{
		
	  String result = "";

	  for ( NetworkInterface ni : Collections.list( NetworkInterface.getNetworkInterfaces() ) )
	  {
	    byte[] hardwareAddress = ni.getHardwareAddress();

	    if ( hardwareAddress != null )
	    {
	      for ( int i = 0; i < hardwareAddress.length; i++ )
	        result += String.format( (i==0?"":"-")+"%02X", hardwareAddress[i] );

	      return result;
	    }
	  }

	  return result;
	}
	public String getLocalHost() throws UnknownHostException {
		String result ="";
		result= result + InetAddress.getLocalHost().getHostName();
		return result;
		
	}
	public String getMachindomain() throws IOException {
		String domain="";
		String line;
		Process ipfconfig = null;
		Reader input = null;
		
		if(new Properties(System.getProperties()).getProperty("os.name").contains("Win")) {
			ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
		}else
			 ipfconfig= Runtime.getRuntime().exec("netstat -rn");
			
		input = new InputStreamReader(ipfconfig.getInputStream());
		BufferedReader resultOutput = new BufferedReader(input);
		while((line=resultOutput.readLine()) != null) {
			   if(line.contains("DNS-Suffixsuchliste")) {
				   domain=line.split(":\\s")[1];
			   }
		}
		return domain;
	}
	public String getSubnetMask() throws SocketException, IOException {
		
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		//System.out.println(networkInterface);
		short prflen= networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
		
		
		int shft = 0xffffffff<<(32-prflen);
		int oct1 = ((byte) ((shft&0xff000000)>>24)) & 0xff;
		int oct2 = ((byte) ((shft&0x00ff0000)>>16)) & 0xff;
		int oct3 = ((byte) ((shft&0x0000ff00)>>8)) & 0xff;
		int oct4 = ((byte) (shft&0x000000ff)) & 0xff;
		String submask = oct1+"."+oct2+"."+oct3+"."+oct4;
		return submask;

	}
	public String getDefaultgateway() throws IOException {
		
		String defaultgateway="";
		String line;
		
		Process ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
		Reader input = new InputStreamReader(ipfconfig.getInputStream());

		BufferedReader resultOutput = new BufferedReader(input);
		
		while( (line=resultOutput.readLine()) != null ) {
		   if(line.contains("Standardgateway")) {
			   defaultgateway=line.split(":\\s")[1];
		   }
		}
		return defaultgateway;
	}
	
	public String getDHCPServer() throws IOException {
		String dhcpserver="";
		String line;
		Process ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
		Reader input = new InputStreamReader(ipfconfig.getInputStream());

		BufferedReader resultOutput = new BufferedReader(input);
		while((line=resultOutput.readLine()) != null) {
			   if(line.contains("DHCP-")) {
				   dhcpserver=line.split(":\\s")[1];
			   }
		}
		
		return dhcpserver;
	}
	
	public String getDNSServer() throws IOException  {
		String dnsserver="";
		String line;
		Process ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
		Reader input = new InputStreamReader(ipfconfig.getInputStream());

		BufferedReader resultOutput = new BufferedReader(input);
		while((line=resultOutput.readLine()) != null) {
			   if(line.contains("DNS-Server")) {
				   dnsserver=line.split(":\\s")[1];
			   }
		}
		return dnsserver;
	}
	
	
	
public  ArrayList<String>[] getBGInfo() {
	
	//BG_Info bg = new BG_Info();
	

	
	return null;
}

public void printBGinfo() throws Exception{
	
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

}
		
}