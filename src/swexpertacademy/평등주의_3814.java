package swexpertacademy;

import java.util.Scanner;

public class 평등주의_3814 {

	static int N, K, arr[], comp[], min, max, left, right;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			min = 100000000;
			max = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] < min) min = arr[i];
				if (max < arr[i]) max = arr[i];
			}

			left = 0;
			right = max;
			int mid = 0;
			int ans = 0;
			while (left <= right) {
				mid = (left + right) / 2;
				comp = arr.clone();
				if (search(mid)) {
					right = mid - 1;
					ans = mid;
				} else {
					left = mid + 1;
				}
			}

			System.out.printf("#%d %d\n", test_case, ans);
		}
	}

	public static boolean search(int mid) {
		int count = 0;
		for (int i = 1; i < N; i++) {
			if (comp[i - 1] < arr[i] && arr[i] - comp[i - 1] > mid) {
				comp[i] = comp[i - 1] + mid;
				count += (arr[i] - comp[i]);
			}
		}

		for (int i = N - 1; i > 0; i--) {
			if (comp[i - 1] > comp[i] && comp[i - 1] - comp[i] > mid) {
				int tmp = comp[i - 1];
				comp[i - 1] = comp[i] + mid;
				count += (tmp - comp[i - 1]);
			}
		}

		if (count <= K) return true;
		else return false;
	}

}
