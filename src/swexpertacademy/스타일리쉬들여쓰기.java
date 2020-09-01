package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타일리쉬들여쓰기 {
	static int T, p, q, R, C, S;
	static char[][] mstMap, mMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			mstMap = new char[p][];
			mMap = new char[q][];

			for (int i = 0; i < mstMap.length; i++) {
				mstMap[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < mMap.length; i++) {
				mMap[i] = br.readLine().toCharArray();
			}

			// 알고리즘
			// RCS를 먼저 구해야 함.
			calRCS();

			int[] Ans = new int[q];
			int[][] arr = new int[3][2];
			for (int i = 0; i < mMap.length; i++) {
				int a = arr[0][0], b = arr[0][1], c = arr[1][0], d = arr[1][1], e = arr[2][0], f = arr[2][1];
				Ans[i] = R * (a - b) + C * (c - d) + S * (e - f);
				for (int j = 0; j < mMap[i].length; j++) {

					if (mMap[i][j] == '(')
						arr[0][0]++;
					if (mMap[i][j] == ')')
						arr[0][1]++;
					if (mMap[i][j] == '{')
						arr[1][0]++;
					if (mMap[i][j] == '}')
						arr[1][1]++;
					if (mMap[i][j] == '[')
						arr[2][0]++;
					if (mMap[i][j] == ']')
						arr[2][1]++;
				}

			}

//			System.out.println(Arrays.toString(Ans));
//			System.out.println(R + " " + C + " " + S + " ");
			System.out.printf("#%d %d", tc, 0);
			for (int i = 1; i < Ans.length; i++) {
				System.out.print(" " + Ans[i]);
			}
			System.out.println();
			R = 0;
			C = 0;
			S = 0;
//		print(mstMap);
		}

	}

	private static void calRCS() {
		int[][] arr = new int[3][2];
		for (int r = 0; r < mstMap.length; r++) {
			for (int c = 0; c < mstMap[r].length; c++) {
				if (mstMap[r][c] == '(')
					arr[0][0]++;
				if (mstMap[r][c] == ')')
					arr[0][1]++;
				if (mstMap[r][c] == '{')
					arr[1][0]++;
				if (mstMap[r][c] == '}')
					arr[1][1]++;
				if (mstMap[r][c] == '[')
					arr[2][0]++;
				if (mstMap[r][c] == ']')
					arr[2][1]++;
			}
			int a = arr[0][0], b = arr[0][1], c = arr[1][0], d = arr[1][1], e = arr[2][0], f = arr[2][1];
			// arr배열
			if (R == 0 || C == 0 || S == 0) {
				for (int i = 0; i < 3; i++) {
					if (arr[i][0] - arr[i][1] == 1) {
						int cnt = 0;
						for (int j = 0; j < mstMap[r + 1].length; j++) {
							if (mstMap[r + 1][j] != '.')
								break;
							if (mstMap[r + 1][j] == '.') {
								cnt++;
							}
						}

						if (i == 0 && R == 0) {
							R = (cnt - C * (c - d) - S * (e - f)) / (a - b);
						} else if (i == 1 && C == 0) {
							C = cnt - R * (a - b) - S * (e - f) / (c - d);
						} else if (i == 2 && S == 0) {
							S = cnt - C * (c - d) - R * (a - b) / (e - f);
						}

					}
				}
			}

		}
	}

	private static void print(char[][] mstMap) {
		for (int i = 0; i < mstMap.length; i++) {
			for (int j = 0; j < mstMap[i].length; j++) {
				System.out.print(mstMap[i][j] + " ");
			}
			System.out.println();
		}
	}

}
