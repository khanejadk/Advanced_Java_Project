package Map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapPractise {

	public static void main(String[] args) {

		Map<Days, String> map = new EnumMap<>(Days.class); // when the keys of map are a single enum then use EnumMap on right side to get more efficient results.
		
		map.put(Days.FRIDAY, "Gym");
		
		System.out.println(Days.FRIDAY.ordinal());

	}

}

enum Days{
	
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

/*

In enum Map, no separate index will get find, but instead it will use the enum elements index to store the data cause they are already defined. So, no hashing will be required to get the index
and then put the elements at their place.

So all operations - adding, accessing, deleting will result in faster execution.

Also, order will get maintained like linked hash map.

map size will be same as enum so no resizing and hashing will be required later.

*/