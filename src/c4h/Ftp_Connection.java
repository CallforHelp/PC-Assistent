package src.c4h;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


public class Ftp_Connection {
	private  final String FTP_HOST           = "";
	private  final String _USER_NAME         = "";
	private  final String _USER_PWD          = "";
	private String schulNummer        = "";
	private  FTPClient ftp                   = null;

	public static void main(String[] args) {
		Ftp_Connection ftp = new Ftp_Connection("schulnummer");
		ftp.loginToFtp();
	}
	public Ftp_Connection(String schulnummer) {
		// TODO Auto-generated constructor stub
		this.schulNummer=schulnummer;
		ftp = new FTPClient();
	}
	public void loginToFtp() {
		try {
			ftp.connect(FTP_HOST);
			showServerReply(ftp);
            int replyCode = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
			boolean success = ftp.login(_USER_NAME, _USER_PWD);
            showServerReply(ftp);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Fehler : "+ e);
		}
		
	}
	
	private void showServerReply(FTPClient ftp) {
		String[] replies = ftp.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
		    }
		}
	}
	
	public String UplaoadToFtp() {
		return schulNummer;
	}

}
