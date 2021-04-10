package ocp.ch5.DatesStringsLocalization.AddingInternationalizationLocation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDatesTimes {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime)); // 1/20/20
		System.out.println(shortDateTime.format(date)); // 1/20/20
		/** System.out.println(shortDateTime.format(time)); */ // UnsupportedTemporalTypeException

		// inverted
		System.out.println(dateTime.format(shortDateTime));
		System.out.println(date.format(shortDateTime));
		/** System.out.println(time.format(shortDateTime)); */// ava.time.temporal.UnsupportedTemporalTypeException

		date = LocalDate.of(2020, Month.JANUARY, 20);
		time = LocalTime.of(11, 12, 34);
		dateTime = LocalDateTime.of(date, time);
		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(shortF.format(dateTime)); // 1/20/20 11:12 AM
		System.out.println(mediumF.format(dateTime)); // Jan 20, 2020 11:12:34 AM

		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
		System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

		f = DateTimeFormatter.ofPattern("MM dd yyyy");
		date = LocalDate.parse("01 02 2015", f);
		time = LocalTime.parse("11:22");
		System.out.println(date); // 2015–01–02
		System.out.println(time); // 11:22
	}

}
