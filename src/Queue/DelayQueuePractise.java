package Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueuePractise {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<DelayedTask> delayQueue = new DelayQueue<>();
		
		delayQueue.put(new DelayedTask("Task1", 4, TimeUnit.SECONDS));
		delayQueue.put(new DelayedTask("Task2", 2, TimeUnit.SECONDS));
		delayQueue.put(new DelayedTask("Task3", 6, TimeUnit.SECONDS));

		while(!delayQueue.isEmpty()) {
			
			DelayedTask task = delayQueue.take();
			System.out.println("Exectued " + task.getTaskName() + " at " + System.currentTimeMillis()); // smallest time delay will run first because of natural ordering of time delay
			
			// Exectued Task2 at 1777655968405
			// Exectued Task1 at 1777655970404
			// Exectued Task3 at 1777655972405
		}
	}

}

class DelayedTask implements Delayed {

	private final String taskName;
	private final long startTime;
	
	public DelayedTask(String taskName, long delay, TimeUnit unit) {
		this.taskName = taskName;
		this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
	}
	
	
	@Override
	public int compareTo(Delayed o) { // just for ordering purpose
		if(this.startTime < ((DelayedTask) o).startTime) {
			return -1;
		}
		if(this.startTime > ((DelayedTask) o).startTime){
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) { // finding the time delay
		long remainingTime = startTime - System.currentTimeMillis();
		return unit.convert(remainingTime, TimeUnit.MILLISECONDS);
	}
	
	public String getTaskName() {
		return taskName;
	}	
	
}

/*

DelayQueue is an implementation class of BlockingQueue interface in java. It is unbounded thread-safe blocking queue.

Elements can only be taken from the queue (removed from queue) only when their delay time is completed (over).

It is used to scheduling task to be executed after certain delay. It internally uses priority queue.

*/