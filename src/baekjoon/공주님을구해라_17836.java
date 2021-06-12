package baekjoon;

import java.util.*;
import java.io.*;

public class 공주님을구해라_17836 {
	static int N, M, T, map[][], ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][][] v;

	static class Point {
		int r, c, cnt, flag;

		public Point(int r, int c, int cnt, int flag) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[2][N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cal();
		if(ans == 0 || ans > T) System.out.println("Fail");
		else System.out.println(ans);
		
	}

	private static void cal() {
		PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
		q.add(new Point(0, 0, 0, 0));
		v[0][0][0] = true;

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			
			if(p.r == N-1 && p.c == M-1) {
				ans = p.cnt;
				return;
			}
			
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[p.flag][nr][nc]) continue;
				if(p.flag == 0 && map[nr][nc] == 1) continue;
				
				v[p.flag][nr][nc] = true;
				if(map[nr][nc] == 2) q.add(new Point(nr,nc,p.cnt+1,1));		
				else q.add(new Point(nr,nc,p.cnt+1,p.flag));
			}
		}

	}

}

