package baekjoon;

import java.util.*;
import java.io.*;

public class 전깃줄2_2568 {
	static int N;
	static ArrayList<Point> list;

	static class Point {
		int s, e;

		public Point(int s, int e) {
			this.s = s;
			this.e = e;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Point(s, e));
		}

		list.sort((o1, o2) -> o1.s - o2.s);

//		list.stream().forEach(o1->{
//			System.out.println(o1.s + " : " + o1.e) ;
//		});
//		System.out.println("--------------");

		int[] LIS = new int[N];
		int[] index = new int[N];
		boolean[] v = new boolean[500002];
		
		
		StringBuilder sb = new StringBuilder();
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Arrays.binarySearch(LIS, 0, size, list.get(i).e);
			if (tmp >= 0)  continue;
			tmp = Math.abs(tmp) - 1;
			
			LIS[tmp] = list.get(i).e;
			index[tmp] = list.get(i).s;
			
			if (tmp == size) {
				++size;
			}
			
			
			
		}
		
//		for(int i = size; i < N;i++) {
//			v[index[i]] = false;
//		}
		
		for(int i = 1; i < v.length;i++) {
			if(v[i]) sb.append(i+"\n");
		}
		
		
		
		System.out.println(N-size);
		System.out.println(sb);
		
		
	}

}
