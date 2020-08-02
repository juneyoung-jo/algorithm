package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		String[] stra = br.readLine().split(" ");
		String str = "";

		for (int i = 0; i < stra.length; i++) {
			str = str + stra[i] + " ";
		}

		Stack<Character> stack = new Stack<Character>();
		char[] arr = new char[str.length()];
		boolean isok = false;

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

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
				stack.push(arr[i]);
				sb.append(stack.pop());
				isok = true;
				continue;
			}

			if (isok) {
				if (arr[i] == '>') {
					stack.push(arr[i]);
					sb.append(stack.pop());
					isok = false;
					continue;
				}
				stack.push(arr[i]);
				sb.append(stack.pop());
				continue;
			}

			stack.push(arr[i]);
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);

	}

}
