package baekjoon;

import java.util.Scanner;

public class 영식이와친구들 {
	static int N, M, L;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();

		arr = new int[N];

		boolean isok = true;
		// 알고리즘 구현부
		arr[0] = 1; // 1번부터 시작이니까 1번 받음
		int index = 0;
		int ans = 0;
		while (isok) {
			ans++;
			if (arr[index] % 2 == 1) { // 여기부터 짜면됨 짝홀비교 & 공 던지고 따라가기 & 값증가
				index += L;
				index = Math.abs(index) % N;
				arr[index]++;
			} else {
				index = N + index - L;
				index = Math.abs(index) % N;
				arr[index]++;
			}

			for (int i = 0; i < arr.length; i++) { // arr를 돌아서 M과 숫자가 같은경우 찾아서 루프 종료

				if (arr[i] == M) {
					isok = false;
					break;
				}

			}
		}

		System.out.println(ans);

		sc.close();
	}

}
