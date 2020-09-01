package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드뒤집기 {
	static int T;
	static long Ans;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			arr = str.toCharArray();

			// 알고리즘
			// 최대 20만까지인 배열.
			// 정렬하는 문제
			// W~B순으로 정렬하면 되니까 맨 뒤의 B부터 정렬할 횟수를 구함.
			// long타입 Ans << 중요
			int start = 1;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] == 'B') {
					Ans += (arr.length - start++ - i);
				}
			}

			System.out.printf("#%d %d\n", tc, Ans);
			Ans = 0;
		}
	}

}
