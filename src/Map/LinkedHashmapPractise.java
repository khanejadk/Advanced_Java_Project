package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashmapPractise {

	public static void main(String[] args) {
		
		LinkedHashMap<String, Integer> linkedHM = new LinkedHashMap<String, Integer>();
		
		linkedHM.put("A", 1);
		linkedHM.put("B", 2);
		linkedHM.put("C", 3);
		
		System.out.println(linkedHM);
		
		Set<Entry<String, Integer>> entry = linkedHM.entrySet();
		for(Entry<String, Integer> entries: entry) {
			System.out.println(entries.getKey() + " : " + entries.getValue());
		}
		
		linkedHM.getOrDefault("D", 0); // here if D key is present then it will give the output otherwise, 0 will get return by using getOrDefault.
		linkedHM.putIfAbsent("A", 10); // here it will not perform the put, becasue A is not absent in the map, so no operation will get perform.
		
	// LinkedHashMap<String, Integer> map = new LinkedHashMap<>(20, 0.75f, false); -- here, by default access order is false and in that case it will preserve the order of addition.
				
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(20, 0.75f, true);
		
		map.put("Deepak", 1);
		map.put("Heena", 2);
		map.put("Veena", 3);
		
		map.get("Heena"); // here, we access the "Heena" key and accessOrder was true at that time. So, it will put the "Heena" key to the last in the result. That is his working.  
		
		Set<Entry<String, Integer>> mapEntry = map.entrySet();
		for(Entry<String, Integer> entries: mapEntry) {
			System.out.println(entries.getKey() + " : " + entries.getValue());
		}
		
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>(hashMap); // another way of creating linkedHashMap
		
	}

}

/* 

it basically uses doubly linked list along with the hashmap bucket array to preserve the order. It is just one difference between them, rest internal working is same.

each D linked list node has bucket and pointers to next/previous nodes

as it uses linked list to preserve the order, so opeartion become slow and hence its efficiency.

Slow memory management also due to linkedlist pointers.

rest TC is same as hashmap

LRU is basically Least Recently used element. so, if accessOrder is true then it will put the recently used elements in the last and thus least used at the top. so to get the least use easily.

It used mostly in caching, becasue caching has very less space to use, so, least used one will get removed from the cache to save the space or storage.

*/
