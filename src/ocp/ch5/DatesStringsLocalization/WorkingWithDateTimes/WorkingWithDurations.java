package ocp.ch5.DatesStringsLocalization.WorkingWithDateTimes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class WorkingWithDurations {

	public static void main(String[] args) {
		Duration daily = Duration.ofDays(1); // PT24H
		Duration hourly = Duration.ofHours(1); // PT1H
		Duration everyMinute = Duration.ofMinutes(1); // PT1M
		Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
		Duration everyMilli = Duration.ofMillis(1); // PT0.001S
		Duration everyNano = Duration.ofNanos(1); // PT0.000000001S

		// equivalent
		daily = Duration.of(1, ChronoUnit.DAYS);
		hourly = Duration.of(1, ChronoUnit.HOURS);
		everyMinute = Duration.of(1, ChronoUnit.MINUTES);
		everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
		everyMilli = Duration.of(1, ChronoUnit.MILLIS);
		everyNano = Duration.of(1, ChronoUnit.NANOS);

		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Duration duration = Duration.ofHours(6);
		System.out.println(dateTime.plus(duration)); // 2015–01–20T12:15
		System.out.println(time.plus(duration)); // 12:15
		/** System.out.println(date.plus(duration)); */ // UnsupportedTemporalException

		date = LocalDate.of(2015, 1, 20);
		time = LocalTime.of(6, 15);
		dateTime = LocalDateTime.of(date, time);
		duration = Duration.ofHours(23);
		System.out.println(dateTime.plus(duration)); // 2015–01–21T05:15
		System.out.println(time.plus(duration)); // 05:15
		/** System.out.println(date.plus(duration)); */ // UnsupportedTemporalException

		date = LocalDate.of(2015, 5, 25);
		Period period = Period.ofDays(1);
		Duration days = Duration.ofDays(1);
		System.out.println(date.plus(period)); // 2015–05–26
		System.out.println(date.plus(days)); // Unsupported unit: Seconds

	}

}
