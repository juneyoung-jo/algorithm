package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 파티_1238 {
	static int N, M, X;
	static ArrayList<Point>[] list;

	static class Point implements Comparable<Point> {
		int to, cnt;

		public Point(int to, int cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		// 간선리스트 만들기
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < M; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			int cnt = sc.nextInt();

			list[to].add(new Point(from, cnt));
		}

		// 다익스트라
		int[] x = cal(X);
		int[][] ans = new int[N + 1][];
		for (int i = 1; i <= N; i++) {
			ans[i] = cal(i);
		}

//		print(ans);

		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			ans[X][i] += ans[i][X];
		}
//		print(ans);
		int Ans = 0;
		for (int i = 1; i <= N; i++) {
			Ans = Math.max(Ans, ans[X][i]);
		}

		System.out.println(Ans);

	}

	private static void print(int[][] ans) {

		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[] cal(int x) {
		boolean[] v = new boolean[N + 1]; // 방문체크
		int[] dis = new int[N + 1]; // 최소값 담을 배열
		Arrays.fill(dis, Integer.MAX_VALUE); // 최대값저장
		dis[x] = 0;

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(x, dis[x]));
		Point p = null;
		while (!pq.isEmpty()) {
			p = pq.poll();
			if (v[p.to])
				continue;
			v[p.to] = true;

			int size = list[p.to].size();
			for (int i = 0; i < size; i++) {
				int to = list[p.to].get(i).to;
				int cnt = list[p.to].get(i).cnt;
				if (!v[to] && p.cnt + cnt < dis[to]) {
					dis[to] = p.cnt + cnt;
					pq.add(new Point(to, dis[to]));
				}
			}
		}

		return dis;

	}

}
