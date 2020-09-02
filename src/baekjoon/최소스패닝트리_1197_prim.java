package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_1197_prim {
	static int V, E;

	static class Point {
		int to, cnt;

		public Point(int to, int cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
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
		Arrays.fill(dist, Integer.MAX_VALUE); // 적은 값을 저장하기 위해서 최대값으로 초기화

		dist[1] = 0; // 시작위치

		for (int i = 0; i < V - 1; i++) {
			int minIdx = 0;
			int minCnt = Integer.MAX_VALUE;

			// 값이 가장 적은 정점 구하기
			for (int j = 1; j < list.length; j++) {
				if (dist[j] < minCnt && !v[j]) {
					minIdx = j;
					minCnt = dist[j];
				}
			}

			v[minIdx] = true;
			int size = list[minIdx].size();

			for (int j = 0; j < size; j++) {
				if (!v[list[minIdx].get(j).to] && list[minIdx].get(j).cnt < dist[list[minIdx].get(j).to]) {
					dist[list[minIdx].get(j).to] = list[minIdx].get(j).cnt;
				}

			}

		}
		int Ans = 0;
		for (int i = 1; i < dist.length; i++) {
			Ans += dist[i];
		}

		System.out.println(Ans);
	}

}
