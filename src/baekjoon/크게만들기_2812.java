package baekjoon;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class 크게만들기_2812 {

	static int K, N, arr[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Stack<Integer> stack = new Stack();

		for (int i = 0; i < str.length(); i++) {
			if (stack.isEmpty())  stack.push(str.charAt(i) - '0');
			else {
				if (stack.peek() < str.charAt(i) - '0' && N > 0) {
					while (true) {
						if (!stack.isEmpty() && stack.peek() < str.charAt(i) - '0' && N > 0) {
							stack.pop();
							N--;
						} else {
							break;
						}
					}
					stack.push(str.charAt(i) - '0');
				} else {
					stack.push(str.charAt(i) - '0');
				}
			}
		}
		
		// N이 남았을 경우 (ex 역순으로 들어올 때, 7654321)
		while (N > 0) {
			stack.pop();
			N--;
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse());

	}

}
