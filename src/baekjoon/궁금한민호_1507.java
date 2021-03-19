package baekjoon;

import java.util.*;
import java.io.*;

public class 궁금한민호_1507 {

	static int N, arr[][];
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				if (i == j)
					map[i][j] = 0;
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = arr[i][j];
			}
		}

		// 알고리즘
		// 플로이드
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == k || k == j)
						continue;
					if (arr[i][k] + arr[k][j] < arr[i][j]) {
						flag = true;
						break;
					}
					if (arr[i][k] + arr[k][j] == arr[i][j]) {
						map[i][j] = 0;
					}

				}
			}

		}

		int ans = 0;
		if (flag) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					ans += map[i][j];
				}
			}

			System.out.println(ans / 2);
		}

	}

}
