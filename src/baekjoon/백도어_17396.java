package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백도어_17396 {
	static int N,M, sight[];
	static class Point implements Comparable<Point>{
		int to;
		long cnt;

		public Point(int to, long cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cnt, o.cnt);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sight = new int[N];
		
		st= new StringTokenizer(br.readLine());
		
		//시야체크 배열
		for (int i = 0; i < N; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		
		//간선리스트 만들어야 함.
		ArrayList<Point>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Point>();
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			list[from].add(new Point(to, cnt));
			list[to].add(new Point(from,cnt));
		}
		
		sight[N-1] = 0; // 넥서스 위치는 0으로 갈 수 있게 바꿔줘야함.
		// 다익스트라
		// 중복체크배열
		boolean[] v = new boolean[N];
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		int start = 0;
		dist[start] = 0;
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(start, dist[start]));
		
		Point p = null;
		
		while (!pq.isEmpty()) {
			p = pq.poll();
			
			if(v[p.to]) continue;
			v[p.to] = true;
			
			int size = list[p.to].size();
			for (int i = 0; i < size; i++) {
				int to = list[p.to].get(i).to;
				long cnt = list[p.to].get(i).cnt;
				if(sight[to] == 0 && !v[to] && p.cnt + cnt < dist[to]) {
					dist[to] = p.cnt + cnt;
					pq.add(new Point(to, dist[to]));
				}
				
			}
		}
		
//		for (long ln : dist) {
//			System.out.println(ln);
//		}
		
		System.out.println(dist[N-1] == Long.MAX_VALUE ? -1 : dist[N-1]);
		
		
	}

}
