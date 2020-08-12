package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
	static int T, N, map[][], numbers[], cnt;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 8방
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			numbers = new int[N];
			boolean[] v = new boolean[N];

			// 핵심은 순열임. => 시간초과 날 수도있음 다른방법 생각
			nqueen(0, v);
			System.out.printf("#%d %d\n", tc, cnt);
			cnt = 0;

		}

	}

	private static void nqueen(int idx, boolean[] v) {
		if (idx == N) { // numbers배열에 순열값 다 담음 중복처리만하면됨.
			boolean[][] bl = new boolean[N][N];
			for (int i = 0; i < numbers.length; i++) {
				bl[i][numbers[i]] = true;
			}

			for (int i = 0; i < bl.length; i++) {
				for (int j = 0; j < bl.length; j++) {
					if (bl[i][j] == true) {
						for (int k = 0; k < 8; k++) {
							for (int n = 1; n <= N; n++) {
								int nr = i + dr[k] * n;
								int nc = j + dc[k] * n;

								if (nr >= 0 && nc >= 0 && nr < N && nc < N && bl[nr][nc] == true) {
									return;
								}

							}
						}
					}
				}
			}
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			numbers[idx] = i;
			v[i] = true;
			nqueen(idx + 1, v);
			v[i] = false;
		}

	}

	private static void print(boolean[][] v) {

		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

}
