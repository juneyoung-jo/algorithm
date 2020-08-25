package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링 {
	static int N, arr[], Ans = Integer.MAX_VALUE;
	static boolean check[];
	static ArrayList<Integer> Alist;
	static ArrayList<Integer> Blist;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}

		arr = new int[N];// 각 구의 사람 수
		for (int i = 0; i < arr.length; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}

		// 인접행렬 만들기
		for (int i = 0; i < list.length; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int num = sc.nextInt() - 1;
				list[i].add(num);
			}
		}

		// 부분집합 -> 1부터 N/2까지 (절반까지만 하면 똑같음 : 선택된거 안된거로 나뉘니까)
		for (int i = 1; i <= N / 2; i++) {
			powerSet(0, i, new boolean[N]);
		}
		if (Ans == Integer.MAX_VALUE) {
			Ans = -1;
		}
		System.out.println(Ans);

	}

	private static void powerSet(int idx, int size, boolean[] v) {
		if (idx == size) {
			Alist = new ArrayList<Integer>();
			Blist = new ArrayList<Integer>();
			for (int i = 0; i < v.length; i++) {
				if (v[i])
					Alist.add(i); // 선택된거
				else
					Blist.add(i); // 선택 안 된거
			}
			// 각각 dfs를 돌려 연결되어있는지 확인 boolean값으로 반환
			// 둘다 true일 경우(즉, 둘다 연결이 되있는 경우) 결과값 계산
			if (dfsA(v, Alist) && dfsB(v, Blist)) {
				int A = 0;
				int B = 0;
				for (int i = 0; i < v.length; i++) {
					if (v[i])
						A += arr[i];
					else
						B += arr[i];
				}
				Ans = Math.min(Ans, Math.abs(A - B));
			}

			return;
		}
		for (int i = idx; i < v.length; i++) {
			if (v[i])
				continue;
			v[i] = true;
			powerSet(idx + 1, size, v);
			v[i] = false;
		}

	}

	private static boolean dfsB(boolean[] v, ArrayList<Integer> lst) {
		check = new boolean[N];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(lst.get(0));
		check[lst.get(0)] = true;
		while (!q.isEmpty()) {
			int p = q.poll();
			int size = list[p].size();
			for (int i = 0; i < size; i++) {
				int nn = list[p].get(i);
				if (!v[nn] && !check[nn]) { // v배열과 check배열값이 반대가 됨.(선택안된거)
					check[nn] = true;
					q.add(nn);
				}

			}
		}

		for (int i = 0; i < v.length; i++) {
			if (v[i] == check[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfsA(boolean[] v, ArrayList<Integer> lst) {
		check = new boolean[N];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(lst.get(0));
		check[lst.get(0)] = true;
		while (!q.isEmpty()) {
			int p = q.poll();
			int size = list[p].size();
			for (int i = 0; i < size; i++) {
				int nn = list[p].get(i);
				if (v[nn] && !check[nn]) { // v배열과 check배열값이 반대가 됨.(선택된거)
					check[nn] = true;
					q.add(nn);
				}

			}
		}

		for (int i = 0; i < v.length; i++) {
			if (v[i] != check[i]) {
				return false;
			}
		}
		return true;
	}

}
