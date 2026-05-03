package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequePractise {

	public static void main(String[] args) {

		Deque<Integer> dq1 = new ArrayDeque<>();
		
		dq1.addFirst(5);     // [5]
		dq1.addLast(20);     // [5, 20]
		dq1.offerFirst(34);  // [34, 5, 20]
		dq1.offerLast(60);   // [34, 5, 20, 60]
		
		dq1.removeFirst();   // [5, 20, 60]
		dq1.pollLast();      // [5, 20]
		
		dq1.getFirst();      // 5
		dq1.peekLast();      // 20
		
/*

ArrayDeque internally uses circular array (basically will play with indexes and connected with each other) and thus retreival, adding first/last, removing first/last operations will be fast.
After the size limit reached then circular array got doubled. It will not be having any null values.
here pointers used as head and tail, so when element is added their pointers position got shift but array items will not move they remain as it is.
 		
*/
		
		Deque<Integer> dq2 = new LinkedList<>();
				
		dq2.offerFirst(100);
		
/*

LinkedList implementing the Deque uses linkedList internally and it is fast for middle insertion and deletion operations, otherwise operations are slower, more memory will consume due to pointers,
and will be used when so use case related to LinkedList Deque will occur otherwise ArrayDeque will be the best implementation.

*/		
	}

}

/*

Deque is the doubly ended queue. It is an interface which has implementation class as ArrayDeque and LinkedList. In this addition and deletion of elements can be done at start/front as well as the end/tail.

It is very versatile and can be act as queue and stack both.

ArrayDeque is resizable array implementaion.

If implementation class is ArrayDeque then it will be faster than Stack when use as stack and faster than LinkedList when use as queue.

		INSERTION METHODS

           addFirst(E e): Inserts the specified element at the front. or give exception at required place.
           addLast(E e): Inserts the specified element at the end. or give exception at required place.
           offerFirst(E e): Inserts the specified element at the front if possible.
           offerLast(E e): Inserts the specified element at the end if possible.

         REMOVAL METHODS

            removeFirst(): Retrieves and removes the first element. or give exception at required place.
            removeLast(): Retrieves and removes the last element. or give exception at required place.
            pollFirst(): Retrieves and removes the first element, or returns null if empty.
            pollLast(): Retrieves and removes the last element, or returns null if empty.

         EXAMINATION METHODS

            getFirst(): Retrieves, but does not remove, the first element.
            getLast(): Retrieves, but does not remove, the last element.
            peekFirst(): Retrieves, but does not remove, the first element, or returns null if empty.
            peekLast(): Retrieves, but does not remove, the last element, or returns null if empty.

          STACK METHODS

            push(E e): Adds an element at the front (equivalent to addFirst(E e)).
            pop(): Removes and returns the first element (equivalent to removeFirst())

*/