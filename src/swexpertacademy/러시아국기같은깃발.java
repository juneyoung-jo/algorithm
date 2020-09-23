package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {
	static int T, N, M, cnt = Integer.MAX_VALUE, wcount,rcount,bcount;
	static char map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			wcount = 0;
			for (int w = 0; w < map.length - 2; w++) {
				for (int i = 0; i < M; i++) {
					if (map[w][i] != 'W') {
						++wcount;
					}
				}
				bcount = 0;
				for (int b = w + 1; b < map.length - 1; b++) {
					for (int i = 0; i < M; i++) {
						if (map[b][i] != 'B') {
							++bcount;
						}
					}
					rcount = 0;
					for (int r = b + 1; r < map.length; r++) {
						for (int i = 0; i < M; i++) {
							if (map[r][i] != 'R') {
								++rcount;
							}
						}
					}
					cnt = Math.min(cnt, wcount + bcount + rcount);
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
			cnt = Integer.MAX_VALUE;
//			print(map);
		}

	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();

		}
	}

}
