package swexpertacademy;

import java.util.Scanner;

public class 비밀번호 { //다시풀자 스택으로
	static int T = 10;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			String str = sc.next();
			while (true) {
				String ans = str;
				str = str.replace("99", "").replace("88", "").replace("77", "").replace("66", "").replace("55", "")
						.replace("44", "").replace("33", "").replace("22", "").replace("11", "").replace("00", "");
				if (ans == str)
					break;
			}

			System.out.println("#" + tc + " " + str);
		}
		sc.close();
	}
}