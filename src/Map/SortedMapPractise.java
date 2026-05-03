package Map;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapPractise {

	public static void main(String[] args) {
		
		SortedMap<String, Integer> map = new TreeMap<String, Integer>();
		
		map.put("Deepak", 100);
		map.put("Rahul", 102);
		map.put("Ramesh", 114);
		map.put("Kiran", 109);
		
		System.out.println(map); // naturally sorted according to the ascending order of names that is the key.
		
		SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>((a,b) -> b - a); // here given the custom comparator for descending ordering.
		
		sortedMap.put(100, "Deepak");
		sortedMap.put(101, "Ganesh");
		sortedMap.put(102, "Raam");
		sortedMap.put(103, "Saurav");
		
		System.out.println(sortedMap);
		
		System.out.println(sortedMap.firstKey());
		System.out.println(sortedMap.lastKey());
		
		System.out.println(sortedMap.headMap(101)); // it will exclude the given one
		
		System.out.println(sortedMap.tailMap(100)); // again exclude the given one
		
		NavigableMap<Integer, String> navigableMap =  new TreeMap<>();
		
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        
        System.out.println(navigableMap);
        
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.ceilingKey(3));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.descendingMap());

	}

}

/*

SortedMap is an interface that extends Map and it is use to give the sorted values according to the map keys. TreeMap is it's implementation class.

Basically there is one more interface which is NavigableMap that extends SortedMap. Now, treeMap implements NavigableMap and NavigableMap extends SortedMap.

Navigable map provides some more methods to do the operations on map and provide sorting/navigation for map in operations.

SortedMap<String, Integer> map = new TreeMap<String, Integer>(); -- here key is String type and it has it's own comparable definition inside it.

So, basically in sorted map either natural ordering is done on the basis of comparable in the key of the map or comparator can be passed in the treeMap for non-natural ordering.
new TreeMap<String, Integer>(comparatorObj);

Now, treeMap internally uses, Red black tree which is self balancing BST.

TC will be log(n) in case of put, get, containsKey becasue they all are sorted and extra time will be required for all the functions and O(n) in case of containsValue because of non sorted manner.

*/