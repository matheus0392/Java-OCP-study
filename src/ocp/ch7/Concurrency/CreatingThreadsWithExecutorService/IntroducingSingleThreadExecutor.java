package ocp.ch7.Concurrency.CreatingThreadsWithExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.System.out;

public class IntroducingSingleThreadExecutor {

	public static void main(String[] args) {

	}

}

class ZooInfo {
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			out.println("begin");
			service.execute(() -> out.println("Printing zoo inventory"));
			service.execute(() -> {
				for (int i = 0; i < 3; i++)
					out.println("Printing record: " + i);
			});
			service.execute(() -> out.println("Printing zoo inventory"));
			out.println("end");
		} finally {
			if (service != null)
				service.shutdown(); //no new taks will be accepted
		}
		service.shutdownNow(); //send stop signal to all currents taks
	}
}