package swexpertacademy;

import java.util.Scanner;

public class 정사각형방2 {
	static int T, N, map[][], cnt = 0, start = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						int count = 1;
						if (nr >= 0 && nc >= 0 && nr < N && nc < N) { // 테두리
							if (map[nr][nc] == map[i][j] + 1) {
								count++;
								boolean isok = false;
								int x = nr;
								int y = nc;
								while (true) {
									for (int l = 0; l < 4; l++) {
										int nnr = x + dr[l];
										int nnc = y + dc[l];

										if (nnr >= 0 && nnc >= 0 && nnr < N && nnc < N) {
											if (map[nnr][nnc] == map[x][y] + 1) {
												count++;
												x = nnr;
												y = nnc;
												break;
											}
										}
										if (l == 3) {
											isok = true;
										}

									}
									if (isok) {
										if (cnt < count) {
											cnt = count;
											start = map[i][j];
										}
										if (cnt == count) {
											if (start > map[i][j]) {
												start = map[i][j];
											}
										}
										break;
									}

								}
							}
						}
					}
				}
			}

			System.out.printf("#%d %d %d\n", tc, start, cnt);
			start = 0;
			cnt = 0;

		}

	}

}
