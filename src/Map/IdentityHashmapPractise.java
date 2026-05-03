package Map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashmapPractise {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new IdentityHashMap<>();
		
        String key1 = new String("Akshit");
        String key2 = new String("Akshit");
        
        map.put(key1, 90);
        map.put(key2, 92);
        
        System.out.println(map);

	}

}

/*

here we are using String as key and creating two different string keys using new operator for different memory address unlike creating in the string pool.

now if we use normal hashmap then, it will use the String's hashcode and equals method and there will be same hashcode and equality generted that results in the same key and only one value in the
output.

Now, if we use IdentityHashmap then doesn't matter it has it's own hashcode or equals method, code will use the objects hashcode and equals method. so, in that case it will play with the memory
address of the String objects and result in two different keys.

*/