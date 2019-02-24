package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� ���������� �����, ������� ������ �������: ");
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
				.println("���������� ����, ���������� ������ ������� ���������� �������� = "
						+ countOfLatinWords);
		System.out
				.println("���������� ���� � ������ ������ ������� � ��������� ���� = "
						+ countOfWordsWithTheSameCountVovelsAndConsonants);

	}

}