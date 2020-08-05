package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 바이러스 {
	static int N, M, count;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N + 1];
		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from); //양방향 중요!!
		}

		dfs(adjList, 1);
		System.out.println(count - 1); // 1번 컴퓨터 제외
	}

	private static void dfs(ArrayList<Integer>[] adjList, int i) {
		v[i] = true;
		count++;
		int size = adjList[i].size();
		for (int j = 0; j < size; j++) {
			int n = adjList[i].get(j);
			if (!v[n]) {
				dfs(adjList, n);
			}
		}
	}

}
