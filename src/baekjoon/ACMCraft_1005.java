package baekjoon;

import java.util.*;
import java.io.*;

public class ACMCraft_1005 {
	static int T, N, K, X, Y, W, D, cost[], arr[];


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] list = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine(), " ");
			cost = new int[N + 1]; // 비용 배열
			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				arr[e] += 1;
			}

			W = Integer.parseInt(br.readLine()); // 도착점

			int[] dp = new int[N + 1];
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (arr[i] == 0) {
					q.add(i); // 시작지점 담기
					dp[i] = cost[i];
				}

			}
			while (!q.isEmpty()) {
				int p = q.poll();

				int size = list[p].size();
				if (p == W) {
					break;
				}

				for (int i = 0; i < size; i++) {
					int end = list[p].get(i);
					arr[end] -= 1;

					dp[end] = Math.max(dp[end], dp[p] + cost[end]);
					if (arr[end] == 0) {
						q.add(end);
					}

				}

			}

			System.out.println(dp[W]);

		}
	}

}
