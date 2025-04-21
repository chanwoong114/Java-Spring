package custom;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class LocalDateTimeExMain {
	public static void main(String[] args) {
		LocalDateTime time1 = LocalDateTime.of(2025,1, 1, 12, 10);
		LocalDateTime time2 = LocalDateTime.of(2025,1, 3, 14, 20);

		Duration duration = Duration.between(time1, time2);
		System.out.println(duration);

		Period period = Period.between(time1.toLocalDate(), time2.toLocalDate());
		System.out.println(period);
	}
}
