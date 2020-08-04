package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	static int N, P[], ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		P = new int[N];

		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}

		// 알고리즘
		// 걸리는 시간이 적은 순서로 정렬한 후 더해주면 정답임.
		Arrays.sort(P); // 배열을 작은순으로 정렬해야함.

		// 2중 포문으로 현재값 + 0번부터 현재의 전까지 합.
		for (int i = 0; i < P.length; i++) {
			ans += P[i];
			for (int j = 0; j < i; j++) {
				ans += P[j];
			}
		}

		System.out.println(ans);

	}

}
