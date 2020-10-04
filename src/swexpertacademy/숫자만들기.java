package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static int T, N, number[], oper[], min = Integer.MAX_VALUE, max, ans, count;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			number = new int[N];
			oper = new int[N - 1];
			list = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					list.add(i);
				}
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			Permutation(0, new boolean[N - 1]);
			System.out.printf("#%d %d\n", tc, ans);

			ans = 0;
			min = Integer.MAX_VALUE;
			max = 0;

			System.out.println(count);
		}

	}

	private static void Permutation(int idx, boolean[] v) {
		if (idx == N - 1) {
			count++;
			int cal = number[0];
			for (int i = 1; i < N; i++) {
				int n = list.get(oper[i - 1]);
				switch (n) {
				case 0:
					cal += number[i];
					break;
				case 1:
					cal -= number[i];
					break;
				case 2:
					cal *= number[i];
					break;
				case 3:
					cal /= number[i];
					break;
				}
			}

			min = Math.min(min, cal);
			max = Math.max(max, cal);

			ans = Math.abs(max - min);

			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (v[i])
				continue;
			v[i] = true;
			oper[idx] = i;
			Permutation(idx + 1, v);
			v[i] = false;
		}

	}

}
