package baekjoon;

import java.util.*;
import java.io.*;

public class 돌그룹DFS_12886 {

	static int A, B, C,sum, ans;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		v = new boolean[1001][1001];
		sum = A+B+C;

		if ((A + B + C) % 3 != 0) System.out.println(0);
		else {
			v[A][B] = true;
			v[B][A] = true;
			cal(A,B);
			System.out.println(ans);
		}
		
	}
	
	
	public static void cal(int x,int y) {
		if(ans == 1) return;
		int z = sum - x - y;
		if(x == y && y == z) { // 셋다 같으면
			ans = 1;
			return;
		}
		if(x != y) {
			int max = Math.max(x, y) - Math.min(x, y);
			int min = Math.min(x, y)*2;
			if(max <= 1000 && min <= 1000 && !v[max][min]) {
				v[max][min] = true;
				v[min][max] = true;
				cal(max,min);
			}
		}
		if(!v[y][z]) {
			v[y][z] = true;
			v[z][y] = true;
			cal(y,z);
		}
	}

}
