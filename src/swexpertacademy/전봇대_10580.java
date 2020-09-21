package swexpertacademy;

import java.util.Scanner;

public class 전봇대_10580 { // 다시 풀어보기
	static int T, N, arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int Ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if ((arr[i][0] - arr[j][0]) * (arr[i][1] - arr[j][1]) < 0)
						Ans++;
				}
			}

			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

}
