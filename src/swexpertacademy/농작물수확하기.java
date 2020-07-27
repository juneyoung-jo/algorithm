package swexpertacademy;

import java.util.Scanner;

public class 농작물수확하기 {
	static int T, N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int num = N / 2;
			int ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = Math.abs(i - num); j < N - Math.abs(i - num); j++) {
					ans += map[i][j];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}

}
