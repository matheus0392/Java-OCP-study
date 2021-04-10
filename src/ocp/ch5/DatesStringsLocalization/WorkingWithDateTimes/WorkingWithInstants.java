package ocp.ch5.DatesStringsLocalization.WorkingWithDateTimes;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class WorkingWithInstants {

	public static void main(String[] args) throws InterruptedException {

		Instant now = Instant.now();
		Thread.sleep(1000);
		Instant later = Instant.now();
		Duration duration = Duration.between(now, later);
		System.out.println(duration.toMillis());

		LocalDate date = LocalDate.of(2015, 5, 25);
		LocalTime time = LocalTime.of(11, 55, 00);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);

		Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
		System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
		System.out.println(instant); // 2015–05–25T15:55:00Z

		LocalDateTime dateTime = LocalDateTime.of(date, time);

		ZoneOffset zoffset = ZoneOffset.ofHours(-4);
		instant = Instant.ofEpochSecond(dateTime.toEpochSecond(zoffset));
		System.out.println(instant); // 2015–05–25T15:55:00Z

		Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(nextDay); // 2015–05–26T15:55:00Z
		Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
		System.out.println(nextHour); // 2015–05–25T16:55:00Z
		/** Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); */ // exception //day or smaller

	}

}
