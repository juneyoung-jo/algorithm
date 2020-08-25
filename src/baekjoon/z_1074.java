package baekjoon;

import java.util.Scanner;

public class z_1074 {
	static int N, r, c, map[][], div, Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		div = (int) Math.pow(2, N);
		cal(1, r, c);

	}

	private static void cal(int idx, int r, int c) {
		if (idx == N) {
			int nr = Math.abs(r) % 2;
			int nc = Math.abs(c) % 2;

			if (nr == 1 && nc == 1) {
				System.out.println(Ans + 3);
			} else if (nr == 1 && nc == 0) {
				System.out.println(Ans + 2);
			} else if (nr == 0 && nc == 1) {
				System.out.println(Ans + 1);
			} else {
				System.out.println(Ans);
			}
			return;
		}

		div /= 2;
		if (div < r + 1 && div < c + 1) {
			Ans += (int) (3 * Math.pow(div, 2));
		} else if (div < r + 1 && div >= c + 1) {
			Ans += (int) (2 * Math.pow(div, 2));
		} else if (div >= r + 1 && div < c + 1) {
			Ans += (int) (1 * Math.pow(div, 2));
		} else {
			Ans += (int) (0 * Math.pow(div, 2));
		}
		r %= div;
		c %= div;
		cal(idx + 1, r, c);
	}

}
