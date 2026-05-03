package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListPractise {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1); //O(n)
		list1.add(2);
		list1.add(4);
		list1.add(0,10);
		
		System.out.println(list1);
		
		list1.set(0, 50); //O(1)
		
		list1.remove(1); // O(n) -- removing element at that particular index
		list1.remove(Integer.valueOf(10)); // removing the particular element, not the index
		
		// we used List interface on left side because of following flexibility
		//list1 = new LinkedList<Integer>();
		
		list1.contains(10); // O(n)
		
		List<Integer> list2 = Arrays.asList(1,2,3,4,5,7,9,10);
		
		List<Integer> list3 = List.of(23,89,90);
		
		System.out.println(list2);
		
		System.out.println(list3);

		list1.get(0); //O(n)
		
		list1.size();
		
		list1.toArray();
		
		//check below also 
	}

}

/*

- Initial capacity = 10 (can also give initial capacity during declaration also. = new ArrayList<>(10); )
- Growth factor = 1.5
- working = An internal array of object references was there that holds the elements. First it check the capacity and then create a new array and copy the previous items in new one
- Adding an element = O(n)  - - TC
- Arrays.asList(1,2,3,4,5….) - - it is a fixed size list and it’s return type is List only so cannot take its value in ArrayList. Also we cannot add or remove elements in it once created 
   because of fixed size. But we can replace value already present in the list.
- List.of(1,2,3,4,5….) is also unmodifiable list. Here we cannot even replace the item. nothing at all.


*/