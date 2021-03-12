package baekjoon;

import java.util.*;
import java.io.*;

public class 동전0_11047 {

	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		int start = N-1;
		while(true) {
			if(K == 0) break;
			if(K >= arr[start]) {
				ans += K/arr[start];
				K = K%arr[start];
			}
			start--;
		}
		
		System.out.println(ans);
	}

}
