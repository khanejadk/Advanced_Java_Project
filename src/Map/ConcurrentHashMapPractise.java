package Map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPractise {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String, Integer> conMap = new ConcurrentHashMap<>();
		
		conMap.put("Deepak", 1);
		conMap.put("Rahul", 2);
		conMap.put("Ramesh", 3);
		conMap.put("Ganesh", 4);
		
		System.out.println(conMap);
		
		//rest all methods same as other maps

	}

}

/*

ConcurrentHashMap comes into picture becasue in the HashTable even the get method is synchronized, there is delay even in the read operations also.

ConcurrentMap is an interface that extends Map and ConcurrentHashMap is it's implementation class.

Till Java 7... The internal working is based on the Segment based locking. What it means is that, the map has been divided into smaller segments (smaller maps which is into 16 small maps) and every
single map will have it's own lock for thread safety. Only segement in which read and write operation is happening will get locked, rest will remain unlock.

During the read operations there will not be any lock on segment, unless there will be write operation performing on the same segment. Write operation will definitely have the locking of segment.

occurs.

Working example (lets see as a variable first):

Thread A ---- x = 42;
Now thread A wants to change the value to 50, so, it will first check it's value, if it is still 42 then it will change it to 50 otherwise it will retry again many times and will take small breaks
in between to avoid CPU wastage.

Map exmaple:
during put, it will first find the index and check that if it is empty or not, if it is empty then put the value otherwise retry and during collision it will get locked (bucket) and do the same.
during updating the value, first it will check the already present value, if it is again the same then update the value otherwise retry.


*/