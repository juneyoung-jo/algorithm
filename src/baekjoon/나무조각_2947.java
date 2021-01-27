package baekjoon;

import java.util.*;
import java.io.*;

public class 나무조각_2947 {
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			if (arr[0] > arr[1]) {
				swich(0, 1);
				for (Integer i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			if (arr[1] > arr[2]) {
				swich(1, 2);
				for (Integer i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			if (arr[2] > arr[3]) {
				swich(2, 3);
				for (Integer i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			if (arr[3] > arr[4]) {
				swich(3, 4);
				for (Integer i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}

			if (check(arr)) {
				break;
			}
		}

	}

	private static void swich(int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	private static boolean check(int[] v) {
		int index = 1;
		for (int i = 0; i < 5; i++) {
			if (index++ != v[i])
				return false;

		}
		return true;
	}

}
