package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите количество строк, которые будете вводить: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String array[] = new String[n];
		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine();
			array[i] = s;
		}
		int countPalindrome = 0;
		String palindrom = "";
		for (int i = 0; i < array.length; i++) {
			String s = array[i];
			if (s.matches("[0-9]+")) {
				String s2 = new StringBuilder(s).reverse().toString();
				boolean isPalindrom = s.equals(s2);
				if (isPalindrom && countPalindrome <= 2) {
					countPalindrome++;
					palindrom = s2;
				}
			}
		}
		if (countPalindrome == 0) {
			System.out.println("Палиндром не найден");
		} else {
			System.out.println("Палиндром = " + palindrom);
		}
	}

}