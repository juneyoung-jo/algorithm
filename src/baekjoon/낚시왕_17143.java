package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕_17143 {
	static int R, C, M, ans;
	static int dr[] = { 0, -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 0, 1, -1 };
	static List<Point> list;

	static class Point {
		int r, c, s, d, z;

		public Point(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			list.add(new Point(r, c, s, d, z));
		}

		cal(1);

	}

	private static void cal(int col) {
		if (col == C + 1) {
			System.out.println(ans);
			System.exit(0);
		}

		int rm = Integer.MAX_VALUE; // 잡을 상어 인덱스
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).c != col)
				continue;
			if (list.get(i).r < dis) {
				dis = list.get(i).r;
				rm = i;
			}
		}

		if (rm != Integer.MAX_VALUE) {
			ans += list.get(rm).z;
			list.remove(rm);
		}

		// 상어 맵 갱신.
		int[][][] map = new int[R + 1][C + 1][3];
		// 0 속도
		// 1 방향
		// 2 크기
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			int s = list.get(i).s;
			int d = list.get(i).d;
			int z = list.get(i).z;

			for (int k = 0; k < s; k++) {
				r += dr[d];
				c += dc[d];

				if (r < 1 || c < 1 || r >= R + 1 || c >= C + 1) {
					d = calDir(d);
					k-=1;
					continue;
				}
			}
			
			if(map[r][c][2] > z) continue;
			map[r][c][0] = s;
			map[r][c][1] = d;
			map[r][c][2] = z;
		}
		
		list.clear();
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j][2] != 0) {
					list.add(new Point(i, j, map[i][j][0], map[i][j][1], map[i][j][2]));
				}
			}
		}
		
		cal(col+1);

	}

	private static int calDir(int d) {

		switch (d) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return d;
	}

}
