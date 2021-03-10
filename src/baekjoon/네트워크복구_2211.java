package baekjoon;

import java.util.*;
import java.io.*;

public class 네트워크복구_2211 {

	static int N, M;
	static boolean[] v;

	static class Point {
		int to, cnt;

		
		public Point(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		//방문 배열
		v = new boolean[N+1];
		List<Point>[] list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 인접리스트 만들기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			list[from].add(new Point(to,cnt));
			list[to].add(new Point(from,cnt));
		}
		
		// 거리 배열
		int[] dist = new int[N+1];
		int[] pList = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(pList, Integer.MAX_VALUE);
		
		PriorityQueue<Point> pq  =new PriorityQueue<>((o1,o2) -> o1.cnt - o2.cnt);
		dist[1] = 0;
		pq.add(new Point(1,0));		
		Point  p = null;
		while(!pq.isEmpty()) {
			p  = pq.poll();
			
			if(v[p.to]) continue;
			v[p.to] = true;
			
			
			int size = list[p.to].size();
			for(int i = 0; i < size; i ++) {
				int to = list[p.to].get(i).to;
				int cnt = list[p.to].get(i).cnt;
				if(!v[to] && p.cnt + cnt < dist[to]) {
					dist[to] = p.cnt + cnt;
					pList[to] = p.to;
					pq.add(new Point(to,dist[to]));
				}
				
			}
			
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if(pList[i] == Integer.MAX_VALUE) continue;
			ans++;
			sb.append(pList[i]+" "+i+"\n");
		}
		
		System.out.println(ans);
		System.out.println(sb.substring(0,sb.length()-1));
		

	}

}
