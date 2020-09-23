package baekjoon;

import java.util.Scanner;

public class 줄세우기_2605 {
	static int N, map[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		map = new int[N+1];
		// 초기화
		
		for (int i = 0; i < map.length; i++) {
			map[i] = i;
		}
		
		for (int i =1; i <= N; i++) {
			int num = sc.nextInt();
			map[i] = map[i] -num;
			if(num >= 1) {
				for (int j = 0; j < i; j++) {
					if(map[i] <= map[j]) {
						map[j] ++;
					}
				}
				
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < map.length; j++) {
				if(i == map[j]) sb.append(j+" ");
			}
		}
		
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());
		
		sc.close();

	}

}
