package baekjoon;

import java.io.*;
import java.util.*;

public class 부분수열의합_14225 {

	static int N, arr[], ans;
	static boolean[] v;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		v = new boolean[N];
		check = new boolean[2000001];
		arr = new int[N];
		ans = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		cal(0);
		
		for (int i = 1; i <= 2000000; i++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}

	}

	private static void cal(int idx) {
		if (idx == N) {
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if(v[i]) cnt+=arr[i];
			}
			
			check[cnt] = true;
			
			return;
		}

		v[idx] = true;
		cal(idx + 1);
		v[idx] = false;
		cal(idx + 1);

	}

}
