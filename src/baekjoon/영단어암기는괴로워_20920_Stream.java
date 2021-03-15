package baekjoon;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class 영단어암기는괴로워_20920_Stream {
	static int N, M;

	static class Point {
		String str;
		int cnt;

		public Point(String str, int cnt) {
			super();
			this.str = str;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [str=" + str + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map<String, Integer> list = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() < M) continue;
			list.merge(str, 1, Integer::sum);
		}

		List<Point> ans = new ArrayList<>();
		for (String s : list.keySet()) {
			int n = list.get(s);
			ans.add(new Point(s, n));
		}

		List<Point> collect = ans.stream().sorted((o1, o2) -> {
			if (o1.cnt == o2.cnt) {
				if (o1.str.length() == o2.str.length()) {
					return o1.str.compareTo(o2.str);
				}
				return Integer.compare(o2.str.length(), o1.str.length());
			}
			return o2.cnt - o1.cnt;
		}).collect(Collectors.toList());

		for (Point aa : collect) {
			sb.append(aa.str + "\n");
		}

		System.out.println(sb.substring(0, sb.length() - 1));

	}

}
