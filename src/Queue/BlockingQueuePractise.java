package Queue;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueuePractise {

	public static void main(String[] args) {

		BlockingQueue<Integer> arrayBlQueue = new ArrayBlockingQueue<>(10); // fixed capacity need to be give in array blocking queue.
		
		Thread producer = new Thread(new Producer(arrayBlQueue));
		Thread consumer = new Thread(new Consumer(arrayBlQueue));
		
		producer.start();
		consumer.start();
		
		BlockingQueue<Integer> linkedBlQueue = new LinkedBlockingQueue<>(); // either give capacity, it will take it otherwise capacity will be Integer.MAX_VALUE but can give out of memory errors.

		BlockingQueue<Integer> priorityBlQueue = new PriorityBlockingQueue<>(); // non-fixed size queue with initial capacity of 11 and elements are in natural ordering with head at priority.
		
		BlockingQueue<Integer> priorityBlQueue1 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder()); // if comparator need to give then size also needs to be given.
		
		
		
		BlockingQueue<String> synchQueue = new SynchronousQueue<>(); // it has capacity of at most one element.
		
		Thread produce = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer...");
                synchQueue.put("Hello from producer!");
                System.out.println("Producer has transferred the message.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer was interrupted.");
            }
        });
		
        Thread consume = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive...");
                String message = synchQueue.take();
                System.out.println("Consumer received: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Consumer was interrupted.");
            }
        });
        
        produce.start();
        consume.start();
	}

}


/*                

BlockingQueue is an interface that is used to work with the queues in multithreaded environment(thread-safe queue). It has implementation classes are ArrayBlockingQueue and linkedBlockingQueue.
It is either wait for the queue to become empty so that it could insert some elements in it or it wait for queue to be have some data so that it can fetch the data from the queue.
It simplify the concurrency problems like producer-consumer.

The operations of the normal Queue will get executed immediately without any delay (like addition/deletion even if the data is not there it thows exception but that too execute immediately).

put -->  Blocks if the queue is full until space becomes available
take --> Blocks if the queue is empty until an element becomes available
offer --> Waits for space to become available, up to the specified timeout

ArrayBlockingQueue is an fixed size (bounded) queue backed by an array (again that circular array). It has low memory overhead and uses a single lock for enqueue and dequeue operations.
If thread number increases then it will be a problem because of waiting for each other to put and take. So array blocking queue can be a problem in that case.


LinkedBlockingQueue is optionally bounded (fixed capacity or not) backed by LinkedList. It has separate lock for both enqueue and dequeue operations.
So, more threads will be handle the operations easily thus linked blocking queue recommended for large number of threads.

PriorityBlockingQueue uses min=heap as array, can grow dynamically and it has initial 11 size and same natural ordering and head element priority will be there.
put method will not block the operations because it is unbounded and no size issue will be there.

SynchronousQueue is another implementation class of BlockingQueue. It works in an ordered manner, first an element will be inserted then other can be insert only if the first one will get remove
first by the other thread and vice versa. Basically, it can not store the element. It has capacity of at most one element.

*/

class Producer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	private int value;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while(true) {
			
			try {
				System.out.println("Producer produced: " + value);
				queue.put(value++);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Producer interrupted");
			}
		}
		
	}
	
}

class Consumer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		while(true) {
			
			try {
				Integer value = queue.take();
				System.out.println("Consumer consumed: " + value);
				queue.put(value++);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Consumer interrupted");
			}
		}
		
	}
	
}