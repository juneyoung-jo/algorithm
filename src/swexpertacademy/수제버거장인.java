package swexpertacademy;

import java.util.Scanner;

public class 수제버거장인 {
	static int T, N, M, arr[][], ans;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();

			v = new boolean[N + 1];
			arr = new int[M][2];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

//			print(arr);

			powerSet(1);
			System.out.printf("#%d %d\n",tc,ans);
			ans = 0;

		}
	}

	private static void powerSet(int idx) {
		if (idx == N + 1) {

//			for (int i = 1; i <= N; i++) {
//				if(v[i]) System.out.print(i + " ");
//			}
//			System.out.println();

			for (int i = 0; i < arr.length; i++) {
				if (v[arr[i][0]] && v[arr[i][1]]) {
					return;
				}
			}
			ans++;
			return;
		}

		v[idx] = true;
		powerSet(idx + 1);
		v[idx] = false;
		powerSet(idx + 1);

	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
