package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("¬ведите количество строк, которые будете вводить: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine();
			array[i] = s;
		}
		for (int j = 0; j < array.length - 1; j++) {
			for (int i = j + 1; i < array.length; i++) {
				if (array[i].length() < array[j].length()) {
					String temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
