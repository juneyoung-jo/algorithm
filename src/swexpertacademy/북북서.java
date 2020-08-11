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
			Stack<String> st = new Stack<String>(); // 북, 서쪽을 저장하기 위해 스택 사용

			arr = new char[str.length()];

			// 스택에 저장
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
			// 가장 오른쪽에 있는 북or서 계산
			if (st.peek() == "west") {
				sum = 90;
			} else {
				sum = 0;
			}
			st.pop();
			while (!st.isEmpty()) { // 스택에 있는 숫자만큼 pop하고 2의 지수승 나누기로 계산
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
			if (sum - (int) sum == 0) { // 값이 딱 떨어졌을 경우는 그냥 계산해서 나오면됨.
				System.out.printf("#%d %d\n", tc, (int) sum);
			} else {
				while (true) { // 그렇지 않을 경우에 소수점이 없어질 수 있는 수를 찾아 정해진 형태로 출력
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
