package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.DeterminingWhichResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class DeterminingWhichResourceBundle {

	static String pack = "ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.DeterminingWhichResourceBundle.";

	public static void main(String[] args) {
		Locale locale = new Locale("en", "CA");
		ResourceBundle rb = ResourceBundle.getBundle(pack + "Zoo", locale);
		System.out.print(rb.getString("hello"));
		System.out.print(". ");
		System.out.print(rb.getString("name"));
		System.out.print(" ");
		System.out.print(rb.getString("open"));
		System.out.print(" ");
		System.out.print(rb.getString("visitor"));
	}

}
