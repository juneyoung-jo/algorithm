package baekjoon;

import java.util.*;
import java.io.*;

public class 주사위굴리기_14499 {

	static int N, M, x, y, K, map[][], arr[], dice[];

	static int[] dr = { 0, 0, 0, -1, 1 }; // 우 좌 상 하
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		arr = new int[K];
		dice = new int[6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 알고리즘
		cal();

	}

	private static void cal() {
		for (int i = 0; i < arr.length; i++) {
			check(arr[i]);
		}
	}

	private static void check(int k) {
		int nr = x + dr[k];
		int nc = y + dc[k];

		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return;

		switch (k) {
		case 1:
			right();
			break;
		case 2:
			left();
			break;
		case 3:
			up();
			break;
		case 4:
			down();
			break;
		}

		if (map[nr][nc] == 0) {
			map[nr][nc] = dice[0];
		}else {
			dice[0] = map[nr][nc];
			map[nr][nc] = 0;
		}
		
		System.out.println(dice[5]);
		
		x= nr;
		y= nc;

	}

	public static void up() {
		int[] ndice = dice.clone();
		dice[0] = ndice[1];
		dice[1] = ndice[5];
		dice[2] = ndice[2];
		dice[3] = ndice[3];
		dice[4] = ndice[0];
		dice[5] = ndice[4];
	}

	public static void down() {
		int[] ndice = dice.clone();
		dice[0] = ndice[4];
		dice[1] = ndice[0];
		dice[2] = ndice[2];
		dice[3] = ndice[3];
		dice[4] = ndice[5];
		dice[5] = ndice[1];
	}

	public static void left() {
		int[] ndice = dice.clone();
		dice[0] = ndice[3];
		dice[1] = ndice[1];
		dice[2] = ndice[0];
		dice[3] = ndice[5];
		dice[4] = ndice[4];
		dice[5] = ndice[2];
	}

	public static void right() {
		int[] ndice = dice.clone();
		dice[0] = ndice[2];
		dice[1] = ndice[1];
		dice[2] = ndice[5];
		dice[3] = ndice[0];
		dice[4] = ndice[4];
		dice[5] = ndice[3];
	}

}
