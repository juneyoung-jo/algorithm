package swexpertacademy;

import java.util.Scanner;

public class 방향전환 {
	static int T, X, Y, x, y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			int sX = Math.abs(X - x);
			int sY = Math.abs(Y - y);

			int ans = 0;

			if (X == x && Y == y) {
				System.out.printf("#%d %d\n", tc, ans);
				continue;
			}

			if (sX > sY) {
				while (true) {
					ans++;
					if (X - x >= 0) {
						X -= 1;
					} else {
						X += 1;
					}

					// 비교
					if (X == x && Y == y) {
						break;
					}

					ans++;
					if (Y - y >= 0) {
						Y -= 1;
					} else {
						Y += 1;
					}

					if (X == x && Y == y) {
						break;
					}

				}
			} else {

				while (true) {
					ans++;
					if (Y - y >= 0) {
						Y -= 1;
					} else {
						Y += 1;
					}

					if (X == x && Y == y) {
						break;
					}

					ans++;
					if (X - x >= 0) {
						X -= 1;
					} else {
						X += 1;
					}

					// 비교
					if (X == x && Y == y) {
						break;
					}

				}

			}

			System.out.printf("#%d %d\n", tc, ans);

		}

	}

}
