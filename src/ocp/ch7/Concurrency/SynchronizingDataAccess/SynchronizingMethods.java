package ocp.ch7.Concurrency.SynchronizingDataAccess;

public class SynchronizingMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printDaysWork() {
		synchronized (SynchronizingMethods.class) {
			System.out.print("Finished work");
		}
	}

	public static synchronized void printDaysWorkEquivalent() {
		System.out.print("Finished work");
	}
}
