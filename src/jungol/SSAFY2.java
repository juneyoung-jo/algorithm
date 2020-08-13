package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SSAFY2 {
	static int N, M, map[][], min = Integer.MAX_VALUE;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(new Point(0, 0, 0));
		System.out.println(min);
	}

	private static void bfs(Point point) {
		v = new boolean[M][N];
		PriorityQueue<Point> q = new PriorityQueue<Point>(); // 0을 담는 큐
		v[point.r][point.c] = true;
		q.add(point);
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == M - 1 && p.c == N - 1) {
				min = p.cnt;
				return;
			}
			for (int k = 0; k < 4; k++) {// 4방체크
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nc >= 0 && nr < M && nc < N && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt));
				}
				if (nr >= 0 && nc >= 0 && nr < M && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt + 1));
				}
			}

		}
	}

//	private static void print(int[][] map2) {
//		for (int i = 0; i < map2.length; i++) {
//			for (int j = 0; j < map2[i].length; j++) {
//				System.out.print(map2[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//	
//	private static void print(boolean[][] v) {
//		for (int i = 0; i < v.length; i++) {
//			for (int j = 0; j < v[i].length; j++) {
//				System.out.print(v[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}
