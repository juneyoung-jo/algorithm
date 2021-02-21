package baekjoon;

import java.util.*;
import java.io.*;

public class 가운데를말해요_1655 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> min = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		max.add(Integer.parseInt(br.readLine()));
		sb.append(max.peek() + "\n");

		for (int i = 0; i < N - 1; i++) {
			int num = Integer.parseInt(br.readLine());

			if (min.size() == max.size()) max.add(num);
			else min.add(num);
			if (search(max.peek(), min.peek(), sb)) {
				int m = min.poll();
				int n = max.poll();
				max.add(m);
				min.add(n);
			}
			sb.append(max.peek() + "\n");
		}

		System.out.println(sb.substring(0, sb.length() - 1).toString());

	}

	private static boolean search(Integer maxNum, Integer minNum, StringBuilder sb) {
		if (maxNum > minNum) {
			return true;
		} else {
			return false;
		}
	}

}
