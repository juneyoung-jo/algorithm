package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 단지번호붙이기 {
	static int N, map[][], Ans = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Apart {
		int r, c;

		public Apart(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		int number = 0;
		ArrayList<Integer> cntList = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					number++;
					dfs(new Apart(r, c));
					cntList.add(Ans);
				}
				Ans = 0;
			}
		}

		Collections.sort(cntList);
		System.out.println(number);
		for (int i = 0; i < cntList.size(); i++) {
			System.out.println(cntList.get(i));
		}
		// print(map);

	}

	private static void dfs(Apart apart) {
		map[apart.r][apart.c] = 0;
		Ans++;

		for (int k = 0; k < 4; k++) {
			int nr = apart.r + dr[k];
			int nc = apart.c + dc[k];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 1) { // 테두리
				dfs(new Apart(nr, nc));
			}
		}
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
