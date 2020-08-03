package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 한빈이와SpotMart {
	static int T, N, M, ans, sum;
	static int[] numbers;
	static int[] arr = new int[2];
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			numbers = new int[N];

			for (int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
			}

			// 알고리즘
			combintation(0, 0); // 조합으로 가야할듯?
			if (ans == 0) {
				ans = -1;
			}
			System.out.printf("#%d %d\n", tc, ans);
			ans = 0;
			flag = false;

		}
	}

	private static void combintation(int idx, int start) {
		if (idx == 2) {// 2개를 뽑았으면 끝
			if (flag) {
				return;
			}
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if (M - sum == 0) {
				ans = M;
				flag = true;
			}
			if (M - sum >= 0) {
				ans = Math.max(ans, sum);
			}
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (flag) break;
			arr[idx] = numbers[i];
			combintation(idx + 1, i + 1);
		}

	}
}
