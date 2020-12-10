package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질_1697 {
	static int T, K, arr[];
	static boolean v[];
	static int[] dr = { -1, 1, 2 };

	static class Point {

		int r, cnt;

		public Point(int r, int cnt) {
			super();
			this.r = r;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		K = sc.nextInt();

		arr = new int[100001];
		v = new boolean[100001];

		bfs(T);
	}

	private static void bfs(int t) {
		Queue<Point> q = new LinkedList<Point>();
		v[t] = true;
		q.add(new Point(t, 0));
		
		Point p = null;
		while(!q.isEmpty()) {
			p  = q.poll();
			
			if(p.r == K) {
				System.out.println(p.cnt);
				return;
			}
			
			int nr;
			for (int d = 0; d < 3; d++) {
				if(d==2) {
					nr = p.r* dr[d];
				}else {
					nr = p.r + dr[d];
				}
				
				if(nr< 0  || nr >= 100001 || v[nr]) continue;
				
				v[nr] = true;
				q.add(new Point(nr, p.cnt+1));
				
			}
			
		}
		
	}

}
