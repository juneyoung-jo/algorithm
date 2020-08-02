package jungol;

import java.util.Scanner;

public class 별삼각형2 {
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		if (n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}

		int mid = n / 2;

		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				if (i < mid) {
					for (int j = 0; j <= i; j++) {
						System.out.print('*');
					}
				} else {
					for (int j = 0; j < n - i; j++) {
						System.out.print('*');
					}
				}
				System.out.println();
			}

			break;
		case 2:
			for (int i = 0; i < n; i++) {
				if (i < mid) {
					for (int j = 0; j < mid - i; j++) {
						System.out.print(' ');
					}
				} else {
					for (int j = 0; j < Math.abs(mid - i); j++) {
						System.out.print(' ');
					}
				}

				if (i < mid) {
					for (int j = 0; j <= i; j++) {
						System.out.print('*');
					}
				} else {
					for (int j = 0; j < n - i; j++) {
						System.out.print('*');
					}
				}
				System.out.println();
			}

			break;
		case 3:
			for (int i = 0; i < n; i++) {
				if (i < mid) {
					for (int j = 0; j < i; j++) {
						System.out.print(' ');
					}
				} else {
					for (int j = 0; j < n - i - 1; j++) {
						System.out.print(' ');
					}
				}

				if (i < mid) {
					for (int j = i; j < n - i; j++) {
						System.out.print('*');
					}
				} else {
					for (int j = n - i - 1; j <= i; j++) {
						System.out.print('*');
					}
				}
				System.out.println();
			}

			break;
		case 4:
			for (int i = 0; i < n; i++) {
				if (i < mid) {
					for (int j = 0; j < i; j++) {
						System.out.print(' ');
					}
				} else {
					for (int j = i; j < i+mid; j++) {
						System.out.print(' ');
					}
				}

				if (i < mid) {
					for (int j = 0; j <= mid - i; j++) {
						System.out.print('*');
					}
				} else {
					for (int j = mid; j <= i; j++) {
						System.out.print('*');
					}
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
