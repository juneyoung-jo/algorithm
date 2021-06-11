package softeer;

import java.util.Arrays;
import java.util.Stack;

/*
 static int[] arr = { 5, 3, 3, 4, 5 }; // [-1, 0, 3, 4, -1]
 static int[] arr = { 3, 3, 3, 4, 5 }; // [3, 3, 3, 4, -1]
 static int[] arr = { 4, 2, 5, 4, 1 }; // [2, 0, -1, 2, 3]
 static int[] arr = { 9, 0, 9, 0, 9 }; // [-1,0,-1, 2, -1]
 static int[] arr = { 7, 6, 5, 4, 3 }; // [-1, 0, 1, 2, 3]
 static int[] arr = { 7, 6, 5, 6, 7 }; // [-1, 0, 1, 4, -1]
 static int[] arr = { 8, 6, 5, 7, 10 }; // [4, 0, 1, 4, -1]
 */
public class test {
//	static int[] arr = { 3, 5, 4, 1, 2 };
//	static int[] arr = { 3, 5, 4, 4, 4 };
	static int[] ans;
	static Stack<Integer> st;

	public static void main(String[] args) {
		int[] test0 = { 3, 5, 4, 1, 2}; // [3, 5, 4, 1, 2]
		cal(test0);
		int[] arr = { 5, 3, 3, 4, 5 }; // [-1, 0, 3, 4, -1]
		cal(arr);
		int[] test1 = { 3, 3, 3, 4, 5 }; // [3, 3, 3, 4, -1]
		cal(test1);
		int[] test2 = { 4, 2, 5, 4, 1 }; // [2, 0, -1, 2, 3]
		cal(test2);
		int[] test3 = { 9, 0, 9, 0, 9 }; // [-1,0,-1, 2, -1]
		cal(test3);
		int[] test4 = { 7, 6, 5, 4, 3 }; // [-1, 0, 1, 2, 3]
		cal(test4);
		int[] test5 = { 7, 6, 5, 6, 7 }; // [-1, 0, 1, 4, -1]
		cal(test5);
		int[] test6 = { 8, 6, 5, 7, 10 }; // [4, 0, 1, 4, -1]
		cal(test6);

	}

	public static void cal(int[] arr) {

		st = new Stack<>();
		ans = new int[arr.length];
		Arrays.fill(ans, -1);

		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				st.push(i);
				continue;
			} else {
				if (arr[st.peek()] < arr[i]) {
					// arr[peek]가 들어올 값보다 작을 때
					while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
						int index = st.pop();
						if (ans[index] == -1) {
							ans[index] = i;
						} else if (Math.abs(index - ans[index]) > Math.abs(i - index)) {
							// 이전에 저장된 값과의 거리 vs 현재 저장위치와의 거리를 계산 -> 더 가까운 쪽으로 갱신
							// 스택에 인덱스를 담아 두기 때문에 계산 가능
							ans[index] = i;
						}
					}

					// ans[i]가 현재 스택의 peek값이 됨.
					// 값이 같을 경우는 제외
					if (!st.isEmpty() && arr[st.peek()] != arr[i]) {
						ans[i] = st.peek();
					}
				} else if (arr[st.peek()] > arr[i]) {
					// peek가 들어올 값보다 클 때
					ans[i] = st.peek();
				} else {
					// peek가 들어올 값과 같을 경우
					ans[i] = ans[st.peek()];
				}
				st.push(i);
			}

		}

		System.out.println(Arrays.toString(ans));

	}

}
