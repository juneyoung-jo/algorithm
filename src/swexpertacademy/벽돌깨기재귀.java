package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벽돌깨기재귀 {
	static int T, N, W, H, ans, point, map[][]; // H x W 배열
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			ans = Integer.MAX_VALUE;
			point = 0;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0)
						point++;
				}
			}

//			print(map);
			cal(N);

			System.out.printf("#%d %d\n", tc, ans);

		}

	}

	private static void cal(int n) {
		if (n == 0 || ans == 0) {
			ans = Math.min(point, ans);
			return;
		}
		int[][] nMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			for (int r = 0; r < H; r++) {
				if (map[r][c] > 0) {
					int sc = point;
					copy(map, nMap);
					dfs(r, c, map[r][c]);
					sortMap(map);
					ans = Math.min(point, ans);
					cal(n - 1);
					copy(nMap, map);
					point = sc;
					break;
				}
			}
		}

	}

	private static void copy(int[][] copymap, int[][] nMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				nMap[i][j] = copymap[i][j];
			}
		}
	}

	private static void sortMap(int[][] map) {// dfs돌 때 마다 사라진 블록을 제외하고 맵을 정렬해줘야 함..
		for (int i = 0; i < W; i++) {
			int arr[] = new int[H]; // 정렬할 때 배열에 저장해서 다 출력하는 식으로 만듬
			int cnt = 0;
			for (int j = H - 1; j >= 0; j--) {// 끝에서부터 값이 있으면 배열에 저장
				if (map[j][i] != 0) {
					arr[cnt++] = map[j][i];

				}
			}
			for (int j = 0; j < H; j++) {
				map[H - j - 1][i] = arr[j];
			}
		}
	}

	private static void dfs(int r, int c, int count) {
		map[r][c] = 0;
		point--;

		for (int k = 0; k < 4; k++) {
			for (int cn = 1; cn < count; cn++) {

				int nr = r + dr[k] * cn;
				int nc = c + dc[k] * cn;

				if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] == 0)
					continue;
				dfs(nr, nc, map[nr][nc]);
			}

		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
