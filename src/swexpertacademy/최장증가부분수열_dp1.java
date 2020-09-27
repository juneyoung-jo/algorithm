package swexpertacademy;

import java.util.Scanner;

public class 최장증가부분수열_dp1 {
	static int T, N, arr[], LIS[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			arr = new int[N];
			LIS = new int[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}

				max = Math.max(LIS[i], max);

			}
			
			System.out.printf("#%d %d\n",tc,max);

		}

	}

}
