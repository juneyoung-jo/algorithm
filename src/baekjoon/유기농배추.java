package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 유기농배추 {
	static int T, M, N, K, map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			int Ans = 0;

			map = new int[M][N];

			for (int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}

			// 여기부터
			//print(map);
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == 1) {
						Ans++;
						bfs(r, c);
					}
				}
			}


			System.out.println(Ans);

		}

		sc.close();
	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList();
		Q.add(new Point(r, c));
		map[r][c] = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 1) {
					map[nr][nc] = 0;
					Q.add(new Point(nr, nc));
				}
			}
		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}


	private static void print(int[][] adjMrx) {
		for (int i = 0; i < adjMrx.length; i++) {
			for (int j = 0; j < adjMrx[i].length; j++) {
				System.out.print(adjMrx[i][j] + " ");
			}
			System.out.println();
		}
	}

}
