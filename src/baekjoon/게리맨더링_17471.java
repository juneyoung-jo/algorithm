package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링_17471 {
	static int arr[], N, Ans = Integer.MAX_VALUE;
	static boolean[] v;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 구역의 개수

		arr = new int[N]; // 인구수

		// 각 구의 인구 수 입력
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		list = new ArrayList[N];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 각 구와 연결된 리스트 만들기
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				list[i].add(sc.nextInt() - 1);
			}
		}
		v = new boolean[N];
		for (int i = 1; i <= N / 2; i++) {
			powerSet(0, i);
		}

		System.out.println(Ans == Integer.MAX_VALUE ? "-1" : Ans);

	}

	private static void powerSet(int idx, int end) {
		if (idx == end) {
			int A = 0;
			int B = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[i])
					A = i;
				else
					B = i;
			}

			if (bfs(A, new boolean[N]) && bfs(B, new boolean[N])) {

				int sumA = 0;
				int sumB = 0;

				for (int i = 0; i < arr.length; i++) {
					if (v[i])
						sumA += arr[i];
					else
						sumB += arr[i];
				}

				Ans = Math.min(Math.abs(sumA - sumB), Ans);
			}

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (v[i])
				continue;
			v[i] = true;
			powerSet(idx + 1, end);
			v[i] = false;
		}

	}

	private static boolean bfs(int start, boolean[] check) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		if (v[start]) {
			while (!q.isEmpty()) {
				int num = q.poll();

				int size = list[num].size();
				for (int i = 0; i < size; i++) {
					int a = list[num].get(i);
					if (!check[a] && v[a]) {
						q.add(a);
						check[a] = true;
					}
				}

			}

			for (int i = 0; i < check.length; i++) {
				if (v[i] != check[i])
					return false;
			}

			return true;
		} else {
			while (!q.isEmpty()) {
				int num = q.poll();

				int size = list[num].size();
				for (int i = 0; i < size; i++) {
					int a = list[num].get(i);
					if (!check[a] && !v[a]) {
						q.add(a);
						check[a] = true;
					}
				}

			}

			for (int i = 0; i < check.length; i++) {
				if (v[i] == check[i])
					return false;
			}

			return true;
		}

	}

}
