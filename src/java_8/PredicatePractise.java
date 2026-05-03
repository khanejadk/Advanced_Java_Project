package java_8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicatePractise {

	// Functional interface | boolean valued function -- test(T t); method | used to test a condition
	
	public static void main(String[] args) {

		Predicate<Integer> predicate = x -> x > 0; // predicate = (x) -> x > 0; we can remove bracket also if argument is only one.
		predicate.test(5);
		
		
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(11));
		
		Predicate<String> isStartWithD = s -> s.startsWith("d");
		System.out.println(isStartWithD.test("deepak"));

		Predicate<String> isEndsWithA = s -> s.endsWith("a");
		
		boolean result = isStartWithD.and(isEndsWithA).test("deepak.khaneja"); // we can combine the multiple conditions also
		System.out.println(result);
		
		
		// BiPredicate: boolean test(T t, U u);   | and();
		
		BiPredicate<Integer, Integer> biPred = (x, y) -> x > y;
		biPred.test(3, 7);
	}

}
