package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미세먼지안녕_17144 {
	static int R, C, T, map[][], Ans, arr[];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static PriorityQueue<Point> q = new PriorityQueue<Point>();

	static class Point implements Comparable<Point> {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[2];

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					continue;
				if (num == -1) {
					arr[cnt] = i;
					cnt++;
				}
				q.add(new Point(i, j, num));
			}
		}

		for (int i = 0; i < T; i++) {
			map = new int[R][C]; // 맵 새로 만듬
			cal(); // 미세먼지 확산하는 함수
			count(map); // 값 계산 및 다시pq에 담기
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			Ans += p.cnt;
		}
		System.out.println(Ans + 2);
//		print(map);

	}

	private static void count(int[][] map) {
		// 위쪽 반시계
		for (int i = arr[0] - 1; i >= 0; i--) { // 왼쪽라인
			if (map[i + 1][0] == -1) {
				map[i][0] = 0;
			} else {
				map[i + 1][0] = map[i][0];
				map[i][0] = 0;
			}
		}

		for (int i = 1; i < C; i++) { // 맨위 줄
			map[0][i - 1] = map[0][i];
			map[0][i] = 0;
		}

		for (int i = 1; i <= arr[0]; i++) { // 오른쪽 라인
			map[i - 1][C - 1] = map[i][C - 1];
			map[i][C - 1] = 0;
		}

		for (int i = C - 2; i >= 1; i--) { // 아래줄
			map[arr[0]][i + 1] = map[arr[0]][i];
			map[arr[0]][i] = 0;
		}

		// 아래쪽 시계

		for (int i = arr[1] + 1; i < R; i++) { // 왼쪽
			if (map[i - 1][0] == -1) {
				map[i][0] = 0;
			} else {
				map[i - 1][0] = map[i][0];
				map[i][0] = 0;
			}

		}

		for (int i = 1; i < C; i++) { // 아래
			map[R - 1][i - 1] = map[R - 1][i];
			map[R - 1][i] = 0;
		}

		for (int i = R - 2; i >= arr[1]; i--) { // 오른쪽
			map[i + 1][C - 1] = map[i][C - 1];
			map[i][C - 1] = 0;
		}

		for (int i = C - 2; i >= 1; i--) { // 위
			map[arr[1]][i + 1] = map[arr[1]][i];
			map[arr[1]][i] = 0;
		}

		// 값 전부다 PQ에 넣기
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] != 0) {
					q.add(new Point(r, c, map[r][c]));
				}
			}
		}

	}

	private static void cal() {
		while (!q.isEmpty()) {

			Point p = q.poll();

			// -1 일때는 그냥 세팅
			if (p.cnt == -1) {
				map[p.r][p.c] = p.cnt;
			} else { // -1 아닐때는 상하좌우 번식
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					if (map[nr][nc] == -1)
						continue; // 공기청정기일 때

					map[nr][nc] += (p.cnt / 5);
					cnt++;
				}
				map[p.r][p.c] += (p.cnt - ((p.cnt / 5) * cnt));
			}

		}
	}

	private static void print(int[][] map2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
