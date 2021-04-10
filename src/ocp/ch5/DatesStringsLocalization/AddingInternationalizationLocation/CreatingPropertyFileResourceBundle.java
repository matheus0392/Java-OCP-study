package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation;

import java.util.Locale; // util.Locale
import java.util.Properties; // util.Properties
import java.util.ResourceBundle;// util.ResourceBundle
import java.util.Set;

public class CreatingPropertyFileResourceBundle {

	static String resource = (new ZooOpen().getClass().getPackage() + ".Zoo").replace("package ", "");

	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle(resource, us);
		Set<String> keys = rb.keySet();
		keys.stream().map(k -> k + ":" + rb.getString(k)).forEach(System.out::println);

		Properties props = new Properties();
		rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));

		System.out.println(props.getProperty("notReallyAProperty")); // null
		System.out.println(props.getProperty("notReallyAProperty", "123")); // 123
	}

}

class ZooOpen {
	public static void main(String[] args) {
		Locale us = new Locale("en", "US");
		Locale france = new Locale("fr", "FR");
		printProperties(us);
		System.out.println();
		printProperties(france);
	}

	public static void printProperties(Locale locale) {
		String resource = (new ZooOpen().getClass().getPackage() + ".Zoo").replace("package ", "");
		ResourceBundle rb = ResourceBundle.getBundle(resource, locale);
		System.out.println(rb.getString("hello"));
		System.out.println(rb.getString("open"));
	}
}