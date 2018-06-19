package src.c4h;

import java.io.*;
import java.util.Vector;

import com.jcraft.jsch.*;

/**
 * @author bani
 *
 */
public class C4H_SFTP_TO_USE {
	//local Field
	/**
	 * 
	 */
	private  int    _PORT;
	/**
	 * 
	 */
	private  String _FTP_HOST ;
	/**
	 * 
	 */
	private  String _USER_NAME ;
	/**
	 * 
	 */
	private  String _USER_PWD ;
	/**
	 * 
	 */
	private String remoteDstFilePath= "/standort/";
	
	//local Object
	/**
	 * 
	 */
	protected Session session = null;
	/**
	 * 
	 */
	protected ChannelSftp channel= null;
	
	/**
	 * 
	 */
	File fileWithSchooNumber=null;
	/**
	 * 
	 */
	File filesDirectory = null;
	
	
	/**
	 * @param benutzername
	 * @param passwort
	 * @param host
	 * @param port
	 * @throws Exception
	 */
	public C4H_SFTP_TO_USE( String benutzername, String passwort, String host, String port ) throws Exception{
		this._FTP_HOST=host;
		this._USER_NAME= benutzername;
		this._USER_PWD=passwort;
		this._PORT= Integer.parseInt(port);
		 /*
		  *  Die erste Option (StrictHostKeyChecking) schaltet die R�ckfragen aus, 
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
	 * @throws Throwable
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
	 * @param schoolNamePath
	 * @return
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
	 * @return
	 * @throws SftpException
	 */
	public String getLocalActualDir() throws SftpException{
		return channel.getHome();
	}
	/**
	 * @param schoolNumber
	 * @return
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
	 * 
	 */
	public void deleteNewFileWithSchoolNumber() {
		if(fileWithSchooNumber!=null)
			fileWithSchooNumber.delete();
		if (filesDirectory!=null)
			filesDirectory.delete();
	}
	/**
	 * 
	 */
	private void closeSFTPConnection() {
		if (channel!=null)
			channel.disconnect();
		if(session!=null)
		session.disconnect();
	}
}
