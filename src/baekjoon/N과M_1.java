package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_1 {
	static int N, M;
	static int[] number;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		number = new int[M];
		sel = new boolean[N + 1];

		combination(0);

	}

	private static void combination(int idx) {
		if (idx == M) {
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (sel[i]) continue;
			number[idx] = i;
			sel[i] = true;
			combination(idx + 1);
			sel[i] = false;
		}

	}
}
