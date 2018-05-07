package src.c4h;

import java.io.*;
import com.jcraft.jsch.*;

public class SftpConnection {
	 
	private  String _FTP_HOST ;
	private  String _USER_NAME ;
	private  String _USER_PWD ;
	private  int    _PORT      ;	
	Session session = null;
	ChannelSftp channel= null;
	
	public static void main(String[] args) throws IOException {
		SftpConnection clientSftp = null;
		if( args == null || args.length < 4 ) {
	         System.out.println( "Fehler: Parameter fehlen." );
	         System.exit( 1 );
		}else {
			clientSftp = new SftpConnection(args[0],args[1],args[2],args[3]);
			try {
				clientSftp.getLocalActualDir();
				System.out.println(""+clientSftp.getLocalActualDir());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public SftpConnection( String benutzername, String passwort, String host, String port ) throws IOException{
		this._FTP_HOST=host;
		this._USER_NAME= benutzername;
		this._USER_PWD=passwort;
		this._PORT= Integer.parseInt(port);
		 /*
		  *  Die erste Option (StrictHostKeyChecking) schaltet die Rückfragen aus, 
		  *  die eine SSH-Installation üblicherweise dann stellt,
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
		
		try {
	         channel.put( "localSrcFilePath", "remoteDstFilePath" );
	      } catch( SftpException ex ) {
	         throw new IOException( ex );
	      }
		
	}
	public String getLocalActualDir() throws SftpException
	   {
	      return channel.getHome();
	   }
}
