package softeer;

import java.util.Arrays;

public class fibo {
	static int[] arr = new int[100];

	public static void main(String[] args) {
		// 피보나치
//		System.out.println(fibo(45));

		// 피보나치 메모이제이션
//		System.out.println(memoFibo(45));

		// 재귀를 이용한 팩토리얼문제
//		System.out.println(factorial(10));

		// 10번동안 랜덤수(1~10 사이) 구하기 중복있을 시 true 리턴
//		System.out.println(rand());

		// 아나그램
		anagram();
	}

	private static void anagram() {
		String str1 = "asd";
		String str2 = "dsaaa";

		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();

		Arrays.sort(char1);
		Arrays.sort(char2);

		String _str1 = new String(char1);
		String _str2 = new String(char2);
		if (_str1.equals(_str2))
			System.out.println("같음");
		else
			System.out.println("다름");

	}

	private static boolean rand() {
		int[] arr = new int[11];
		int count = 4;
		while (count-- > 0) {
			int i = (int) (Math.random() * 10) + 1;
			if (arr[i] > 0)
				return true;
			else
				arr[i]++;
		}

		System.out.println(Arrays.toString(arr));
		return false;
	}

	private static int factorial(int i) {
		if (i <= 1)
			return i;
		return factorial(i - 1) * i;
	}

	private static int memoFibo(int i) {
		if (i <= 1) {
			arr[i] = 1;
			return 1;
		}
		if (arr[i] != 0)
			return arr[i];

		arr[i] = memoFibo(i - 1) + memoFibo(i - 2);

		return arr[i];

	}

	private static int fibo(int i) {
		if (i <= 1) {
			return 1;
		}

		return fibo(i - 1) + fibo(i - 2);
	}

}
