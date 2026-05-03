package Queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedQueuePractise {

	public static void main(String[] args) {

		Queue<String> queue = new ConcurrentLinkedDeque<>();
		
		Thread producer = new Thread(() -> {
			
			while(true) {
				try {
					queue.add("Task " + System.currentTimeMillis());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer = new Thread(() -> {
			
			while(true) {
				try {
					String task = queue.poll();
					System.out.println("Processing " + task);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		producer.start();
		consumer.start();

	}

}

/*

ConcurrentLinkedQueue is an implementation class of Queue interface. It is a lock free thread safe queue that does not lock the queue for put and take operations.

It is also termed as non-blocking queue for thread safe operations.

Compare and swap approach has been used here instead of locking. It will adding the element at tail and before adding it will check if all clear then it will add.
If another element is there by another thread it will do the same repeating task and then add.




*/