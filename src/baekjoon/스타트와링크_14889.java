package baekjoon;

import java.util.*;
import java.io.*;

public class 스타트와링크_14889 {
	static int N, map[][],arr[],narr[],start[],link[],sumS,sumL,ans;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new boolean[N];
		arr = new int[N/2];
		narr = new int[N/2];
		start = new int[2];
		link = new int[2];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cal(0,0);
		System.out.println(ans);
//		print(map);

	}

	private static void cal(int idx, int start) {
		if(idx == N/2) {
//			System.out.println(Arrays.toString(arr));
			go();
			return;
		}
		
		for (int i = start; i < N; i++) {
			arr[idx] = i;
			cal(idx+1, i+1);
		}
		
	}

	private static void go() {
		int st = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(st < arr.length && i == arr[st]) {
				st++;
			}else {
				narr[idx++] = i;
			}
		}
		sumS = 0;
		Combination(0,0,arr);
		sumL = 0;
		CombinationL(0,0,narr);
		
		int num = Math.abs(sumL-sumS);
		if(ans > num) ans = num;		
	}

	private static void CombinationL(int idx, int st, int[] list) {
		if(idx == 2) {
			sumL += map[start[0]][start[1]];
			sumL += map[start[1]][start[0]];
			return;
		}
		
		for (int i = st; i < list.length; i++) {
			start[idx] = list[i];
			CombinationL(idx+1,i+1,list);
		}
	}

	private static void Combination(int idx, int st, int[] list) {
		if(idx == 2) {
			sumS += map[start[0]][start[1]];
			sumS += map[start[1]][start[0]];
			return;
		}
		
		for (int i = st; i < list.length; i++) {
			start[idx] = list[i];
			Combination(idx+1,i+1,list);
		}
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
