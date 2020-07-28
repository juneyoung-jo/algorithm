package swexpertacademy;

import java.util.Scanner;

public class 원재의메모리복구 {
	static int T;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			arr = new int[str.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i) - '0';
			}

			int ans = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				if (i == 0) {
					if (arr[i] == 1) {
						ans++;
					}
				}
				if (arr[i] != arr[i + 1]) {
					ans++;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);

		}
		sc.close();
	}
}
