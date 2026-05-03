package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorPractise {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		for(Integer i : list) {
			System.out.println(i);
		}
		
		// below is the internal transformation of above for each loop and working as: it uses pointer to iterate over the collection of elements
		
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// Iterator also provides the functionality of removing the elements from the list while iterating it. In for each we need to use copyOnWriteArrayList to do that but here it is possible.
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		
		Iterator<Integer> it = numbers.iterator();
		
		while(it.hasNext()) {
			
			Integer num = it.next();
			if(num % 2 == 0) {
				it.remove();
			}
		}
		
		System.out.println(numbers);
		
		// listIterator is also a method and that provides a bit more functionality than iterator method
		
		ListIterator<Integer> i = numbers.listIterator();

		i.hasPrevious();
		i.nextIndex();
		i.previous();
		
	}

}

/*

Iterator is basically an interface and ArrayList implementing it internally and overriding that iterator method which is returing the Iterator object.

*/