package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원자소멸시뮬레이션 {
	static int T, N, map[][][], Ans;
	static Queue<Point> q;
	static ArrayList<Point> list;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, dir, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			q = new LinkedList<Point>();
			list = new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				q.add(new Point(Integer.parseInt(st.nextToken()) + 1000, Integer.parseInt(st.nextToken()) + 1000,
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			map = new int[2000][2000][3];
			while (!q.isEmpty()) {
				Point p = q.poll();

				int nr = p.r + dr[p.dir];
				int nc = p.c + dc[p.dir];

				if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length)
					continue;

				map[nr][nc][0] += p.cnt;
				map[nr][nc][1] += 1; // 개체수
				map[nr][nc][2] = p.dir; // 방향
				list.add(new Point(nr, nc));

				while (q.isEmpty()) {
					for (int k = 0; k < list.size(); k++) {
						if (map[list.get(k).r][list.get(k).c][1] >= 2) {
							Ans += map[list.get(k).r][list.get(k).c][0];
							map[list.get(k).r][list.get(k).c][0] = 0;
							map[list.get(k).r][list.get(k).c][1] = 0;
							map[list.get(k).r][list.get(k).c][2] = 0;
						} else if (map[list.get(k).r][list.get(k).c][1] == 1) {
							q.add(new Point(list.get(k).r, list.get(k).c, map[list.get(k).r][list.get(k).c][2],
									map[list.get(k).r][list.get(k).c][0]));
							map[list.get(k).r][list.get(k).c][0] = 0;
							map[list.get(k).r][list.get(k).c][1] = 0;
							map[list.get(k).r][list.get(k).c][2] = 0;
						}
					}

					break;
				}

				list.clear();
			}

			System.out.println(Ans);
			Ans = 0;

		}

	}

}