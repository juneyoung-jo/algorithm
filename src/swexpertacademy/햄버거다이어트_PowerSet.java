package swexpertacademy;

import java.util.Scanner;

public class 햄버거다이어트_PowerSet { // 부분집합으로 풀기
	static int T, N, L, sum, result, ans;
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
			powerSet(0);
			System.out.printf("#%d %d\n", tc, ans);
			ans = 0;

		}
	}

	private static void powerSet(int idx) {
		if (idx == arr.length) {
			sum = 0;
			result = 0;
			for (int i = 0; i < arr.length; i++) {
				if (sel[i] == true) {
					sum += arr[i][1];
					result += arr[i][0];
				}
			}
			if (L - sum >= 0) {
				ans = Math.max(ans, result);
			}
			return;
		}

		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);

	}

}
