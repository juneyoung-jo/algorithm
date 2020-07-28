package swexpertacademy;

import java.util.Scanner;

public class Ladder1 {
	static int T = 10, map[][] = new int[100][100], r, c, ans;
	static int[] dr = { 0, 0, -1 }; // 왼,오른,위
	static int[] dc = { -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int index = 0; index < T; index++) {
			int tc = sc.nextInt();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			while (true) {

				for (int i = 0; i < 3; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nc >= 0 && nc < 100 && nr >= 0) {
						if (map[nr][nc] == 1) {
							r = nr;
							c = nc;
							map[r][c] = 2;
							break;
						}
					}

				}

				if (r == 0) {
					break;
				}
			}

			System.out.printf("#%d %d\n", tc, c);
		}

		sc.close();

	}

}
