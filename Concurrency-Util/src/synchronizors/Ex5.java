package synchronizors;

// CountDown Latch

import java.util.concurrent.CountDownLatch;

// CuntDown Latch

public class Ex5 {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(3);

		TechLead techLead1 = new TechLead(countDownLatch, "first");
		TechLead techLead2 = new TechLead(countDownLatch, "second");
		TechLead techLead3 = new TechLead(countDownLatch, "third");

		techLead1.start();
		techLead2.start();
		techLead3.start();

		try {
			System.out.println("HR Manager waiting for recruitment to complete...");

			countDownLatch.await();
		
			// techLead1.join();
			// techLead2.join();
			// techLead3.join();

			System.out.println("Distribute Offer Letter");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class TechLead extends Thread {

	CountDownLatch countDownLatch;

	public TechLead(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;

	}

	@Override
	public void run() {
		try {
			countDownLatch.countDown();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " : recruted");

		// countDownLatch.countDown();

	}

}
