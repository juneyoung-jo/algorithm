package swexpertacademy;

import java.util.Scanner;

public class 정사각형방 {
	static int T, N, map[][], cnt = 0, start = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					search(i, j, 1, map[i][j]);
				}
			}

			System.out.printf("#%d %d %d\n", tc, start, cnt);
			start=0;
			cnt=0;

		}

	}

	private static void search(int x, int y, int count, int num) {
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) { // 테두리
				if (map[nr][nc] == map[x][y] + 1) {
					search(nr, nc, count + 1, num);
				}
			}
		}

		if (cnt == count) {
			if (start > num) {
				start = num;
			}
		}

		if (cnt < count) {
			cnt = count;
			start = num;
		}
	}

}
