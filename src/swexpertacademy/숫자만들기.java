package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static int T, N, number[], operator[], oper[], min, max, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			min = Integer.MAX_VALUE;
			max = -100000001;

			N = Integer.parseInt(br.readLine());
			number = new int[N];
			oper = new int[N - 1];
			operator = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			Permutation(0);
			System.out.printf("#%d %d\n", tc, max - min);

		}

	}

	private static void Permutation(int idx) {
		if (idx == N - 1) {
			int cal = number[0];
			int[] arr = new int[4];

			for (int i = 0; i < oper.length; i++) {
				arr[oper[i]] += 1;
			}

			if (!Arrays.equals(arr, operator))
				return;

			for (int i = 0; i < oper.length; i++) {
				switch (oper[i]) {
				case 0:
					cal += number[i + 1];
					break;
				case 1:
					cal -= number[i + 1];
					break;
				case 2:
					cal *= number[i + 1];
					break;
				case 3:
					cal /= number[i + 1];
					break;
				}
			}

			min = Math.min(min, cal);
			max = Math.max(max, cal);
			return;
		}

		for (int i = 0; i < 4; i++) {
			oper[idx] = i;
			Permutation(idx + 1);
		}

	}

}
