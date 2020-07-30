package swexpertacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {
	static int T = 10, N;
	static int[] sub = { -1, -2, -3, -4, -5 }; // 한 싸이클

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> Q = new LinkedList<Integer>();

		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				int n = sc.nextInt();
				Q.offer(n);
			}

			boolean isok = true;
			while (isok) {
				for (int i = 0; i < sub.length; i++) {
					int num = Q.poll() + sub[i];
					if (num <= 0) {
						Q.offer(0);
						isok = false;
						break;
					}
					Q.offer(num);
				}

			}

			System.out.print("#" + N + " ");
			while (!Q.isEmpty()) {
				System.out.print(Q.poll() + " ");
			}
			System.out.println();

		}
	}

}
