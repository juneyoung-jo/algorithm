package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 방향전환_dfs_강의코드 {
	static int x1, y1, x2, y2;
	static final int HOR = 0, VER = 1;

	static int[][][] dir = {
			// hor
			{ { -1, 0 }, { 1, 0 } },
			// ver
			{ { 0, -1 }, { 0, 1 } }

	};

	static class Point {
		int x, y, d, cnt; // x,y,이동방향,이동횟수

		public Point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			System.out.printf("#%d %d\n", tc, bfs());

		}
	}

	private static int bfs() {
		// TODO Auto-generated method stub

		Queue<Point> q = new LinkedList<Point>();
		boolean[][][] v = new boolean[2][201][201];
		v[HOR][x1][y1] = true;
		q.offer(new Point(x1, y1, HOR, 0));
		v[VER][x1][y1] = true;
		q.offer(new Point(x1, y1, VER, 0));

		Point cur = null;
		int nx, ny;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.x == x2 && cur.y == y2)
				return cur.cnt;

			int[][] d = dir[cur.d ^ 1]; // 현재 좌표 방향의 반대에 해당하는 델타값 (XOR)

			for (int i = 0; i < d.length; i++) {
				nx = cur.x + d[i][0];
				ny = cur.y + d[i][1];
				if (nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200 && !v[cur.d ^ 1][nx][ny]) {
					v[cur.d ^ 1][nx][ny] = true;
					q.offer(new Point(nx, ny, cur.d ^ 1, cur.cnt + 1));
				}

			}

		}

		return 0;
	}

}
