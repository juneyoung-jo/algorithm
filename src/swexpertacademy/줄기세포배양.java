package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 줄기세포배양 {
	static int T, N, M, K, map[][], nmap[][][], Ans;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.cnt, this.cnt);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			nmap = new int[N + K][M + K][3]; // 상하좌우로 K값만큼만 크면됨(증식 최대사이즈). newMap의 중앙에 map값 저장해야함
			v = new boolean[N + K][M + K]; // 중복체크

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 여기에 nmap도 같이 초기화
					nmap[K / 2 + i][K / 2 + j][0] = map[i][j]; // 현재 cnt값 -> 증식한 칸에 cnt값 표현하기 위함.
					nmap[K / 2 + i][K / 2 + j][1] = map[i][j]; // Q에 넣는 기준이 됨 -> cnt값을 1개씩 -1일 경우에 Q에 add함
					nmap[K / 2 + i][K / 2 + j][2] = map[i][j]; // 정답이 되는 기준 -> 증식한 다음에도 x시간 동안 살아있기 때문에
				}
			}

			// 알고리즘
			// 1. 새로운 맵을 만들어 기존맵을 중앙에 배치 ㅇㅇ
			// 2. Point 객체 만들어 r,c, cnt값 사용, 우선순위큐 사용해야할듯 값이 큰거 먼저 돌려야함
			// 3. 시간이 지남에 따라 값이 변경되기 때문에 3중포문(시간, 행, 열)
			PriorityQueue<Point> q = new PriorityQueue<Point>();

			for (int t = 0; t < K; t++) {
				for (int r = 0; r < nmap.length; r++) {
					for (int c = 0; c < nmap[r].length; c++) {
						nmap[r][c][1] -= 1;

						if (nmap[r][c][0] != 0 && !v[r][c] && nmap[r][c][1] == -1) {
							nmap[r][c][2] -= 1; // 증식 할 때 -1해줘야함.(안 하면 1 높아서 값 틀림)
							q.add(new Point(r, c, nmap[r][c][0]));
						}
						if (v[r][c]) {
							nmap[r][c][2] -= 1; // 증식한 이후에 하나씩 빼줘서 살아있는지 죽었는지 확인함
						}
					}
				}
				while (!q.isEmpty()) {
					bfs(q.poll()); // 상 하 좌 우 계산 -> 깊이 1
				}
			}

			cntmap(nmap);
			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;

		}

	}

	private static void cntmap(int[][][] nmap) {
		for (int r = 0; r < nmap.length; r++) {
			for (int c = 0; c < nmap[r].length; c++) {
				if (nmap[r][c][2] > 0) {
					Ans++;
				}
			}
		}
	}

	private static void bfs(Point p) {
		v[p.r][p.c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = p.r + dr[k];
			int nc = p.c + dc[k];

			if (nr >= 0 && nc >= 0 && nr < N + K && nc < M + K && !v[nr][nc] && nmap[nr][nc][0] == 0) {
				nmap[nr][nc][0] = p.cnt;
				nmap[nr][nc][1] = p.cnt;
				nmap[nr][nc][2] = p.cnt;
			}
		}
	}

	private static void print(int[][][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j][2] + " ");
			}
			System.out.println();
		}
	}

}
