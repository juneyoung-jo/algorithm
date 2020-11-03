package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static int T, N, M, R, C, L, map[][], ans;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, time, type;

		public Point(int r, int c, int time, int type) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.type = type;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			v = new boolean[N][M];
			ans = 1; // 맨홀뚜껑 위치

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(new Point(R, C, 1, map[R][C]));
//			print(map);
			System.out.printf("#%d %d\n",tc,ans);

		}

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		v[point.r][point.c] = true;

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			
			if(p.time == L) continue;

			for (int k = 0; k < 4; k++) {

				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] == 0)
					continue;

					if(!check(p.type,k,map[nr][nc])) continue;
					ans++;
					v[nr][nc] = true;
					q.add(new Point(nr, nc, p.time+1, map[nr][nc]));

			}

		}

	}


	private static boolean check(int t,int k, int dir ) {
		if(t== 2 && (k== 2 || k== 3)) return false;
		if(t== 3 && (k== 0 || k== 1)) return false;
		if(t== 4 && (k== 1 || k== 2)) return false;
		if(t== 5 && (k== 0 || k== 2)) return false;
		if(t== 6 && (k== 0 || k== 3)) return false;
		if(t== 7 && (k== 1 || k== 3)) return false;
		
		if(k==0 && (dir == 3 || dir == 4 || dir == 7 )) return false;
		if(k==1 && (dir == 3 || dir == 5 || dir == 6 )) return false;
		if(k==2 && (dir == 2 || dir == 6 || dir == 7 )) return false;
		if(k==3 && (dir == 2 || dir == 4 || dir == 5 )) return false;
		return true;
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
