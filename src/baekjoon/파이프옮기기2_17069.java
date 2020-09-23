package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기2_17069 {
	static int N, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][][] dp = new long[3][N + 1][N + 1];
		long ans = 0;
		// 0은 오른쪽
		// 1은 아래
		// 2는 대각선

		dp[0][1][2] = 1;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 1)
					continue;
				dp[0][r][c] += dp[0][r][c - 1] + dp[2][r][c - 1];
				dp[1][r][c] += dp[1][r - 1][c] + dp[2][r - 1][c];

				// 주변에 없을 때
				if (map[r - 1][c] == 0 && map[r][c - 1] == 0) {
					dp[2][r][c] += dp[2][r - 1][c - 1] + dp[1][r - 1][c - 1] + dp[0][r - 1][c - 1];
				}

			}
		}

		for (int i = 0; i < 3; i++) {
			ans += dp[i][N][N];
		}
		System.out.println(ans);

	}

	private static void print(int[][] map) {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
