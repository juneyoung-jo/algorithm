package jungol;

import java.util.Scanner;

public class 해밀턴순환회로_1681 {
	static int N, map[][], Ans = Integer.MAX_VALUE;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

//		print(map);
		dfs(1, 0, 0);
		System.out.println(Ans);

	}

	private static void dfs(int idx, int start, int cnt) {
		if (idx == N) {
			if (map[start][0] == 0)
				return;
			cnt += map[start][0];
			if (Ans > cnt) {
				Ans = cnt;
			}
			return;
		}

		for (int i = 1; i < N; i++) {
			if (!v[i] && map[start][i] != 0) {
				v[i] = true;
				dfs(idx + 1, i, cnt + map[start][i]);
				v[i] = false;
			}
		}
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
