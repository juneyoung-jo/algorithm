package swexpertacademy;

import java.util.Scanner;

public class 백만장자프로젝트 {
	static int T, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int num = arr[arr.length - 1];
			long sum = 0;
			if (N == 1) {
				System.out.printf("#%d %d\n", tc, sum);
				continue;
			}
			for (int i = arr.length - 2; i >= 0; i--) {
				if (num <= arr[i]) {
					num = arr[i];
					continue;
				} else {
					sum += num - arr[i];
				}

			}

			System.out.printf("#%d %d\n", tc, sum);
		}
	}

}