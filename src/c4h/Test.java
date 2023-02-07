package src.c4h;

import java.util.Enumeration;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		


		Properties p = new Properties(System.getProperties());
		Enumeration<?> e = p.propertyNames();
		String property = null;
		String propertyValue = null;
		while (e.hasMoreElements()) {
			property = (String) e.nextElement();
			propertyValue = p.getProperty(property);
			//System.out.println(property + " = " + propertyValue);
		}
		String str = System.getenv("path");
		System.out.println(str.replaceAll(";", "\n"));



	}

}
