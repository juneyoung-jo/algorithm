package softeer;

import java.util.Arrays;

public class BinarySearch {
	static int arr[] = { 3, 9, 4, 7, 0, 5, 1, 6, 8, 2 };
	public static void main(String[] args) {

		// 정렬
		Arrays.sort(arr);

		int m = 8;
		// 이분탐색
		int start = 0;
		int end = arr[arr.length - 1];
		int ans = -1;

		while (start <= end) {
			int mid = (start + end) / 2; // 중간값 logN

			if (search(mid, m)) {
				end = mid - 1;
				ans = mid;
			} else {
				start = mid + 1;
			}

		}
		
		if(ans == -1) System.out.println("없음.");
		else System.out.println("index : " + ans +", 값 : " + arr[ans]);

	}

	private static boolean search(int mid, int m) {
		return arr[mid] >= m;
	}

}
