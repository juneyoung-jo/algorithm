package baekjoon;

import java.util.*;
import java.io.*;

public class 강의실배정_11000 {

	static int N;

	static class Point implements Comparable<Point> {
		int start, end;

		public Point(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Point o) {

			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		PriorityQueue<Point> pq = new PriorityQueue<>();
		PriorityQueue<Point> pqEnd = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
		StringTokenizer st = null;
		int start, end;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			pq.add(new Point(start, end));
		}

		Point p = null;
		while (!pq.isEmpty()) {
			p = pq.poll();

			if (pqEnd.size() > 0 && pqEnd.peek().end <= p.start) {
				pqEnd.poll();
			}

			pqEnd.add(p);

		}

		System.out.println(pqEnd.size());

	}

}
