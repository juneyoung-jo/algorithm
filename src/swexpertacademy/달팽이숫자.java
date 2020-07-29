package swexpertacademy;

import java.util.Scanner;

public class 달팽이숫자 { // 다시풀어보자 ㅈㄴ어려움
	static int T, map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int n = sc.nextInt();

			map = new int[n][n];
			int sw = 1; // 음수 양수 스위치값
			int row = 0;
			int col = -1;
			int count = 1;

			while (n > 0) {
				for (int K = 0; K < n; K++) { // 5번 4번 ~
					col += sw;
					map[row][col] = count++;
				}

				n -= 1;

				for (int k = 0; k < n; k++) { // 4번 3번 ~
					row += sw;
					map[row][col] = count++;
				}

				sw *= -1;

			}
			System.out.println("#" + tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

}
