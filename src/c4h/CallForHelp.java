package src.c4h;


public class CallForHelp {

	public static void main(String[] args) throws Throwable{	
		
		CallForaHelpGUI start=new CallForaHelpGUI();
		
		try {
			start.createshowGui();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
