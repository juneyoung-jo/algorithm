package baekjoon;

import java.util.Scanner;

public class 슈퍼마리오_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int Ans = 0;
		int ans = Integer.MAX_VALUE;
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num += arr[i];
			if (Math.abs(100 - num) <= ans) {
				ans = Math.abs(100 - num);
				Ans = num;
			}
		}

		System.out.println(Ans);

	}

}
