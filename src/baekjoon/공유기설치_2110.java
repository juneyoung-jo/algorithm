package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {

	static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int left = 1;
		int right = arr[N - 1] - arr[0];
		int dist = 0;

		// 알고리즘
		while (left <= right) {
			int mid = (left + right) / 2;
			int start = arr[0];
			int cnt = 1;

			for (int i = 1; i < N; i++) {
				dist = arr[i] - start;
				if (mid <= dist) {
					++cnt;
					start = arr[i];
				}
			}

			if (cnt >= C) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);

	}
}
