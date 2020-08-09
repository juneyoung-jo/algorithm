package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class view {
	static int T = 10;
	static int N, arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int Ans = 0;
			int max = 0;
			for (int i = 2; i < arr.length - 2; i++) {
				int left = Math.max(arr[i - 2], arr[i - 1]);
				int right = Math.max(arr[i + 2], arr[i + 1]);
				max = Math.max(left, right);
				if (arr[i] > max) {
					Ans += (arr[i] - max);
				}
			}

			System.out.printf("#%d %d\n", tc, Ans);

		}

	}

}
