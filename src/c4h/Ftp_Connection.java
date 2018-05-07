package src.c4h;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class Ftp_Connection {
	private  final String FTP_HOST           = "";
	private  final String _USER_NAME         = "";
	private  final String _USER_PWD          = "";
	private        String schulNummer        = "";
	private  FTPClient ftp                   = null;

	public static void main(String[] args) {
		Ftp_Connection ftp = new Ftp_Connection("schulnummer");
		ftp.loginToFtp();
	}
	public Ftp_Connection(String schulnummer) {
		this.schulNummer=schulnummer;
		loginToFtp();
	}
	public void loginToFtp() {
		ftp = new FTPClient();
		try {
			ftp.connect(FTP_HOST);
			boolean success = ftp.login(_USER_NAME, _USER_PWD);
            if (!success) {
                System.out.println("Could not login to the server");
            } else {
                System.out.println("LOGGED IN SERVER");
            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fehler : "+ e);
		}
		
	}
	
	public void downloadFtp() {
		
	}
	public void deleteFileFTP()throws IOException{
		String filename = "schulnummer"+""+".txt";
	    boolean deleted = ftp.deleteFile(filename);
	    if (deleted) {
	      System.out.println("File deleted...");
	    }

	    ftp.logout();
	    ftp.disconnect();
	}
	public void UplaoadToFtp() throws IOException{
		FileInputStream fis = null;
		String filename = "schulnummer"+""+".txt";
		fis = new FileInputStream(filename);
	    ftp.storeFile(filename, fis);
	    ftp.logout();
	    fis.close();
		
	}

}
