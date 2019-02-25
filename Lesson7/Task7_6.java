package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_6 {
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
		boolean wordNotFound = true;
		for (int i = 0; i < array.length; i++) {
			String string = array[i];
			int count = 0;
			for (int j = 1; j < string.length(); j++) {
				if (string.toCharArray()[j] > string.toCharArray()[j - 1]) {
					count++;
				}
			}
			if ((string.length() - 1 == count) && (string.length() > 1)
					&& wordNotFound) {
				System.out
						.println("Cлово, символы в котором идут в строгом пор€дке возрастани€ их кодов: "
								+ string);
				wordNotFound = false;
				break;
			}

		}
		if (wordNotFound) {
			System.out.println("NOT FOUND");
		}

	}

}