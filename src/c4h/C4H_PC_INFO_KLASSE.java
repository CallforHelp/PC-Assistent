package src.c4h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Eine Klasse zum Zeigen der wichtigsten informationen &uuml;ber den Client. 
 * Netwerk und PC Information
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_PC_INFO_KLASSE {
	
	public final int RechnerTypLaenge = 4;
	
	String schulNummer="";
	
	/**
	 * Die Schulnummer muss erstellt werden damit f&uuml;r die Fehleranmeldung sofort mitgenommen wird.
	 * SchulNummer erstellen 
	 * @throws Throwable Hostname
	 */
	public C4H_PC_INFO_KLASSE() throws Throwable {
		
		settSchulNummer();
	
	}
	
	/**
	 * Ueberschrift Name Des Tool. 
	 * @return uebrschrift
	 */
	public String uberSchrift() {
		
		String ueberschrift ="C4H";	
		
		return ueberschrift;
	}
	
	/**
	 * Die Zeit wird vom Systemausgelesen.
	 * @return Zeit(time)
	 */
	public String timetoBuild() {
		
		String time = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
		
		return time;
	}
	
	/*****************************************************************************************/
	/******************************************PC_INFO****************************************/
	
	/**
	 * System Property ist die Klasse zum Auslesen. 
	 * von eingenschaften 
	 * @return userName
	 */
	public String getUserName() {
		
		String userName = new Properties(System.getProperties()).getProperty("user.name");
		
		return userName;
	}
	
	/**
	 * Hier wird anhand der HostName die SchuleNummer ausgelesen. 
	 * @return Schulnummer
	 * @throws Throwable Hostname
	 */
	public String settSchulNummer() throws Throwable {
		
		Pattern p = Pattern.compile("[0-9]{4}");
		Matcher m = p.matcher(InetAddress.getLocalHost().getHostName());
		
		// match
		if (m.find())
			schulNummer= m.group();
		
		if(!pruefeSchulnr())

			this.schulNummer="FalscheSchulnummer";

		
    return schulNummer;

	}
	/**
	 * Gibt Einfach die Schulnummer zurueck.
	 * @return schulNummer
	 * @throws Throwable Hostname
	 */
	public String getSchulNummer() throws Throwable {
		
		return schulNummer;
	}
	
	/**
	 * System Properties 
	 * Auslesen von OSName
	 * @return OsVersion
	 */
	public String getOSversion(){
		
		String OsVersion= new Properties(System.getProperties()).getProperty("os.name");
		
		return OsVersion;
	}
	
	/**
	 * Betriebsystemarchitektur
	 * @return OSArchitektur
	 */
	public String getOSArchitecture(){
		
		String OsArch= new Properties(System.getProperties()).getProperty("os.arch");
		
		return OsArch;
	}
	/**
	 * Muster Image von 3s
	 * die info bekommen wir aus dem Infobereich des Betriebsystems
	 * @return musterImages
	 * @throws IOException RegEintrag
	 */
	public String getMusterImages() throws IOException {
		
		String musterImages = "";
		String line;
		String location = "HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\OEMInformation";
		String key = "Model";
		Process process = null ;
		if(getOSversion().contains("W")||getOSversion().contains("w")) {	// Run reg query, then read output with StreamReader (internal class)
			process = Runtime.getRuntime().exec("reg query " +location+" /v "+key);
			Reader input = new InputStreamReader(process.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			while((line=resultOutput.readLine()) != null) {
				if (line.contains("REG")){
						musterImages=line.split("REG_SZ")[1].trim();
				}				
			}
			
		}
		
		return musterImages;
	}
	/**
	 * RechnerTyp aus dem Hostname auslesen. 
	 * @return RechnerTyp
	 * @throws Exception Hostname
	 */
	public String getRechnertypen() throws Exception {
		
		String rechnerTyp="";
		
		String hostname = InetAddress.getLocalHost().getHostName();
		
		for (int i = RechnerTypLaenge; i < (RechnerTypLaenge*2); i++) {
			rechnerTyp=rechnerTyp+(hostname.charAt(i));
		}
		
		return rechnerTyp; 
	}
	
	/*****************************************************************************************/
	/****************************************** NETZWERK ****************************************/
	
	/**
	 * IpAdresse Auslesen.
	 * @return result(IPAdress)
	 * @throws UnknownHostException Hostadresse
	 */
	public String getLocalAdresse() throws UnknownHostException {
		
		String result ="";
		result= InetAddress.getLocalHost().getHostAddress();
		return result;
		
	}
	/**
	 * MacAdresse auslesen. 
	 * @return MacAdresse
	 * @throws IOException Commandbefehl 
	 */
	public String getMacAddress() throws IOException{
		String result = "";
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			Process p = Runtime.getRuntime().exec("getmac /fo csv /nh");
			BufferedReader in = new java.io.BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			line = in.readLine();        
			String[] macAdre = line.split(",");
			result=macAdre[0].replace('"','\0').trim();
			//for mac 
			}else {
				for( NetworkInterface ni : Collections.list( NetworkInterface.getNetworkInterfaces() ) ){
					byte[] hardwareAddress = ni.getHardwareAddress();
					if( hardwareAddress != null ){
						for ( int i = 0; i < hardwareAddress.length; i++ )
							result += String.format( (i==0?"":"-")+"%02X", hardwareAddress[i] );
					}
				}
			}
		return result;
	}
	
	/**
	 * Localhost auslesen.
	 * @return Localhost
	 * @throws UnknownHostException Hostname
	 */
	public String getLocalHost() throws UnknownHostException {
		
		String result ="";
		result= InetAddress.getLocalHost().getHostName();
		
		return result;
		
	}
	/**
	 * angemeldete Domaine auslesen.
	 * @return domain
	 * @throws IOException commandbefehl
	 */
	public String getMachindomain() throws IOException {
		
		String domain="";
		String line;
		Process ipfconfig = null;
		Reader input = null;
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			while((line=resultOutput.readLine()) != null){
				if(line.contains("DNS-Suffixsuchliste")){
					domain=line.split(":\\s")[1];
				}
			}
		}else {
			ipfconfig = Runtime.getRuntime().exec("cat /etc/resolv.conf");
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			
			while((line=resultOutput.readLine())!= null){
				//System.out.println(line);
				if(line.contains("domain")){
					domain=line.split("\\s")[1];
				}
			}
		}
		
		return domain;
	}
	
	/**
	 * Subnetzmask berechnnen und darstellen.
	 * @return submasl
	 * @throws SocketException IpAdress
	 * @throws IOException Localhost
	 */
	public String getSubnetMask() throws SocketException, IOException {
		
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		short prflen= networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
		int shft = 0xffffffff<<(32-prflen);
		int oct1 = ((byte) ((shft&0xff000000)>>24)) & 0xff;
		int oct2 = ((byte) ((shft&0x00ff0000)>>16)) & 0xff;
		int oct3 = ((byte) ((shft&0x0000ff00)>>8)) & 0xff;
		int oct4 = ((byte) (shft&0x000000ff)) & 0xff;
		String submask = oct1+"."+oct2+"."+oct3+"."+oct4+"/"+prflen;
		
		return submask;
		
	}
	
	/**
	 * Gateway auslesen.
	 * @return defaultgateway
	 * @throws IOException commandbefehl
	 */
	public String getDefaultgateway() throws IOException {
		
		String defaultgateway="";
		String line;
		Process ipfconfig=null;
		Reader input = null;
		if (getOSversion().contains("W")||getOSversion().contains("w") ) {
			ipfconfig= Runtime.getRuntime().exec("netsh interface ip show config");
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			while( (line=resultOutput.readLine()) != null ) {
				if(line.contains("Standardgateway")) {
					defaultgateway=line.split(":\\s")[1].trim();
				}
			}
		}else {
			ipfconfig = Runtime.getRuntime().exec("netstat -nr");
			input = new InputStreamReader(ipfconfig.getInputStream());
			
			BufferedReader resultOutput = new BufferedReader(input);
			
			while((line=resultOutput.readLine())!= null){
				if(line.contains("default")){
					Pattern p = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
					Matcher m = p.matcher(line);
					if (m.find())
						defaultgateway= m.group();
				}
			}
		}
		
		return defaultgateway;
	}
	
	/**
	 * DHCP serveradresse auslesen.
	 * @return dhcpserver
	 * @throws IOException commandbefehl
	 */
	public String getDHCPServer() throws IOException {
		
		String dhcpserver="";
		String line;
		Reader input = null;
		Process ipfconfig= null; 
		
		if(getOSversion().contains("W")||getOSversion().contains("w")){
			ipfconfig= Runtime.getRuntime().exec("ipconfig /all");
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			while((line=resultOutput.readLine()) != null) {
				if(line.contains("DHCP-")) {
				dhcpserver=line.split(":\\s")[1];
				}
			}
		}else {
			//netstat -nr | grep default | awk '{print $2}';
			ipfconfig = Runtime.getRuntime().exec("cat /etc/resolv.conf");
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			
			while((line=resultOutput.readLine())!= null){
				//System.out.println(line);
				if(line.contains("nameserver")){
					dhcpserver=line.split("\\s")[1];
				}
			}
		}
		
		return dhcpserver;
	}
	
	/**
	 * DNS serveradresse auslesen.
	 * @return dnsserver
	 * @throws IOException commandbefehl
	 */
	public String getDNSServer() throws IOException{
		
		String dnsserver="";
		String line;
		Process ipfconfig= null;
		Reader input = null;
		
		if(getOSversion().contains("W")||getOSversion().contains("w")){
			ipfconfig = Runtime.getRuntime().exec("ipconfig /all");
			
			input = new InputStreamReader(ipfconfig.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			
			while((line=resultOutput.readLine())!= null){
				if(line.contains("DNS-Server")){
					dnsserver=line.split(":\\s")[1];
				}
			}
		}else {
				ipfconfig = Runtime.getRuntime().exec("cat /etc/resolv.conf");
				input = new InputStreamReader(ipfconfig.getInputStream());
				BufferedReader resultOutput = new BufferedReader(input);
				
				while((line=resultOutput.readLine())!= null){
					//System.out.println(line);
					if(line.contains("nameserver")){
						dnsserver=line.split("\\s")[1];
					}
				}
		}
		
		return dnsserver;
	}
	/**
	 * Schulnummer Pr&uuml;fen ob es korrekt eingetragen ist.
	 * Ein Hinweis als info wird dargestellt
	 * @return true/false
	 * @throws Throwable HostName
	 */
	public boolean pruefeSchulnr() throws Throwable {
		
		if (getSchulNummer().length()==4){
			if ((getSchulNummer().equals("")) || (getSchulNummer().contains("0000"))) {
				return false;
			}else 
				return true;
		}
		return  false;
	}
	
	/************************************************************************************************************/
	/************************************** PRINTING * @throws Throwable ****************************************/
	/**
	 * Print Information in der Console 
	 * @throws Throwable Hostname Localhost
	 */
	public void printBGinfo() throws Throwable{
	
		C4H_PC_INFO_KLASSE BG = new C4H_PC_INFO_KLASSE();
	
		System.out.println("3S");
		System.out.println("BG_Info");
		System.out.println("time to build :"+ BG.timetoBuild());
		System.out.println("*********************************");	
		System.out.println("Schul-Support-Services HiTEC e.V.");
		
		System.out.println("*********************************");
		System.out.println("            PC Info              ");
		System.out.println("*********************************");
		System.out.println("Host Name     :"+ BG.getLocalHost());
		System.out.println("User Name     :"+ BG.getUserName());
		System.out.println("SchulNummer   :"+ BG.getSchulNummer());
		System.out.println("OS Version    :"+ BG.getOSversion());
		System.out.println("OS Architektur:"+ BG.getOSArchitecture());
		System.out.println("Muster Images :"+ BG.getMusterImages());
		System.out.println("Rechner Typen :"+ BG.getRechnertypen());
		
	
		System.out.println("*********************************");
		System.out.println("            NETZWERK             ");
		System.out.println("*********************************");
	
		System.out.println("Adresse local  :"+ BG.getLocalAdresse());
		System.out.println("Subnet Mask    :"+ BG.getSubnetMask());
		System.out.println("MAC Adresse    :"+ BG.getMacAddress());
		System.out.println("Machine Domain :"+ BG.getMachindomain());
		System.out.println("Default Gateway:"+ BG.getDefaultgateway());
		System.out.println("DHCP Server    :"+ BG.getDHCPServer());
		System.out.println("DNS Server     :"+ BG.getDNSServer());
		
		
		try {
			System.out.println("Pruenfung der Schulnummer: "+BG.getSchulNummer()+" is "+ BG.pruefeSchulnr());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
}
