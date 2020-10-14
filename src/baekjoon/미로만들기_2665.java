package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 미로만들기_2665 {

	static int n, map[][], ans;
	static boolean[][] v;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point implements Comparable<Point> {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		v= new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(new Point(0, 0, 0));
		System.out.println(ans);
//		print(map);

	}

	private static void bfs(Point point) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		v[0][0] = true;
		pq.add(point);
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.r == n-1 && p.c == n-1) {
				ans  = p.cnt;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n || v[nr][nc]) continue;
				if(map[nr][nc] == 1) {
					v[nr][nc] = true;
					pq.add(new Point(nr, nc, p.cnt));
				}
				
				if(map[nr][nc] == 0) {
					v[nr][nc] = true;
					pq.add(new Point(nr, nc, p.cnt + 1));
				}
			}
		}

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
