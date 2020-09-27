package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 최장증가부분수열_dp2 {
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

			int size = 0;
			for (int i = 0; i < N; i++) {
				int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
				temp = Math.abs(temp) - 1;
				LIS[temp] = arr[i];

				if (size == temp) {
					size++;
				}
			}

			System.out.printf("#%d %d\n", tc, size);

		}

	}

}
