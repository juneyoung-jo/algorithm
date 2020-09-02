package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 게리맨더링_17471_강의코드 {
	static int N, Ans = Integer.MAX_VALUE;
	// 정점배열
	static int[] voters;
	static int[][] adj;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		voters = new int[N + 1];
		adj = new int[N + 1][N + 1];
		sel = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			voters[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int k = sc.nextInt();
				adj[i][k] = 1;
				adj[k][i] = 1;
			}
		}
		// System.out.println(Arrays.toString(voters));
		// print(adj);
		powerSet(1);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void powerSet(int idx) {
		if (idx == voters.length) {
			// 두 선거구의 구역들이 서로 연결되어 있는지 확인
			if (check(sel)) {
				// 두선거구의 합을 구합
				int sumA = 0, sumB = 0;
				for (int i = 1; i < voters.length; i++) {
					if (sel[i])
						sumA += voters[i];
					else
						sumB += voters[i];
				}
				// 합의 최소값구하기
				Ans = Math.min(Ans, Math.abs(sumA - sumB));
				return;
			}

			return;
		}

		// 부분집합
		sel[idx] = true;
		powerSet(idx + 1);
		sel[idx] = false;
		powerSet(idx + 1);
	}

	private static boolean check(boolean[] sel) {
		// 선거구 안의 구역들의 연결여부 확인
		ArrayList<Integer> listA = new ArrayList();
		ArrayList<Integer> listB = new ArrayList();
		for (int i = 1; i < sel.length; i++) {
			if (sel[i])
				listA.add(i);
			else
				listB.add(i);
		}
		if (listA.size() == 0 || listB.size() == 0)
			return false;
		// 각 정점들의 연결여부를 확인하는 배열
		boolean[] visited = new boolean[N + 1];
		dfs(listA, listA.get(0), visited);
		dfs(listB, listB.get(0), visited);

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	private static void dfs(ArrayList<Integer> list, Integer idx, boolean[] visited) {
		visited[idx] = true;
		for (int i = 0; i < list.size(); i++) {
			if (adj[idx][list.get(i)] == 1 && !visited[list.get(i)]) {
				dfs(list, list.get(i), visited);
			}
		}

	}

	private static void print(int[][] adj) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}

	}

}