package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 퇴사_14051 {
	static int N, t[],p[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		p = new int[N+1];
		t = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(dp));
		
		
		
		
		
	}

}
