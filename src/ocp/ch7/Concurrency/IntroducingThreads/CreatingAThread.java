package ocp.ch7.Concurrency.IntroducingThreads;

import static java.lang.System.out;

public class CreatingAThread {

	public static void main(String[] args) throws InterruptedException {
		out.println("begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();
		out.println("end");

		Thread.sleep(1000);
		out.println();

		// not started thread, just run
		new PrintData().run();
		(new Thread(new PrintData())).run();
		(new ReadInventoryThread()).run();

		new Thread(() -> System.out.println("Hello World")).start();
		new Thread(() -> {int i=10; i++;}).start();
		new Thread(() -> {return;}).start();
		new Thread(() -> {}).start();
		
		
		/** new Thread(() -> "").start(); */ 						//DOES NOT COMPILE
		/** new Thread(() -> 5).start(); */ 						//DOES NOT COMPILE
		/** new Thread(() -> { return new Object(); }).start(); */ 	//DOES NOT COMPILE

	}

}

class PrintData implements Runnable {
	public void run() {
		for (int i = 0; i < 3; i++)
			out.println("Printing record: " + i);

	}

	public static void main(String[] args) {
		(new Thread(new PrintData())).start();
	}
}

class ReadInventoryThread extends Thread {
	public void run() {
		out.println("Printing zoo inventory");
	}

	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
	}
}
