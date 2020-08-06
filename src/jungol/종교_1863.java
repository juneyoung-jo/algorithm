package jungol;

import java.util.Scanner;

public class 종교_1863 {
	static int[] parents;
	static int[] rank;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		if (n <= 0 || n > 50000 || m < 0 || m > 100000) {
			System.exit(0);
		}

		parents = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			makeSet(i);
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			union(x, y);
		}

		//print(parents);
		int Ans = 0;
		for (int i = 1; i <= n; i++) { // 종교의 수 담기
			if (parents[i] == i) {
				Ans++;
			}
		}

		System.out.println(Ans);

		sc.close();
	}

	private static void print(int[] parents) {
		for (int i = 0; i < parents.length; i++) {
			System.out.print(parents[i] + " ");
		}
	}

	private static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}

	}

	private static int find(int x) {
		if (parents[x] == x) {
			return parents[x];
		} else {
			return find(parents[x]);
		}

	}

	private static void makeSet(int num) {
		parents[num] = num;
	}

}
