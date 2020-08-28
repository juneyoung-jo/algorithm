package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;


public class 최대상금 {
	static int T, arr[], N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			N = sc.nextInt();

			arr = new int[str.length()];
			// 값 담기
			Integer[] comp = new Integer[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
				comp[i] = str.charAt(i) - '0';
			}
			int num = Integer.parseInt(str);

			// 역순 정렬 (가장 큰 숫자만들기)
			Arrays.sort(comp, (a, b) -> {
				return b - a;
			});
			for (int comps : comp) {
				sb.append(comps);
			}
			int max = Integer.parseInt(sb.toString());

			// n번 횟수만큼
			int start = 0;
			while (N-- > 0) {
				if (num == max) {
					break;
				}


			}

			System.out.println(Arrays.toString(arr) + " " + N);

		}

	}
}
