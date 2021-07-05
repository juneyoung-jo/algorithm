package baekjoon;

import java.util.*;
import java.io.*;

public class 미로탈출하기_17090 {
	static int N, M, v[][], ans;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		v = new int[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		go();
		cal();
		System.out.println(ans);

	}

	private static void cal() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j] == 2) ans++;
			}
		}
		
	}

	private static void go() {
		// TODO Auto-generated method stub
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(v[i][j] == 0) {
					dfs(i,j);
				}
			}
		}
		
	}

	private static int dfs(int r, int c) {
		v[r][c] = 1;
		
		int k = calDir(map[r][c]);
		int nr = r + dr[k];
		int nc = c + dc[k];

		if(check(nr,nc)) v[r][c] = 2;
		else if(v[nr][nc] == 0) {
			if(dfs(nr,nc) == 2) v[r][c] = 2; 
		}
		
		return v[r][c];
		
	}
	
	private static int calDir(char cc) {
		if(cc == 'U') return 0;
		if(cc == 'R') return 1;
		if(cc == 'D') return 2;
		return 3;
	}

	private static boolean check(int nr, int nc) {
		if(nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] == 2) return true; 
		return false;
	}

}
