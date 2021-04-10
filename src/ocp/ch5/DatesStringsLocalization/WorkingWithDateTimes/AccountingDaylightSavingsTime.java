package ocp.ch5.DatesStringsLocalization.WorkingWithDateTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AccountingDaylightSavingsTime {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
		System.out.println();

		date = LocalDate.of(2016, Month.NOVEMBER, 6);
		time = LocalTime.of(1, 30);
		zone = ZoneId.of("US/Eastern");
		dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–11–06T01:30–04:00[US/Eastern]
		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–11–06T01:30–05:00[US/Eastern]
		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–11–06T02:30–05:00[US/Eastern]

		date = LocalDate.of(2016, Month.MARCH, 13);
		time = LocalTime.of(2, 30);
		zone = ZoneId.of("US/Eastern");
		dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]

	}

}
