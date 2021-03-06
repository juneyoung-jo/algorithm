package swexpertacademy;

import java.util.Scanner;

public class 무선충전 { // 정답은 맞는데 테케가 빡빡하면 틀릴수도?
	static int T, M, A, Ans;
	static int[][] map = new int[10][10];
	static int[][] move, bc;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static boolean[][] v;
	static boolean[] dupA, dupB;

	static class Point {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			A = sc.nextInt();

			move = new int[2][M];
			bc = new int[A][4];

			// move입력
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < M; j++) {
					move[i][j] = sc.nextInt();
				}
			}

			// bc 입력
			for (int i = 0; i < bc.length; i++) {
				for (int j = 0; j < bc[i].length; j++) {
					bc[i][j] = sc.nextInt();
				}
			}


			Point Aman = new Point(0, 0, 0);
			Point Bman = new Point(9, 9, 0);

			{
				dupA = new boolean[A];
				dupB = new boolean[A];

				cal(Aman.c, Aman.r, dupA);
				cal(Bman.c, Bman.r, dupB);

				int cnta = 0;
				int cntb = 0;

				for (int j = 0; j < A; j++) {
					if (dupA[j]) {
						cnta++;
					}
					if (dupB[j]) {
						cntb++;
					}
				}

				if (cnta + cntb == 1) {// 그냥 계산하면 됨.
					for (int j = 0; j < A; j++) {
						if (dupA[j]) {
							Ans += bc[j][3];
							break;
						}
						if (dupB[j]) {
							Ans += bc[j][3];
							break;
						}
					}
				} else if (cnta == 1 && cntb == 1) {
					for (int j = 0; j < A; j++) {
						if (dupA[j] && dupB[j]) {
							Ans += bc[j][3];
							break;
						} else {
							if (dupA[j]) {
								Ans += bc[j][3];
							}
							if (dupB[j]) {
								Ans += bc[j][3];
							}
						}
					}

				} else {// 중복이 있을 수 있으니 체크 해서 값 넣어야 함.
					int maxA = 0;
					int maxB = 0;

					for (int j = 0; j < A; j++) {
						if (dupA[j]) {
							maxA = Math.max(maxA, bc[j][3]);
						}
					}

					for (int j = 0; j < A; j++) {
						if (dupB[j]) {
							maxB = Math.max(maxB, bc[j][3]);
						}
					}

					if (maxA == maxB) {
						if (cnta >= 2 && cntb == 1) {
							Ans += maxB;
							int maxC = 0;
							for (int j = 0; j < A; j++) {
								if (dupA[j] && bc[j][3] != maxB) {
									maxC = Math.max(maxC, bc[j][3]);
								}
							}
							Ans += maxC;
						} else if (cnta == 1 && cntb >= 2) {
							Ans += maxA;
							int maxC = 0;
							for (int j = 0; j < A; j++) {
								if (dupB[j] && bc[j][3] != maxA) {
									maxC = Math.max(maxC, bc[j][3]);
								}
							}
							Ans += maxC;
						} else {// 둘다 2 이상이면
							int maxAA = 0;
							int maxBB = 0;
							for (int j = 0; j < A; j++) {
								if (dupA[j] && bc[j][3] != maxA) {
									maxAA = Math.max(maxAA, bc[j][3]);
								}
							}
							for (int j = 0; j < A; j++) {
								if (dupB[j] && bc[j][3] != maxB) {
									maxBB = Math.max(maxBB, bc[j][3]);
								}
							}

							if (maxAA > maxBB) {
								Ans += maxAA;
								Ans += maxB;
							} else {
								Ans += maxBB;
								Ans += maxA;
							}

						}

					} else {
						Ans += maxA;
						Ans += maxB;
					}
				}

			}

			for (int i = 0; i < M; i++) {
				Aman.r += dr[move[0][i]];
				Aman.c += dc[move[0][i]];
				dupA = new boolean[A];
				cal(Aman.c, Aman.r, dupA);

				Bman.r += dr[move[1][i]];
				Bman.c += dc[move[1][i]];
				dupB = new boolean[A];
				cal(Bman.c, Bman.r, dupB);

				// 값 계산만 하면 끝
				int cnta = 0;
				int cntb = 0;
				for (int j = 0; j < A; j++) {
					if (dupA[j]) {
						cnta++;
					}
					if (dupB[j]) {
						cntb++;
					}
				}
				if (cnta + cntb == 0)
					continue;
				if (cnta + cntb == 1) {// 그냥 계산하면 됨.
					for (int j = 0; j < A; j++) {
						if (dupA[j]) {
							Ans += bc[j][3];
							break;
						}
						if (dupB[j]) {
							Ans += bc[j][3];
							break;
						}
					}
				} else if (cnta == 1 && cntb == 1) {
					for (int j = 0; j < A; j++) {
						if (dupA[j] && dupB[j]) {
							Ans += bc[j][3];
							break;
						} else {
							if (dupA[j]) {
								Ans += bc[j][3];
							}
							if (dupB[j]) {
								Ans += bc[j][3];
							}
						}
					}

				} else {// 중복이 있을 수 있으니 체크 해서 값 넣어야 함.
					int maxA = 0;
					int maxB = 0;
					int maxAc = 0;
					int maxBc = 0;
					for (int j = 0; j < A; j++) {
						if (dupA[j]) {
							if (maxA < bc[j][3])
								maxAc = j;
							maxA = Math.max(maxA, bc[j][3]);
						}
					}

					for (int j = 0; j < A; j++) {
						if (dupB[j]) {
							if (maxB < bc[j][3])
								maxBc = j;
							maxB = Math.max(maxB, bc[j][3]);
						}
					}

					if (maxA == maxB) {
						if (maxAc != maxBc) {
							Ans += maxA;
							Ans += maxB;
							continue;
						}

						if (cnta >= 2 && cntb == 1) {
							Ans += maxB;
							int maxC = 0;
							for (int j = 0; j < A; j++) {
								if (dupA[j] && bc[j][3] != maxB) {
									maxC = Math.max(maxC, bc[j][3]);
								}
							}
							Ans += maxC;
						} else if (cnta == 1 && cntb >= 2) {
							Ans += maxA;
							int maxC = 0;
							for (int j = 0; j < A; j++) {
								if (dupB[j] && bc[j][3] != maxA) {
									maxC = Math.max(maxC, bc[j][3]);
								}
							}
							Ans += maxC;
						} else {// 둘다 2 이상이면
							int maxAA = 0;
							int maxBB = 0;
							for (int j = 0; j < A; j++) {
								if (dupA[j] && bc[j][3] != maxA) {
									maxAA = Math.max(maxAA, bc[j][3]);
								}
							}
							for (int j = 0; j < A; j++) {
								if (dupB[j] && bc[j][3] != maxB) {
									maxBB = Math.max(maxBB, bc[j][3]);
								}
							}

							// 둘다 2이상일 때
							if (maxAA > maxBB) {
								Ans += maxAA;
								Ans += maxB;
							} else {
								Ans += maxBB;
								Ans += maxA;
							}

						}

					} else {
						Ans += maxA;
						Ans += maxB;
					}
				}

			}
//			print(map);
			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;
		}

	}

	private static void cal(int c, int r, boolean[] dup) {
		for (int i = 0; i < A; i++) {
			if ((Math.abs(c - (bc[i][0] - 1)) + Math.abs(r - (bc[i][1] - 1))) <= bc[i][2]) {
				dup[i] = true;
			}
		}
	}


	private static void print(int[][] move) {
		// TODO Auto-generated method stub
		for (int i = 0; i < move.length; i++) {
			for (int j = 0; j < move[i].length; j++) {
				System.out.print(move[i][j] + " ");
			}
			System.out.println();
		}
	}

}
