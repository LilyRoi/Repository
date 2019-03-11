package Lesson13home_work;

public class Massive {
	public String name;
	private int size;

	Massive(int size) {
		this.size = size;
	}

	public int methodWithArithmeticException(int a) {
		int result = 0;
		try {
			result = size / a;
		} catch (ArithmeticException e) {
			System.out.println("division by 0");
		}
		return result;

	}

	public int methodWithSomeCatch(int a) {
		int result = 0;
		try {
			result = size / a;
			name.length();
		} catch (ArithmeticException e) {
			System.out.println("division by 0");
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException");
		}
		return result;
	}

	public int methodWithMultiCatch(int a) {
		int result = 0;
		try {
			result = size / a;
			name.length();
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println(e.getClass());
		}
		return result;
	}

	public int methodWithFinally(int a) {
		int result = 0;
		try {
			result = size / a;
		} catch (ArithmeticException e) {
			System.out.println("division by 0");
		} finally {
			System.out.println("From Finally");
			return result;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

}
