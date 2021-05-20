package baekjoon;

import java.util.*;
import java.io.*;

public class 괄호_9012 {

	static int tc;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());

		Stack<Character> st = new Stack<>();

		L:for (int T = 0; T < tc; T++) {
			st.clear();
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					st.push(c);
				} else if (c == ')') {
					if (st.size() == 0 || st.peek() == ')') {
						sb.append("NO\n");
						continue L;
					} else {
						if (st.peek() == '(') st.pop();
					}
				}
			}
			
			if(st.size() == 0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);

	}

}
