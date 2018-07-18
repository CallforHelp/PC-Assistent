package src.c4h;


/**
 * Main Methode zum Starten der APP C4H
 * @author  Helmi Bani 
 * @version 1.0
 * 
 * */
public class C4H {

	/**A Main To Start C4H
	 * @param args Keine Argumente Nötig 
	 * @throws Throwable Gui-Start
	 */
	public static void main(String[] args) throws Throwable{	
		
		C4H_GUI_TRAY_ICON start=new C4H_GUI_TRAY_ICON();
		
		try {
			start.createshowGui();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
