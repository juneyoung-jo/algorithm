package baekjoon;

import java.util.*;
import java.io.*;

public class 차이를최소로_3090 {
	static int N, T, arr[], comp[], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		ans = -1; // 초기화
		arr = new int[N];
		int min = 0;
		int max = 0;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i])
				max = arr[i];
		}

		// 이분 탐색
		while (min <= max) {
			int mid = (min + max) / 2;
			comp = arr.clone();
			if (search(mid)) {
				max = mid - 1;
				ans = mid;
			} else {
				min = mid + 1;
			}

		}
		
		comp = arr.clone();
		search(ans);
		
		for(int i = 0; i < comp.length; i++) {
			sb.append(comp[i]+" ");
		}
		System.out.println(sb.toString());
		

	}


	private static boolean search(int mid) {
		long count = 0; // 조심하자.. 

		// 오른쪽으로 진행
		for (int i = 1; i < comp.length; i++) {
			if (comp[i - 1] < comp[i] && comp[i] - comp[i - 1] > mid) {
				comp[i] = comp[i - 1] + mid;
				count += (arr[i] - comp[i]);
			}
		}

		// 왼쪽으로 진행
		for (int i = comp.length - 1; i >= 1; i--) {
			if (comp[i - 1] > comp[i] && comp[i - 1] - comp[i] > mid) {
				int tmp = comp[i - 1];
				comp[i - 1] = comp[i] + mid;
				count += (tmp - comp[i - 1]);
			}
		}
		
		return count <= T;
	}

}
