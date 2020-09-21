package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
	static int N, M, map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int Ans = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		String[] str = new String[N];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = str[i].charAt(j) - '0';
			}
		}

		bfs(0, 0);

		print(map);
		System.out.println(map[N - 1][M - 1]);

	}

	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(r, c));
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 1) {
					int num = map[p.r][p.c];
					map[nr][nc] = num + 1;
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
