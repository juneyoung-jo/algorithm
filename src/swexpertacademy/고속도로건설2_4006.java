package swexpertacademy;

import java.util.*;
import java.io.*;

public class 고속도로건설2_4006 {
	static int T, N, M, parents[];

	static class Point {
		int start, end, cnt;

		public Point(int start, int end, int cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			List<Point> list = new ArrayList<>();
			parents = new int[N+1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				list.add(new Point(start, end, cnt));
			}

			makeSet();
			list.sort((o1, o2) -> o1.cnt - o2.cnt);
			
			int sum = 0;
			int count = 0;
			for(Point p : list) {
				if(Union(p.start,p.end)) {
					sum+= p.cnt;
					count+=1;
					
					if( count == N) break;
				}
				
				
			}
			
			System.out.printf("#%d %d\n",tc,sum);

		}

	}
	
	public static void makeSet() {
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	public static boolean Union(int s,int e) {
		int ss = find(s);
		int ee = find(e);
		
		if(ss == ee) return false;
		
		parents[ee] = ss;
		return true;
		
	}

	private static int find(int s) {
		if(parents[s] == s) return parents[s];
		return parents[s] = find(parents[s]);
	}

}
