package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 수정이의타일자르기 {

	static int T, N, M;
	static ArrayList<Integer> tile;
	static ArrayList<Point> list;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ans = 1;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			tile = new ArrayList<Integer>();
			list = new ArrayList<Point>();

			list.add(new Point(M, M));

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				tile.add((int) Math.pow(2, Integer.parseInt(st.nextToken())));
			}

			// 내림차순 정렬
			Collections.sort(tile, (o1, o2) -> Integer.compare(o2, o1));

			// 구현
			L: for (Integer tile : tile) {
				// 현재 들어있는 리스트로 해결 가능할 때
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).r >= tile && list.get(i).c >= tile) {
						int nr = list.get(i).r - tile;
						int nc = list.get(i).c - tile;

						if (nr == 0 && nc == 0) {
							list.remove(i);
							continue L;
						} else if (nr == 0 || nc == 0) {
							list.remove(i);
							if (nr == 0) {
								list.add(new Point(tile, nc));
							} else {
								list.add(new Point(nr, tile));
							}
							continue L;
						} else {
							list.add(new Point(nr, list.get(i).c));
							list.add(new Point(list.get(i).r - nr, nc));
							list.remove(i);
							continue L;
						}

					}
				}

				// 해결이 안되면 새로운 종이 꺼내서 잘라야함.
				ans++;
				int nr = M - tile;
				int nc = M - tile;

				if (nr == 0 && nc == 0) {
					continue L;
				} else if (nr == 0 || nc == 0) {
					if (nr == 0) {
						list.add(new Point(tile, nc));
					} else {
						list.add(new Point(nr, tile));
					}
					continue L;
				} else {
					list.add(new Point(nr, M));
					list.add(new Point(M - nr, nc));
					continue L;
				}
			}

			System.out.printf("#%d %d\n", tc, ans);
		}

	}

}
