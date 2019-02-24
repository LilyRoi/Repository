package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите количество строк, которые будете вводить: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine();
			array[i] = s;
		}
		int maxIndex = 0;
		int maxSize = array[0].length();
		int minIndex = 0;
		int minSize = array[0].length();
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > maxSize) {
				maxIndex = i;
				maxSize = array[i].length();
			}
			if (array[i].length() < minSize) {
				minIndex = i;
				minSize = array[i].length();
			}
		}
		System.out.printf("Самая длинная строка %s с количеством символов %d",
				array[maxIndex], maxSize);
		System.out.println();
		System.out.printf("Самая короткая строка %s с количеством символов %d",
				array[minIndex], minSize);
	}
}