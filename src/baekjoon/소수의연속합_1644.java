package baekjoon;

import java.util.Scanner;

public class 소수의연속합_1644 {
	static int N, ans;
	static boolean[] isPrime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isPrime = new boolean[N + 1];

		// 소수판별 (에라토스테네스 체)
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			for (int j = i * i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}

		System.out.println(cal());
		sc.close();
	}

	private static int cal() {
			int start = 2;
			int sum = 0;
			for (int i = 2; i < isPrime.length; i++) {
				if (!isPrime[i]) continue;
				sum += i; // end 포인터 관리
				if (sum == N) ans++;
				else if(sum > N){ // 클 경우
					while (sum > N) { // start 포인터 관리
						if (start > i) break;
						if (isPrime[start] && start <= i) {
							sum -= start;
							if(sum == N) ans++;
						}
						start++;
					}
				}
			}
		
		return ans;
	}

}
