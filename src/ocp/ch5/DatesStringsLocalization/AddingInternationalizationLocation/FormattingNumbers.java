package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {

	public static void main(String[] args) throws ParseException {
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth));
		NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(g.format(attendeesPerMonth));
		NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth));

		double price = 48;
		NumberFormat us2 = NumberFormat.getCurrencyInstance();
		System.out.println(us2.format(price));

		NumberFormat en = NumberFormat.getInstance(Locale.US);
		NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
		String s = "40.45";
		System.out.println(en.parse(s)); // 40.45
		System.out.println(fr.parse(s)); // 40

		NumberFormat nf = NumberFormat.getInstance();
		String one = "456abc";
		String two = "-2.5165x10";
		String three = "x85.3";
		System.out.println(nf.parse(one)); // 456
		System.out.println(nf.parse(two)); // -2.5165
		/** System.out.println(nf.parse(three)); */ // throws ParseException

		String amt = "$92,807.99";
		NumberFormat cf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		double value = (Double) cf.parse(amt);
		System.out.println(value); // 92807.99
	}
}
