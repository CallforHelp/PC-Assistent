
package src.c4h;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 * Website Reader &ouml;ffnen Details und Connect
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_WEBSITE_START  {
	
	/**
	 * Standart Website zum Fehlermelden
	 */
	String webSeite ="http://fehlermeldung.3s-hamburg.de";
	private C4H_PC_INFO_KLASSE bginfo; 
	
	//browser starten
	/**
	 * Browser start egal mit welchen OS
	 * @throws Throwable Hostname
	 */
	public void openWebSite()throws Throwable  {
		C4H_PC_INFO_KLASSE bginfo= new  C4H_PC_INFO_KLASSE();
		
		String senschoolNumber = "?schulnummer="+bginfo.getSchulNummer();
		String pcName = "^&pcname="+bginfo.getLocalHost();
		
		System.out.println(webSeite+senschoolNumber+pcName);
		
		System.out.println("standard browswer wird aufgerufen");
		if(bginfo.getOSversion().contains("W")||bginfo.getOSversion().contains("w")) { 
			new ProcessBuilder(new String[] { "cmd", "/c","start",(webSeite+senschoolNumber+pcName)}).start();
		}else {
			new ProcessBuilder(new String[] {"open",(webSeite+senschoolNumber+pcName)}).start();
		}
	}
	public void openWebSiteExample(String URL)throws Throwable  {
		
		System.out.println("standard browswer wird aufgerufen");
		if(bginfo.getOSversion().contains("W")||bginfo.getOSversion().contains("w")) { 
			new ProcessBuilder(new String[] { "cmd", "/c","start",(URL)}).start();
		}else {
			new ProcessBuilder(new String[] {"open",(URL)}).start();
		}
	}
	//quelltext ausdrucken
	/**
	 * Liest einzelne Quelltext Schreibt es in der konsole aus
	 * @throws MalformedURLException Format
	 * @throws IOException EinAusgabe
	 */
	public void webScraper () throws MalformedURLException, IOException{
	    Scanner scanner = new Scanner(new URL(webSeite).openStream());
	        while(scanner.hasNextLine()){
	            System.out.println(scanner.nextLine());
	        }
	        scanner.close();
	    }
	//quelltext in Dateispeichern
	/**
	 * Schreibe webseiten Inhalt in einer Datei
	 */
	public void startFIleInput() {
        File file = new File("temp.txt");
        FileOutputStream ausgabe = null;
           try {
               ausgabe = new FileOutputStream(file);
           } catch (FileNotFoundException e1) {
               e1.printStackTrace();
           }
           DataOutputStream raus = new DataOutputStream(ausgabe);
           String test=new C4H_WEBSITE_START().
        		   getStrFromUrl(webSeite);
           try {
               raus.writeBytes(test);
           } catch (IOException e) {
               e.printStackTrace();
           }
           System.out.println(test);
      
   }
  
	//quellext ausdrucken
 /**
  * Quelltext der Seite auslesen und ausdrucken
  *  @param surl SeitenURL
  *  @return Text mit seitenquelltext 
  */
private String getStrFromUrl(String surl){
       
	   String str=null;
       String str1=null;
       try {
    	   URL url = new URL(surl);
           URLConnection conn = url.openConnection();
          
           BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          
           str = new String();
           while ((str1 = in.readLine()) != null) {
               str = str +"\r\n"+ str1;
           }
           
           in.close();
           
           return str;
       }catch (MalformedURLException e){
    	   System.out.println( e.getMessage());
           }catch (IOException e){
        	 System.out.println( e.getMessage());
        	 }
       return str;
   }
	
    
	
}