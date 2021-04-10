package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation;

import java.util.Locale;

public class PickingLocale {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		System.out.println(locale);

		System.out.println(Locale.GERMAN); // de
		System.out.println(Locale.GERMANY); // de_DE

		System.out.println(new Locale("fr")); // fr
		System.out.println(new Locale("hi", "IN")); // hi_IN
		System.out.println(new Locale("HI", "in")); // hi_IN

		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();
		Locale l3 = new Locale.Builder().setRegion("US").build();

		System.out.println(l1); // en_US
		System.out.println(l2); // en_US
		System.out.println(l3); // _US

		// change current default
		System.out.println(Locale.getDefault()); // en_US
		Locale locale2 = new Locale("fr");
		Locale.setDefault(locale2); // change the default
		System.out.println(Locale.getDefault()); // fr
	}

}
