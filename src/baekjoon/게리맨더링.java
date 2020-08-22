package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 게리맨더링 {
	static int N, arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		arr = new int[N];// 각 구의 사람 수
		for (int i = 0; i < arr.length; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}

		// 인접행렬 만들기
		for (int i = 0; i < list.length; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int num = sc.nextInt();
				list[i].add(num);
			}
		}

		// 조합 -> 1부터 N/2까지
		for (int i = 0; i < N / 2; i++) {
//			powerSet(0);
		}

	}

}
