package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 블랙잭 {
	static int N, M;
	static int[] arr, numbers;
	static int max, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		//알고리즘 
		numbers = new int[3]; //3장의 카드를 뽑는다.
		combination(0, 0); //조합
		System.out.println(ans);
		ans=0;

	}

	private static void combination(int idx, int start) {
		if (idx == 3) {
			max = 0;
			for (int i = 0; i < numbers.length; i++) {
				max += numbers[i];
			}
			if (M - max >= 0) { // 나온 경우의 수 합을 구한 후 큰값을 저장
				ans = Math.max(ans, max);
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			numbers[idx] = arr[i];
			combination(idx + 1, i + 1);
		}

	}

}
