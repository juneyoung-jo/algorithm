package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미생물격리 {
	static int T, N, M, K, map[][][], Ans;
	static int[] dr = { 0, -1, 1, 0, 0 }; // 1~4 상하좌우
	static int[] dc = { 0, 0, 0, -1, 1 };

	static class Point {
		int r;
		int c;
		int val;
		int dir;

		public Point(int r, int c, int val, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 배열
			M = Integer.parseInt(st.nextToken()); // 이동 시간?
			K = Integer.parseInt(st.nextToken()); // 군집 개수
			// 한방에 1회전 다 해야하기 때문에 하나씩 처리하면 안됨.
			// 큐를 사용해서 한번에 다 처리해야함.
			Queue<Point> q = new LinkedList<Point>();

			map = new int[N][N][3]; // n행 n열 + {미생물수, 방향, 비교 후 큰값} -> 3차원 배열로 하면 쉬울듯

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				q.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// 알고리즘
			// 한번에 모든게 원소들이 다 이동해야 하기 때문에 큐를 사용했음.
			// 맵을 초기화 하고 하나씩 계산해 나가면 풀림.
			// 계산하고 또 초기화해야함.
			for (int idx = 0; idx < M; idx++) { // 회전 수
				// 큐에서 하나씩 꺼내면서 값 map에 저장
				while (!q.isEmpty()) {
					Point p = q.poll();
					int nr = p.r + dr[p.dir];
					int nc = p.c + dc[p.dir];

					// 가장자리
					if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
						map[nr][nc][0] = p.val / 2;
						if (p.dir == 1) { // 방향 바꾸기
							map[nr][nc][1] = 2;
						} else if (p.dir == 2) {
							map[nr][nc][1] = 1;
						} else if (p.dir == 3) {
							map[nr][nc][1] = 4;
						} else if (p.dir == 4) {
							map[nr][nc][1] = 3;
						}
						continue;
					}
					if (map[nr][nc][0] != 0) { // 값이 있으면 겹치고 방향은 큰값.
						if (map[nr][nc][2] < p.val) {
							map[nr][nc][1] = p.dir;
							map[nr][nc][2] = p.val;
						}
						map[nr][nc][0] += p.val;
						continue;
					}
					map[nr][nc][0] = p.val;
					map[nr][nc][1] = p.dir;
					map[nr][nc][2] = p.val;
				}

				// 1회전이 다 끝나면 다시 큐에 저장
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c][0] > 0) {
							q.add(new Point(r, c, map[r][c][0], map[r][c][1]));
						}
					}
				}

				// 기존 map을 초기화 해줘야함. 단 마지막 회전때는 안해야함.
				if (idx == M - 1) {
					break;
				}
				map = new int[N][N][3];
			}

//			print(map);

			cal(map);

			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;

		}

	}

	private static void cal(int[][][] map) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				Ans += map[i][j][0];
			}
		}

	}

	private static void print(int[][][] map) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[i][j].length; k++) {
					System.out.print(map[i][j][k] + ",");
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
