package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성_강의코드 {
	static int T, N, K, map[][], max, top;
	static boolean[][] v;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[N][N];
			max = 0; // 최장 경로
			top = 0; // 봉우리

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (top < map[i][j])
						top = map[i][j];
				}
			}

			findTop();
			System.out.printf("#%d %d\n", tc, max);

		}
	}

	private static void findTop() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == top) {
					makeLoad(i, j, map[i][j], false, 1);
				}
			}
		}

	}

	// dfs
	private static void makeLoad(int r, int c, int height, boolean isUsed, int distance) {
		max = Math.max(max, distance);
		v[r][c] = true;

		int nr, nc;
		for (int k = 0; k < 4; k++) {
			nr = r + dr[k];
			nc = c + dc[k];

			if (nr >= 0 & nc >= 0 && nr < N && nc < N && !v[nr][nc]) {
				if (height > map[nr][nc]) { // 현 위치 기준으로 내리막
					makeLoad(nr, nc, map[nr][nc], isUsed, distance + 1);
				} else if (!isUsed && map[nr][nc] - K < height) { // 현 위치 기준으로 오르막 : 깎아서 갈 수 있는지 체크
					makeLoad(nr, nc, height - 1, true, distance + 1);
				}
			}
		}

		v[r][c] = false;

	}

}
