package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 활주로건설2 {
	static int T, N, X, map[][], map2[][], cnt;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			map2= new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map[i][j];
				}
			}

			// 알고리즘
			// 행 열 나눠서 계산
			// 행
			cnt = 0;
			cal(map);
			cal(map2);
			
			System.out.printf("#%d %d\n", tc, cnt);

		}

	}

	private static void cal(int[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			boolean isOk = false;
			v = new boolean[N]; // 중복검사
			for (int j = 0; j < map[i].length - 1; j++) {
				// 길이가 2이상 차이나면 다음 행or 열로 넘어감
				if (map[i][j] - map[i][j + 1] > 1 || map[i][j] - map[i][j + 1] < -1) {
					break;
				}
				// 길이가 1차이일 때
				if (map[i][j] - map[i][j + 1] == 1) {
					for (int k = 1; k <= X; k++) {
						if (j + k >= N) {
							isOk = true;
							break;
						}
						// 이미 활주로가 놓여져있으면 끝내기
						if (v[j + k]) {
							isOk = true;
							break;
						}
						v[j + k] = true;
					}

				}

				// 길이가 -1차이일 때
				if (map[i][j] - map[i][j + 1] == -1) {
					for (int k = 0; k < X; k++) {
						if (j - k < 0) {
							isOk = true;
							break;
						}
						if (v[j - k]) {
							isOk = true;
							break;
						}
						v[j - k] = true;
					}

				}

				if (isOk) {
					break;
				}
				if (j == N - 2) {
					cnt++;
				}
			}
		}
		
	}

}
