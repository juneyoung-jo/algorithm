package jungol;

import java.util.Scanner;

public class 별삼각형1 {
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		if (n > 100 || n < 1) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}

		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print('*');
				}
				System.out.println();
			}

			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print('*');
				}
				System.out.println();
			}

			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1 - i; j++) {
					System.out.print(' ');
				}

				for (int j = n - i; j <= n + i; j++) {
					System.out.print('*');
				}
				System.out.println();
			}

			break;

		default:
			System.out.println("INPUT ERROR!");
			break;
		}

	}

}
