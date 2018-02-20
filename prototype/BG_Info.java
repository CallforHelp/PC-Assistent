package prototype;


import java.net.*;
import java.util.*;

public class BG_Info {
	
	public static void main(String[] args) throws Exception {
		BG_Info BG = new BG_Info();
		
		System.out.println("Was brauche ich für BG_Info:  \n");
		System.out.println("********************************");
		
		System.out.println("Host Name : " + BG.getLocalHost());
		System.out.println("MAC Adresse: "+BG.getMacAddress());
		System.out.println("Adresse local: " + BG.getLocalAdresse());
		

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

	public String getLocalAdresse() throws UnknownHostException {
		String result ="";
		result= result + InetAddress.getLocalHost().getHostAddress();
		return result;
		
	}
	
	public  String printBGINFO() throws UnknownHostException, SocketException {
		
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
	

}
