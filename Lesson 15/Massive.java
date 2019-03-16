package Lesson15home_work;


public class Massive {
private String name;
	
	private int length;
	
	public int getLastItem(int [] array) {
		return array[array.length-1];
	}
	
	public int getLenght(int [] array) {
		return array.length;
	}
	
	public int getFirstItem(int [] array) {
		return array[0];
	}
	
	public void methodWithException() {
		throw new ExampleException();
	}
	
	
	public void setLength(String length) {
		this.length = Integer.parseInt(length);		
	}

}
