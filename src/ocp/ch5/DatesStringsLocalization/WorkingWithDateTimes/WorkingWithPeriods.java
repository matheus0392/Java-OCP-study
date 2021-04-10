package ocp.ch5.DatesStringsLocalization.WorkingWithDateTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class WorkingWithPeriods {

	public static void main(String[] args) {
		Period annually = Period.ofYears(1); // every 1 year
		Period quarterly = Period.ofMonths(3); // every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		Period everyOtherDay = Period.ofDays(2); // every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

		System.out.println(Period.of(1, 2, 3)); // P1Y2M3D

		System.out.println(Period.ofMonths(3)); // P3M

		System.out.println(Period.of(0, 20, 47)); // P20M47D

		System.out.println(Period.ofWeeks(3)); // P21D

		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Period period = Period.ofMonths(1);
		System.out.println(date.plus(period)); // 2015–02–20
		System.out.println(dateTime.plus(period)); // 2015–02–20T06:15
		System.out.println(time.plus(period)); // UnsupportedTemporalTypeException

	}

}
