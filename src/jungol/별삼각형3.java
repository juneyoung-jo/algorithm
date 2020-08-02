package jungol;

import java.util.Scanner;

public class 별삼각형3 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		if (n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}

		int mid = n / 2;

		for (int i = 0; i < n; i++) {
			if (i <= mid) { // 공백
				for (int j = 0; j < i; j++) {
					System.out.print(' ');
				}
			} else {
				for (int j = i+1; j < n; j++) {
					System.out.print(' ');
				}
			}

			if (i <= mid) { // 별
				for (int j = n - i; j <= n + i; j++) {
					System.out.print('*');
				}
			} else {
				for (int j = i; j < n + (2 * mid) - i; j++) {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}

}
