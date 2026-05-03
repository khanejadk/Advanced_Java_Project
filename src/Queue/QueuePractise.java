package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractise {

	public static void main(String[] args) {

		// Representing LinkedList as Queue  -- FIFO
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.addLast(1); // here we are adding at last so using addLast, however can directly add also because it will add into the last only by default.
		list.addLast(2);
		list.addLast(3); //enqueue
		
		System.out.println(list); 
		
		list.removeFirst(); // dequeue
		
		System.out.println(list); // here jo pehle aaya, vo pehle gaya. So FIFO
		
		list.getFirst(); // peek
		
		// Now actual Queue collection in Java implementation. because via Linkedlist there is so much complexity
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1); // enqueue = add, offer
		queue.add(2);
		queue.add(3);
		
		queue.remove(3); // dequeue = remove, poll
		
		queue.peek(); // peek = peek, element
		
		queue.size();
		
		
		Queue<Integer> queue1 = new LinkedList<>();
		
		queue1.add(1);   // will throw exception if, the size is fixed and still we are adding element into it.
		queue1.offer(2);
		queue1.offer(3); // will not throw any exception, in case of size exceeded, just it will return false as a result.
		
		queue1.remove(); // will throw exception if there is no element to remove, but still we are doing it.
		queue1.poll();   // will not throw any exception, but return null as a result.
		
		queue1.element(); // will throw an exception if there is not element to peek.
		queue1.peek();    // will return null instead of throwing exception.
 	}

}

/* 

Queue is a data structure where the elements added in the format of FIFO. Elements are added into the end and removed from the front, that is the basic principle.

In Java, Queue is an interface that provides the functionality of FIFO for elements and it has different implementation classes such as LinkedList, priorityQueue etc and so on.




*/