package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 치즈_2636 {
	static int N, M, map[][], ans, time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cal(1);
//		print(map);
		
		System.out.println(time);
		System.out.println(ans);

	}

	private static void cal(int idx) {

		int sum = 0;
		int cnt = 0;
		boolean[][] v= new boolean[N][M];
		
		dfs(0,0,v);
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				
				if(map[r][c]==0) {
					cnt ++;
					continue;
				} 
				
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];

					if (map[nr][nc] == 0 && v[nr][nc]) {
						map[r][c] = 0;
						sum++;
						cnt++;
						break;
					}
				}

			}
		}
		
		if(cnt == N*M) {
			time = idx;
			ans = sum;
			return;
		} 
		
		cal(idx+1);

	}

	private static void dfs(int r, int c, boolean[][] v) {
		v[r][c] = true;
		
		for (int k = 0; k < 4; k++) {
			int nr = r+ dr[k];
			int nc = c + dc[k];
			
			if(nr< 0 || nc < 0 || nr>= N || nc>=M) continue;
			if(map[nr][nc] == 0 && !v[nr][nc]) {
				dfs(nr,nc,v);
			}
		}
		
		
		
	}

	private static void print(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
