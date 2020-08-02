package swexpertacademy;

import java.util.Scanner;

public class 재미있는오셀로게임 {
	static int T, N, M, countb, countw;
	static char[][] map;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			map = new char[N][N];

			switch (N) {
			case 4:
				map[1][1] = 'w';
				map[1][2] = 'b';
				map[2][1] = 'b';
				map[2][2] = 'w';
				break;
			case 6:
				map[2][2] = 'w';
				map[2][3] = 'b';
				map[3][2] = 'b';
				map[3][3] = 'w';
				break;
			case 8:
				map[3][3] = 'w';
				map[3][4] = 'b';
				map[4][3] = 'b';
				map[4][4] = 'w';
				break;

			default:
				break;
			}

			int[] arr = new int[3]; // 바둑좌표 받기
			for (int i = 0; i < M; i++) { // 돌 놓기

				// 좌표받아서 바둑돌 놓기
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				if (arr[2] == 1) {
					map[arr[0] - 1][arr[1] - 1] = 'b';
				} else {
					map[arr[0] - 1][arr[1] - 1] = 'w';
				}

				// 8방체크
				for (int cnt = 0; cnt < 8; cnt++) {
					int nr = arr[0] - 1 + dr[cnt];
					int nc = arr[1] - 1 + dc[cnt];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 테투리
						if (arr[2] == 1) {// 흑돌인경우
							if (map[nr][nc] == 'w') {
								int count = 0;
								while (true) {
									nr += dr[cnt];
									nc += dc[cnt];
									if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
										if (map[nr][nc] == 'b') {
											for (int j = 0; j <= count; j++) {
												nr -= dr[cnt];
												nc -= dc[cnt];
												map[nr][nc] = 'b';
											}
											break;
										} else if (map[nr][nc] == '\u0000') {
											break;
										} else {
											count++;
										}
									} else {
										break;
									}

								}
							}

						} else {// 백돌인경우
							if (map[nr][nc] == 'b') {
								int count = 0;
								while (true) {
									nr += dr[cnt];
									nc += dc[cnt];
									if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
										if (map[nr][nc] == 'w') {
											for (int j = 0; j <= count; j++) {
												nr -= dr[cnt];
												nc -= dc[cnt];
												map[nr][nc] = 'w';
											}
											break;
										} else if (map[nr][nc] == '\u0000') {
											break;
										} else {
											count++;
										}
									} else {
										break;
									}

								}
							}

						}
					}

				}

			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'b') {
						countb++;
					} else if (map[i][j] == 'w') {
						countw++;
					}
				}
			}

			System.out.printf("#%d %d %d\n", tc, countb, countw);
			countb=0; //초기화 => 지역변수로 만들자...
			countw=0; //초기화
			
		}

	}

}
