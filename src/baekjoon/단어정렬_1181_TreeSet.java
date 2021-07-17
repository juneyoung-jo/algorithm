package baekjoon;

import java.util.*;
import java.io.*;

public class 단어정렬_1181_TreeSet {
	static int N;
	static class Point implements Comparable<Point> {
		int len;
		String str;

		public Point(String str, int len) {
			this.len = len;
			this.str = str;
		}

		@Override
		public int compareTo(Point o) {
			if (this.len == o.len)
				return this.str.compareTo(o.str);
			return this.len - o.len;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Set<Point> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set.add(new Point(str, str.length()));
		}

		StringBuilder sb = new StringBuilder();
		set.forEach(o -> sb.append(o.str + "\n"));
		System.out.println(sb);

	}

}
