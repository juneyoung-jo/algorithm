package baekjoon;
import java.util.*;
import java.io.*;


public class 연속합_1912 {
	static int N, arr[],ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[0] = arr[0];
		ans = dp[0];
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1], 0) + arr[i];
			if(ans < dp[i]) ans = dp[i];
		}
		
		System.out.println(ans);
	}

}
