package Lesson10home_work;

public class Word implements Printable{
	private String body;

	public Word(String body) {
		this.body = body;
	}

	public void print(int number) {		
		if (body.length() > number) {
			StringBuilder b = new StringBuilder(body);
			b.setCharAt(number, '%');
			System.out.print(b.toString() + " ");
		}

	}

}
