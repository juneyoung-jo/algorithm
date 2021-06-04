package baekjoon;

import java.util.Scanner;

public class 최대공약수와최소공배수_2609 {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int gcd = GCD();
		System.out.println(gcd);
		System.out.println(N*M/gcd);
		
	}
	
	private static int GCD() {
		int a = N; 
		int b = M;
		
		int tmp = -1;
		while(b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}

}
