package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점심식사시간_강의코드 {
	static int T, N, min, cnt; // 맵의크기, 최소시간, 사람의수
	static boolean[] selected;
	static int[][] sList;
	static final int M = 1, W = 2, D = 3, C = 4; // 사람들의 상태 : 이동중, 대기, 개단내려가기, 완료
	static ArrayList<Person> pList;

	static class Person implements Comparable<Person> {
		int r, c, downCnt, status, time; // 행, 열, 내려간계단수, 상태, 입구 도착시간

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void init() {
			downCnt = 0;
			status = M;
			time = 0;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.time - o.time;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<Person>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;

			int c = 0, k = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					c = Integer.parseInt(st.nextToken());
					if (c == 1)
						pList.add(new Person(i, j));
					else if (c > 1)
						sList[k++] = new int[] { i, j, c };

				}

			}
			cnt = pList.size();
			selected = new boolean[cnt];

			divide(0);
			System.out.printf("#%d %d\n", tc, min);
		}

	}

	private static void divide(int index) {

		if (index == cnt) {
			makeList();
			return;
		}

		selected[index] = true;
		divide(index + 1);
		selected[index] = false;
		divide(index + 1);
	}

	private static void makeList() {
		ArrayList<Person> aList = new ArrayList<Person>();
		ArrayList<Person> bList = new ArrayList<Person>();

		for (int i = 0; i < cnt; i++) {
			Person p = pList.get(i);
			p.init();

			if (selected[i]) {
				p.time = Math.abs(p.r - sList[0][0]) + Math.abs(p.c - sList[0][1]);
				aList.add(p);
			} else {
				p.time = Math.abs(p.r - sList[1][0]) + Math.abs(p.c - sList[1][1]);
				bList.add(p);
			}
		}

		int res = go(aList, bList);
		if (min > res)
			min = res;
	}

	private static int go(ArrayList<Person> aList, ArrayList<Person> bList) {
		int timeA = 0, timeB = 0;
		if (aList.size() > 0)
			timeA = processDown(aList, sList[0][2]);
		if (bList.size() > 0)
			timeB = processDown(bList, sList[1][2]);
		return timeA > timeB ? timeA : timeB;
	}

	private static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list);
		int time = list.get(0).time;
		int size = list.size();
		int ingCnt = 0, cCnt = 0;
		Person p;

		while (true) {

			for (int i = 0; i < size; i++) {
				p = list.get(i);
				if (p.status == C)
					continue;

				if (p.time == time) {
					p.status = W;
				} else if (p.status == W && ingCnt < 3) {
					p.status = D;
					p.downCnt = 1;
					ingCnt++;
				} else if (p.status == D) {
					if (p.downCnt < height) {
						p.downCnt++;
					} else {
						p.status = C;
						cCnt++;
						ingCnt--;
					}
				}

			}

			if (cCnt == size)
				break;
			++time;
		}

		return time;

	}

}
