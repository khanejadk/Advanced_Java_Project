package java_8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionPractise {

	// Functional interface | R apply(T t); method | used to do some operation and then return a value
	
	public static void main(String[] args) {

		Function<Integer, Integer> function = (x) -> x + 18;   // R apply(T t)
		function.apply(10); // 10 + 18 = 28
		
		Function<Integer, Integer> doubleTheValue = x -> x * 2;
		
		Integer result = function.andThen(doubleTheValue).apply(10);
		
		System.out.println(result);
		
		function.compose(doubleTheValue).apply(10); // here doubleTheValue will run first and then function will run using compose default method
		
		Function<Integer, Integer> identityFunc = Function.identity(); // it is a static method of the Function functional interface. It will give the result as it is (input = output)
		
		
		// BiFunction: R apply(T t, U u);  | .andThen();
		
		BiFunction<Integer, Integer, Integer> biFunc = (x, y) -> x * y;
		biFunc.apply(10, 3);
		
		
		// Unary and Binary Operator: extends Funciton and BiFunction
		
		UnaryOperator<Integer> uOP = x -> x * x; // basically when argument and return type both are same then use unary operator instead of Function without writing Integer two times.
		
		BinaryOperator<Integer> bOP = (x, y) -> x - y; // both arguments are same and also their return type is same then use BinaryOperator instead of using BiFunction.
	}

}
