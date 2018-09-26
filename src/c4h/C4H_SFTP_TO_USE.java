package src.c4h;

import java.io.*;
import java.util.Vector;

import com.jcraft.jsch.*;
/**
 * SFTP Client zum speichern von Rechner-information auf den c4H-Server. 
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H_SFTP_TO_USE {
	//local Field
	/**
	 * PORT
	 */
	private  int    _PORT;
	/**
	 * HOST
	 */
	private  String _FTP_HOST ;
	/**
	 * USER_NAME
	 */
	private  String _USER_NAME ;
	/**
	 * USER_PWD
	 */
	private  String _USER_PWD ;
	/**
	 * PFAD ORDNER
	 */
	private String remoteDstFilePath= "/standort/";
	
	//local Object
	/**
	 * Session
	 */
	protected Session session = null;
	/**
	 * chanel
	 */
	protected ChannelSftp channel= null;
	
	/**
	 * Ordnername
	 */
	File fileWithSchooNumber=null;
	/**
	 * Dateiname
	 */
	File filesDirectory = null;
	
	
	/**
	 * Ein construktor +Argumente zur Verbindung in c4H-Server.
	 * der ClientID ist immer gleich
	 * @param benutzername user
	 * @param passwort pass
	 * @param host hostname
	 * @param port port nummer SFTP
	 * @throws Exception Hostname LocalHost PortNumber
	 */
	public C4H_SFTP_TO_USE( String benutzername, String passwort, String host, String port ) throws Exception{
		this._FTP_HOST=host;
		this._USER_NAME= benutzername;
		this._USER_PWD=passwort;
		this._PORT= Integer.parseInt(port);
		 /*
		  *  Die erste Option (StrictHostKeyChecking) schaltet die R&uuml;ckfragen aus, 
		  *  die eine SSH-Installation ueblicherweise dann stellt,
		  *   wenn Sie sich das erste Mal mit dem jeweiligen Host verbinden
		  */
		
		try {
			session = (new JSch()).getSession( _USER_NAME,_FTP_HOST , _PORT );
			session.setPassword(_USER_PWD);
			session.setConfig("StrictHostKeyChecking", "no");
	        session.connect();
		} catch (JSchException e) {
			System.out.println(e);
		}
		if (session.isConnected())
			System.out.println("session is READY: "+session.isConnected());
		try{
			channel = (ChannelSftp) session.openChannel( "sftp" );
			channel.connect();
			if(channel.isConnected())
				System.out.println("Channel is Ready: "+channel.isConnected());
			
		} catch (JSchException e) {
			System.out.println(e);
		}

	}
	
	/**
	 * Schreibe in einer Datei die Schulnummer.
	 * @throws Throwable Hostname
	 */
	public  void uploadFileWithSchoolNumber() throws Throwable {
		C4H_PC_INFO_KLASSE bg = new C4H_PC_INFO_KLASSE();
		//channel.rm("/standort/"+bg.getSchulNummer());
		try {
			if (!isFileExistInSFTP(remoteDstFilePath+bg.getSchulNummer())) { 
				channel.put(createNewFileWithSchoolNumber(bg.getSchulNummer()), remoteDstFilePath);
			}else 
				System.out.println("Datei Vorhanden");
	      } catch(SftpException ex) {
	    	  ex.printStackTrace();
	    	  System.out.println(ex.getMessage());
	      }
		closeSFTPConnection();
		deleteNewFileWithSchoolNumber();
		
	}
	/**
	 * Pr&uuml; ob die Schulnummer schon im SFTP vorhanden ist.
	 * @param schoolNamePath DateiName
	 * @return Richtig/Faslch
	 */
	@SuppressWarnings("static-access")
	public boolean isFileExistInSFTP(String schoolNamePath) {
		@SuppressWarnings("rawtypes")
		Vector res = null;
		try {
			res = channel.ls(schoolNamePath);
		} catch (SftpException e) {
			if (e.id== channel.SSH_FX_NO_SUCH_FILE) {
				System.out.println("File ist not Exist"+e.id+ e.getMessage());
				return false;
			}
		}
		return res !=null && !res.isEmpty();
	}

	/**
	 * gibt den Pfad im SFTP zuruuml;ck.
	 * @return Pfad 
	 * @throws SftpException Verbindungsuafbau
	 */
	public String getLocalActualDir() throws SftpException{
		return channel.getHome();
	}
	/**
	 * Erstelle ein Dokument mit dem Schulnummer als Inhalt.
	 * @param schoolNumber Schulnummer
	 * @return DokumentName 
	 */
	public String createNewFileWithSchoolNumber(String schoolNumber) {
		
		//create directory
		
		filesDirectory = new File("c:\\standort\\");
        if (!filesDirectory.exists()) {
            if (filesDirectory.mkdirs()) {
                System.out.println("directories are created!");
            } else {
                System.out.println("Failed to create directorie!");
            }
        }

		//create File
		try {
			fileWithSchooNumber = new File(filesDirectory.getPath()+"\\"+schoolNumber);
			if (fileWithSchooNumber.createNewFile()){
		        System.out.println("File is created!");
		      }else{
		        System.out.println("File already exists.");
		      }
		      
	    	} catch (IOException e) {
		      e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileWithSchooNumber))) {
			bw.write(schoolNumber);
			bw.close();
			System.out.println("Done ist written the schoolNumber");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		fileWithSchooNumber.getAbsolutePath();
		return fileWithSchooNumber.getAbsolutePath();
		
		
	}
	/**
	 * Reset alles 
	 * Delete Objekte
	 * no Returns
	 */
	public void deleteNewFileWithSchoolNumber() {
		if(fileWithSchooNumber!=null)
			fileWithSchooNumber.delete();
		if (filesDirectory!=null)
			filesDirectory.delete();
	}
	/**
	 * Schliesse die Verbindung
	 */
	private void closeSFTPConnection() {
		if (channel!=null)
			channel.disconnect();
		if(session!=null)
		session.disconnect();
	}
}
