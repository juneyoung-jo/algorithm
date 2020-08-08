package swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

public class 북북서 {
	static int T;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			Stack<String> st = new Stack<String>();

			arr = new char[str.length()];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = str.charAt(i);
				if (arr[i] == 'n') {
					st.push("north");
				} else if (arr[i] == 'w') {
					st.push("west");
				}
			}

			int num = 1;
			double sum = 0;
			if (st.peek() == "west") {
				sum = 90;
			} else {
				sum = 0;
			}
			st.pop();
			while (!st.isEmpty()) {
				if (st.peek() == "west") {
					sum += 90 / Math.pow(2, num);
					num++;
					st.pop();
				} else {
					sum -= 90 / Math.pow(2, num);
					num++;
					st.pop();
				}

			}
			int n = 2;
			if (sum - (int) sum == 0) {
				System.out.printf("#%d %d\n", tc, (int) sum);
			} else {
				while (true) {
					if (sum * n - (int) (sum * n) == 0) {
						System.out.printf("#%d ", tc);
						System.out.println((int) (sum * n) + "/" + n);
						break;
					}
					n *= 2;
				}
			}

		}

	}

}
