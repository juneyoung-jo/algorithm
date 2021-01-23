package baekjoon;

import java.util.*;
import java.io.*;

public class 연구소_14502 {

	static int N, M, ans,cnt_zero;
	static boolean v[][][][][][];
	static Queue<Point> dq;
	static Queue<Point> q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		v = new boolean[N][M][N][M][N][M];
		dq = new LinkedList<>();
		ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					dq.add(new Point(i, j));
				if(map[i][j] == 0) {
					cnt_zero++;
				}
			}
		}

		cal(0, new int[6], map);
		System.out.println(ans);
//		print(map);

	}

	private static void cal(int idx, int[] vv, int[][] map) {
		if (idx == 6) {
			if (v[vv[0]][vv[1]][vv[2]][vv[3]][vv[4]][vv[5]] || v[vv[0]][vv[1]][vv[4]][vv[5]][vv[2]][vv[3]]
					|| v[vv[2]][vv[3]][vv[0]][vv[1]][vv[4]][vv[5]] || v[vv[4]][vv[5]][vv[0]][vv[1]][vv[2]][vv[3]]
					|| v[vv[2]][vv[3]][vv[4]][vv[5]][vv[0]][vv[1]] || v[vv[4]][vv[5]][vv[2]][vv[3]][vv[0]][vv[1]])
				return;

			v[vv[0]][vv[1]][vv[2]][vv[3]][vv[4]][vv[5]] = true;

			// 알고리즘
			bfs(map, new boolean[N][M]);

			return;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					vv[idx] = i;
					vv[idx + 1] = j;
					cal(idx + 2, vv, map);
					map[i][j] = 0;
					vv[idx] = 0;
					vv[idx + 1] = 0;
				}
			}
		}

	}

	private static void bfs(int[][] map, boolean[][] vvv) {
		q.clear();
		q.addAll(dq);
		
		Point p = null;
		int cnt = 0;
		while(!q.isEmpty()) {
			p = q.poll();
			vvv[p.r][p.c] = true;
			
			for (int k = 0; k < 4; k++) {
				int nr = p.r +  dr[k];
				int nc = p.c +  dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M || vvv[nr][nc]) continue;
				if(map[nr][nc] == 1 || map[nr][nc] == 2) continue;
				vvv[nr][nc] = true;
				cnt ++;
				q.add(new Point(nr,nc));
				
			}
			
		}
		
		ans = Math.max(ans,cnt_zero - cnt-3);
		
		

	}


	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
