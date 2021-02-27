package baekjoon;

import java.util.*;
import java.io.*;

public class 컨베이어벨트_20055 {

	static int N, K, uArr[], dArr[], ans;
	static boolean[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		uArr = new int[N];
		v = new boolean[N];
		dArr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			uArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			dArr[i] = Integer.parseInt(st.nextToken());
		}

		cal();

		System.out.println(ans);

	}

	private static void cal() {

		while (true) {
			ans++;
			moveC();
			moveR();
			if (uArr[0] > 0) {
				uArr[0]--;
				v[0] = true;
			}

			if (check())
				return;

		}

	}

	private static void moveR() {

		v[N - 1] = false;
		for (int i = N - 2; i >= 0; i--) {
			if (v[i]) {
				if (uArr[i + 1] > 0 && !v[i + 1]) {
					v[i] = false;
					v[i + 1] = true;
					uArr[i + 1]--;
				}
			}
		}

	}

	private static void moveC() {
		int uTmp = uArr[N - 1];
		int dTmp = dArr[0];

		// 위
		for (int i = N - 2; i >= 0; i--) {
			uArr[i + 1] = uArr[i];
			v[i + 1] = v[i];
		}

		uArr[0] = dTmp;
		v[0] = false;

		// 아래
		for (int i = 1; i < N; i++) {
			dArr[i - 1] = dArr[i];
		}

		dArr[N - 1] = uTmp;

	}

	private static boolean check() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (uArr[i] == 0)
				cnt++;
			if (dArr[i] == 0)
				cnt++;
		}

		if (cnt >= K)
			return true;

		return false;
	}

}
