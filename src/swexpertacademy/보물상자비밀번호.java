package swexpertacademy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물상자비밀번호 {
	static int T, N, K, cnt, sum;
	static int[] Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			Ans = new int[N];
			cnt = N / 4;
			ArrayList<Character> arr = new ArrayList();
			ArrayList<Character> arr_2 = new ArrayList();

			String str = sc.next();
			for (int i = 0; i < N; i++) {
				arr.add(str.charAt(i));

			}

			if (cnt < K) { // cnt번만 반복
				for (int i = 0; i < cnt; i++) {
					arr.add(arr.remove(0));
					for (int j = 0; j < arr.size(); j++) {
						arr_2.add(arr.get(j));
					}
				}

			} else { // k번 반복
				for (int i = 0; i < K; i++) {

				}
			}

			compute(arr_2); // 계산

//			for (Character cr : arr_2) {
//				System.out.print(cr + " ");
//			}

		}

	}

	private static void compute(ArrayList<Character> arr) {
		for (int i = 0; i < 3; i++) {
			if (arr.get(i) == 'A') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 10;
			} else if (arr.get(i) == 'B') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 11;
			} else if (arr.get(i) == 'C') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 12;
			} else if (arr.get(i) == 'D') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 13;
			} else if (arr.get(i) == 'E') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 14;
			} else if (arr.get(i) == 'F') {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * 15;
			} else {
				sum += Math.pow(16, Math.abs((i % cnt) - (cnt - 1))) * (arr.get(i) - '0');
			}
			System.out.println(sum);
		}
	}

}
