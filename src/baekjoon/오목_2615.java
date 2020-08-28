package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_2615 {
	static int map[][] = new int[19][19];
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int c = 0; c < map.length; c++) {
			for (int r = 0; r < map.length; r++) {
				if (map[r][c] == 1) {
					int cnt = 1;
					int nr = r;
					int nc = c;
					// 위아래
					while (true) { // 위쪽
						int nnr = nr + dr[1];
						int nnc = nc + dc[1];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {
							break;
						}

					}

					nr = r;
					nc = c;

					while (true) { // 아래쪽
						int nnr = nr + dr[5];
						int nnc = nc + dc[5];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {
							break;
						}

					}
					nr = r;
					nc = c;

					if (cnt == 5) {
						System.out.println("1");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}
					// 좌우
					while (true) { // 좌
						int nnr = nr + dr[7];
						int nnc = nc + dc[7];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 우
						int nnr = nr + dr[3];
						int nnc = nc + dc[3];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("1");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}

					// 왼쪽위 오른쪽아래
					while (true) { // 왼쪽 위
						int nnr = nr + dr[0];
						int nnc = nc + dc[0];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 오른족아래 아래
						int nnr = nr + dr[4];
						int nnc = nc + dc[4];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("1");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}

					// 오룬쪽 위 왼쪽 아래
					while (true) { // 오른쪽 위
						int nnr = nr + dr[2];
						int nnc = nc + dc[2];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 왼쪽 아래
						int nnr = nr + dr[6];
						int nnc = nc + dc[6];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 1) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("1");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}

				} else if (map[r][c] == 2) {
					int cnt = 1;
					int nr = r;
					int nc = c;
					// 위아래
					while (true) { // 위쪽
						int nnr = nr + dr[1];
						int nnc = nc + dc[1];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 아래쪽
						int nnr = nr + dr[5];
						int nnc = nc + dc[5];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("2");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}
					// 좌우
					while (true) { // 좌
						int nnr = nr + dr[7];
						int nnc = nc + dc[7];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {
							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 우
						int nnr = nr + dr[3];
						int nnc = nc + dc[3];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {
							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("2");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}

					// 왼쪽위 오른쪽아래
					while (true) { // 왼쪽 위
						int nnr = nr + dr[0];
						int nnc = nc + dc[0];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 왼쪽 아래
						int nnr = nr + dr[4];
						int nnc = nc + dc[4];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("2");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}

					// 오룬쪽 위 왼쪽 아래
					while (true) { // 오른쪽 위
						int nnr = nr + dr[2];
						int nnc = nc + dc[2];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					while (true) { // 왼쪽 아래
						int nnr = nr + dr[6];
						int nnc = nc + dc[6];

						if (nnr < 0 || nnc < 0 || nnr >= 19 || nnc >= 19)
							break;

						if (map[nnr][nnc] == 2) {
							cnt++;
							nr = nnr;
							nc = nnc;
						} else {

							break;
						}

					}
					nr = r;
					nc = c;
					if (cnt == 5) {
						System.out.println("2");
						System.out.println((r + 1) + " " + (c + 1));
						System.exit(0);
					} else {
						cnt = 1;
					}
				}
			}
		}

		System.out.println("0");

//		print(map);

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
