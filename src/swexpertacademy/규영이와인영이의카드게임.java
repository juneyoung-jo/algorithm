package swexpertacademy;

import java.util.Scanner;

public class 규영이와인영이의카드게임 {
	static int T, A[], B[], arr[], win, lose;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			A = new int[9]; // 규영이
			B = new int[9]; // 인영이
			arr = new int[9];
			v = new boolean[9];
			win = 0;
			lose = 0;
			for (int i = 0; i < 9; i++) {
				A[i] = sc.nextInt();
			}

			int index = 0;
			L: for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < 9; j++) {
					if (i == A[j])
						continue L;
				}
				B[index++] = i;
			}

			// 구현
			Permutation(0);
			System.out.printf("#%d %d %d\n", tc, win, lose);

		}

	}

	private static void Permutation(int idx) {
		if (idx == 9) {
			int a = 0; // 규영
			int b = 0; // 인영

			for (int i = 0; i < 9; i++) {
				if (A[i] > arr[i]) {
					a += A[i] + arr[i];
				} else {
					b += A[i] + arr[i];
				}
			}

			if (a == b)
				return;
			if (a > b) {
				win++;
			} else {
				lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (v[i])
				continue;
			v[i] = true;
			arr[idx] = B[i];
			Permutation(idx + 1);
			v[i] = false;
		}

	}

}
