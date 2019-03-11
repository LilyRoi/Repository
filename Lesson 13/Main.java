package Lesson13home_work;

public class Main {
	public static void main(String [] args) {
		Massive m= new Massive(2);
		m.methodWithArithmeticException(0); // here ArithmeticException
		m.methodWithSomeCatch(2); //here NullPointerException 
		m.methodWithMultiCatch(4); //here NullPointerException
		m.methodWithFinally(5); 
		
		
		
	}

}
