package baekjoon;

import java.util.Scanner;

public class 사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A, B, C, D;
		int P, M, N;
		int result = 0;
		int result1 = 0;
		int result2 = 0;

		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		P = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();

		if (P % (A + B) != 0) {
			if (P % (A + B) - A <= 0) {
				result++;
			}
		}
		if (P % (C + D) != 0) {
			if (P % (C + D) - C <= 0) {
				result++;
			}
		}

		if (M % (A + B) != 0) {
			if (M % (A + B) - A <= 0) {
				result1++;
			}
		}
		if (M % (C + D) != 0) {
			if (M % (C + D) - C <= 0) {
				result1++;
			}
		}

		if (N % (A + B) != 0) {
			if (N % (A + B) - A <= 0) {
				result2++;
			}
		}
		if (N % (C + D) != 0) {
			if (N % (C + D) - C <= 0) {
				result2++;
			}
		}

		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);
		
		sc.close();

	}

}
