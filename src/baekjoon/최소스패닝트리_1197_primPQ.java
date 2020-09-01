package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197_primPQ {
	static int V, E;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ArrayList<Point>[] list = new ArrayList[V + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Point>();
		}

		// 인접 리스트 만들기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list[from].add(new Point(to, cnt));
			list[to].add(new Point(from, cnt));
		}

		boolean[] v = new boolean[V + 1]; // 방문 체크
		int[] dist = new int[V + 1]; // 결과 값 저장할 배열
		PriorityQueue<Point> PQ = new PriorityQueue<Point>();
		Arrays.fill(dist, Integer.MAX_VALUE); // 작은 값을 저장하기 위해서 최대값으로 초기화

		dist[1] = 0; // 시작위치

		PQ.add(new Point(1, dist[1]));
		Point current = null;
		while (!PQ.isEmpty()) {

			// 값이 가장 작은 정점 구하기
			current = PQ.poll();

			v[current.to] = true;
			int size = list[current.to].size();

			for (int j = 0; j < size; j++) {
				if (!v[list[current.to].get(j).to] && list[current.to].get(j).cnt < dist[list[current.to].get(j).to]) {
					dist[list[current.to].get(j).to] = list[current.to].get(j).cnt;
					PQ.add(new Point(list[current.to].get(j).to, dist[list[current.to].get(j).to]));
				}

			}

		}
		int Ans = 0;
		for (int i = 1; i < dist.length; i++) {
			Ans += dist[i];
		}
//		System.out.println(Arrays.toString(dist));

		System.out.println(Ans);
	}

}
