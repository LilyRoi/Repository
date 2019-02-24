package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите количество строк, которые будете вводить: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String array[] = new String[n];
		int countOfLatinWords = 0;
		int countOfWordsWithTheSameCountVovelsAndConsonants = 0;
		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine();
			array[i] = s;
			if (s.matches("[A-z]+")) {
				countOfLatinWords++;
				int consonantsCount = s.replaceAll("[aeiouAEIOU]", "").length();
				int vowelsCount = s.replaceAll("[^aeiouAEIOU]", "").length();
				if (vowelsCount == consonantsCount) {
					countOfWordsWithTheSameCountVovelsAndConsonants++;
				}
			}
		}
		System.out
				.println("Количество слов, содержащих только символы латинского алфавита = "
						+ countOfLatinWords);
		System.out
				.println("Количество слов с равным числом гласных и согласных букв = "
						+ countOfWordsWithTheSameCountVovelsAndConsonants);

	}

}