package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int T, N, map[][], ans;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			print(map);

			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					calR(r, c, new boolean[101], 0);
				}
			}
			
			System.out.printf("#%d %d\n",tc,ans);

		}

	}

	private static void calR(int r, int c, boolean[] v, int rCnt) {
		

		int nr = r + dr[0];
		int nc = c + dc[0];

		if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[map[nr][nc]])
			return;
		v[map[nr][nc]] = true;
		calR(nr, nc, v, rCnt + 1);
		calL(nr,nc,v,rCnt+1,0);
		v[map[nr][nc]] = false;
	}

	private static void calL(int r, int c, boolean[] v, int rCnt, int lCnt) {
		
		int nr = r + dr[1];
		int nc = c + dc[1];

		if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[map[nr][nc]]) return;
		v[map[nr][nc]] =true;
		calL(nr, nc, v, rCnt, lCnt+1);
		calAns(nr,nc,v,rCnt,lCnt+1);
		v[map[nr][nc]] =false;
		
	}

	private static void calAns(int r, int c, boolean[] v, int rCnt, int lCnt) {
		boolean[] vv = new boolean[101];
		copyV(v,vv);
		int nr = r;
		int nc = c;
		for (int i = 0; i < rCnt; i++) {
			nr +=  dr[2];
			nc +=  dc[2];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || vv[map[nr][nc]]) return;
			vv[map[nr][nc]] = true;
		}
		
		for (int i = 0; i < lCnt; i++) {
			nr += dr[3];
			nc += dc[3];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || vv[map[nr][nc]]) return;
			vv[map[nr][nc]] = true;
		}
		
		ans = Math.max(ans, (rCnt+lCnt)*2);
		
	}

	private static void copyV(boolean[] v, boolean[] vv) {
		for (int i = 0; i < v.length; i++) {
			vv[i] = v[i];
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
