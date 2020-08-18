package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기 { // 시간초과 메모리초과나서 다시 풀어야 할 듯 + 답도 틀림.
	static int T, N, cnt;
	static char[][] map;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// 알고리즘 bfs를 써야할 듯
			cnt = 0;

//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < N; c++) {
//					if (map[r][c] == '.') {
//						cnt++;
//						bfs(new Point(r, c));
//					}
//
//				}
//			}

			bfs(new Point(0, 3));

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '.') {
						cnt++;
//						bfs(new Point(r, c));
					}

				}
			}

			System.out.printf("#%d %d\n", tc, cnt);

			print(map);

		}

	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(point);
		int count = 0; // 지뢰 수
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int k = 0; k < 8; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (map[nr][nc] == '*')
						count++;
				}

			}

			map[p.r][p.c] = (char) (count + '0');
			count = 0;
			for (int k = 0; k < 8; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (map[nr][nc] == '.') {
						q.add(new Point(nr, nc));
					}
				}

			}

		}

	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}