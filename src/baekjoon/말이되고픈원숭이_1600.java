package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {
	static int K, W, H, map[][],ans = Integer.MAX_VALUE;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] drr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dcc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static boolean[][][] v;
	
	static class Point{
		int r,c ,cnt, move;

		public Point(int r, int c, int cnt, int move) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.move = move;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		v = new boolean[H][W][K+1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		print(map);
		
		bfs(new Point(0, 0, 0, K));
		System.out.println(ans==Integer.MAX_VALUE?-1:ans);

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			
			if(p.r == H-1 && p.c == W-1) {
				ans = Math.min(p.cnt, ans);
				break;
			}
			
			
			
			for (int k = 0; k < 8; k++) { //말처럼 뛰기
				int nr = p.r + drr[k];
				int nc = p.c + dcc[k];
				
				//테두리 체크
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
				if(map[nr][nc] == 1 ) continue;
				if(p.move >= 1 && !v[nr][nc][p.move-1]) {
					v[nr][nc][p.move-1] = true;
					q.add(new Point(nr, nc, p.cnt+1, p.move-1));
				}
			}
			
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
				if(map[nr][nc] == 1 ) continue;
				if(!v[nr][nc][p.move]) {
					v[nr][nc][p.move] = true;
					q.add(new Point(nr, nc, p.cnt+1, p.move));
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

