package Lesson10home_work;

import java.util.Scanner;

public class Task10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Какую букву заменить:");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Какую букву заменить: ");
		int number = scanner.nextInt();
		scanner.nextLine();

		String str = new String();
		for (int i = 0; i < n; i++) {
			str = str + scanner.nextLine();
		}		
		String[] array = str.split("\\t");

		Paragraph[] paragraphs = new Paragraph[array.length];		
		for (int i=0; i<array.length; i++) {			
			paragraphs[i]= new Paragraph(array[i]);			
		}
		
		for(Paragraph p : paragraphs) {			
			p.print(number);			
		}

	}

}
