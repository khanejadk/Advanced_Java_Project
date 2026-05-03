package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerPractise {

	// Functional interface | It will just accept or consume something but won't return anythig -- void accept(T t); method | used to consume something
	
	public static void main(String[] args) {

		Consumer<Integer> consumer =  x -> System.out.println(x); // void accept(T t);
		
		consumer.accept(10);
		
		List<Integer> list =  Arrays.asList(1,2,3,4,5);
		
		Consumer<List<Integer>> printList = x -> {
			for(int i: x) {
				System.out.println(i);
			}
		};
		
		printList.accept(list);
		
		// consumer.andThen(printList).accept(list);
		
		
		// BiConsumer: void accept(T t, U u);  |  .andThen();
		
		BiConsumer<Integer, Integer> biCons = (x, y) -> System.out.println(x + y);
		biCons.accept(10, 8);

	}

}
