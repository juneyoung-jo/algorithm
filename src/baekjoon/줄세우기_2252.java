package baekjoon;

import java.util.*;
import java.io.*;

public class 줄세우기_2252 {

	static int N, M, v[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		v = new int[N + 1];

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			list[n].add(m);
			v[m]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i =1; i<=N; i++) {
			if(v[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current+" ");
			
			for(int i = 0; i<list[current].size(); i++) {
				int next = list[current].get(i);
				v[next]--;
				if(v[next]==0) q.add(next);
			}
		}
		
		System.out.println(sb.substring(0,sb.length()-1));
	}

}
