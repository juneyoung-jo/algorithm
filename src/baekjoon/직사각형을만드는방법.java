package baekjoon;

import java.util.Scanner;

public class 직사각형을만드는방법 {
	static int n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		// 알고리즘
		//제곱근을 구해서 n보다 작은 사각형을 구하면 됨.
		//i는 1부터 돌리고 j는 i부터 돌려서 중복제거
		int mid = (int) Math.sqrt(n); // 제곱근을 구함. 그 이상은 필요없음.

		for (int i = 1; i <= mid; i++) { // i가 제곱근까지
			for (int j = i; j <= n; j++) { // j는 n까지
				if (i * j <= n) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

}
