package ocp.ch7.Concurrency.CreatingThreadsWithExecutorService;

import static java.lang.System.out;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		Runnable task1 = () -> System.out.println("Hello Zoo");
		Callable<String> task2 = () -> {
			out.println("Monkey");
			return "Monkey";
		};
		Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);	// execute once after 10 sec
		Future<?> result2 = service.schedule(task2, 1, TimeUnit.MINUTES);	// execute once after 1 min
		// service.shutdownNow();

		service.scheduleWithFixedDelay(() -> System.out.println("Hello 1 "+LocalDateTime.now().getSecond()), 5, 1, TimeUnit.SECONDS); // every 1 second
		service.scheduleWithFixedDelay(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			out.println("Hello 2 "+LocalDateTime.now().getSecond());
		}, 0, 2, TimeUnit.SECONDS); //2 seconds after last task finish

	}

}
