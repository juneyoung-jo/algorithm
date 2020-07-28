package swexpertacademy;

import java.util.Scanner;

public class 농작물수확하기 {
	static int T, N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int num = N / 2;
			int ans = 0;
			
			//알고리즘 구현부
			for (int i = 0; i < N; i++) { //i : 0~N
				for (int j = Math.abs(i - num); j < N - Math.abs(i - num); j++) { 
					//j : 2 1 0 1 2, 기준 : 3 4 5 4 3, j_for문 횟수 1번 3번 5번 3번 1번 
					ans += map[i][j];
				}
			}

			System.out.println("#" + tc + " " + ans);
		}

		sc.close();
	}

}
