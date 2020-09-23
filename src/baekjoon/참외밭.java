package baekjoon;

import java.util.Scanner;

public class 참외밭 {
	//나중에 다시 풀어볼 것.
	static int K, map[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();

		map = new int[6][2];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int maxrow = 0;
		int maxcol = 0;

		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				maxrow = Math.max(maxrow, map[i][1]);
			} else {
				maxcol = Math.max(maxcol, map[i][1]);
			}
		}

		int minrow = Integer.MAX_VALUE;
		int mincol = Integer.MAX_VALUE;
		
		// 파인곳 찾기. <= 이부분 다시 구현	
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (map[(i + 5) % 6][1] + map[(i + 1) % 6][1] == maxcol) {
					minrow = map[i][1];
				}
			} else {
				if (map[(i + 5) % 6][1] + map[(i + 1) % 6][1] == maxrow) {
					mincol = map[i][1];
				}
			}

		}

		System.out.println(((maxrow * maxcol) - (minrow * mincol)) * K);
	}

}
