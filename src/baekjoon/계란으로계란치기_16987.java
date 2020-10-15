package baekjoon;

import java.util.*;

public class 계란으로계란치기_16987 {
	static int N, Ans;
	static List<Point> list;

	static class Point {
		int s, w;

		public Point(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		list = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}

		cal(0);

		System.out.println(Ans);

	}

	private static void cal(int idx) {
		if (idx == N) {// 가장 오른쪽 계란을 집고 한번더 쳐야 함.
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (list.get(i).s <= 0)
					sum++;
			}
			Ans = Math.max(Ans, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (idx == i)
				continue; // 자신의 계란일 때 패스
			if (list.get(idx).s <= 0) {
				cal(idx + 1);
				break;
			}
			if (list.get(i).s <= 0)
				continue;

			list.get(idx).s -= list.get(i).w;
			list.get(i).s -= list.get(idx).w;
			cal(idx + 1);
			list.get(idx).s += list.get(i).w;
			list.get(i).s += list.get(idx).w;
		}
		
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i).s <= 0)
				sum++;
		}
		Ans = Math.max(Ans, sum);

	}

}
