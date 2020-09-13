package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {
	static int T, D, W, K, arr[], min;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new boolean[D][W];
			min = K;
			arr = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) {
						map[i][j] = true;
					} else {
						map[i][j] = false;
					}
				}
			}

//			print(map);
			// 알고리즘
			// 부분집합 문제

			if (check(map)) {
				min = 0;
			} else {
				powerSet(0, 0);
			}

			System.out.printf("#%d %d\n", tc, min);

		}

	}

	private static void powerSet(int idx, int cnt) {
		if (cnt > min)
			return;

		if (idx == D) {
//			System.out.println(Arrays.toString(arr));
			boolean[][] cArr = new boolean[D][W];
			for (int i = 0; i < cArr.length; i++) { // 맵 복사
				System.arraycopy(map[i], 0, cArr[i], 0, map[i].length);
			}

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 1)
					continue;
				if (arr[i] == 2) {
					for (int j = 0; j < W; j++) {
						cArr[i][j] = true;
					}
				} else if (arr[i] == 3) {
					for (int j = 0; j < W; j++) {
						cArr[i][j] = false;
					}
				}
			}

			if (check(cArr)) {
				if (min > cnt)
					min = cnt;
			}

			return;
		}

		arr[idx] = 1; // 기본
		powerSet(idx + 1, cnt);
		arr[idx] = 2; // A
		powerSet(idx + 1, cnt + 1);
		arr[idx] = 3; // B
		powerSet(idx + 1, cnt + 1);

	}

	private static boolean check(boolean[][] map) {
		for (int c = 0; c < W; c++) {
			int cnt = 1;
			for (int r = 0; r < D - 1; r++) {
				if (map[r][c] != map[r + 1][c]) { // 다음 행과 같다면
					cnt = 1;
				} else { // 인접한 2개 셀이 같다면
					if (++cnt >= K) {
						break;
					}
				}
			}
			if (cnt < K) {
				return false;
			}
		}
		return true;
	}

	private static void print(boolean[][] map) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
