package Queue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequePractise {

	public static void main(String[] args) {

		ConcurrentLinkedDeque<Integer> queue = new ConcurrentLinkedDeque<>();
		
		queue.add(1);
		queue.addFirst(0);
 
		queue.offer(2);
		
		queue.removeFirst();
		
		queue.remove();
		
		System.out.println(queue);
	}

}

/*

It is an implementation class of Queue interface. It is a non-blocking thread safe double ended queue.

It will use compare and swap stratergy internally.

*/