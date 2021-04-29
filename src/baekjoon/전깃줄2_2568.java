package baekjoon;

import java.util.*;
import java.io.*;

public class 전깃줄2_2568 {
	static int N;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int[] idx = new int[N];
		int[] LIS = new int[N];
		int[] index = new int[500002];
		int[] cost = new int[500002];
		int[] v = new int[500002];
 

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			idx[i] = s;
			index[e] = s;
			cost[s] = e; 
		}

		Arrays.sort(idx); // A전봇대 기준 정렬 후 LIS를 구하면 됨.
		
		Arrays.fill(v, -1);

		int size = 0; // LIS 크기
		for (int i = 0; i < N; i++) {
			int tmp = Arrays.binarySearch(LIS, 0, size, cost[idx[i]]); //이분탐색
			if (tmp >= 0) continue;
			tmp = Math.abs(tmp) - 1;
			
			// 바꿔치기할 내용 바로 앞의 값을 저장해야 함. 추적하기 위해 ( A전봇대로 알아두면 편함 )
			if (tmp == 0) v[idx[i]] = 0;
			else v[idx[i]] = index[LIS[tmp-1]]; 
			
			LIS[tmp] = cost[idx[i]];

			if (tmp == size) {
				++size;
			}

		}
		
		int start = index[LIS[size-1]];
		int s = size;
		
		// 교차하지 않게 하기위해선 가장 긴 증가하는 부분수열값 제거해야 함. 
		while(s-->0) {
			int tmp = start;
			start = v[start];
			v[tmp] = -1;
		}
		v[index[LIS[size-1]]] = -1;
		
		// A전봇대 순이기 때문에 정렬이 됨.
		for(int i = 0; i < v.length; i++) {
			if(v[i] != -1) sb.append(i+"\n");
		}

		System.out.println(N - size);
		System.out.println(sb);

	}

}
