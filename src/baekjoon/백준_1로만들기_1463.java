package baekjoon;

import java.util.Scanner;

public class 백준_1로만들기_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] ans = new int[N+3];

		ans[1] = 0;
		ans[2] = 1;
		ans[3] = 1;

		for (int i = 4; i <= N; i++) {
			ans[i] = 1 + ans[i - 1];
			if (i % 2 == 0) {
				if (ans[i] > ans[2] + ans[i / 2]) {
					ans[i] = ans[2] + ans[i / 2];
				}
			}
			if (i % 3 == 0) {
				if (ans[i] > ans[3] + ans[i / 3]) {
					ans[i] = ans[3] + ans[i / 3];
				}
			}

		}

		System.out.println(ans[N]);
	}

}
