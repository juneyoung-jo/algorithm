package swexpertacademy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 보물상자비밀번호 {
	static int T, N, K, cnt;
	static long sum;
	static long[] Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			Ans = new long[10000];
			cnt = N / 4;
			ArrayList<Character> arr = new ArrayList<>();
			ArrayList<Character> arr_2 = new ArrayList<>();

			String str = sc.next();
			for (int i = 0; i < N; i++) {
				arr.add(str.charAt(i));

			}
			
			//알고리즘
			//제일 앞숫자를 뒤에 써야하기 때문에 어레이 리스트 사용
			//길이가 길지 않기 때문에  어레이 리스트 2개 사용하여 한번에 계산함.
			//N -> 28이하 정수
			for (int i = 0; i <= cnt; i++) {
				if (i == 0) {
					for (int j = 0; j < arr.size(); j++) {
						arr_2.add(arr.get(j));
					}
					continue;
				}
				arr.add(arr.remove(0));
				for (int j = 0; j < arr.size(); j++) {
					arr_2.add(arr.get(j));
				}
			}

			compute(arr_2); // 계산

			// 중복제거
			for (int i = 0; i < Ans.length; i++) {
				if (Ans[i] == 0) {
					break;
				}
				for (int j = i - 1; j >= 0; j--) {
					if (Ans[i] == Ans[j]) {
						Ans[j] = 0;
					}
				}
			}
			
			
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < Ans.length; i++) {
				list.add(Ans[i]);
			}
			Collections.sort(list); //정렬
			Collections.reverse(list); //역순 정렬
			
			
			System.out.printf("#%d %d\n", tc, list.get(K - 1));
		}

	}

	private static void compute(ArrayList<Character> arr) {
		for (int j = 0; j < Ans.length; j++) {
			boolean isok = false;
			for (int i = 0; i < arr.size(); i++) {//자리수를 구해서 16진수 계산
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

				if (i % cnt == cnt - 1) {
					Ans[j] = sum;
					j++;
					sum = 0;
				}

				if (i == arr.size() - 1) {
					isok = true;
					break;
				}
			}
			if (isok) {
				break;
			}
		}
	}

}
