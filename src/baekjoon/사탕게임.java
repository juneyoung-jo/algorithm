package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {
	static int N, max = 1, Ans = 1;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				if (map[r][c] == map[r][c + 1]) {
					continue;
				}
				// switch
				char tmp = map[r][c];
				map[r][c] = map[r][c + 1];
				map[r][c + 1] = tmp;

				// 최대값 구하기
				for (int i = 0; i < N; i++) {
					max = 1;
					for (int j = 0; j < N - 1; j++) { // 행
						if (map[i][j] == map[i][j + 1]) {
							++max;
							Ans = Math.max(max, Ans);
						} else {
							max = 1;
						}
					}
					max = 1;
					for (int j = 0; j < N - 1; j++) { // 열
						if (map[j][i] == map[j + 1][i]) {
							++max;
							Ans = Math.max(max, Ans);
						} else {
							max = 1;
						}
					}
				}

				// 다시 초기화
				tmp = map[r][c];
				map[r][c] = map[r][c + 1];
				map[r][c + 1] = tmp;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				if (map[c][r] == map[c + 1][r]) {
					continue;
				}
				// switch
				char tmp = map[c][r];
				map[c][r] = map[c + 1][r];
				map[c + 1][r] = tmp;

				// 최대값 구하기
				for (int i = 0; i < N; i++) {
					max = 1;
					for (int j = 0; j < N - 1; j++) { // 행
						if (map[i][j] == map[i][j + 1]) {
							++max;
							Ans = Math.max(max, Ans);
						} else {
							max = 1;
						}
					}
					max = 1;
					for (int j = 0; j < N - 1; j++) { // 열
						if (map[j][i] == map[j + 1][i]) {
							++max;
							Ans = Math.max(max, Ans);
						} else {
							max = 1;
						}
					}
				}

				// 다시 초기화
				tmp = map[c][r];
				map[c][r] = map[c + 1][r];
				map[c + 1][r] = tmp;
			}
		}

		System.out.println(Ans);

	}

}
