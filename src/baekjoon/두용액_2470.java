package baekjoon;

import java.util.*;
import java.io.*;

public class 두용액_2470 {
	static int N;
	static Integer arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(o1,o2) -> Math.abs(o1)-Math.abs(o2));
		
		int min = Integer.MAX_VALUE;
		int x = 0;
		int y = 0;
		for(int i = 1; i< N; i++) {
			if(Math.abs(arr[i-1]+arr[i]) < min) {
				min = Math.abs(arr[i-1]+arr[i]);
				x = arr[i-1];
				y = arr[i];
			}
		}
		
		System.out.println(y>x ? x + " " + y : y + " " + x); 

	}

}
