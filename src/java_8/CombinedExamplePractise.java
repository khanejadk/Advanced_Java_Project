package java_8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CombinedExamplePractise {

	public static void main(String[] args) {

		Predicate<Integer> predicate = x -> x > 50;
		
		Function<Integer, Integer> function = x -> x + 52;
		
		Consumer<Integer> consumer = x -> System.out.println("KL Rahul's highest score in IPL: " + x);
		
		
		
		Supplier<Integer> supplier = () -> 100;
		
		if(predicate.test(supplier.get())) {
			
			consumer.accept(function.apply(supplier.get()));
		}

	}

}
