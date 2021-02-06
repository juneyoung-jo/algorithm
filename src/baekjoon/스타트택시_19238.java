package baekjoon;

import java.util.*;
import java.io.*;

public class 스타트택시_19238 {

	static int N, M, G, map[][], taxiR, taxiC, ans, result;
	static PriorityQueue<Point> q;
	static int[] dr = { -1, 0, 0, 1 }; // 상 왼 오 하
	static int[] dc = { 0, -1, 1, 0 };
	static ArrayList<Point> list;

	static class Point implements Comparable<Point>{
		int r, c, gas, cnt, men;
		
		

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int gas, int cnt, int men) {
			super();
			this.r = r;
			this.c = c;
			this.gas = gas;
			this.cnt = cnt;
			this.men = men;
		}

		public Point(int r, int c, int gas, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.gas = gas;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if(this.cnt - o.cnt < 0) {
				return -1;
			}else if(this.cnt == o.cnt) {
				if(this.r - o.r < 0) {
					return -1;
				}else if(this.r == o.r){
					if(this.c - o.c < 0) {
						return -1;
					}
					return 1;
				}
				return 1;
			}
			return 1;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>();

		map = new int[N][N]; 
		list = new ArrayList<>();


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		taxiR = Integer.parseInt(st.nextToken()) - 1;
		taxiC = Integer.parseInt(st.nextToken()) - 1;

		list.add(new Point(0, 0));
		list.add(new Point(0, 0));
		
		int r, c, R, C;
		for (int i = 2; i <= M + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			R = Integer.parseInt(st.nextToken()) - 1;
			C = Integer.parseInt(st.nextToken()) - 1;
			
			list.add(new Point(R, C));

			map[r][c] = i;
		}

		cal();

//		print(map);
		
		System.out.println(result == M ? G : -1);

	}

	private static void cal() {

		// 알고리즘

		// 1. 최단 경로의 손님 찾기
		while(true) {
			
		Point men = minDist(taxiR, taxiC, G);
		if(men == null) break; // 가스 고갈로 손님을 못태울 때
		
		// 2. 손님 태우고 도착지로 출발~
		Point s = go(men);
		if(s == null) break;
		}

	}

	private static Point go(Point men) {
		q.clear();
		boolean[][] v=  new boolean[N][N];
		q.add(men);
		v[men.r][men.c] = true;
		
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (list.get(p.men).r == p.r && list.get(p.men).c == p.c && p.gas>=0) {
				result += 1;
				G = p.gas + p.cnt*2;
				taxiR = p.r;
				taxiC = p.c;
				return new Point(p.r,p.c,G,0,0);
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] || map[nr][nc] == 1 || p.gas<0) continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.gas - 1, p.cnt+1,p.men));

			}
		}
		
		return null;
		
	}

	private static Point minDist(int tR, int tC, int g) {
		q.clear();
		boolean[][] v = new boolean[N][N];
		q.add(new Point(tR, tC, g, 0));
		v[tR][tC] = true;


		// 택시와 승객의 위치가 같을 때
		if (map[tR][tC] >= 2) {
			int num = map[tR][tC];
			map[tR][tC] = 0;
			return new Point(tR, tC, g, 0,num);
		}

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (map[p.r][p.c] >= 2) {
				int num = map[p.r][p.c]; 
				map[p.r][p.c] = 0;
				return new Point(p.r, p.c, p.gas, 0, num);
			}

			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] || map[nr][nc] == 1 || p.gas<0) continue;
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.gas - 1, p.cnt+1));

			}
		}

		return null;

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
