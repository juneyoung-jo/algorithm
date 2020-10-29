package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 보급로_다익스트라2 {
	static int T, N, map[][], Ans;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];

			for (int i = 0; i < map.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			Ans = Integer.MAX_VALUE;

			dijkstra(0, 0);
			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

	private static void dijkstra(int r, int c) {
		int[][] dist = new int[N][N];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		dist[r][c] = 0;
		v[r][c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (check(nr, nc))
				continue;
			dist[nr][nc] = map[nr][nc];
		}

		while (true) {
			int min = Integer.MAX_VALUE;
			int minR = -1;
			int minC = -1;

			// 최소값과 좌표 구함.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && dist[i][j] != Integer.MAX_VALUE) {
						if (dist[i][j] < min) {
							min = dist[i][j];
							minR = i;
							minC = j;
						}
					}
				}
			}

			v[minR][minC] = true;
			for (int k = 0; k < 4; k++) {
				int nr = minR + dr[k];
				int nc = minC + dc[k];

				if (check(nr, nc))
					continue;
				if (dist[nr][nc] > dist[minR][minC] + map[nr][nc]) {
					dist[nr][nc] = min + map[nr][nc];
				}
			}

			if (minR == N - 1 && minC == N - 1)
				break;

		}

		Ans = dist[N - 1][N - 1];
	}

	private static boolean check(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N)
			return true;
		return false;
	}

}
