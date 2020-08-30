package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 최대상금 {
	static int T, N;
	static Integer[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			N = sc.nextInt();

			arr = new Integer[str.length()];
			// 값 담기
			Integer[] comp = new Integer[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
				comp[i] = str.charAt(i) - '0';
			}

			// 역순 정렬 (가장 큰 숫자만들기)
			Arrays.sort(comp, (a, b) -> b - a);

			// n번 횟수만큼
			while (N > 0) {
				if (Arrays.deepEquals(arr, comp)) {
					break;
				}

				L: for (int i = 0; i < arr.length; i++) {
					if (arr[i] != comp[i]) {
						for (int j = arr.length - 1; j >= 0; j--) {
							if (comp[i] == arr[j]) {
								if (i != 0 && comp[i] == comp[i - 1])
									N++;
								int tmp = arr[i];
								arr[i] = arr[j];
								arr[j] = tmp;
								break L;
							}
						}
					}
				}

				N--;
			}

			L: while (N-- % 2 == 1) {
				for (int i = 1; i < arr.length; i++) {
					if (arr[i] == arr[i - 1]) {
						break L;
					}
				}

				int tmp = arr[arr.length - 2];
				arr[arr.length - 2] = arr[arr.length - 1];
				arr[arr.length - 1] = tmp;

			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();

		}

	}
}
