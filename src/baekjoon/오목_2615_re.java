package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_2615_re {
	static int[] dr = { -1, 0, 1, 1 };
	static int[] dc = { 1, 1, 1, 0 };
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[20][20];
		
		for (int i = 1; i <= 19; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				if(map[r][c] == 0) continue;
				for (int k = 0; k < 4; k++) {
					int num = 1;
					int cnt = 1;
					while(true) {
						int nr = r + dr[k]*cnt;
						int nc = c + dc[k]*cnt;
						
						if(check(nr,nc)) break;
						if(map[nr][nc] != map[r][c]) break;
						num ++;
						cnt ++;
					}
					if(num == 5) {
						int nr = r + dr[k]*-1;
						int nc = c + dc[k]*-1;
						
						if(check(nr,nc)) {
							System.out.println(map[r][c]);
							System.out.printf("%d %d\n",r,c);
							flag =true;
						}
						else{
							if(map[nr][nc] != map[r][c]) {
								System.out.println(map[r][c]);
								System.out.printf("%d %d\n",r,c);
								flag =true;
							}
						}
						
					}
					
				}
				
			}
			
		}	
		
		if(!flag) {
			System.out.println(0);
		}
		
	}

	private static boolean check(int nr, int nc) {
		if(nr < 0 || nc < 0 || nr >= 20 || nc>=20) return true;
		return false;
	}
}

