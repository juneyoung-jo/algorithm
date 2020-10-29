package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여왕벌_10836 {
	static int map[][], M, N, num[][];
	static int[] dr = { 0, -1, -1 };
	static int[] dc = { -1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][M];
		num = new int[N][3];

		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}

		int[] arr = new int[2 * M - 1];

		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());

			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= one; i++) {
				arr[zero + i - 1] += 1;
			}

			for (int i = 1; i <= two; i++) {
				arr[zero + one + i - 1] += 2;
			}

		}

		calMap(arr);
		print(map);
	}

	private static void calMap(int[] arr) {
		int index = 0;
		for (int r = M - 1; r >= 0; r--) {
			map[r][0] += arr[index++];
		}
		for (int c = 1; c < M; c++) {
			map[0][c] += arr[index++];
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				int nr = i + -1;
				int nc = j + 0;
				map[i][j] = map[nr][nc];
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
