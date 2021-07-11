package baekjoon;

import java.io.*;
import java.util.*;

public class 컬러볼_10800 {
	static int N, sizeArr[];
	static Point[] arr;
	static int[] colorArr = new int[200001];

	static class Point implements Comparable<Point> {
		int idx, color, size;

		public Point(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.size == o.size) return this.color - o.color;
			return this.size - o.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		sizeArr = new int[2001]; 

		arr = new Point[N];	
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			arr[i] = new Point(i,color,size);
			
		}
		
		Arrays.sort(arr);
		 
		int sum = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			int idx = arr[i].idx;
			int color = arr[i].color;
			int size = arr[i].size;
			
			sum += size;
			colorArr[color] += size;
			sizeArr[size] += size;
			
			if(i > 0 && arr[i-1].color == color && arr[i-1].size == size) dp[idx] = dp[arr[i-1].idx];
			else dp[idx] = sum - sizeArr[size] - colorArr[color]  + size;
			
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(dp[i]+"\n");
		}
		
		System.out.println(sb);
		
	}

}
