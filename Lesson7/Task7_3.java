package Lesson7home_work.copy;

import java.util.Scanner;

public class Task7_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("������� ���������� �����, ������� ������ �������: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			String s = scanner.nextLine();
			array[i] = s;
		}

		int totalLenght = 0;
		for (int i = 0; i < array.length; i++) {
			totalLenght = totalLenght + array[i].length();

		}
		int averageLength = totalLenght / n;
		System.out.println("������� �����: " + averageLength);

		System.out.println("������, ����� ������� ������ �������: ");
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() < averageLength) {
				System.out.println(array[i] + "(" + array[i].length() + ")");
			}
		}

		System.out.println("������, ����� ������� ������ �������: ");
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > averageLength) {
				System.out.println(array[i] + "(" + array[i].length() + ")");
			}
		}
	}
}
