package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 벽돌깨기 {
	static int T, N, W, H, map[][], arr[], Ans; // H x W 배열
	static boolean v[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 알고리즘
			// n회만큼 발사할 수 있으니까 중복순열을 구함.
			// 중복 순열만큼 dfs를 돌리는데 한번 돌리고 다 깨지면 깨진 블록 다시 배치해야함.

			arr = new int[N]; // 중복순열 값 담는 배열
//			permutaiton(0);
			v = new boolean[H][W];
			dfs(new Point(2, 2, 1));
			newmap(map);

			print(map);

			System.out.println(Ans);
		}

	}

	private static void newmap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

			}
		}

	}

	private static void permutaiton(int idx) {
		if (idx == N) {
//			System.out.println(Arrays.toString(arr));
			for (int i = 0; i < arr.length; i++) {
				if (search(arr[i]) == 0) {
					return;
				}
				v = new boolean[H][W];
				dfs(new Point(search(arr[i]), arr[i], 1));

			}
			return;
		}

		for (int i = 0; i < W; i++) {
			arr[idx] = i;
			permutaiton(idx + 1);
		}

	}

	private static void dfs(Point p) {
		v[p.r][p.c] = true;
		int size = map[p.r][p.c];
		map[p.r][p.c] = 0;

		for (int k = 0; k < 4; k++) {
			for (int cn = 0; cn < size; cn++) {
				int nr = p.r + dr[k] * cn;
				int nc = p.c + dc[k] * cn;

				if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] != 0 && !v[nr][nc]) {
					dfs(new Point(nr, nc, p.cnt++));
				}
			}

		}

	}

	private static int search(int i) { // dfs 시작할 행을 구함. 열은 i값
		for (int r = 0; r < map.length; r++) {
			if (map[r][i] != 0) {
				return r;
			}
		}

		return 0;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
