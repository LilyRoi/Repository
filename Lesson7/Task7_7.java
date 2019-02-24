package Lesson7home_work.copy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task7_7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¬ведите количество строк, которые будете вводить: ");
		int n = scanner.nextInt(); 
		scanner.nextLine(); 
		
		String array[] = new String[n]; 

		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine(); 
			array[i] = s; 
		}

		for (String word : array) { 
			HashSet<String> set = new HashSet<String>(Arrays.asList(word.split(""))); 
																					
			int countOfUniqChars = set.size();			
			int countOfAllChars = Arrays.asList(word.split("")).size();			
			if (countOfAllChars == countOfUniqChars) {
				System.out.println(word);
				break;
			}

		}

	}

}