package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {
	static int L, W, ans;
	static char[][] map;
	static Queue<Point> q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[L][];
		q = new LinkedList<Point>();

		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'L') {
					bfs(new Point(i, j, 0));
				}
			}
		}
		
		System.out.println(ans);

	}

	private static void bfs(Point point) {
		q.clear();
		boolean[][] v = new boolean[L][W];
		v[point.r][point.c] = true;
		q.add(point);
		
		Point p= null;
		while(!q.isEmpty()) {
			p = q.poll();
			
			if(ans < p.cnt) ans = p.cnt;
			
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= L || nc >= W || v[nr][nc]) continue;
				if(map[nr][nc] == 'W') continue;
				
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.cnt+1));
			}
			
		}
		
	}

}
