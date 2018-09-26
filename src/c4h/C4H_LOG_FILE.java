package src.c4h;
/**
 * Eine Klasse für Monitoringprocess
 * ist noch nicht Aktiv in dies Tool wird mit dem nauml;chsten Update 
 * Aktiviert
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class C4H_LOG_FILE {
  
  FileWriter writer;
  File file;
  
  public void schreiben(String loginfotext){  
	  // File anlegen 
     file = new File("FileWriterTest.txt");
     try {
       // new FileWriter(file ,true) - falls die Datei bereits existiert
       // werden die Bytes an das Ende der Datei geschrieben
       
       // new FileWriter(file) - falls die Datei bereits existiert
       // wird diese uuml;berschrieben
       writer = new FileWriter(file ,true);
       
       // Text wird in den Stream geschrieben
       writer.write(loginfotext);
       
       // Platformunabhuuml;ngiger Zeilenumbruch wird in den Stream geschrieben
       writer.write(System.getProperty("line.separator"));
       
       // Schreibt den Stream in die Datei
       // Sollte immer am Ende ausgef�hrt werden, sodass der Stream 
       // leer ist und alles in der Datei steht.
       writer.flush();
       
       // Schliesst den Stream
       writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}