package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 추억의2048게임 {
	static int T, N, map[][];
	static String S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (S) {
			case "up":
				upCal();
				break;

			case "down":
				downCal();
				break;
				
			case "left":
				leftCal();
				break;
				
			case "right":
				rightCal();
				break;

			default:
				break;
			}
			System.out.printf("#%d\n",tc);
			print(map);

		}

	}

	private static void rightCal() {
		boolean[][] v = new boolean[N][N];

		for (int i = N-1; i >= 0; i--) {
			for (int c = 0; c < N; c++) {
				if (v[c][i])
					continue;
				for (int r = i - 1; r >= 0; r--) {
					if (map[c][r] == 0)
						continue;
					if (map[c][i] != map[c][r])
						break;
					map[c][i] *= 2;
					map[c][r] = 0;
					v[c][r] = true;
					break;
				}
			}
		}
		

		int start = 0;
		for (int c = 0; c < N; c++) {
			int[] arr = new int[N];
			for (int r = N-1; r >= 0; r--) {
				if (map[c][r] != 0) {
					arr[start++] = map[c][r];
				}
			}
			for (int r = 0; r < N; r++) {
				map[c][N-r-1] = arr[r];
			}
			start = 0;
		}
	}

	private static void leftCal() {
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int c = 0; c < N; c++) {
				if (v[c][i])
					continue;
				for (int r = i + 1; r < N; r++) {
					if (map[c][r] == 0)
						continue;
					if (map[c][i] != map[c][r])
						break;
					map[c][i] *= 2;
					map[c][r] = 0;
					v[c][r] = true;
					break;
				}
			}
		}

		int start = 0;
		for (int c = 0; c < map.length; c++) {
			int[] arr = new int[N];
			for (int r = 0; r < map.length; r++) {
				if (map[c][r] != 0) {
					arr[start++] = map[c][r];
				}
			}

			for (int r = 0; r < N; r++) {
				map[c][r] = arr[r];
			}
			start = 0;
		}
		
		
	}

	private static void downCal() {
		boolean[][] v = new boolean[N][N];

		for (int i = N-1; i >= 0; i--) {
			for (int c = 0; c < N; c++) {
				if (v[i][c])
					continue;
				for (int r = i - 1; r >= 0; r--) {
					if (map[r][c] == 0)
						continue;
					if (map[i][c] != map[r][c])
						break;
					map[i][c] *= 2;
					map[r][c] = 0;
					v[r][c] = true;
					break;
				}
			}
		}
		

		int start = 0;
		for (int c = 0; c < N; c++) {
			int[] arr = new int[N];
			for (int r = N-1; r >= 0; r--) {
				if (map[r][c] != 0) {
					arr[start++] = map[r][c];
				}
			}
			for (int r = 0; r < N; r++) {
				map[N-r-1][c] = arr[r];
			}
			start = 0;
		}
	}

	private static void upCal() {
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int c = 0; c < N; c++) {
				if (v[i][c])
					continue;
				for (int r = i + 1; r < N; r++) {
					if (map[r][c] == 0)
						continue;
					if (map[i][c] != map[r][c])
						break;
					map[i][c] *= 2;
					map[r][c] = 0;
					v[r][c] = true;
					break;
				}
			}
		}

		
		
		int start = 0;
		for (int c = 0; c < map.length; c++) {
			int[] arr = new int[N];
			for (int r = 0; r < map.length; r++) {
				if (map[r][c] != 0) {
					arr[start++] = map[r][c];
				}
			}

			for (int r = 0; r < N; r++) {
				map[r][c] = arr[r];
			}
			start = 0;
		}

	}

	private static void print(int[][] map2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
