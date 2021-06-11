package baekjoon;

import java.util.*;
import java.io.*;

public class 빙산_2574 {
	static int N, M, map[][], ans, cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] v;
	static Queue<Point> q = new LinkedList<>();
	
	static class Point{
		int r,c,cnt;
		
		public Point(int r,int c, int cnt) {
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
			}
		}
		
		// 알고리즘
		boolean flag = false;
		while (true) {
			init(); // 방문배열 초기화
			int count = 0; // 덩어리 수
			L: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !v[i][j]) {
						count++;
						cal(i, j);
					}
					if (count == 2) {
						break L;
					}
				}
			}
			
			if(count == 2) {
				flag = true;
				break;
			}else if(count == 0) {
				break;
			}
			go(); // 빙산 녹이기
			ans++;
		}

		System.out.println(flag ? ans : 0);
	}

	private static void go() {
		q.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int c = 0;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
						if(map[nr][nc] == 0) c++;
					}
					q.add(new Point(i,j,map[i][j] - c));
				}
			}
		}
		Point p = null;
		while(!q.isEmpty()) {
			p = q.poll();
			map[p.r][p.c] = p.cnt < 0 ? 0 : p.cnt;  
		}
	}

	private static void cal(int r, int c) {
		if (v[r][c]) return;

		v[r][c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || v[nr][nc]) continue;
			cal(nr, nc);

		}

	}

	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = false;
			}
		}
	}

}
