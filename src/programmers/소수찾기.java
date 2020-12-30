package programmers;

import java.util.HashSet;

public class 소수찾기 {
	static int ans;
	static char[] num;
	static boolean[] v;
	static HashSet<Integer> set;

	public static void main(String[] args) {

		String numbers = "17";

		num = numbers.toCharArray();
		v = new boolean[num.length];
		set = new HashSet<Integer>();

		for (int i = 1; i <= v.length; i++) {
			combination(0, i, new int[i + 1]);
		}

		check();

		System.out.println(ans);
	}

	static public void check() {

		L: for (Integer result : set) {
			if (result < 2)
				continue L;
			for (int i = 2; i * i <= result; i++) {
				if (result % i == 0)
					continue L;
			}
			ans++;
		}

	}

	static public void combination(int idx, int size, int[] list) {

		if (idx == size) {
			String str = "";

			for (int i = 0; i < size; i++) {
				str += list[i];
			}

			if (str.length() == 0)
				return;
			int result = Integer.parseInt(str);
			set.add(result);
			return;
		}

		for (int i = 0; i < v.length; i++) {
			if (v[i])
				continue;
			v[i] = true;
			list[idx] = num[i] - '0';
			combination(idx + 1, size, list);
			v[i] = false;
		}

	}
}
