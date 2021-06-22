package baekjoon;

import java.util.*;
import java.io.*;

public class Baaaaaaaaaduk2_16988 {

	static int N, M, map[][], ans;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] v;
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> hq = new LinkedList<>();
	static ArrayList<Point> list = new ArrayList<>();
	static Point[] blist = new Point[2];

	static class Point {
		int r, c, cnt;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Point(i, j));
			}
		}

		cal(0, 0);
		System.out.println(ans);

	}

	private static void cal(int idx, int start) {
		if (idx == 2) {
			go();
			return;
		}

		for (int i = start; i < list.size(); i++) {
			blist[idx] = list.get(i);
			cal(idx + 1, i + 1);
		}

	}

	private static void go() {
		vClear();
		q.clear();
		v[blist[0].r][blist[0].c] = true;
		v[blist[1].r][blist[1].c] = true;
		map[blist[0].r][blist[0].c] = 1;
		map[blist[1].r][blist[1].c] = 1;

		int count = 0;

		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < 4; k++) {
				int nr = blist[i].r + dr[k];
				int nc = blist[i].c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] != 2) continue;
				count += bfs(nr, nc);
			}
		}

		if (ans < count) ans = count;

		map[blist[0].r][blist[0].c] = 0;
		map[blist[1].r][blist[1].c] = 0;
	}

	private static int bfs(int r, int c) {
		Point p = null;
		v[r][c] = true;
		q.add(new Point(r, c));
		boolean dead = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			p = q.poll();
			cnt++;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] == 1)
					continue;
				if (map[nr][nc] == 0) {
					dead = false;
				} else if (map[nr][nc] == 2) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}

		if (dead)
			return cnt;
		else
			return 0;

	}

	private static void vClear() {
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				v[i][j] = false;
			}
		}
	}

}
