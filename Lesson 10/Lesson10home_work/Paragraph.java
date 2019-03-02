package Lesson10home_work;

public class Paragraph implements Printable{
	
	private String body;
	
	public Paragraph(String body) {
		this.body = body;		
	}
	
	public Sentence[] getSentences() {
		String [] array = body.split("\\.");
		Sentence sentenses [] = new Sentence[array.length];
		for(int i = 0; i < array.length; i++) {
			sentenses[i] = new Sentence(array[i]);		
		}
		return sentenses;
	}
	
	public void print(int number) {	
		System.out.println("\t");
		for(Sentence s : getSentences()) {			
			s.print(number);
			
		}		
	}

}
