package java_8;

public class FunctionalInterfacePractise {

	public static void main(String[] args) {

		MathsOperation op1 = new sumOperation();
		op1.operation(1, 2); // this is the old way to create op1 object using interface reference and then call the method using implementing class
		
		MathsOperation op2 = (int a, int b) -> {
			
			return a + b;
			
		}; // also we can remove arguments data type also because we know functional interface has only one method and its understandable and also if only one return statement then can be written in single line.
           // MathsOperation op2 = (a, b) -> a + b;
		
		MathsOperation subtract = (a, b) -> a - b; // here we just defined what that interface method will do
		
		int result = subtract.operation(5, 2); // here we are actually using it
		
		System.out.println(result);
		
		
	}

}

@FunctionalInterface
interface MathsOperation{
	
	int operation(int a, int b);
}

class sumOperation implements MathsOperation{

	@Override
	public int operation(int a, int b) {
		
		return a + b;
		
	}
	
}

class subtractOperation implements MathsOperation{

	@Override
	public int operation(int a, int b) {
		
		return a - b;
		
	}
	
}