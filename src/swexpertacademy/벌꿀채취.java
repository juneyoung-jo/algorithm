package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벌꿀채취 {
	static int T, N, M, C, map[][], max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0;
			int[] arr = new int[M];
			boolean[] v;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N - M; c++) {
					int sum = 0; // 합계

					// A일꾼
					for (int i = 0; i < M; i++) {
						arr[i] = map[r][c + i];
					}
					v = new boolean[M];
					max = 0;
					powerSet(0, arr, v);
					sum = max;

					// B일꾼 -> A일꾼이 일한 곳 제외.
					for (int i = r; i < N; i++) {
						for (int j = 0; j <= N - M; j++) {
//							if(i==r) continue;
							if (i == r && (!check(j, c) || !check(c, j)))
								continue;
							for (int k = 0; k < M; k++) {
								arr[k] = map[i][j + k];
							}
							v = new boolean[M];
							max = 0;
							powerSet(0, arr, v);
							sum += max;
							ans = Math.max(ans, sum);
							sum -= max;

						}
					}

				}
			}

			System.out.printf("#%d %d\n", tc, ans);
//			print(map);

		}

	}

	private static void powerSet(int idx, int[] arr, boolean[] v) {
		if (idx == M) {
			int sum = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[i])
					sum += arr[i];
			}
			if (sum <= C) {
				int powsum = 0;
				for (int i = 0; i < v.length; i++) {
					if (v[i])
						powsum += Math.pow(arr[i], 2);
				}
				max = Math.max(max, powsum);
			}

			return;
		}

		v[idx] = true;
		powerSet(idx + 1, arr, v);
		v[idx] = false;
		powerSet(idx + 1, arr, v);

	}

	private static boolean check(int ac, int c) {

		for (int i = 0; i < M; i++) {
			if (c == ac + i)
				return false;
		}
		return true;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
