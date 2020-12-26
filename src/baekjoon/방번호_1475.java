package baekjoon;

import java.util.Scanner;

public class 방번호_1475 {
	static int N, number[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		number = new int[9];

		String str = Integer.toString(N);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '9') number[6]++;
			else number[str.charAt(i) - '0']++;

		}

		if (number[6] % 2 == 0) number[6] /= 2;
		else number[6] = number[6] / 2 + 1;

		int ans = 0;
		for (int i = 0; i < number.length; i++) {
			if (ans < number[i])
				ans = number[i];
		}

		System.out.println(ans);

	}

}
