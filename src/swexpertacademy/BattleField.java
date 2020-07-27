package swexpertacademy;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BattleField {
	static int T, H, W, r, c, N;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		// System.setIn(new FileInputStream("building.txt"));
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];
			for (int i = 0; i < H; i++) { // map 만들기
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (str.charAt(j) == '<' || str.charAt(j) == '>' || str.charAt(j) == '^' || str.charAt(j) == 'v') {
						r = i;
						c = j;
					}
				}
			}

			N = sc.nextInt();
			String st = sc.next();

			for (int i = 0; i < N; i++) { // 명령 횟수만큼 반복
				char order = st.charAt(i);
				int nr, nc;

				switch (order) {
				case 'U':
					nr = r + dr[0];
					nc = c + dc[0];
					map[r][c] = '^';
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) { // 테투리 체크
						if (map[nr][nc] == '.') {
							map[r][c] = '.';
							map[nr][nc] = '^';
							r = nr;
							c = nc;
						}

					}

					break;
				case 'D':
					nr = r + dr[1];
					nc = c + dc[1];
					map[r][c] = 'v';
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) { // 테투리 체크
						if (map[nr][nc] == '.') {
							map[r][c] = '.';
							map[nr][nc] = 'v';
							r = nr;
							c = nc;
						}
						
					}

					break;
				case 'L':
					nr = r + dr[2];
					nc = c + dc[2];
					map[r][c] = '<';
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) { // 테투리 체크
						if (map[nr][nc] == '.') {
							map[r][c] = '.';
							map[nr][nc] = '<';
							r = nr;
							c = nc;
						}
						
					}

					break;
				case 'R':
					nr = r + dr[3];
					nc = c + dc[3];
					map[r][c] = '>';
					if (nr >= 0 && nr < H && nc >= 0 && nc < W) { // 테투리 체크
						if (map[nr][nc] == '.') {
							map[r][c] = '.';
							map[nr][nc] = '>';
							r = nr;
							c = nc;
						}
					}

					break;
				case 'S':
					if (map[r][c] == '^') {
						for (int j = r - 1; j >= 0; j--) {
							if (map[j][c] == '#') {
								break;
							}
							if (map[j][c] == '*') {
								map[j][c] = '.';
								break;
							}
						}
					} else if (map[r][c] == 'v') {
						for (int j = r + 1; j < H; j++) {
							if (map[j][c] == '#') {
								break;
							}
							if (map[j][c] == '*') {
								map[j][c] = '.';
								break;
							}
						}

					} else if (map[r][c] == '<') {
						for (int j = c - 1; j >= 0; j--) {
							if (map[r][j] == '#') {
								break;
							}
							if (map[r][j] == '*') {
								map[r][j] = '.';
								break;
							}
						}
					} else if (map[r][c] == '>') {
						for (int j = c + 1; j < W; j++) {
							if (map[r][j] == '#') {
								break;
							}
							if (map[r][j] == '*') {
								map[r][j] = '.';
								break;
							}
						}
					}

					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
