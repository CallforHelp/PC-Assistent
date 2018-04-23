
package bginfo;

import java.io.*;
import java.util.*;
import java.net.*;

public class WebsiteReader {
	
	String webSeite ="https://fehlermeldung.3s-hamburg.de"; 
	BG_Info bginfo= new  BG_Info();
	//browser starten
	public void openWebSiteExample() throws IOException {
		
		System.out.println("standard browswer wird aufgerufen");
		if(bginfo.getOSversion().contains("W")||bginfo.getOSversion().contains("w")) { 
			new ProcessBuilder(new String[] { "cmd", "/c", "start",webSeite }).start();
			}else {
				new ProcessBuilder(new String[] {"open",webSeite}).start();
			}
		}
	//quelltext ausdrucken
	public void webScraperExample () throws MalformedURLException, IOException{
	    Scanner scanner = new Scanner(new URL(webSeite).openStream());
	        while(scanner.hasNextLine()){
	            System.out.println(scanner.nextLine());
	        }
	        scanner.close();
	    }
	//quelltext in Dateispeichern
	public void startFIleInput() {
        File file = new File("temp.txt");
        FileOutputStream ausgabe = null;
           try {
               ausgabe = new FileOutputStream(file);
           } catch (FileNotFoundException e1) {
               e1.printStackTrace();
           }
           DataOutputStream raus = new DataOutputStream(ausgabe);
           String test=new WebsiteReader().
        		   getStrFromUrl(webSeite);
           try {
               raus.writeBytes(test);
           } catch (IOException e) {
               e.printStackTrace();
           }
           System.out.println(test);
      
   }
  
	//quellext ausdrucken
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