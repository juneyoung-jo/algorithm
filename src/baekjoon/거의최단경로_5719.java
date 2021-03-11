package baekjoon;
import java.util.*;
import java.io.*;

public class 거의최단경로_5719 {
	
	static int N,M,S,D, dist[],pList[];
	static boolean[] v;
	static class Point{
		int to,cnt;
		
		public Point(int to,int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			List<Point>[] list = new ArrayList[N];
			List<Point>[] RList = new ArrayList[N];
			
			for(int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				RList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				
				list[from].add(new Point(to,cnt));
				RList[to].add(new Point(from,cnt));
			}
			
			// 알고리즘
			v = new boolean[N];
			dist = new int[N];
			pList = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(pList, -1);
			
			PriorityQueue<Point> pq = new PriorityQueue<>((o1,o2)->o1.cnt -o2.cnt); 
			dist[S] = 0;
			pq.add(new Point(S,dist[S]));
			Point p = null;
			while(!pq.isEmpty()) {
				p = pq.poll();
				
				if(v[p.to]) continue;
				v[p.to] = true;
				
				int size = list[p.to].size();
				
				for(int i = 0; i < size; i++) {
					int to = list[p.to].get(i).to; 
					int cnt = list[p.to].get(i).cnt;
					
					if(!v[to] && p.cnt + cnt < dist[to]) {
						dist[to] = p.cnt + cnt;
						pList[to] = p.to;
						pq.add(new Point(to,dist[to]));
						
					}
				}
				
			}
			
			int size = RList[D].size(); // 도착점
			v = new boolean[N];
			v[S] = true;
			p = null;
			
			// 최적 경로 찾아내서 지우기.
			cal(RList,list,D);
			
			// 거의 최단경로 찾기.
			dist = new int[N];
			pList = new int[N];
			boolean[] v =  new boolean[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			Arrays.fill(pList, -1);
			
			pq = new PriorityQueue<>((o1,o2)->o1.cnt -o2.cnt); 
			dist[S] = 0;
			pq.add(new Point(S,dist[S]));
			p = null;
			while(!pq.isEmpty()) {
				p = pq.poll();
				
				if(v[p.to]) continue;
				v[p.to] = true;
				
				size = list[p.to].size();
				
				for(int i = 0; i < size; i++) {
					int to = list[p.to].get(i).to; 
					int cnt = list[p.to].get(i).cnt;
					
					if(!v[to] && p.cnt + cnt < dist[to]) {
						dist[to] = p.cnt + cnt;
						pList[to] = p.to;
						pq.add(new Point(to,dist[to]));
					}
				}
				
			}
			
			System.out.println(dist[D] == Integer.MAX_VALUE? "-1" : dist[D]);
			
		}
	}
	private static void cal(List<Point>[] RList, List<Point>[] list, int d) {
		Point p = null;
		for(int i = 0; i < RList[d].size(); i++) {
			p = RList[d].get(i);
			if(p.cnt + dist[p.to] == dist[d]) {
				for(int j= 0; j < list[p.to].size(); j++) {
					if(list[p.to].get(j).to == d) {
						list[p.to].remove(j);
						cal(RList,list,p.to);
						j--;
					}
					
				}
			}
		}
	}

}
