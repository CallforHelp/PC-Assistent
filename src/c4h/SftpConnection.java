package src.c4h;

import java.io.*;
import java.util.Vector;

import com.jcraft.jsch.*;

public class SftpConnection {
	 
	private  String _FTP_HOST ;
	private  String _USER_NAME ;
	private  String _USER_PWD ;
	private  int    _PORT      ;
	BG_Info bg =new BG_Info();
	Session session = null;
	ChannelSftp channel= null;
	String remoteDstFilePath= "/standort/";
	File fileWithSchooNumber=null;
	File filesDirectory = null;
	
	
	public static void main(String[] args) throws IOException {
		SftpConnection clientSftp = null;
		if( args == null || args.length < 4 ) {
	         System.out.println( "Fehler: Parameter fehlen." );
	         System.exit( 1 );
		}else {
			clientSftp = new SftpConnection(args[0],args[1],args[2],args[3]);
			try {
				clientSftp.createNewFileWithSchoolNumber("1234");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		clientSftp.closeSFTPConnection();
		clientSftp.deleteNewFileWithSchoolNumber();
	}
	
	public SftpConnection( String benutzername, String passwort, String host, String port ) throws IOException{
		this._FTP_HOST=host;
		this._USER_NAME= benutzername;
		this._USER_PWD=passwort;
		this._PORT= Integer.parseInt(port);
		 /*
		  *  Die erste Option (StrictHostKeyChecking) schaltet die R�ckfragen aus, 
		  *  die eine SSH-Installation �blicherweise dann stellt,
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
		 
		 try {
			channel = (ChannelSftp) session.openChannel( "sftp" );
			channel.connect();
		} catch (JSchException e) {
			System.out.println(e);
			
		}

	}
	
	public  void uploadFileWithSchoolNumber() throws Exception {
		//channel.rm("/standort/"+bg.getSchulNummer());
		try {
			if (!isFileExistInSFTP(remoteDstFilePath+bg.getSchulNummer())) 
				channel.put(createNewFileWithSchoolNumber(bg.getSchulNummer()), remoteDstFilePath);
	      } catch(SftpException ex) {
	    	  ex.printStackTrace();
	    	  System.out.println(ex.getMessage());
	      }
		closeSFTPConnection();
		deleteNewFileWithSchoolNumber();
		
	}
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

	public String getLocalActualDir() throws SftpException{
		return channel.getHome();
	}
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
		fileWithSchooNumber.getAbsolutePath();
		return fileWithSchooNumber.getAbsolutePath();
		
		
	}
	public void deleteNewFileWithSchoolNumber() {
		System.out.println(filesDirectory.getPath());
		fileWithSchooNumber.delete();
		filesDirectory.delete();
	}
	private void closeSFTPConnection() {
		channel.disconnect();
		session.disconnect();
	}
}
