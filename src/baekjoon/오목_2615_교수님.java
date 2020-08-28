package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 오목_2615_교수님 {
	static int[][] board = new int[19 + 1][19 + 1];

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("오목.txt"));
		Scanner sc = new Scanner(System.in);
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		// print(board);
		boolean flag = false;
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				if (board[r][c] == 1 || board[r][c] == 2) {
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						int cnt = 1;
						while (check(nr, nc) && board[nr][nc] == board[r][c]) {
							nr += dr[k];
							nc += dc[k];
							cnt++;
						}
						// 오목이면
						if (cnt == 5) {

							// 뒤로 돌아가서 오목인지 확인
							int bCnt = 1;

							nr = nr + (dr[k] * -1);
							nc = nc + (dc[k] * -1);
							while (check(nr, nc) && board[nr][nc] == board[r][c]) {

								nr += (dr[k] * -1);
								nc += (dc[k] * -1);
								bCnt++;
							}
							if (bCnt > 6)
								continue;
							flag = true;
							System.out.println(board[r][c]);
							System.out.println(r + " " + c);
						}
					}
				}
			}
		}
		if (!flag) {
			System.out.println(0);
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr > 0 && nr <= 19 && nc > 0 && nc <= 19) {
			return true;
		}
		return false;
	}

	// 우상 우 우하 하
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };

	private static void print(int[][] board2) {
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
	}

}
