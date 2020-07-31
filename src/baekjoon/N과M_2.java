package baekjoon;

import java.util.Scanner;

public class N과M_2 {
	static int N, M;
	static int[] number;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		number = new int[M];
		sel = new boolean[N + 1];

		combination(0, 1);

	}

	private static void combination(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < number.length; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N; i++) {
			number[idx] = i;
			combination(idx + 1, i + 1);
		}

	}
}
