package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 음식배달 {
	static int T, N, map[][], ans;
	static boolean[] v;
	static List<Point> home;
	static List<Point> store;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

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

			map = new int[N][N];
			home = new ArrayList<Point>();
			store = new ArrayList<Point>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						home.add(new Point(i, j));
					if (map[i][j] != 0 && map[i][j] != 1)
						store.add(new Point(i, j, map[i][j]));
				}
			}

			v = new boolean[store.size()];
			ans = Integer.MAX_VALUE;
			powerSet(0);
			System.out.printf("#%d %d\n",tc,ans);

//			print(map);

		}

	}

	private static void powerSet(int idx) {
		if (idx == store.size()) {
//			System.out.println(Arrays.toString(v));
			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int st = Integer.MAX_VALUE;
				for (int j = 0; j < v.length; j++) {
					if (v[j]) {
						st = Math.min(Math.abs(home.get(i).r - store.get(j).r)
								+Math.abs(home.get(i).c - store.get(j).c) , st);
					}
				}
				sum += st;
				if(sum > ans) return; // 가지치기
			}
			if(sum==0 || sum<0) return;
			for (int j = 0; j < v.length; j++) {
				if (v[j]) {
					sum+= store.get(j).cnt;
				}
			}
			ans = Math.min(ans,sum);

			return;
		}

		v[idx] = true;
		powerSet(idx + 1);
		v[idx] = false;
		powerSet(idx + 1);

	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stu
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
