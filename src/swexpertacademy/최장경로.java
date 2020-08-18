package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최장경로 {
	static int T, N, M, max = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] p = new ArrayList[N + 1];

			for (int i = 0; i <= N; i++) {
				p[i] = new ArrayList<Integer>();

			}
			//알고리즘
			//인접리스트 구해서 dfs돌려서 가장 긴 경로 찾는 문제
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				p[from].add(to);
				p[to].add(from);
			}
			
			for (int i = 1; i <= N; i++) {
				int cnt = 1;
				dfs(p, i, new boolean[N + 1], cnt);
			}

			System.out.printf("#%d %d\n", tc, max);
			max = 1;

		}
	}

	private static void dfs(ArrayList<Integer>[] p, int idx, boolean[] v, int cnt) {
		v[idx] = true;
		int size = p[idx].size();
		for (int i = 0; i < size; i++) {
			int n = p[idx].get(i);
			if (!v[n]) {
				dfs(p, n, v, cnt + 1);
				v[n] = false;
			}
		}

		max = Math.max(max, cnt);

	}

}
