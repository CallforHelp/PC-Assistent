package src.c4h;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
 
public class WindowsReqistry {
 
    /**
     * 
     * @param location path in the registry
     * @param key registry key
     * @return registry value or null if not found
     */
    public static final String readRegistry(String location, String key){
        try {
            // Run reg query, then read output with StreamReader (internal class)
        	
        	Process process = Runtime.getRuntime().exec("reg query "+'"'+ location + "\" /v " + key);
            System.out.println("reg query "+ location + " /v " + key);
            StreamReader reader = new StreamReader(process.getInputStream());
            
            reader.start();
            process.waitFor();
            reader.join();
            
            String musterImages ="";
            // Parse out the value
            System.out.println(reader.getResult());
            if (reader.getResult().contains("REG")){
				musterImages=reader.getResult().split("REG_SZ")[1].trim();
			}	
//            String[] parsed = reader.getResult().split("\\s+");
            
            return musterImages;
            
        } catch (Exception e) {}
 
        return null;
    }
 
    static class StreamReader extends Thread {
        private InputStream is;
        private StringWriter sw= new StringWriter();
 
        public StreamReader(InputStream is) {
            this.is = is;
        }
 
        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1)
                    sw.write(c);
            } catch (IOException e) { 
            }
        }
 
        public String getResult() {
            return sw.toString();
        }
    }
    public static void main(String[] args) {
 
        // Sample usage
        String value = WindowsReqistry.readRegistry("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\OEMInformation", "Model");
        System.out.println(value);
    }
}