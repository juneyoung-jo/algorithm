package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_3124 {
	static class Edge implements Comparable<Edge>{
		int dest;
		int cost;
		Edge(int d, int c){
			dest = d;
			cost = c;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Edge>[] adj = new ArrayList[V+1];
			for(int i = 0; i <= V; i++)
				adj[i] = new ArrayList<>();
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adj[v1].add(new Edge(v2, cost));
				adj[v2].add(new Edge(v1, cost));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[V+1];
			int cnt = 1;
			visited[1] = true;
			pq.addAll(adj[1]);
			long result = 0;
			while( cnt < V ) {
				Edge e = pq.poll();
				
				//e.dest목적지 간선을 선택
				if( visited[e.dest])
					continue;
				
				pq.addAll( adj[e.dest] );
				visited[e.dest] = true;
				cnt++;
				result += e.cost;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
