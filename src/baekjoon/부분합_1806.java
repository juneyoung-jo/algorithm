package baekjoon;

import java.util.*;
import java.io.*;

public class 부분합_1806 {

	static int N, S, arr[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		int start = 0;
		for(Integer a : arr) {
			sum+=a;
			cnt += 1;
			if(sum >= S) {
				if(ans > cnt) ans = cnt;
				
				while(true) {
					sum-=arr[start++];
					if(sum < S) {
						cnt--;
						break;
					}else {
						cnt--;
						if(ans > cnt) ans = cnt;
					}
				}
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0:ans);
		
	}

}
