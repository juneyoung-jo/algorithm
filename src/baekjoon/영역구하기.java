package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 영역구하기 {
	static int M, N, K, map[][], arr[][], Ans[][], cnt;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		arr = new int[K][4];
		Ans = new int[K][4];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length; i++) {
			Ans[i][0] = M - 1 - arr[i][1];
			Ans[i][1] = arr[i][0];
			Ans[i][2] = M - arr[i][3];
			Ans[i][3] = arr[i][2] - 1;
		}

		// map 만드는 코드
		for (int i = 0; i < K; i++) { // K회
			for (int r = Math.min(Ans[i][0], Ans[i][2]); r <= Math.max(Ans[i][0], Ans[i][2]); r++) {
				for (int c = Math.min(Ans[i][1], Ans[i][3]); c <= Math.max(Ans[i][1], Ans[i][3]); c++) {
					map[r][c] = 1;
				}
			}
		}

		// dfs로 풀었더니 안됨. 이유 : 100x100할 경우 스택오버플로우
		// bfs로 바꿈.
		int count = 0;
		v = new boolean[M][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (!v[r][c] && map[r][c] == 0) {
					++count;
					bfs(new Point(r, c, 1));
					list.add(cnt);
					cnt = 0;
				}
			}
		}

		System.out.println(count);
		Collections.sort(list);

		for (Integer List : list) {
			sb.append(List + " ");
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
//		print(map);

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		v[point.x][point.y] = true;
		q.add(point);
		int ct = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nr = p.x + dr[k];
				int nc = p.y + dc[k];

				if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					ct++;
					q.add(new Point(nr, nc, p.cnt + 1));
				}
			}

			cnt = Math.max(cnt, ct);
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
