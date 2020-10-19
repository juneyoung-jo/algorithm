package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
	static int N, map[][], ans;
	static PriorityQueue<Point> q = new PriorityQueue<Point>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r, c, cnt;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (N != 0) {// 0들어오면 종료.

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			print(map);
			ans = Integer.MAX_VALUE;
			bfs(new Point(0, 0, map[0][0]), new boolean [N][N]);
			System.out.println("Problem "+num++ +": "+ans);
			
			N = Integer.parseInt(br.readLine());
		}

	}

	private static void bfs(Point point,boolean[][] v) {
		q.clear();
		v[point.r][point.c] = true;
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == N-1 && p.c == N-1) {
				ans = Math.min(ans, p.cnt);
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr< 0 || nc < 0 || nr>= N || nc>= N || v[nr][nc]) continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.cnt+ map[nr][nc]));
				
			}
			
		}
		
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
