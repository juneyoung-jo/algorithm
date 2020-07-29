package swexpertacademy;

import java.util.Scanner;

public class 햄버거다이어트1 { // 조합으로 풀기
	static int T, N, L, sum, result, ans;
	static int[][] numbers;
	static int[][] arr;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();

			arr = new int[N][2];

			for (int i = 0; i < arr.length; i++) { // 값 저장
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}

			}
			sel = new boolean[N];
			// 알고리즘
			for (int i = 0; i < arr.length; i++) {
				numbers = new int[i + 1][2];
				permutation(0, 0);
			}
			System.out.printf("#%d %d\n", tc, ans);
			ans = 0;

		}
	}

	private static void permutation(int idx, int start) {
		if (idx == numbers.length) {
			sum = 0;
			result = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i][1];
				result += numbers[i][0];
			}
			if (L - sum >= 0) {
				ans = Math.max(ans, result);
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			numbers[idx][1] = arr[i][1];
			numbers[idx][0] = arr[i][0];
			permutation(idx + 1, i + 1);
		}

	}

}
