package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고_2578 {
	static int[][] map = new int[5][5];
	static int[][] ans = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 내 빙고판
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 부를 숫자
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				ans[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 빙고시작.
		System.out.println(cal());

	}

	private static int cal() {
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cnt++;

				L: for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						if (map[r][c] == ans[i][j]) {
							map[r][c] = 0;
							break L;
						}
					}
				} // 내 빙고판 지우는 for문 끝

				// 빙고 검사. 최소 12개.
				if (cnt >= 10) {

					int bingo = 0;
					for (int row = 0; row < 5; row++) {
						int rnum = 0;
						int cnum = 0;

						// 행검사
						for (int col = 0; col < 5; col++) {
							rnum += map[row][col];
						}
						if (rnum == 0)
							bingo++;
						if (bingo >= 3)
							return cnt;

						// 열검사
						for (int col = 0; col < 5; col++) {
							cnum += map[col][row];
						}

						if (cnum == 0)
							bingo++;
						if (bingo >= 3)
							return cnt;
					}

					// 대각선검사
					int num_1 = map[0][0] + map[1][1] + map[2][2] + map[3][3] + map[4][4];
					if (num_1 == 0)
						bingo++;
					if (bingo >= 3)
						return cnt;

					int num_2 = map[0][4] + map[1][3] + map[2][2] + map[3][1] + map[4][0];
					if (num_2 == 0)
						bingo++;
					if (bingo >= 3)
						return cnt;

				}

			}
		} // 사회자가 부르는 번호 끝
		return cnt;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
