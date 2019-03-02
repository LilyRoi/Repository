package Lesson10home_work;

public class Sentence implements Printable{
	String body;
	
	public Sentence(String body) {
		this.body = body;		
	}
	
	public Word[] getWords() {
		String [] array = body.split("\\s+");
		Word words [] = new Word[array.length];
		for(int i = 0; i < array.length; i++) {
			words[i] = new Word(array[i]);		
		}
		return words;
	}
	
	public void print(int number) {
		for(Word word: getWords()) {
			word.print(number);			
		}
	}

}
