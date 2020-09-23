package baekjoon;

import java.util.Scanner;

public class 수이어가기_2635 {
	static int T, ans, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		
		//알고리즘
		// 재귀로 최대가 될 수 있는 i값과 그때의 결과값을 찾음.
		// 배열을 구해서 직접 for문으로 값을 저장 시킴.
		for (int i = T; i >= 0; i--) {
			cal(1,T,i,i);
		}
		int[] arr = new int[ans];
		cal(1,T,N,arr);
		
		System.out.println(ans);
		int num = T;
		for (int i = 0; i < arr.length; i++) {
			num -= arr[i];  
			arr[i] = num;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		

	}

	private static void cal(int idx, int t, int i, int[] arr) {
		if (i < 0) {
			return;
		}
		
		arr[idx] = t-i;
		cal(idx + 1, i, t - i,arr);
	}

	private static void cal(int idx, int t, int i,int start) {
		if (i < 0) {
			if(ans<idx) {
				ans = idx;
				N = start;
			}
			return;
		}

		cal(idx + 1, i, t - i,start);

	}

}
