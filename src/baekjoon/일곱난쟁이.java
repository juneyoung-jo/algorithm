package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {
	static int[] arr = new int[9];
	static int[] numbers = new int[7];
	static int max = 100, sum, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		permutation(0, 0);

	}

	private static void permutation(int idx, int start) {
		if (idx == numbers.length) {
			sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			if (max - sum == 0) {
				Arrays.sort(numbers);
				for (int i = 0; i < numbers.length; i++) {
					System.out.println(numbers[i]);
				}

			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			numbers[idx] = arr[i];
			permutation(idx + 1, i + 1);
		}

	}

}
