package swexpertacademy;

import java.util.Scanner;

public class Professional조합 {
	static int T, N, R;
	static final int P = 1234567891;
	static long dp[] = new long[1000002];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		dp[0] = dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = (i * dp[i - 1]) % P;
		}
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			R = sc.nextInt();

			long a = cal((dp[R] * dp[N - R]) % P, P - 2); //(n-r)!(r!)^1234567891 -2
			long ans = (dp[N] * a) % P; //
			System.out.printf("#%d %d\n", tc, ans);
		}

	}

	private static long cal(long x, int div) {

		if (div == 1)
			return x;
		long result = cal(x, div / 2);
		result = (result * result) % P;
		if (div % 2 != 0) {
			result = (result * x) % P;
		}

		return result;

	}

}
