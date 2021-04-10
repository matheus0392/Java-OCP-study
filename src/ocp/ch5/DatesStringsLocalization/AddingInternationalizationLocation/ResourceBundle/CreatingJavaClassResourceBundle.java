package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.ResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class CreatingJavaClassResourceBundle {

	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle(
				"ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.ResourceBundle.Zoo", Locale.US);
		System.out.println(rb.getObject("hello"));

		rb = ResourceBundle.getBundle(
				"ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation.ResourceBundle.Tax", Locale.US);
		System.out.println(rb.getObject("tax"));

	}

}
