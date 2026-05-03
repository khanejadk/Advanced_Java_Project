package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractise {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(16);
		pq.add(8);
		pq.add(2);
		pq.add(76); // here all the elements will be there in the internal array in a sorted manner

		System.out.println(pq); // so basically when we print it, it will do natural sort and give the first element which is 2 and then rest is like in the any order.
		// basically, only head element is their priority. so sorted manner 2 give. If we remove 2 then result will be like, 8, 16,76 becasue 8 after sored and priority and then rest elements.
		
		System.out.println("Peeked element: " + pq.peek());
		
		// to print element in a sorted manner:
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder()); // here we can pass any comparator for any customized ordering. (a-b and b-a for example).
	}

}

/*

Priority queue is an implementation class of Queue interface.

It basically focus on the head/front element and it is their only priority.

They basically find the first or head element in a natural ordering way and will focus on that only. If that head element gets removed then again the first element after the natural ordering will
be of the top priority.
2 will be top priority and rest can be any order. If 2 removed then, 8 will be the priority element and then remaining can be of any order.

It does not allow null elements.

Internally it uses a min-heap to get the priority element. In min-heap, the parent node is smallest than their child node. So, smallest will be at the top and thus easily fetched.
So O(1) for fetching smallest element. Rest O(logn) for adding or deleting any element from PQ (min-heap).


*/