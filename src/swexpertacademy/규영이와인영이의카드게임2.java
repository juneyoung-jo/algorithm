package swexpertacademy;

import java.util.Scanner;

public class 규영이와인영이의카드게임2 {
	static int T, A[], B[], win, lose;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			A = new int[9]; // 규영이
			B = new int[9]; // 인영이
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
			Permutation(0, 0, 0);
			System.out.printf("#%d %d %d\n", tc, win, lose);

		}

	}

	private static void Permutation(int idx, int ku, int in) {
		if (idx == 9) {
			if (ku > in) win++;
			else lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (v[i]) continue;
			v[i] = true;
			Permutation(idx + 1, A[idx] >B[i] ? A[idx] + B[i]+ku : 0+ku, A[idx] < B[i] ? A[idx] + B[i] + in : 0 + in);
			v[i] = false;
		}

	}

}
