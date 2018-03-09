package prototype;

import java.net.*;
import java.io.*;

public class Login {

    // Variables to hold the URL object and its connection to that URL.
    private static URL URLObj;
    private static URLConnection connect;
	
    public static void main(String[] args) {
        try {
            // Establish a URL and open a connection to it. Set it to output mode.
            URLObj = new URL("https://hades.3s-desk.de/login.php");
            connect = URLObj.openConnection();
            connect.setDoOutput(true);	
        }
        catch (MalformedURLException ex) {
            System.out.println("The URL specified was unable to be parsed or uses an invalid protocol. Please try again.");
            System.exit(1); 
        }
        catch (Exception ex) {
            System.out.println("An exception occurred. " + ex.getMessage());
            System.exit(1);
        }		
        try {
            // Create a buffered writer to the URLConnection's output stream and write our forms parameters.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connect.getOutputStream()));
            writer.write("username=helmi&pass=IntiHel27&submit=Login");
            writer.close();
			
            // Now establish a buffered reader to read the URLConnection's input stream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			
            String lineRead = "";
			
            // Read all available lines of data from the URL and print them to screen.
            while ((lineRead = reader.readLine()) != null) {
                System.out.println(lineRead);
            }
			
            reader.close();
        }
        catch (Exception ex) {
            System.out.println("There was an error reading or writing to the URL: " + ex.getMessage());
        }
    }
}
