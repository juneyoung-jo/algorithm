package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 치킨배달_15686 {
	static int N, M, map[][], Ans = Integer.MAX_VALUE, numbers[], Min;
	static List<Point> list;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<Point>();
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][N];
		numbers = new int[M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) { // 치킨집 좌표를 알아야 하기 때문에 리스트에 저장
					list.add(new Point(i, j));
				}
			}
		}

		// 치킨집 중 n개 뽑음
		combination(0, 0);

		System.out.println(Ans);

	}

	private static void combination(int idx, int start) {
		if (idx == M) {
//			System.out.println(Arrays.toString(numbers));

			// 최소값 계산
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					int min = Integer.MAX_VALUE;
					if (map[r][c] == 1) { // 뽑힌 치킨집과 우리집의 치킨거리가 최소가 되는값을 뽑음.
						for (int i = 0; i < numbers.length; i++) {
							int num = Math.abs(r - list.get(numbers[i]).r) + Math.abs(c - list.get(numbers[i]).c);
							min = Math.min(min, num);
						}
						// 치킨거리가 최소가 된 값을 Min에 저장
						Min += min;
					}
				}
			}
			// for문이 끝나고 나면 최소로 저장된 치킨거리가 나옴.
			// 하지만 결과값들 중 가장 작은 값을 뽑아야 하기 때문에 최소값 해줘야 함.
			Ans = Math.min(Min, Ans);
			// Min은 전역변수니 초기화 필수
			Min = 0;
			return;
		}

		for (int i = start; i < list.size(); i++) {
			numbers[idx] = i;
			combination(idx + 1, i + 1);
		}
	}

}
