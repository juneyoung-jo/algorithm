package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		str += " ";

		Stack<Character> stack = new Stack<Character>();
		char[] arr = new char[str.length()];
		boolean isok = false;

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		// 알고리즘 구현
		/*
		 * '<'가 나오면 '>'가 나올때까지 sb에 저장하고 , 그냥 문자가 나오면 스택에 ' ' or '<'가 나올때까지 저장 후 한번에 sb에
		 * 저장(단어 뒤집기)
		 */
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(' ');
				continue;
			}

			if (arr[i] == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(arr[i]);
				isok = true;
				continue;
			}

			if (isok) {
				if (arr[i] == '>') {
					sb.append(arr[i]);
					isok = false;
					continue;
				}
				sb.append(arr[i]);
				continue;
			}

			stack.push(arr[i]);
		}

		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);

	}

}
