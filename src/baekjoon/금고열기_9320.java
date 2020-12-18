package baekjoon;

import java.util.*;
import java.io.*;

public class 금고열기_9320 {

	static int arr[];
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr = new int[4];
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			v = new boolean[4];
			// 알고리즘
			Permutation(0);

		}

	}

	private static void Permutation(int idx) {
		if(idx == 4) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(v[i]) continue;
			v[i] = true;
		}
		
		
	}

}
