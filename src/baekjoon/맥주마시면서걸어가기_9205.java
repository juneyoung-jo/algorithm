package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 맥주마시면서걸어가기_9205 {
	static int T, n, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			n = sc.nextInt();

			int[][] map = new int[n + 2][2];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ArrayList<Integer>[] list = new ArrayList[n+2];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(i==j) continue;
					if(Math.abs(map[i][0] -map[j][0]) + Math.abs(map[i][1] -map[j][1]) <=1000) {
						list[i].add(j);
					}
				}
			}
			boolean[] v= new boolean[n+2];
			v[0] =true;
			dfs(0,list,v);
			
			
			System.out.println(ans > 0 ? "happy":"sad");
			ans = 0;

//			print(map);
		}


	}

	private static void dfs(int idx, ArrayList<Integer>[] list, boolean[] v) {
		
		
		if(idx == n+1) {
			ans++;
			return;
		}
		int size = list[idx].size();
		for (int i = 0; i < size; i++) {
			 int num = list[idx].get(i);
			 if(!v[num]) {
				 v[num] = true;
				 dfs(num,list,v);			 }
		}
		
		
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
