package src.c4h;


/**
 * @author bani
 *
 */
public class CallForHelp {

	/**
	 * @param args
	 * @throws Throwable
	 */
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
