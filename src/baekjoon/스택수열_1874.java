package baekjoon;

import java.util.*;
import java.io.*;

public class 스택수열_1874 {
	static int n, arr[];
	static Stack<Integer> st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		st = new Stack<>();

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 알고리즘 
		cal();

		System.out.println(st.size() == 0 ? sb.substring(0,sb.length()-1):"NO");

	}

	private static void cal() {
		int idx = 1;
		for (int i = 1; i <= n; i++) {
			sb.append("+\n");
			st.push(i);

			while (true) {
				if (st.size() > 0 && st.peek() == arr[idx]) {
					idx++;
					sb.append("-\n");
					st.pop();
				} else {
					break;
				}
			}
		}
	}

}
