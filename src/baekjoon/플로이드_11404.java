package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 플로이드_11404 {
	// 프롤이드워셜로 다시 풀기.
	static int N, M;
	static int inf = 10000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		int dis[][] = new int[N + 1][N + 1];

		// dis배열 max값으로 초기화
		for (int i = 1; i < dis.length; i++) {
			for (int j = 1; j < dis.length; j++) {
				if (i == j)
					dis[i][j] = 0;
				else
					dis[i][j] = inf;
			}
		}

		// 간선 배열 만들기.
		for (int d = 0; d < M; d++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			if (dis[to][from] > cnt)
				dis[to][from] = cnt;
		}

		// 프로이드-와샬
		for (int k = 1; k < dis.length; k++) {// 거쳐가는 노드
			for (int i = 1; i < dis.length; i++) {// 출발 노드
				if(k==i) continue;
				for (int j = 1; j < dis.length; j++) {// 도착 노드
					if(i==j || k==j) continue;
					if (dis[i][k] + dis[k][j] < dis[i][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
					}
				}
			}
		}

		print(dis);

	}

	private static void print(int[][] dis) {

		for (int i = 1; i < dis.length; i++) {
			for (int j = 1; j < dis[i].length; j++) {
				if (dis[i][j] == inf) {
					dis[i][j] = 0;
				}
				System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}

	}

}
