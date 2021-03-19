package ocp.ch7.Concurrency.ManagingConcurrentProcesses;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ApplyingTheFork_JoinFramework {

	public static void main(String[] args) {
		Double[] weights = new Double[10];

		ForkJoinTask<?> task = new WeighAnimalAction(weights, 0, weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);

		// Print results
		out.println();
		out.print("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
		out.println();
		out.println();
		
		ForkJoinTask<Double> task2 = new WeighAnimalTask2(weights,0,weights.length);
		ForkJoinPool pool2 = new ForkJoinPool();
		Double sum = pool2.invoke(task2);
		out.println("Sum: "+sum);
	}

}

class WeighAnimalAction extends RecursiveAction {
	private int start;
	private int end;
	private Double[] weights;

	public WeighAnimalAction(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	protected void compute() {
		if (end - start <= 3)
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal Weighed: " + i);
			}
		else {
			int middle = start + ((end - start) / 2);
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
			ForkJoinTask.invokeAll(new WeighAnimalAction(weights, start, middle),
					new WeighAnimalAction(weights, middle, end));
		}
	}
}

class WeighAnimalTask2 extends RecursiveTask<Double> {
	private int start;
	private int end;
	private Double[] weights;

	public WeighAnimalTask2(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	protected Double compute() {
		if (end - start <= 3) {
			double sum = 0;
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				out.println("Animal Weighed: " + i);
				sum += weights[i];
			}
			return sum;
		} else {
			int middle = start + ((end - start) / 2);
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
			RecursiveTask<Double> otherTask = new WeighAnimalTask2(weights, start, middle);
			otherTask.fork();

			return new WeighAnimalTask2(weights, middle, end).compute() + otherTask.join();
		}
	}
}