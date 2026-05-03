package List;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListPractise {

	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(10); // O(1) -- because just node reference only need to change or point to next node, that is it
		linkedList.add(25);
		linkedList.add(30);
		linkedList.add(40);
		
		System.out.println(linkedList);
		
		linkedList.remove(1); // O(1) - - because just node reference only need to change or point to next node, that is it
		linkedList.remove(Integer.valueOf(40));
		
		System.out.println(linkedList);
		
		linkedList.addFirst(50);
		linkedList.addLast(100);
		
		System.out.println(linkedList);
		
		linkedList.get(2);  //  O(n)  -- because of worst case, traversing the whole list
		
		linkedList.contains(40);  // O(n)
		
		LinkedList<String> list1 = new LinkedList<String>(Arrays.asList("Ram", "Shyam", "Ramesh"));
		LinkedList<String> list2 = new LinkedList<String>();
		
		list2.addAll(list1);
		
		System.out.println(list2);
		
	}

}
