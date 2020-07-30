package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 탑 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		String[] str = br.readLine().split(" ");

		Stack<int[]> st = new Stack<int[]>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(str[i]);
			if (st.isEmpty()) {
				sb.append("0 ");
				st.push(new int[] { i, n });
				continue;
			}
			while (!st.isEmpty()) {
				if (st.peek()[1] >= n) { // 스택에 들어와 있는 값이 들어올n값보다 클때
					sb.append(st.peek()[0] + 1 + " ");
					st.push(new int[] { i, n });
					break;
				} else {
					st.pop();
				}
			}
			if (st.isEmpty()) {
				st.push(new int[] { i, n });
				sb.append("0 ");
			}

		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
