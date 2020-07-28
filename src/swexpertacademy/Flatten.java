package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	static int T = 10;
	static int[] arr = new int[100];
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) { // 더하고 뺀다음 정렬해야함.
				Arrays.sort(arr);
				++arr[0];
				--arr[99];
				Arrays.sort(arr);
			}

			min = arr[99] - arr[0];

			System.out.printf("#%d %d\n", tc, min);
		}
		sc.close();
	}

}
