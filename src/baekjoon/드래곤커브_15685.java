package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 드래곤커브_15685 {

	static int K, map[][], ans;
	static int[] dr = { 0, -1, 0, 1 }; // 오 상 왼 하
	static int[] dc = { 1, 0, -1, 0 };

	static int[] ddr = { 0, 1, 1 };
	static int[] ddc = { 1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new int[200][200];
		K = sc.nextInt();
		int[][] arr = new int[K][4];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			cal(arr[i][0], arr[i][1], arr[i][2], arr[i][3]);
		}

		for (int r = 0; r < map.length; r++) {
			L: for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == 1) {
					for (int k = 0; k < 3; k++) {
						int nr = r + ddr[k];
						int nc = c + ddc[k];

						if (map[nr][nc] != 1) continue L;
					}
					ans++;
				}
			}
		}

//		print(map);
		System.out.println(ans);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void cal(int c, int r, int dir, int g) {
		map[r][c] = 1;

		List<Integer> list = new ArrayList<Integer>();
		list.add(dir);

		for (int i = 0; i < g; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}

		int nr = r;
		int nc = c;

		for (int i = 0; i < list.size(); i++) {
			nr += dr[list.get(i)];
			nc += dc[list.get(i)];

			map[nr][nc] = 1;
		}

	}

}
