package Map;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapPractise {

	public static void main(String[] args) {
		
		ConcurrentSkipListMap<Integer, String> conSkipMap = new ConcurrentSkipListMap<>();
		
		conSkipMap.put(1, "Deepak");
		
		Thread t2 = new Thread(() ->{
			
			for(int i=0; i<100; i++) {
				conSkipMap.put(i, "Thread t1");
			}
		});
		
		Thread t1 = new Thread(() ->{
			
			for(int i=100; i<200; i++) {
				conSkipMap.put(i, "Thread t2");
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(conSkipMap.size());
		System.out.println(conSkipMap);

	}
	
/*
 
ConcurrentSkipListMap class is an implementing class of ConcurrentMap interface. Basically it uses SkipList as it's data structure, like array(bucket) data structure used in case of other maps.

SkipList is a probablistic data structure -- it basically uses different layers to store/represent data and it is better than using linear approach to set or find element in the data structure.

Using it, we can acheive sorted and synchronized map that is ConcurrentSkipListMap
 
 	
 */

}
