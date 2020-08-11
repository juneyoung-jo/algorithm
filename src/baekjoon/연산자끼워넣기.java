package baekjoon;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static int N, arr[], opnum, max = -1000000000, min = 1000000000;
	static int Oper[] = new int[4];
	static char[] op, p_op;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			Oper[i] = sc.nextInt();
			opnum += Oper[i];
		}

		op = new char[opnum];
		v = new boolean[opnum];
		p_op = new char[opnum];
		opSet(); // 연산자 배열을 만드는 함수 -> permutation을 만들기 위해
		permutation(0); // 순열 사용
		System.out.printf("%d\n%d\n", max, min);
		max = 0;
		min = 0;

	}

	private static void permutation(int idx) {
		if (idx == opnum) {
			int sum = arr[0];
			for (int i = 1; i < arr.length; i++) { //1번 부터 해야 연산자 부터 계산됨 0번은 숫자임
				if (p_op[i - 1] == '+') {
					sum += arr[i];
				}
				if (p_op[i - 1] == '-') {
					sum -= arr[i];
				}
				if (p_op[i - 1] == '*') {
					sum *= arr[i];
				}
				if (p_op[i - 1] == '/') {
					sum /= arr[i];
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < op.length; i++) {
			if (v[i])
				continue;
			p_op[idx] = op[i];
			v[i] = true;
			permutation(idx + 1);
			v[i] = false;

		}

	}

	private static void opSet() {//0~4까지의 배열에 담겨있는 숫자만큼의 연산자 배열을 만들어 각각 저장
		int idx = 0;
		for (int j = 0; j < 4; j++) {
			if (j == 0) {
				for (int i = 0; i < Oper[j]; i++) {
					op[idx] = '+';
					idx++;
				}
			}
			if (j == 1) {
				for (int i = 0; i < Oper[j]; i++) {
					op[idx] = '-';
					idx++;
				}
			}
			if (j == 2) {
				for (int i = 0; i < Oper[j]; i++) {
					op[idx] = '*';
					idx++;
				}
			}
			if (j == 3) {
				for (int i = 0; i < Oper[j]; i++) {
					op[idx] = '/';
					idx++;
				}
			}

		}

	}

}
