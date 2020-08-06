package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 롤케이크2 {
	static int N, M, count;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			arr[i] = n;
		}
		
		
		//알고리즘
		//오름차순으로 정렬한 후 10의 배수인 것먼저 자르기
		//ex) 11 20 이면 20부터  1번잘랐을 때 2개가 나옴 
		//그 후 자르기 횟수가 남으면 10의 배수가 아닌 것 자르기
		Arrays.sort(arr); // 정렬

		// 10의 배수 먼저 자르기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 10) { //10이면 자를 필요없기 때문에 그냥 카운트
				count++;
				continue;
			}
			while (M > 0 && arr[i] % 10 == 0) { 
				arr[i] -= 10;
				count++;
				M -= 1;
				if (arr[i] == 10) {
					count++;
					break;
				}
			}

		}
		
		// 10의 배수 아닌거 자르기
		cut(0); //재귀사용
		System.out.println(count);
	}

	private static void cut(int idx) { 
		if (M <= 0 || idx == N) {

			return;
		}
		while (M > 0) {
			if (arr[idx] % 10 != 0 && arr[idx] > 10) {
				arr[idx] -= 10;
				count++;
				M -= 1;
			}
			if (arr[idx] < 10) {
				break;
			}
			if (arr[idx] == 10) {
				break;
			}
		}
		cut(idx + 1);
	}

}
