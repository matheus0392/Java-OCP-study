package ocp.ch7.Concurrency.CreatingThreadsWithExecutorService;

import static java.lang.System.out;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WaitingAllTasksToFinish {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			// Add tasks to the thread executor
			Future<Integer> result = service.submit(() -> {Thread.sleep(5000); return 30 + 11;});
		} finally {
			if (service != null)
				service.shutdown();
		}

		if (service != null) {
			service.awaitTermination(3, TimeUnit.SECONDS); //wait tasks finish
			// Check whether all tasks are finished
			if (service.isTerminated())
				out.println("All tasks finished");
			else
				out.println("At least one task is still running");
		}
	}

}
