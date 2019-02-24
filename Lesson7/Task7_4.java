package Lesson7home_work.copy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Task7_4 {
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
		String wordMinCharVar = array[0];
		List chars = Arrays.asList(array[0].split(""));
		int sizeMinCharVar = new HashSet<String>(Arrays.asList(array[0].split(""))).size();
		for (String word : array) {
			Set<String> set = new HashSet<String>(Arrays.asList(word.split("")));
			if (set.size() < sizeMinCharVar) {
				wordMinCharVar = word;
				sizeMinCharVar = set.size();
			}
		}
		System.out.println("Cлово, в котором число различных символов минимально: "+ wordMinCharVar + "(" + sizeMinCharVar + ")");

	}

}