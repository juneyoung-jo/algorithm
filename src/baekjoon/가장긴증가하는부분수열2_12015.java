package baekjoon;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열2_12015 {
	static int N, arr[], LIS[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		LIS = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Arrays.binarySearch(LIS, 0, size, arr[i]);

			if (tmp >= 0)
				continue;
			tmp = Math.abs(tmp) - 1;
			LIS[tmp] = arr[i];

			if (tmp == size) {
				++size;
			}
		}

		System.out.println(size);

	}

}
