package Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapPractise {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>(20, 0.5f); // default = 16, 0.75
		
		map.put(100, "Deepak");
		map.put(101, "Rahul");
		map.put(102, "Divya");
		map.put(103, "Nupur");
		map.put(104, "Srikanth");
		
		map.put(103, "Ananya"); //it will replace the value from Nupur to Ananya for 103 key. as key will be unique so no new entry will be added but instead replace the old one.
		
		System.out.println(map);
		
		
		System.out.println(map.get(103));
		
		map.containsKey(100);
		map.containsValue("Himesh");
		
		Set<Integer> keySet = map.keySet();

		for(int i : keySet) {
			System.out.println(map.get(i));
		}
		
		Collection<String> mapValues = map.values();
		System.out.println("Values: " + mapValues);
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		for(Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		map.remove(100);
		map.remove(101, "Radha"); // it will result in false as there is no value present with this key
		
		/*
		 
		 	Internal working of Hash Map:
		 	
		 	There are basically four components: key, value, bucket and Hash function. Key and value we are already aware of.
		 	
		 	Now there is a array which we call as bucket that stores one particular value of map. I mean one key+value will store at a particular index of the array. 
		 	
		 	First a key will pass to the hash method and an index will be generated as the output and then at this index that particular key+value will get stored in the array.
		 	
		 	The output of the hash function will be a fixed size string of bytes irrespective of any sized key passed.
		 	
		 	int index = hashcode % arraySize;
		 	
		 	initial size of array will be 16 then hash divided by 16 and remainder will be the index. (load factor is 0.75)
		 	
		 	Retrieval of data:
		 	
		 	map.get(100); -- here again this key will pass to hash function and a unique index will get generated. now it will check at that particular index whether this key+value present or not.
		 	
		 	why because, this hash code has finite number of possibility so there are chances that two key+value can have same index and stored at same place and that is called collision in map.
		 	
		 	at each index of array, data is stored in a linked list. (at a particular index, linked list is present)
		 	
		 	but these linked list is not optimal approach so after java 8, we use balanced BST because linked list have linear search operation to search a data at a index (Red black tree)
		 	
		 	initially linked list is used but after the threshold of 8, it converted into BST and then TC changed to O(logN) from O(n)
		 	
		 	Also, when the array size changed then all the hashing thing happen again to shift elements to a new index in new sized array and that is re-hashing
		 
		 	Also, in case of data types string, integer etc, values will be checked and compared to get the data from a particular bucket but if we use custom object as our key then it will use the
		 	object address or reference with hash function to do all the things. that is adding or retrieval
		 	
		 	so in case of custom objects as data type, always use hash code and equals method then only we will get proper results otherwise duplicate will be added and it will be a mess.
		 
		 */
	}

}
