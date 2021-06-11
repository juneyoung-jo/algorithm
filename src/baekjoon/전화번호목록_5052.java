package baekjoon;

import java.util.*;
import java.io.*;

public class 전화번호목록_5052 {

	static int t, n;
	static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();
			}

			Arrays.sort(arr);

			if (cal()) {
				sb.append("NO\n");
			} else {
				sb.append("YES\n");
			}
		}
		
		System.out.println(sb);

	}

	private static boolean cal() {

		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1].startsWith(arr[i]))
				return true;
		}

		return false;

	}

}
