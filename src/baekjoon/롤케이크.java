package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 롤케이크 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			arr[i] = n;
		}

		Arrays.sort(arr); // 정렬
		int count = 0;

		// 10의 배수먼저 자르기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 10) {
				count++;
				continue;
			}
			while (M > 0 && arr[i] % 10 == 0) {
				arr[i] -= 10;
				count++;
				M -= 1;
				if (arr[i] == 10) {
					count++;
					break;
				}
			}

		}
		
		
		//10배수 아닌거 짜르기
		if (M > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 10 || arr[i] % 10 == 0) {
					continue;
				}
				while (arr[i] > 10 && M > 0) {
					arr[i] -= 10;
					count++;
					M -= 1;
				}
				if (M < 0) {
					break;
				}

			}

		}

		System.out.println(count);

	}
}
