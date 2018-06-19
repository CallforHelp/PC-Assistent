package src.c4h;


/**
 * Main Methode zum Starten der APP C4H
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class CallForHelp {

	/**A Main To Start C4H
	 * @param args Keine Argumente Nötig 
	 * @throws Throwable GuiStart
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
