package swexpertacademy;

import java.util.Scanner;
import java.util.Stack;

public class 비밀번호_스택 {
	static int T = 10;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			String str = sc.next();
			Stack<Character> st = new Stack<Character>(); // 문제 스택
			Stack<Character> ans = new Stack<Character>(); // 정답 스택

			// 입력과 동시에 알고리즘구현함.
			for (int i = 0; i < N; i++) {// 입력 부분
				if (st.size() == 0) {// 스택이 비어있을 때 하나 추가
					st.push(str.charAt(i));
					continue;
				}
				if (st.peek() == str.charAt(i)) { // 스택에 들어있는 값과 들어갈 값이 같으면 팝
					st.pop();
					continue;
				}
				st.push(str.charAt(i)); // 아니면 푸시해서 값 채워넣음
			}

			// 다 걸러진 문제스택을 정답스택으로 옮겨야함. 이유 : 역순으로 출력되기 때문
			int st_size = st.size();
			for (int i = 0; i < st_size; i++) {
				ans.push(st.pop());
			}

			// 출력부분
			int ans_size = ans.size();
			System.out.print("#" + tc + " ");
			for (int i = 0; i < ans_size; i++) {
				System.out.print(ans.pop());
			}
			System.out.println();

		}
		sc.close();
	}
}