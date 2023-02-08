package src.c4h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
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
	
	private final int RechnerTypLaenge = 4;
	//private C4H_LOG_FILE pcInfoLog = new C4H_LOG_FILE();
	public String toolTipFehlerHinweisText;
	ArrayList<String> list = new ArrayList<>();
	String schulNummer="";
	
	/**
	 * Die Schulnummer muss erstellt werden damit f&uuml;r die Fehleranmeldung sofort mitgenommen wird.
	 * SchulNummer erstellen 
	 * @throws Throwable Hostname
	 */
	public C4H_PC_INFO_KLASSE() {
		
		try {
			settSchulNummer();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
		String userName = new Properties(System.getProperties()).getProperty("user.name");
		if(userName==""||userName==null)
			return "Fehler-UserName";
		return userName;
		}return "Mac-Rechner";
	}
	
	/**
	 * Hier wird anhand der HostName die SchuleNummer ausgelesen. 
	 * @return Schulnummer
	 * @throws Throwable Hostname
	 */
	public String settSchulNummer() throws Throwable {
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
		Pattern p = Pattern.compile("[0-9]{4}");
		Matcher m = p.matcher(InetAddress.getLocalHost().getHostName());
		
		// match
		if (m.find())
			schulNummer= m.group();
		
		if(!pruefeSchulnr())
			this.schulNummer="Fehler-Schulnummer";
		return schulNummer;
		
		}else {
			this.schulNummer= "Fehler-SchulNummer";
			return schulNummer;
		}

	}
	/**
	 * Gibt Einfach die Schulnummer zurueck.
	 * @return schulNummer
	 * @throws Throwable Hostname
	 */
	public String getSchulNummer() throws Throwable {
		
		return "5063";
	}
	
	/**
	 * System Properties 
	 * Auslesen von OSName
	 * @return OsVersion
	 */
	public String getOSversion(){
		
		String OsVersion= new Properties(System.getProperties()).getProperty("os.name");
		if(OsVersion==""||OsVersion==null)
			return "Fehler OS-Version";
		return OsVersion;
	}
	
	/**
	 * Betriebsystemarchitektur
	 * @return OSArchitektur
	 */
	public String getOSArchitecture(){
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			String OsArch= new Properties(System.getProperties()).getProperty("os.arch");
			return OsArch;
		}else return "Mac-Rechner";
	}
	/**
	 * Muster Image von 3s
	 * die info bekommen wir aus dem Infobereich des Betriebsystems
	 * @return musterImages
	 * @throws IOException RegEintrag
	 */
	public String getMusterImages() throws Throwable{
		
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
		if(musterImages==""|| musterImages==null)
			return"Fehler-MusterImage";
		
		return musterImages;
	}
	/**
	 * RechnerTyp aus dem Hostname auslesen. 
	 * @return RechnerTyp
	 * @throws Exception Hostname
	 */
	public String getRechnertypen() throws Exception {
		
		String rechnerTyp="";
		
		
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			String hostname = InetAddress.getLocalHost().getHostName();
			for (int i = RechnerTypLaenge; i < (RechnerTypLaenge*2); i++) {
				rechnerTyp=rechnerTyp+(hostname.charAt(i));
			}
		}else {
			return "Mac-Rechner";
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
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			result= InetAddress.getLocalHost().getHostAddress();
			if(result=="")
				return "Fehler-Netzwerk";
			return result;
		}else 
			return "Fehler-Netzwerk";
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
				return "Mac Rechner ";
				/*for( NetworkInterface ni : Collections.list( NetworkInterface.getNetworkInterfaces() ) ){
					byte[] hardwareAddress = ni.getHardwareAddress();
					if( hardwareAddress != null ){
						for ( int i = 0; i < hardwareAddress.length; i++ )
							result += String.format( (i==0?"":"-")+"%02X", hardwareAddress[i] );
					*/
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
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
			result= InetAddress.getLocalHost().getHostName();
			if(result=="")
				return "Fehler-Netzwerk";
			return result;
		}else{
			return "Mac-Rechner";
		}
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
		if(domain=="")
			return "keine-Domain";
		
		return domain;
	}
	
	/**
	 * Subnetzmask berechnnen und darstellen.
	 * @return submasl
	 * @throws SocketException IpAdress
	 * @throws IOException Localhost
	 */
	public String getSubnetMask() throws SocketException, IOException {
		if(getOSversion().contains("W")||getOSversion().contains("w")) {
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		short prflen= networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
		int shft = 0xffffffff<<(32-prflen);
		int oct1 = ((byte) ((shft&0xff000000)>>24)) & 0xff;
		int oct2 = ((byte) ((shft&0x00ff0000)>>16)) & 0xff;
		int oct3 = ((byte) ((shft&0x0000ff00)>>8)) & 0xff;
		int oct4 = ((byte) (shft&0x000000ff)) & 0xff;
		String submask = oct1+"."+oct2+"."+oct3+"."+oct4+"/"+prflen;
		
		return submask;
		}else 
			return "Mac-Rechner";
		
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
		if(defaultgateway=="")
			return "Fehler-Netzwerk";
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
		if(dhcpserver=="")
			return "Fehler-Netzwerk";
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
		if(dnsserver=="")
			return "Fehler-Netzwerk";
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
	/**
	 * Es wird hier nochmal sicher gestellt dass die Version unser MusterImages 
	 * erstellt.
	 * Hinweis die Klasse tritt nur auf falls NULL beim Standard MUsterImage Ausgabe kommt
	 * 
	 * @return MusterImage aus der REG
	 * @throws IllegalArgumentException MusterImage
	 * @throws IllegalAccessException Value vom REG
	 * @throws InvocationTargetException Value vom REG
	 */
	public String getMusterImageAusRegistry() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String musterausdatei="";
		int HKEY_LOCAL_MACHINE= 0x80000002;
		if(getOSversion().contains("W")||getOSversion().contains("w")){
			musterausdatei = C4H_WIN_REGISTRY.readString(HKEY_LOCAL_MACHINE,"SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\OEMInformation","Model", 0);
			if(getOSversion().contains("7")) {
				if(musterausdatei.contains("Musterimage")) {
					String s=musterausdatei.split("Musterimage")[1].trim();
					musterausdatei=s;
				}
				System.out.println(musterausdatei);
			}
				
			if(musterausdatei==null)
				return "Fehler-MusterImage";
			if(musterausdatei.equals(""))
				return "Fehler-MusterImage";
			else 
				return musterausdatei;
		}else 
			return "Fehler-MusterImage";
	}
	
	/************************************************************************************************************/
	/************************************** PRINTING * @throws Throwable ****************************************/
	/**
	 * Print Information in der Console 
	 * @throws Throwable Hostname Localhost
	 */
	public void printBGinfo() throws Throwable{
	
		System.out.println("3S");
		System.out.println("BG_Info");
		System.out.println("time to build :"+ timetoBuild());
		System.out.println("*********************************");	
		System.out.println("Schul-Support-Services HiTEC e.V.");
		
		System.out.println("*********************************");
		System.out.println("            PC Info              ");
		System.out.println("*********************************");
		System.out.println("Host Name     :"+ getLocalHost());
		System.out.println("User Name     :"+ getUserName());
		System.out.println("SchulNummer   :"+ getSchulNummer());
		System.out.println("OS Version    :"+ getOSversion());
		System.out.println("OS Architektur:"+ getOSArchitecture());
		System.out.println("Muster Images :"+ getMusterImages());
		System.out.println("Rechner Typen :"+ getRechnertypen());
		
	
		System.out.println("*********************************");
		System.out.println("            NETZWERK             ");
		System.out.println("*********************************");
	
		System.out.println("Adresse local  :"+ getLocalAdresse());
		System.out.println("Subnet Mask    :"+ getSubnetMask());
		System.out.println("MAC Adresse    :"+ getMacAddress());
		System.out.println("Machine Domain :"+ getMachindomain());
		System.out.println("Default Gateway:"+ getDefaultgateway());
		System.out.println("DHCP Server    :"+ getDHCPServer());
		System.out.println("DNS Server     :"+ getDNSServer());
		
		
		try {
			System.out.println("Pruenfung der Schulnummer: "+getSchulNummer()+" is "+ pruefeSchulnr());
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public boolean getState() throws Throwable {
		
		//PC
		if (!list.isEmpty())
			list.removeAll(list);
		
		list.add(getLocalHost());
		list.add(getUserName());
		list.add(getSchulNummer());
		list.add(getOSversion());
		list.add(getOSArchitecture());
		list.add(getMusterImageAusRegistry());
		list.add(getRechnertypen());
		//Netzwerk
		list.add(getLocalAdresse());
		list.add(getSubnetMask());
		list.add(getMacAddress());
		list.add(getMachindomain());
		list.add(getDefaultgateway());
		list.add(getDHCPServer());
		list.add(getDNSServer());
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equalsIgnoreCase("Fehler-Netzwerk")||(list.get(i).equalsIgnoreCase("Fehler-MusterImage")||(list.get(i).equalsIgnoreCase("Fehler-Schulnummer")))) {
				toolTipFehlerHinweisText=list.get(i).replaceAll("Fehler-", "");
				System.out.println(toolTipFehlerHinweisText);
				return false;
			}
		}
		return true;
	}
	

		
}
