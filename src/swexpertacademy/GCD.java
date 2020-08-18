package swexpertacademy;

import java.util.Scanner;

public class GCD {
	static int T, K, cnt, A, B;
	static long[][] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		v = new long[91][2];

		// 알고리즘
		// 피보나치 수열?임.
		// for - while로 먼저 짜고 결과값 비교해서 만듬 -> 시간초과
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			int a = 2;
			int b = 1;
			v[1][0] = 2;
			v[1][1] = 1;
			v[2][0] = 3;
			v[2][1] = 2;

			for (int i = 3; i <= K; i++) {
				v[i][0] = v[i - 1][0] + v[i - 2][0];
				v[i][1] = v[i - 1][1] + v[i - 2][1];
			}

			System.out.printf("#%d %d %d\n", tc, v[K][0], v[K][1]);
		}
	}

}
