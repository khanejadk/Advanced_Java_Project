package Map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCachePractise<K, V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 1L;
	private int capacity;
	
	public LRUCachePractise(int capacity) {
		
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
		
	
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		
		return size() > capacity; // here the moment size of map become greater than the capacity, it will remove the least used entry from the map.
	}


	public static void main(String[] args) {
		
		LRUCachePractise<String, Integer> cacheLRU = new LRUCachePractise<String, Integer>(4);
		
		cacheLRU.put("Deepak", 100);
		cacheLRU.put("Rahul", 75);
		cacheLRU.put("Karan", 90);
		cacheLRU.put("Abhishek", 88);
		
		cacheLRU.put("Hardik", 33);
	
		cacheLRU.get("Rahul");
		
		for(java.util.Map.Entry<String, Integer> entry: cacheLRU.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

}
