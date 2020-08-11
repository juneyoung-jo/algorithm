package swexpertacademy;

import java.util.Scanner;

public class NQueen미완성 {
	static int T, N, map[][], Ans[][], cnt;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 8방
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			Ans = new int[N][N];

			for (int c = 0; c < N; c++) {
				nqueen(0, c, new boolean[N][N]);
			}
			System.out.printf("#%d %d", tc, cnt);
			cnt = 0;

		}

	}

	private static void nqueen(int r, int c, boolean[][] v) {
		if (r == N - 1) {
			return;
		}

		v[r][c] = true;
		boolean isOk = true;
		for (int k = 0; k < 8; k++) {
			for (int i = 1; i <= N; i++) {
				int nr = r + dr[k] * i;
				int nc = c + dc[k] * i;
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && v[nr][nc]) { // 트루로 만들기
					isOk = false;
				}
			}
		}

		if (isOk) {
			for (int i = 0; i < v.length; i++) {
				if (r + 1 == N - 1) {
					cnt++;
				}
				nqueen(r + 1, i, v);
			}
		}

	}

	private static void print(boolean[][] v) {

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

}
