package baekjoon;

import java.util.*;
import java.io.*;

public class 움직이는미로탈출_16954 {
	static char[][] map = new char[8][];
	static boolean v[][][] = new boolean[9][8][8];
	static int ans, round;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> next = new LinkedList<>();

	static class Point {
		int r, c, cnt;

		public Point(int r, int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt =cnt;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 시작점
		next.add(new Point(7, 0, round));
		v[round][7][0] = true;
		while(true) {
			if(ans == 1) break;
			if(q.size() == 0 && next.size() == 0) break;
			cal();
		}
		
		System.out.println(ans);
	}

	private static void cal() {
		q.clear();
		q.addAll(next);
		next.clear();

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			
			if(map[p.r][p.c] == '#') continue;
			if(p.r == 0 && p.c == 7 ) {
				ans = 1;
				return;
			}
			
			
			for(int k = 0; k < 8; k++) {
				
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= 8 || nc >= 8 || v[p.cnt][nr][nc] || map[nr][nc] == '#') continue;
				v[p.cnt][nr][nc] = true;
				next.add(new Point(nr,nc,round));
			}
			
			// 제자리 
			next.add(new Point(p.r,p.c,round));

		}
		
		// 벽 내리기
		go();
		if(round < 8) round++;

	}

	private static void go() {
		for(int r = 7; r >= 1; r--) {
			for(int c = 0; c < 8; c++) {
				map[r][c] = map[r-1][c];
			}
		}
		
		for(int c = 0; c < 8; c++) {
			map[0][c] = '.';
		}
		
	}

}
