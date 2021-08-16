package baekjoon;

import java.io.*;
import java.util.*;

public class 키순서_2458 {
	static int N, M, ans, arr[];
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		v = new boolean[N + 1][N + 1];
		arr = new int[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			v[end][start] = true;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i != j && v[i][k] && v[k][j]) v[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(v[i][j]) {
					arr[i]++;
					arr[j]++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(arr[i] == N-1) ans++;
		}

		System.out.println(ans);
	}

}
