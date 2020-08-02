package jungol;

import java.util.Scanner;

public class 달팽이삼각형 {
	static int n;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		if (n > 100) {
			System.exit(0);
		}

		map = new int[n][n];

		int count = 0; // 0부터 하나씩 증가하도록 카운트값 만들어 줌 0~9까지 반복이지만 출력할때 나머지함수 쓰면 쭉 증가해도 상관없음.
		int sw = 1; // 증가 감소가 반복되기 때문에 스위치변수 만들어 줌
		int row = -1; // 0,0부터하기위해 -1부터시작
		int col = -1;// 0,0부터하기위해 -1부터시작

		for (int i = 0; i < n; i++) { // 순서가 6 5 4 3 2 1 순으로 n번부터 -1씩 감소
			for (int j = i; j < n; j++) { // 1. 행 열 둘다 증가
				row += sw;
				col += sw;
				map[row][col] = count++;
			}

			sw *= -1;
			n -= 1;

			for (int j = i; j < n; j++) { // 2. 행고정 열만 감소
				col += sw;
				map[row][col] = count++;
			}

			n -= 1;

			for (int j = i; j < n; j++) {// 3. 열고정 행만 감소 1~3사이클 반복
				row += sw;
				map[row][col] = count++;
			}

			sw *= -1;

		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(map[i][j] % 10 + " ");
			}
			System.out.println();
		}

	}

}
