package baekjoon;

import java.util.*;
import java.io.*;

public class 효율적인해킹_1325 {

	static int N, M, dp[];
	static ArrayList<Integer>[] list;
	static boolean[] v;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		dp = new int[N + 1];

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			list[end].add(start);
		}

		// 알고리즘
		for (int i = 1; i <= N; i++) {
			v = new boolean[N + 1];
			cal(i);
		}

		StringBuilder sb = new StringBuilder();
		int ans = 1;
		for (int i = 1; i <= N; i++) {
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}

		for (int i = 1; i <= N; i++) {
			if (ans == dp[i]) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb);
	}

	private static void cal(int idx) {
		v[idx] = true;
		q.add(idx);

		while (!q.isEmpty()) {
			int num = q.poll();
			int size = list[num].size();
			for (int i = 0; i < size; i++) {
				int n = list[num].get(i);
				if (v[n]) continue;
				v[n] = true;
				q.add(n);
				dp[n]++;
			}
		}

	}

}
