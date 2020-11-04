package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class professional키순서 {
	static int T,N,M, arr[],ans;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T  = Integer.parseInt(br.readLine());
		StringTokenizer st = null; 
		
		for (int tc = 1; tc <= T; tc++) {
			N  = Integer.parseInt(br.readLine());
			M  = Integer.parseInt(br.readLine());
			v = new boolean[N+1][N+1];
			arr = new int[N+1];
			ans = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				v[start][end] = true;
			}
			
			for (int k = 1; k <= N ; k++) {
				for (int i = 1; i <= N ; i++) {
					for (int j = 1; j <= N ; j++) {
						if(v[i][k] && v[k][j])
							v[i][j] = true;
					}
				}
			}
			
			
			for (int i = 1; i <= M ; i++) {
				for (int j = 1; j <= M ; j++) {
					if(v[i][j]) {
						arr[j]++;
						arr[i]++;
					} 
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(arr[i] == N-1) ans ++;
			}
			
			System.out.printf("#%d %d\n",tc,ans);
			
			
			
		}
		
		
		
		
		
		
	}

}

