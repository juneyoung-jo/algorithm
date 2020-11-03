package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경비원_2564 {
	static int W, H, K, arr[][], ans, map[][];
	static Queue<Point> q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 북 남 서 동
	// 1 2 3 4
	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		W = sc.nextInt();
		H = sc.nextInt();
		K = sc.nextInt();

		arr = new int[K + 1][2];
		map = new int[H + 1][W + 1];

		for (int i = 1; i <= K; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		arr[0][0] = sc.nextInt();
		arr[0][1] = sc.nextInt();

		// 테두리 -1로 변경
		for (int i = 0; i <= H; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || i == H)
					map[i][j] = -1;
				if (j == 0 || j == W)
					map[i][j] = -1;
			}
		}

		int r = 0;
		int c = 0;

		// 좌표 표시
		for (int i = 0; i <= K; i++) {
			switch (arr[i][0]) {
			case 1:
				if (i == 0) {
					r = 0;
					c = arr[i][1];
				}
				map[0][arr[i][1]] = 2;
				break;
			case 2:
				if (i == 0) {
					r = H;
					c = arr[i][1];
				}
				map[H][arr[i][1]] = 2;
				break;
			case 3:
				if (i == 0) {
					r = arr[i][1];
					c = 0;
				}
				map[arr[i][1]][0] = 2;
				break;
			case 4:
				if (i == 0) {
					r = arr[i][1];
					c = W;
				}
				map[arr[i][1]][W] = 2;
				break;
			}
		}

		bfs(new Point(r, c, 0), new boolean[H + 1][W + 1]);

//		System.out.println(r + " : " + c);
//		print(map);

		System.out.println(ans);

		// 알고리즘

	}

	private static void bfs(Point point, boolean[][] v) {
		q.clear();
		q.add(point);
		v[point.r][point.c] = true;

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			if (map[p.r][p.c] == 2) {
				ans += p.cnt;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= H + 1 || nc >= W + 1 || v[nr][nc] || map[nr][nc] == 0)
					continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.cnt + 1));

			}

		}

	}

	private static void print(int[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
