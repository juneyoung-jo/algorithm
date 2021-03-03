package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기_1759 {
	static int L, C;
	static char arr[], ans[];
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		ans = new char[L];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		// 알고리즘
		Arrays.sort(arr);

		cal(0, 0);
		System.out.println(sb.substring(0, sb.length() - 1));

	}

	private static void cal(int idx, int start) {
		if (idx == L) {

			check();

			return;
		}

		for (int i = start; i < C; i++) {
			ans[idx] = arr[i];
			cal(idx + 1, i + 1);
		}

	}

	private static void check() {
		int c = 0, v = 0;
		String str = "";
		for (int i = 0; i < L; i++) {
			if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u') {
				c++;
			} else {
				v++;
			}
			str += ans[i];
		}

		if (c < 1 || v < 2)
			return;
		sb.append(str + "\n");
	}

}
