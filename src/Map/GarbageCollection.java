package Map;

import java.lang.ref.WeakReference;

public class GarbageCollection {

	public static void main(String[] args) {
		
		Phone phone = new Phone("IQOO", "12");  // it is a strong reference (strong pionter reference)
		
		WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "16 pro max"));
		
	    System.out.println(phoneWeakReference.get());
	    
	    System.gc(); // it just suggest the JVM to clear the memory. but final call will be of JVM to clear the memory.
	    
	    try {
	    	Thread.sleep(10000);
	    } catch (Exception ignored) {
	    	
	    }
	    System.out.println(phoneWeakReference.get());

	}
}
	
class Phone {
	String brand;
	String model;

	public Phone(String brand, String model) {
		this.brand = brand;
	    this.model = model;
	}

	@Override
	public String toString() {
		return "Phone{" +
	    "brand='" + brand + '\'' +
	    ", model='" + model + '\'' +
	    '}';
	}

}

/*

Using WeakReference, it suggests JVM to clear the memory after the operation.

for strong reference, JVM will not clear the memory itself but for weak reference it will clear after the operation.

It don't use much in the industry, only in some case of cashing it got used. If not, it can pick the data from the main memory if not caching.


*/