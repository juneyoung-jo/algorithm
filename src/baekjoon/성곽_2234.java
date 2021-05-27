package baekjoon;

import java.util.*;
import java.io.*;

public class 성곽_2234 {
	static int n, m, map[][], cnt, size, maxSize, v[][];
	static int[] dr = { 0, -1, 0, 1 }; // 서 북 동 남
	static int[] dc = { -1, 0, 1, 0 };
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Integer> list;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[m][n];
		v = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<>();
		list.add(0); // 0번 인덱스 사용 안함.

		int mark = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j] == 0) {
					int cnt = bfs(i, j, mark);
					mark++;
					list.add(cnt);
				}
			}
		}

		// 벽하나 지우고 최대값 구하기
		cal();

		System.out.println(--mark);
		System.out.println(size);
		System.out.println(maxSize);

	}

	public static void cal() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
					if(v[i][j]  == v[nr][nc]) continue;
					
					int sum = list.get(v[i][j]) + list.get(v[nr][nc]);
					if(maxSize < sum) maxSize = sum;
				}

			}
		}

	}

	public static int bfs(int r, int c, int mark) {
		q.clear();
		v[r][c] = mark;
		q.add(new Point(r, c, 1));
		int count = 1;
		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();
			if (size < count)
				size = count;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				int flag = 1 << k;

				if (nr < 0 || nc < 0 || nr >= m || nc >= n || v[nr][nc] != 0)
					continue;
				if ((map[p.r][p.c] & flag) > 0)
					continue; // 벽일 경우

				v[nr][nc] = mark;
				count++;
				q.add(new Point(nr, nc, p.cnt + 1));
			}
		}

		return count;

	}

}
