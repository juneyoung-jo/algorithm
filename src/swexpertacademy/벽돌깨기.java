package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 벽돌깨기 {
	static int T, N, W, H, map[][], arr[], Ans = Integer.MAX_VALUE, copymap[][]; // H x W 배열
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
			permutaiton(0); // 중복 순열하면서 dfs안에서 돌려야함.
			if (Ans == Integer.MAX_VALUE) { // 값이 안 바뀔 때
				Ans = 0;
			}

			System.out.printf("#%d %d\n", tc, Ans);
			Ans = Integer.MAX_VALUE;

		}

	}

	private static void sortmap(int[][] map) {// dfs돌 때 마다 사라진 블록을 제외하고 맵을 정렬해줘야 함..
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

	private static void permutaiton(int idx) {
		if (idx == N) {
			copymap = new int[H][W]; // 새로운 맵
			cmap(copymap);// 매번 새로운 맵 만들어 줘야 함.
			for (int i = 0; i < arr.length; i++) {
				if (search(arr[i]) == -1) { // 만약 col에 더 부실 벽돌이 없다면 더 할 필요없이 리턴
					return;
				}
				v = new boolean[H][W]; // 매번 탐색확인 배열 초기화해줘야함
				dfs(new Point(search(arr[i]), arr[i], 1), copymap); // dfs돌리면서 copymap 같이 돌리기
				sortmap(copymap); // 정렬
			}
			Ans = Math.min(Ans, countmap(copymap)); // 최저값 저장
			return;
		}

		for (int i = 0; i < W; i++) { // 중복순열
			arr[idx] = i;
			permutaiton(idx + 1);
		}

	}

	private static int countmap(int[][] copymap) {// 다 끝나고 남은 블록 세주는 함수
		int cnt = 0;
		for (int i = 0; i < copymap.length; i++) {
			for (int j = 0; j < copymap[i].length; j++) {
				if (copymap[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void cmap(int[][] copymap) {// 모든 경우를 다 돌려야하기 때문에 맵을 계속 새로만들어줘야함.
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < copymap[i].length; j++) {
				copymap[i][j] = map[i][j];
			}
		}
	}

	private static void dfs(Point p, int[][] copymap) { // 깨진블록들 0으로 바꿔주면서 dfs돌림
		v[p.r][p.c] = true;
		int size = copymap[p.r][p.c];
		copymap[p.r][p.c] = 0;

		for (int k = 0; k < 4; k++) {
			for (int cn = 0; cn < size; cn++) {
				int nr = p.r + dr[k] * cn;
				int nc = p.c + dc[k] * cn;

				if (nr >= 0 && nc >= 0 && nr < H && nc < W && copymap[nr][nc] != 0 && !v[nr][nc]) {
					dfs(new Point(nr, nc, p.cnt++), copymap);
				}
			}

		}

	}

	private static int search(int i) { // dfs 시작할 행을 구함. 열은 i값
		for (int r = 0; r < copymap.length; r++) {
			if (copymap[r][i] != 0) {
				return r;
			}
		}

		return -1;
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
