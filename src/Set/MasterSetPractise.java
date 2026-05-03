package Set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class MasterSetPractise {

	public static void main(String[] args) {
		
	//HashSet
		
		Set<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(10);
		set.add(1); //duplicate will not add
		boolean result = set.add(100);
		
		System.out.println(set);
		System.out.println("Result: " + result);
		
		set.remove(100);
		
		System.out.println(set);
		
		System.out.println(set.contains(10));
		
		// here no get method will be available and we need to use iteration or convert set into the list to get the element value at a particular index.

		set.size();
		
	//LinkedHashSet -- It basically preserve the order of element addition in the set
		
		Set<Integer> linkedHSet = new LinkedHashSet<>();
		
		linkedHSet.add(10);
		linkedHSet.add(100);
		linkedHSet.add(90);
		
		System.out.println(linkedHSet);
		
	//TreeSet -- It is used for sorted set
		
		Set<Integer> treeSet = new TreeSet<>((a,b) -> b-a);
		
		treeSet.add(100);
		treeSet.add(10);
		treeSet.add(45);
		
		System.out.println(treeSet);
		
	// same we can use ConcurrentSkipListSet for concurrency synchronized execution and sorted concurrent execution. Internal working will be the same. only skiplist will be there, no conHashset
		ConcurrentSkipListSet<Integer> skipListSet = new ConcurrentSkipListSet<>();		
		
		Collections.synchronizedSet(set); // it will use as sync, but very slow and old so use above recommended Concurrent sets only for thread safe thing.
		
		Collections.unmodifiableSet(set);
		
		Set.of(1, 3, 5, 6, 7, 5, 4); // immutable list of any number of elements, not limited to 10 like Map.of().
		
	// CopyOnWriteArraySet -- like CopyOnWriteArrayList it has all the same features but the difference will the that it has unique elements in the set unlike duplicate in the list.
	// Rest features will be same as copy will create for write operations and after iterations (read operations) the original will get updated and so on. 
	// only difference between concurrentSkipListSet and CopyOnWriteArraySet will be that concurrent one may or may not give actual result while working with multiple thread but copy one will give
		//because it is working on a particular copy not with actual data
		
	}

}

/*

Set ia an interface and it has few implementation classes as HashSet, LinkedHashSet, TreeSet, EnumSet etc.

Set is basically a collections of data where there is no duplicate value will be present in the list of collections. All values will be unique.

Set is basically same as Map only. It's internal working is totally based on the map internal working.

Set implements Collection interface so its method will be different from the maps. Put=add, get=contains, remove=remove

basically set.add(1); ==== map.put(1, PRESENT); (public static final Object PRESENT = new Object(); -- PRESENT is basically a dummy value as it is required in the map internal working so).


*/