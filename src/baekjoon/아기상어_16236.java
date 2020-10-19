package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {

	static int N, map[][], ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Point> q = new LinkedList<Point>();

	static class Point {
		int r, c, count, size;

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", count=" + count + ", size=" + size + "]";
		}

		public Point(int r, int c, int count, int size) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.size = size;
		}

	}
	static boolean[] vv ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean[][] v = new boolean[N][N];
		vv =  new boolean[N];
		int r = 0, c = 0; // 상어의 위치
		int size = 2; // 상어 크기

		for (int i = 0; i < N; i++) { // 맵 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		
		int idx = 0;
		int sizeUp = 0;
		while (idx != Integer.MAX_VALUE) { // idx값 변화가 없으면 잡아먹을 물고기가 없어 끝
			
			idx = Integer.MAX_VALUE; // 물고기 잡아먹을 곳(최소값) 저장하는 변수

			int row = -1;
			int col = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && map[i][j] < size) {
						int num = bfs(new Point(r, c, 0, size), i, j, v); // 최소값 저장
						if (num < idx) {
							idx = num;
							row = i;
							col = j;
						}
					}
				}
			}
			
			if(row != -1 && col != -1) {
				sizeUp += 1;
				map[row][col] = 0;
				map[r][c] = 0;
			}
			
			if(sizeUp == size) {
				size += 1;
				sizeUp = 0;
			}
			r = row;
			c = col;
			ans += idx == Integer.MAX_VALUE? 0 : idx;

		}
		System.out.println(ans == Integer.MAX_VALUE? 0:ans);
//		print(map);
	}

	private static int bfs(Point point, int i, int j, boolean[][] v) {
		for (int l = 0; l < N; l++) {
			v[l] = Arrays.copyOf(vv, vv.length);
		}
		
		q.clear();
		v[point.r][point.c] = true;
		q.add(point);

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.r == i && p.c == j) {
				return p.count;
			}
			
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr< 0 || nc <0 || nr >= N || nc >= N || v[nr][nc]) continue;
				if(map[nr][nc] > p.size) continue;
				
				v[nr][nc] = true;
				q.add(new Point(nr, nc, p.count+1, p.size));
			}
		}

		return Integer.MAX_VALUE;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}

