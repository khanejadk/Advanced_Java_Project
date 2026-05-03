package java_8;

import java.util.function.Supplier;

public class SupplierPractise {

	// Functional interface | Return something -- T get(); method | used to supply value of specified datatype
	
	public static void main(String[] args) {

		Supplier<Integer> supplier = () -> 10; // T get();
		
		System.out.println(supplier.get());

	}

}
