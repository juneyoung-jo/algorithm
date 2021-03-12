package baekjoon;

import java.util.*;
import java.io.*;

public class 비밀모임_13424 {

	static int T, N, M, K, arr[], dis[][], ans;
	static final int inf = 1000001;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;

			dis = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						dis[i][j] = 0;
					else
						dis[i][j] = inf;
				}
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());

				dis[to][from] = cnt;
				dis[from][to] = cnt;
			}

			K = Integer.parseInt(br.readLine());
			arr = new int[K];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int k = 1; k < dis.length; k++) {// 거쳐가는 노드
				for (int i = 1; i < dis.length; i++) {// 출발 노드
					for (int j = 1; j < dis.length; j++) {// 도착 노드
						if (dis[i][k] + dis[k][j] < dis[i][j]) {
							dis[i][j] = dis[i][k] + dis[k][j];
						}
					}
				}
			}

			int sum = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int s = 0;
				for (int j = 0; j < K; j++) {
					s += dis[arr[j]][i];
				}
				if (s < sum) {
					sum = s;
					ans = i;
				}

			}

			System.out.println(ans);

		}

	}

}
