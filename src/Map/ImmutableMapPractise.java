package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapPractise { // immutable map is a one, once instantiated then it cannot be able to add, delete or update its data.

	public static void main(String[] args) {

		Map<String, Integer> map1 = new HashMap<>();
		
		map1.put("Deepak", 1);
		map1.put("Karan", 8);
		map1.put("Dinesh", 11);
		
		System.out.println("Map1: " + map1);
		
		Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
		
		System.out.println("Map2: " + map2);
		
		map2.put("Heena", 100); // here map2 is become un-modifyable and thus throwing exception as it's become a immutable map.
		
		//But this approach was good till java 8 and in Java 9 they introduced below ways to create an immutable map

		Map<String, Integer> map3 = Map.of("Deepak", 10, "Kishna", 10);
		
		map3.put("Karan", 0); // will throw the exception as it is an immutable map now. but Map.of() is limited to size of 10 elements only
		
		//then introduced, below:
		Map.ofEntries(Map.entry("Deepak", 1), Map.entry("Karan", 2)); // it is also immutable but can have any number of enteries.
	}

}