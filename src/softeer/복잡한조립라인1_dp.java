package softeer;

import java.util.*;
import java.io.*;

public class 복잡한조립라인1_dp {

	static int N, K, line[][], time[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		List<Integer> t = new ArrayList<>();
		line = new int[N][K];
		time = new int[N][K][K];
		
		// 2->2 (1*2)
		// 3-> 6 (2*3)
		// 4 -> 12 (3*4)
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				line[i][j] = Integer.parseInt(st.nextToken());
			}
			if (i == N - 1) continue;
			for (int j = 0; j < (K-1)*K; j++) {
				t.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if( i == N-1) break;
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < K; k++) {
					if(j==k) continue;
					time[i][j][k] = t.get(idx++);
				}
			}
			
		}
		
		// 알고리즘
		int[][] ans = new int[N][K];
		for (int i = 0; i < N; i++) {
			Arrays.fill(ans[i],Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			if(i == 0) {
				for (int j = 0; j < K; j++) {
					ans[i][j] = line[0][j];
				}
				continue;
			}
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < K; k++) {
					// 시작위치값 + 이동값 + 도착위치값
					if(ans[i-1][k] + time[i-1][k][j] + line[i][j]  < ans[i][j]) {
						ans[i][j] = ans[i-1][k] + time[i-1][k][j] + line[i][j];
					}
				}
			}
			
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++) {
			answer = Math.min(answer, ans[N-1][i]);
		}
		
		System.out.println(answer);
		

	}

}
