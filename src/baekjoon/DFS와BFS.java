package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class DFS와BFS {
	static int N, M, V;

	public static void main(String[] args) throws IOException {
		// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		String[] str = bf.readLine().split(" ");

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		ArrayList<Integer>[] adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 1; i <= N; i++) { // 정렬을 해줘야 함 ㅠ 차라리 인접행렬로 구하는게 더 편했을 듯.
			Collections.sort(adjList[i]);
		}

		dfs(adjList, V, new boolean[N + 1]);
		System.out.println();
		bfs(adjList, V);
		System.out.println();

	}

	private static void bfs(ArrayList<Integer>[] adjList, int idx) {
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean[] vis = new boolean[N + 1];

		vis[idx] = true;
		Q.offer(idx);
		while (!Q.isEmpty()) {
			int p = Q.poll();
			System.out.print(p + " ");
			int size = adjList[p].size();
			for (int i = 0; i < size; i++) {
				int n = adjList[p].get(i);
				if (!vis[n]) {
					vis[n] = true;
					Q.offer(n);
				}
			}
		}

	}

	private static void dfs(ArrayList<Integer>[] adjList, int idx, boolean[] vis) {
		vis[idx] = true;
		System.out.print(idx + " ");
		Integer size = adjList[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adjList[idx].get(i);
			if (!vis[n]) {
				dfs(adjList, n, vis);
			}
		}
	}

}
