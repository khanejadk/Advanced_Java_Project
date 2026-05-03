package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class streamPractise_1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 8, 9, 78);
		
		Optional<Integer> sum1 = list.stream().reduce((a, b) -> a + b); // here result will be of optional type because null values can be there and also no identity parameter is specified before.
		
		Integer sum2 = list.stream().reduce(0, (a, b) -> a + b); // here we already took the identity = 0, so there will not be any null so result will be of type Integer
		
		System.out.println(sum1.get());
		System.out.println(sum2);

		boolean result = list.stream().anyMatch(x -> x > 0);
		
		
		// count occurence of a character. lets say 'l'
		String str = "hello world";
		
		str.chars().filter(x -> x == 'l').count();  // str.chars() will produce a stream of characters.
		
		// statefull and stateless operations.
		// statefull when stream has to observe each elements of a collection at a time. for ex: sorted and distinct operations are stateful
		// stateless when stream has nothing to do with other elements of collections other than the one it is executing. eg: map
		
		List<List<String>> names = Arrays.asList(
				Arrays.asList("Deepak", "Khaneja"),
				Arrays.asList("Heena", "Khaneja"),
				Arrays.asList("Veena", "Khaneja"));
		
		System.out.println(names.stream().flatMap(x -> x.stream()).toList());
		System.out.println(names.stream().flatMap(List::stream).toList());
		
		List<String> words = Arrays.asList(
				"Deepak is",
				"a good person",
				"and a very",
				"kind human being");
		
		System.out.println(words.stream().flatMap(x -> Arrays.stream(x.split(" "))).map(String::toUpperCase).toList());
	}

}