package bginfo;

public class CallForHelp {

	public static void main(String[] args){	
		
		ShowGUI start=new ShowGUI();
		try {
			start.createshowGui();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
