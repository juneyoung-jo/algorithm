package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자만들기_dfs {
	static int T, N, number[], operator[], min, max, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			min = Integer.MAX_VALUE;
			max = -100000001;

			N = Integer.parseInt(br.readLine());
			number = new int[N];
			operator = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			dfs(1, number[0]);
			System.out.printf("#%d %d\n", tc, max - min);

		}

	}

	private static void dfs(int idx, int total) {
		if (idx == N) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;

		}

		for (int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					dfs(idx+1, total+number[idx]);
					break;
				case 1:
					dfs(idx+1, total-number[idx]);
					break;
				case 2:
					dfs(idx+1, total*number[idx]);
					break;
				case 3:
					dfs(idx+1, total/number[idx]);
					break;
				}
				operator[i]++;
			}
		}

	}

}
