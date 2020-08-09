package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사 {
	static int T, N, S[][], cnt, arr[], Ans = 20001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			cnt = N / 2;
			arr = new int[cnt];
			combination(0, 0);

			System.out.printf("#%d %d\n",tc,Ans);
			Ans = 20001;

		}

	}

	private static void combination(int idx, int start) {
		if (idx == cnt) {
			int sumA = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				list.add(i);
			}
			
				for (int j = 0; j < arr.length; j++) {
					for (int i = 0; i < list.size(); i++) {
					if(arr[j] == list.get(i)) {
						list.remove(i);
					}
				}
			}
			
			
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sumA += S[arr[i]][arr[j]];
				}
			}
			

			int sumB = 0;
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					sumB += S[list.get(i)][list.get(j)];
				}
			}
			int sumAB = Math.abs(sumA - sumB);
			Ans = Math.min(sumAB, Ans);
			return;
		}
		for (int i = start; i < N; i++) {
			arr[idx] = i;
			combination(idx + 1, i + 1);
		}
	}

	private static void print(int[][] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

}
