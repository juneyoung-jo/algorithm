package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

	static int N, M, ans;
	static boolean[] v;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		v = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int start, end;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			list[start].add(end);
			list[end].add(start);
		}

		for (int i = 1; i < list.length; i++) {
			if (!v[i]) {
				ans++;
				dfs(i);
			}
		}

		System.out.println(ans);

	}

	private static void dfs(int idx) {
		v[idx] = true;
		int size = list[idx].size();
		for (int i = 0; i < size; i++) {
			if (!v[list[idx].get(i)]) {
				dfs(list[idx].get(i));
			}
		}
	}

}
