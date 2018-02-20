package prototype;

import java.io.*;
import java.net.*;

public class PostToUrl
{
   public static void main( String[] args )
   {
      if( 2 != args.length ) {
         System.out.println( "\nSend data per HTTP POST Request.\n" +
                             "Usage: java PostToUrl url \"parm1=val1&parm2=val2\" \n" );
         System.exit( 1 );
      }
      System.out.println( "\nURL:  " + args[0] );
      System.out.println( "Data: " + args[1] );
      System.out.println( "Response:" );

      OutputStream os = null;
      InputStream  is = null;

      try {
         // Connection:
         URL           url = new URL( args[0] );
         URLConnection con = url.openConnection();
         if( !(con instanceof HttpURLConnection) )
            throw new Exception( "Error: Only HTTP allowed." );
         ((HttpURLConnection) con).setRequestMethod( "POST" );
         con.setDoOutput( true );
         // Send data:
         os = con.getOutputStream();
         os.write( args[1].getBytes() );
         os.flush();
         // Read response:
         is = con.getInputStream();
         int len;
         byte[] buff = new byte[4096];
         while( -1 != (len = is.read( buff )) ) {
            System.out.print( new String( buff, 0, len ) );
         }
         System.out.println();
       } catch( Exception ex ) {
         System.out.println( "\nError: " + ex );
       } finally {
         if( os != null ) try { os.close(); } catch( IOException ex ) {/*ok*/}
         if( is != null ) try { is.close(); } catch( IOException ex ) {/*ok*/}
       }
   }
}