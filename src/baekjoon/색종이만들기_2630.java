package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {
	static int N, map[][], AnsW, AnsB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

//		print(map);
		div(0, 0, 0, N);
		System.out.println(AnsW);
		System.out.println(AnsB);

	}

	private static void div(int idx, int r, int c, int size) {
//		boolean isOkB = true;
//		boolean isOkW = true;
		int sum = 0;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}

		if (sum == size*size) {
			AnsB++;
		}else if(sum==0) {
			AnsW++;
		}else {
			int num = size / 2;
			div(idx + 1, r, c, num);
			div(idx + 1, r, c + num, num);
			div(idx + 1, r + num, c, num);
			div(idx + 1, r + num, c + num, num);
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
