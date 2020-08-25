package swexpertacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 무선충전 {
	static int T, M, A;
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

			// 배터리공간 표시하기
//			v = new boolean[10][10];
//			for (int i = 0; i < A; i++) {
//				bfs(new Point(bc[i][1] - 1, bc[i][0] - 1, bc[i][2]));
//			}

			Point Aman = new Point(0, 0, 0);
			Point Bman = new Point(9, 9, 0);
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
					if (dupA[j] == true) {
						cnta++;
					}
					if (dupB[j] == true) {
						cnta++;
					}
				}

				if (cnta + cntb == 1) {// 그냥 계산하면 됨.

				} else if (cnta == 1 && cntb == 1) {

				} else {// 중복이 있을 수 있으니 체크 해서 값 넣어야 함.

				}

			}
//			print(map);

		}

	}

	private static void cal(int c, int r, boolean[] dup) {
		for (int i = 0; i < A; i++) {
			if ((Math.abs(c - (bc[i][0] - 1)) + Math.abs(r - (bc[i][1] - 1))) <= bc[i][2]) {
				dup[i] = true;
			}
		}
	}

//	private static void bfs(Point point) {
//		Queue<Point> q = new LinkedList<Point>();
//		q.add(point);
//		v[point.r][point.c] = true;
//		map[point.r][point.c] = 1;
//
//		while (!q.isEmpty()) {
//			Point p = q.poll();
//
//			for (int k = 1; k < 5; k++) {
//				int nr = p.r + dr[k];
//				int nc = p.c + dc[k];
//
//				if (nr >= 0 && nc >= 0 && nr < 10 && nc < 10 && !v[nr][nc] && map[nr][nc] == 0 && p.cnt > 0) {
//					q.add(new Point(nr, nc, p.cnt - 1));
//					v[nr][nc] = true;
//					map[nr][nc] = 1;
//				}
//			}
//
//		}
//	}

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
