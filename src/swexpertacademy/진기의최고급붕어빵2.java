package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진기의최고급붕어빵2 {
	static int T, N, M, K, arr[], num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			num = new int[11112];
			int begin = 0;

			for (int i = M; i <= 11111; i++) {
				if (i >= 1 && begin + M == i) {
					num[i] = num[i - 1] + K;
					begin = i;
					continue;
				}
				num[i] = num[i - 1];
			}

			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) { // N명 들어옴 사람
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			boolean isOk = false;
			for (int i = 0; i < N; i++) {
				for (int j = arr[i]; j < 11112; j++) {
					if (num[j] >= 1)
						num[j]--;
					else {
						System.out.printf("#%d Impossible\n", tc);
						isOk = true;
						break;
					}

				}
				if (isOk) {
					break;
				}
			}

			if (!isOk) {
				System.out.printf("#%d Possible\n", tc);
			}

		}

	}

}
