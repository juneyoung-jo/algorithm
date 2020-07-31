package swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 최적경로 {
	static int[][] map = new int[100][100];
	static int[][] arr, distance;
	static int[] numbers;
	static boolean[] isSelected;
	static int T, N, sumx, sumy, ans, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			N += 2;

			arr = new int[N][3];

			for (int i = 0; i < N; i++) {
				arr[i][0] = i;
				for (int j = 1; j <= 2; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int bx = arr[1][1];
			int by = arr[1][2];

			arr[1][1] = arr[N - 1][1];
			arr[1][2] = arr[N - 1][2];

			arr[N - 1][1] = bx;
			arr[N - 1][2] = by;

			numbers = new int[N];
			isSelected = new boolean[N];
			distance = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = Math.abs(arr[i][2] - arr[j][2]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(distance[i][j] + " ");
				}
				System.out.println();
			}

			ans = 100000;
			permutation(0);
			System.out.printf("#%d %d\n", tc, ans);

		}

	}

	private static void permutation(int idx) {

		if (idx == arr.length - 2) {
			count++;
			// 거리계산하는 알고리즘 구현
			sumx = Math.abs(arr[0][1] - arr[numbers[0]][1]);
			sumy = Math.abs(arr[0][2] - arr[numbers[0]][2]);
			for (int i = 0; i < numbers.length - 3; i++) {
				sumx += Math.abs(arr[numbers[i]][1] - arr[numbers[i + 1]][1]);
				sumy += Math.abs(arr[numbers[i]][2] - arr[numbers[i + 1]][2]);
			}
			sumx += Math.abs(arr[numbers[numbers.length - 3]][1] - arr[N - 1][1]);
			sumy += Math.abs(arr[numbers[numbers.length - 3]][2] - arr[N - 1][2]);
			int sumxy = sumx + sumy;
			ans = Math.min(sumxy, ans);
			// System.out.println(sumx + sumy + " : " + count);
			// System.out.println(Arrays.toString(numbers) + count);
			return;
		}

		for (int i = 1; i < arr.length - 1; i++) {
			if (isSelected[i])
				continue;
			numbers[idx] = i;
			isSelected[i] = true;
			permutation(idx + 1);
			isSelected[i] = false;

		}
	}

}
