package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_9466 {
	static int T, n, arr[], ans, vNum[];
	static boolean  v[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr = new int[n + 1];
			v = new boolean[n + 1];
			vNum = new int[n+1];
			ans = 0;

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (!v[i]) {
					dfs(i, 1);
				}
			}

			System.out.println(n - ans);

		}

	}

	private static void dfs(int start, int cnt) {
		v[start] = true;
		vNum[start] = cnt;

		if (!v[arr[start]]) {
			dfs(arr[start], cnt + 1);
		} else {
			if (vNum[arr[start]] != 0) {
				ans += (cnt - vNum[arr[start]]+1);
			}
		}
		vNum[start] = 0;
	}
}
