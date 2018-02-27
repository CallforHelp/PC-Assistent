package prototype;


import java.io.IOException;
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
		System.out.println("PC Info");
		System.out.println("********************************");
		
		System.out.println("Host Name     :"+ BG.getLocalHost());
		System.out.println("User Name     :"+ BG.getUserName());
		System.out.println("OS Version    :"+ BG.getOSversion());
		System.out.println("OS Architektur:"+ BG.getOSArchitecture());
		System.out.println("Muster Images :");
		
		System.out.println("********************************");
		System.out.println("NETZWERK");
		System.out.println("********************************");
		
		System.out.println("Adresse local  :"+ BG.getLocalAdresse());
		System.out.println("Subnet Mask    :"+ BG.getSubnetMask());
		System.out.println("MAC Adresse    :"+ BG.getMacAddress());
		System.out.println("Machine Domain :"+ BG.getMusterImages());
		System.out.println("Default Gateway:"+ BG.getDefaultgateway());
		System.out.println("DHCP Server    :");
		System.out.println("DNS Server     :");

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
		return "";
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
	public String getSubnetMask() throws SocketException, IOException {
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		short prflen= networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
		int shft = 0xffffffff<<(32-prflen);
		int oct1 = ((byte) ((shft&0xff000000)>>24)) & 0xff;
		int oct2 = ((byte) ((shft&0x00ff0000)>>16)) & 0xff;
		int oct3 = ((byte) ((shft&0x0000ff00)>>8)) & 0xff;
		int oct4 = ((byte) (shft&0x000000ff)) & 0xff;
		String submask = oct1+"."+oct2+"."+oct3+"."+oct4;
		return submask;

	}
	public String getDefaultgateway() throws SocketException, UnknownHostException {
		return"";
	}
	public String getDHCPServer() {
		String dhcpserver="";
		return dhcpserver;
	}
	public String getDNSServer() {
		String dnsserver="";
		return dnsserver;
	}
	
	
	
/*public  String printBGINFO() throws UnknownHostException, SocketException {
		
		BG_Info BG = new BG_Info();
	System.out.println("Was brauche ich für BG_Info");
	try {
		System.out.println( "Host Name : " + BG.getLocalHost());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		System.out.println( "Adresse local: " + BG.getLocalAdresse());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	try {
		System.out.println("MAC Adresse: "+BG.getMacAddress()+"\n");
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return "Hostname: "+BG.getLocalHost()+"\n"+"IP: "+BG.getLocalAdresse()+"\n"+"MacAdresse: "+BG.getMacAddress()+"\n";	
	}
	
*/
}
