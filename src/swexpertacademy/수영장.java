package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {
	static int T, cost[], arr[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			cost = new int[4];
			arr = new int[12];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			cal(0, 0);
			System.out.printf("#%d %d\n", tc, ans > cost[3] ? cost[3] : ans);

		}

	}

	private static void cal(int idx, int sum) {
		if (idx >= 12) {
			ans = Math.min(ans, sum);
			return;
		}
		if(sum > ans) return;

		cal(idx + 1, sum + cost[0] * arr[idx]);
		cal(idx + 1, sum + cost[1]);
		cal(idx + 3, sum + cost[2]);

	}

}
