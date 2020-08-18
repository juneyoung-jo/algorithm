package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 하나로 {
	static int T, N, arr[][], parents[];
	static double E;

	static class Point implements Comparable<Point> {
		int v;
		int w;
		long cost;

		public Point(int v, int w, long cost) {
			super();
			this.v = v;
			this.w = w;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {

			return Long.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][2];
			parents = new int[N];
			ArrayList<Point> list = new ArrayList<Point>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // x좌표 입력받기
				arr[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // y좌표 입력받기
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());
			
			//알고리즘
			//크루스칼 알고리즘 최소신장트리 구하는 문제
			//비용 계산하는게 관건임. 좌표로 잘 나와있으니 빼서 제곱해서 구하면 됨.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					list.add(new Point(i, j, (long) Math.pow(Math.abs(arr[i][0] - arr[j][0]), 2)
							+ (long) Math.pow(Math.abs(arr[i][1] - arr[j][1]), 2)));
				}
			}

			// parents초기화
			makeSet(parents);
			Collections.sort(list);

			double Ans = 0;
			int cnt = 0;
			for (Point lists : list) {
				if (union(lists.v, lists.w)) {
					Ans += lists.cost;
					if (++cnt == N - 1) {
						break;
					}

				}

			}

			System.out.printf("#%d %d\n", tc, (long) Math.round(Ans * E));

//			print(arr);

		}
	}

	private static boolean union(int x, int y) {
		int xx = find(x);
		int yy = find(y);

		if (xx == yy)
			return false;
		parents[yy] = xx;
		return true;
	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);

	}

	private static void makeSet(int[] parents) {

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

	}

//	private static void print(int[][] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}
