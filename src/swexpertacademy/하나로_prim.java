package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로_prim {
	static int T, N, arr[][];
	static double E;

	static class Point implements Comparable<Point> {
		int to;
		long cost;

		public Point(int v, long cost) {
			super();
			this.to = v;
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
			ArrayList<Point>[] list = new ArrayList[N];

			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Point>();
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // x좌표 입력받기
				arr[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // y좌표 입력받기
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());

			// 알고리즘
			// 프림 알고리즘 최소신장트리 구하는 문제
			// 비용 계산하는게 관건임. 좌표로 잘 나와있으니 빼서 제곱해서 구하면 됨.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					list[i].add(new Point(j, (long) Math.pow(Math.abs(arr[i][0] - arr[j][0]), 2)
							+ (long) Math.pow(Math.abs(arr[i][1] - arr[j][1]), 2)));
				}
			}

			long[] dist = new long[N];
			boolean[] v = new boolean[N];

			PriorityQueue<Point> pq = new PriorityQueue<Point>();
			Arrays.fill(dist, Long.MAX_VALUE);

			dist[0] = 0;
			pq.add(new Point(0, dist[0]));
			int cnt = 0;

			Point current = null;
			while (!pq.isEmpty()) {
				current = pq.poll();
				if (v[current.to]) {
					continue;
				}
				cnt++;
				if (cnt == N) {
					break;
				}

				v[current.to] = true;
				int size = list[current.to].size();
				for (int i = 0; i < size; i++) {
					if (!v[list[current.to].get(i).to]
							&& list[current.to].get(i).cost < dist[list[current.to].get(i).to]) {
						dist[list[current.to].get(i).to] = list[current.to].get(i).cost;
						pq.add(new Point(list[current.to].get(i).to, dist[list[current.to].get(i).to]));
					}
				}

			}

			long Ans = 0;

			for (Long l : dist) {
				Ans += l;
			}

			System.out.printf("#%d %d\n", tc, (long) Math.round(Ans * E));

//			print(arr);

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
