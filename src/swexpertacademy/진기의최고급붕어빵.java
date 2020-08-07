package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진기의최고급붕어빵 {
	static int T, N, M, K, arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) { // N명 들어옴 사람
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			boolean isok = false;
			for (int i = 1; i <= N; i++) {
				if ((arr[i] / M) * K - i < 0) {
					System.out.printf("#%d Impossible\n", tc);
					break;
				}

				if (i == N) {
					isok = true;
				}

			}
			if (isok) {
				System.out.printf("#%d Possible\n", tc);
			}

		}

	}

}
