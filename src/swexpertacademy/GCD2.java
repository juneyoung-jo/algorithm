package swexpertacademy;

import java.util.Scanner;

public class GCD2 {
	static int T, K, cnt, A, B;
	static long[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		v = new long[93];
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			v[0] = 0;
			v[1] = 1;

			for (int i = 2; i < v.length; i++) {
				v[i] = v[i - 1] + v[i - 2];
			}

			System.out.printf("#%d %d %d\n", tc, v[K + 2], v[K + 1]);
		}
	}

}
