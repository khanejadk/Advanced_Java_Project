package java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		// Method reference: using the method without actual invoking and in place of lambda expression.
		
		List<String> students = Arrays.asList("Deepak", "Arun", "Karan");
		
		students.forEach(x -> System.out.println(x)); // using actual lambda expression
		
		students.forEach(System.out::println); // using method reference in place of lambda expression
		
		// Constructor reference:
		
		List<String> modelName = Arrays.asList("A1", "A2", "A3");
		
		modelName.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList()); // again using the lambda expression and mapping the field into class object
		
		modelName.stream().map(MobilePhone::new).collect(Collectors.toList()); // using the constructor reference to map the field into object
		
		// Actual streams: It used to process list of collections using the functional and declarative manner. It basically simplifies the data processing thing and improve readability.
		
		/// Stream Creation:
		
		// 1. apply on a collection
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		Stream<Integer> stream1 = nums.stream();
		
		// 2. using Arrays
		Integer[] arr = {1, 2, 3, 4, 5};
		Stream<Integer> stream2 =  Arrays.stream(arr);
		
		// 3. Using Stream.of()
		Stream<String> stream3 = Stream.of("Karan", "Rahul", "Manish", "Gagan");
		
		// 4. Infinite stream
		Stream.generate(() -> 1); // will create infinite streams of all 1
		Stream.generate(() -> 1).limit(50); // finite streams of 1 of size 50
		
		// 5. infinite streams using iterator
		Stream.iterate(0, x -> x + 1); // 0, 1, 2, 3, 4 ........ will give infinite stream 

		
		// Stream to array convert: toArray() it is a terminal operator
		Stream<Integer> st = Stream.of(1, 2, 3, 4, 5);
		Object[] array = st.toArray();
		
		System.out.println(Stream.of(1, 2, 3, 4, 5).max(Comparator.naturalOrder()).get());
		System.out.println(Stream.of(1, 2, 3, 4, 5).max(Integer::compare).get());
		
		System.out.println(Stream.of(1, 2, 3, 4, 5).sorted(Comparator.reverseOrder()).toList());
		
		
	}

}

class MobilePhone {
	
	private String model;

	public MobilePhone(String model) {
		this.model = model;
	}
	
	
}