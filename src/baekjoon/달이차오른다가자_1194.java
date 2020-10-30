package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자_1194 {
	static int N, M;
	static int ans = -1;
	static char[][] map;
	static boolean[][][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, cnt, bit;

		public Point(int r, int c, int cnt, int bit) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.bit = bit;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int r = 0;
		int c = 0;
		map = new char[N][M];
		v = new boolean[65][N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					r = i;
					c = j;
				}
			}
		}

		bfs(new Point(r, c, 0, 0));
		System.out.println(ans);
//		print(map);

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		v[0][point.r][point.c] = true;
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (map[p.r][p.c] == '1') {
				ans = p.cnt;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == '#' || v[p.bit][nr][nc])
					continue;
				if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] =='1') {
					v[p.bit][nr][nc] = true;
					q.add(new Point(nr, nc, p.cnt + 1, p.bit));
					continue;
				}
				if (map[nr][nc] == 'a' || map[nr][nc] == 'b' || map[nr][nc] == 'c' || map[nr][nc] == 'd'
						|| map[nr][nc] == 'e' || map[nr][nc] == 'f') {
					
					if ((1 << (map[nr][nc] - 'a')) != ((1 << (map[nr][nc] - 'a')) & p.bit)){
						v[p.bit][nr][nc] = true;
						v[p.bit + (1 << (map[nr][nc] - 'a'))][nr][nc] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.bit + (1 << (map[nr][nc] - 'a'))));
						continue;
					}else {
						v[p.bit][nr][nc] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.bit));
					}
				}
				if (map[nr][nc] == 'A' || map[nr][nc] == 'B' || map[nr][nc] == 'C' || map[nr][nc] == 'D'
						|| map[nr][nc] == 'E' || map[nr][nc] == 'F') {
					if ((1 << (map[nr][nc] - 'A')) == ((1 << (map[nr][nc] - 'A')) & p.bit)) {
						v[p.bit][nr][nc] = true;
						q.add(new Point(nr, nc, p.cnt + 1, p.bit));
					}
				}

			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
