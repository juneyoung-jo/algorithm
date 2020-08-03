package swexpertacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 암호문1 {
	static int N, T = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= T; tc++) {
			List list = new ArrayList();
			N = sc.nextInt();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				list.add(i, num);
			}

			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				switch (str) {
				case "I":
					int idx = sc.nextInt();
					int number = sc.nextInt();
					for (int j = idx; j < idx + number; j++) {
						int num = sc.nextInt();
						list.add(j, num);
					}
					break;

				default:
					break;
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i).toString() + " ");
			}

			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}

	}

}
