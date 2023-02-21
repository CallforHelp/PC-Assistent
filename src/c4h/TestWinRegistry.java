package src.c4h;




import java.io.BufferedReader;
import java.io.InputStreamReader;

	public class TestWinRegistry {
		public static void main(String argv[])throws Exception{
			String PATH = "powershell.exe (Get-ItemProperty -Path 'HKLM:\\\\SOFTWARE\\\\Microsoft\\\\Windows\\\\CurrentVersion\\\\OEMInformation' -Name 'Modell').Modell";
			Process modellAusRegistry= Runtime.getRuntime().exec(PATH);
			InputStreamReader input = new InputStreamReader(modellAusRegistry.getInputStream());
			BufferedReader resultOutput = new BufferedReader(input);
			
			String line;
			if((line=resultOutput.readLine()) != null)
				System.out.println(line);
			else System.out.println("nix");
			
	
	}
}



