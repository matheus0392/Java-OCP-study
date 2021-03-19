package ocp.ch7.Concurrency.CreatingThreadsWithExecutorService;

import static java.lang.System.out;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class WaitingForResults {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> future = service.submit(() -> out.println("Hello Zoo"));

			out.println(future.isDone());
			out.println(future.isCancelled());
			out.println(future.get());
			out.println(future.cancel(true));
			out.println(future.get(1, TimeUnit.SECONDS));

		} finally {
			if (service != null)
				service.shutdown();
		}

	}

}

class CheckResults {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				for (int i = 0; i < 5000000; i++) {
					CheckResults.counter++;
					// out.println(CheckResults.counter);
				}
			});
			result.get(1, TimeUnit.SECONDS);
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
