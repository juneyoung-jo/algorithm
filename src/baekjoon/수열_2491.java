package baekjoon;

import java.util.Scanner;

public class 수열_2491 {
	static int N,arr[],ans[], Ans=1;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 1;
		//크거나 같을 때
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1] <= arr[i]) {
				cnt ++;
				Ans = Ans < cnt ? cnt:Ans; 
			}else {
				cnt  = 1;
			}
		}
		
		
		//작거나 같을 때
		cnt = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1] >= arr[i]) {
				cnt ++;
				Ans = Ans < cnt ? cnt:Ans; 
			}else {
				cnt  = 1;
			}
		}
		
		System.out.println(Ans);
	}

}
