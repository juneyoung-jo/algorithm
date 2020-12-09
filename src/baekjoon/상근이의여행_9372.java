package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근이의여행_9372 {
	static int T, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int start, end;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
			}

			System.out.println(N - 1);

		}

	}


}
