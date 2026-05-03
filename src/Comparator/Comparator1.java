package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Comparator1 {

	public static void main(String[] args) {
		
		// comparator basically used for doing custom comparision or user defined comparison in primitive datatypes or custom (user defined classes objects).
		// while comparable used for the natural ordering. I mean when we give null in the sort method.
		
		List<String> fruits = new ArrayList<>();
		
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Pea");
		fruits.add("Pomegranade");
		
		fruits.sort(null); // natural ordering, in the ascending order. Internally it is done by the comparable method.
		
		fruits.sort(new FruitsLengthComparator());
		System.out.println(fruits);
		
		fruits.sort((s1,s2) -> s1.length() - s2.length()); //ascending order using direct lambda expression without using class implementing comparator
		System.out.println(fruits);
		
		fruits.sort((s1,s2) -> s2.length() - s1.length()); //descending order
		System.out.println(fruits);
		
	}

}

class FruitsLengthComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
		return s2.length() - s1.length(); //s1-s2 for ascending order and s2-s1 for descending order always
	}
	
}

