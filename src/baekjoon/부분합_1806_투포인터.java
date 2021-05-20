package baekjoon;

import java.util.*;
import java.io.*;

public class 부분합_1806_투포인터 {

	static int N, S, arr[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int start = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum < S) continue;
			if (ans > i - start + 1) ans = i - start + 1;
			sum -= arr[start];
			sum -= arr[i];
			start++;
			i--;
		}

		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);

	}

}
