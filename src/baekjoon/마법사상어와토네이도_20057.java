package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도_20057 {
	static int N, map[][], ans;
	static int[] dr = { -2, -1, -1, -1 }; // ㅗ 모양
	static int[] dc = { 0, -1, 0, 1 };
	static double[] uRatio = { 0.02, 0.1, 0.07, 0.01 };
	static double[] dRatio = { 0.02, 0.01, 0.07, 0.1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cal(map);

//		print(map);
		System.out.println(ans);

	}

	private static void cal(int[][] map) {
		int r = N / 2;
		int c = N / 2;
		int sw = 0;
		int num = 1;
		int cnt = 1;
		while (true) {

			if (sw == 0) {
				for (int i = 0; i < cnt; i++) {
					leftCal(r, --c);
//					map[r][--c] = num++;
				}
				for (int i = 0; i < cnt; i++) {
					downCal(++r, c);
//					map[++r][c] = num++;
				}
				sw = 1;
			} else {
				for (int i = 0; i < cnt; i++) {
					rightCal(r, ++c);
//					map[r][++c] = num++;
				}
				for (int i = 0; i < cnt; i++) {
					upCal(--r, c);
//					map[--r][c] = num++;
				}
				sw = 0;
			}
			cnt++;
			if (cnt == N) {
				for (int i = 1; i < cnt; i++) {
					leftCal(r, --c);
//					map[r][--c] = num++;
				}
				break;
			}
		}
	}

	private static void upCal(int r, int c) {
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dc[k];
			int nc = c + dr[k];

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * uRatio[k];
				sum += (int) map[r][c] * uRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * uRatio[k];
			sum += (int) map[r][c] * uRatio[k];
		}

		for (int k = 0; k < 4; k++) {
			int nr = r + dc[k] * -1;
			int nc = c + dr[k] * -1;

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * dRatio[k];
				sum += (int) map[r][c] * dRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * dRatio[k];
			sum += (int) map[r][c] * dRatio[k];
		}

		int nc = c;

		int nr = r - 2;
		if (!check(nr, nc)) {
			ans += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		} else {
			map[nr][nc] += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		}

		nr = r - 1;
		if (!check(nr, nc)) {
			ans += map[r][c] - sum;
		} else {
			map[nr][nc] += map[r][c] - sum;
		}

		map[r][c] = map[++r][c];

	}

	private static void downCal(int r, int c) {
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dc[k];
			int nc = c + dr[k];

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * dRatio[k];
				sum += (int) map[r][c] * dRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * dRatio[k];
			sum += (int) map[r][c] * dRatio[k];
		}

		for (int k = 0; k < 4; k++) {
			int nr = r + dc[k] * -1;
			int nc = c + dr[k] * -1;

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * uRatio[k];
				sum += (int) map[r][c] * uRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * uRatio[k];
			sum += (int) map[r][c] * uRatio[k];
		}

		int nc = c;

		int nr = r + 2;
		if (!check(nr, nc)) {
			ans += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		} else {
			map[nr][nc] += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		}

		nr = r + 1;
		if (!check(nr, nc)) {
			ans += map[r][c] - sum;
		} else {
			map[nr][nc] += map[r][c] - sum;
		}

		map[r][c] = map[--r][c];

	}

	private static void rightCal(int r, int c) {
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * dRatio[k];
				sum += (int) map[r][c] * dRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * dRatio[k];
			sum += (int) map[r][c] * dRatio[k];
		}

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k] * -1;
			int nc = c + dc[k] * -1;

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * uRatio[k];
				sum += (int) map[r][c] * uRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * uRatio[k];
			sum += (int) map[r][c] * uRatio[k];
		}

		int nr = r;

		int nc = c + 2;
		if (!check(nr, nc)) {
			ans += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		} else {
			map[nr][nc] += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		}

		nc = c + 1;
		if (!check(nr, nc)) {
			ans += map[r][c] - sum;
		} else {
			map[nr][nc] += map[r][c] - sum;
		}

		map[r][c] = map[r][--c];

	}

	private static void leftCal(int r, int c) {
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * uRatio[k];
				sum += (int) map[r][c] * uRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * uRatio[k];
			sum += (int) map[r][c] * uRatio[k];
		}

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k] * -1;
			int nc = c + dc[k] * -1;

			if (!check(nr, nc)) {
				ans += (int) map[r][c] * dRatio[k];
				sum += (int) map[r][c] * dRatio[k];
				continue;
			}

			map[nr][nc] += (int) map[r][c] * dRatio[k];
			sum += (int) map[r][c] * dRatio[k];
		}

		int nr = r;

		int nc = c - 2;
		if (!check(nr, nc)) {
			ans += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		} else {
			map[nr][nc] += (int) map[r][c] * 0.05;
			sum += (int) map[r][c] * 0.05;
		}

		nc = c - 1;
		if (!check(nr, nc)) {
			ans += map[r][c] - sum;
		} else {
			map[nr][nc] += map[r][c] - sum;
		}

		map[r][c] = map[r][++c];

	}

	// 경계선 넘어간 모래
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N)
			return false;
		return true;
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
