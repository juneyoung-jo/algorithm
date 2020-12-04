package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄스터 {
	static int N, X, M, arr[][], ans[], max, ansArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[M][3];
			ans = new int[N];
			ansArr = new int[N];
			max = -1;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
			}

			cal(0);
			System.out.printf("#%d", tc);
			if (max == -1)
				System.out.println(" -1");
			else {
				for (int i = 0; i < ansArr.length; i++) {
					System.out.print(" " + ansArr[i]);
				}
				System.out.println();
			}

		}

	}

	private static void cal(int idx) {
		if (idx == N) {
			check();
			return;
		}

		for (int j = 0; j <= X; j++) {
			ans[idx] = j;
			cal(idx + 1);
		}

	}

	private static void check() {
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = arr[i][0] - 1; j < arr[i][1]; j++) {
				sum += ans[j];
			}
			if (sum != arr[i][2])
				return;
		}

		int total = 0;
		for (int i = 0; i < ans.length; i++) {
			total += ans[i];
		}

		if (max < total) {
			max = total;
			for (int i = 0; i < ansArr.length; i++) {
				ansArr[i] = ans[i];
			}
		}
	}

}
