package baekjoon;

import java.util.Scanner;

public class 비밀이메일 {
	static String str;
	static int r, c;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.next();
		int num = str.length();

		// 알고리즘 : r과 c를 구하는 문제
		int sq = (int) Math.sqrt(num); // r <= c , r*c = N -> 제곱근을 구해야함.
		arr = new char[num];
		r = 0;
		c = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}

		for (int i = 1; i <= sq; i++) { // r구하기
			if (num % i == 0) {
				r = Math.max(r, i);
			}
		}

		c = num / r; // c구하기

		char[][] ans = new char[r][c];
		int idx = 0;
		for (int i = 0; i < c; i++) {// 저장
			for (int j = 0; j < r; j++) {
				ans[j][i] = arr[idx++];
			}
		}

		for (int i = 0; i < r; i++) { // 출력
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
			}
		}

	}

}
