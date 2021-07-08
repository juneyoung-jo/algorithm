import java.util.*;

class Solution {
	static boolean[][] v;
	static int trapCount, arr[][], ans;
	static Map<Integer, Integer> map = new HashMap<>();
	static PriorityQueue<Point> q = new PriorityQueue<>();

	static class Point implements Comparable<Point> {
		int start, flag, cnt;

		public Point(int start, int flag, int cnt) {
			this.start = start;
			this.flag = flag;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}

	}

	public static void main(String[] args) {
		int n = 4;
		int start = 1;
		int end = 4;
		int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
		int[] traps = { 2, 3 };

		trapCount = traps.length;
		v = new boolean[1 << trapCount][n + 1];
		arr = new int[n + 1][n + 1];

		for (int i = 0; i < traps.length; i++) {
			map.put(traps[i], i);
		}

		for (int i = 0; i < roads.length; i++) {
			int P = roads[i][0];
			int Q = roads[i][1];
			int S = roads[i][2];
			arr[P][Q] = S;
		}
		
		cal(start, end);

		System.out.println(ans);
	}

	public static void cal(int start, int end) {
		q.add(new Point(start, (1 << trapCount) - 1, 0));
		v[(1 << trapCount) - 1][start] = true;

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.start == end) {
				ans = p.cnt;
				return;
			}

			for (int i = 1; i < arr.length; i++) {
				if (v[p.flag][i]) continue;
				if(arr[p.start][i] == 0 && arr[i][p.start] == 0) continue; // 아예 연결안됨.
				if (map.containsKey(p.start)) { // 현재 위치가 함정
					if ((p.flag & 1 << map.get(p.start)) == 0) {
						if (map.containsKey(i)) { // 연결된곳이 함정이면
							if ((p.flag & 1 << map.get(i)) == 0) {
								if(arr[p.start][i] == 0) continue;
								v[p.flag][i] = true;
								q.add(new Point(i, p.flag & ~(1 << map.get(i)) | 1 << map.get(i), p.cnt + arr[p.start][i]));
							} else {
								if(arr[i][p.start] == 0) continue;
								v[p.flag][i] = true;
								q.add(new Point(i, p.flag & ~(1 << map.get(i)), p.cnt + arr[i][p.start]));
							}
							continue;
						}
						if(arr[i][p.start] == 0) continue;
						v[p.flag][i] = true;
						q.add(new Point(i, p.flag, p.cnt + arr[i][p.start]));
					}else {
						if (map.containsKey(i)) { // 연결된곳이 함정이면
							if ((p.flag & 1 << map.get(i)) == 0) {
								if(arr[i][p.start] == 0) continue;
								v[p.flag][i] = true;
								q.add(new Point(i, p.flag & ~(1 << map.get(i)) | 1 << map.get(i), p.cnt + arr[i][p.start]));
							} else {
								if(arr[i][p.start] == 0) continue;
								v[p.flag][i] = true;
								q.add(new Point(i, p.flag & ~(1 << map.get(i)), p.cnt + arr[i][p.start]));
							}
							continue;
						}
						if(arr[p.start][i] == 0) continue;
						v[p.flag][i] = true;
						q.add(new Point(i, p.flag, p.cnt + arr[p.start][i]));
						
					}
				} else {
					if (map.containsKey(i)) { // 연결된곳이 함정이면
						if ((p.flag & 1 << map.get(i)) == 0) {
							if(arr[i][p.start] == 0) continue;
							v[p.flag][i] = true;
							q.add(new Point(i, p.flag & ~(1 << map.get(i)) | 1 << map.get(i), p.cnt + arr[i][p.start]));
						}else {
							if(arr[p.start][i] == 0) continue;
							v[p.flag][i] = true;
							q.add(new Point(i, p.flag & ~(1 << map.get(i)), p.cnt + arr[p.start][i]));
						}
						continue;
					}
					if(arr[p.start][i] == 0) continue;
					v[p.flag][i] = true;
					q.add(new Point(i, p.flag, p.cnt + arr[p.start][i]));
				}
			}

		}
	}
}