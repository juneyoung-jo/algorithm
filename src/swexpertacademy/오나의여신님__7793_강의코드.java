package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */
public class 오나의여신님__7793_강의코드 {

	static int N, M;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> dQueue, sQueue;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			dQueue = new LinkedList<int[]>();
			sQueue = new LinkedList<int[]>();

			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						// 수연이는 'S'로 자신의 visit을 관리할 예정
						sQueue.offer(new int[] { i, j });
					} else if (map[i][j] == '*') {
						// 악마는 '*'로 자신의 visit을 관리할 예정
						dQueue.offer(new int[] { i, j });
					}
				}
			}

			System.out.println("#" + t + " " + bfs());

		}
	}

	private static String bfs() {

		int dSize, sSize, nr, nc, cnt = 0, result = -1;
		int[] dCur, sCur;

		L: while (true) {
			++cnt; // 큐에서 나오는 애들이 확장될 시간
			// 악마
			dSize = dQueue.size(); // 현재 dQueue에 들어있는 큐의 크기가 같은 시간에 이동할 악마들의 이동좌표의 개수임.
			while (dSize-- > 0) {
				dCur = dQueue.poll();
				for (int d = 0; d < 4; d++) {
					nr = dCur[0] + dr[d];
					nc = dCur[1] + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '.') { // 경계 벗어나지 않고 평범한 지역일때만 감(수연이가
																						// 이미 지나간 위치나 자신이 이미 지나온 위치나
																						// 돌맹이나 여신위치는 안감)
																						// 수연이가 이미 지나간 위치는 악마가 가봤자 더 늦은
																						// 시간에 가므로 의미없음.
						map[nr][nc] = '*'; // 자신의 흔적을 표시(visited 처리 효과)
						dQueue.offer(new int[] { nr, nc });
					}
				}
			}

			// 수연
			sSize = sQueue.size(); // 현재 sQueue에 들어있는 큐의 크기가 같은 시간에 이동할 수연이의 이동 좌표 개수임.
			if (sSize == 0)
				break; // 이동할 수연이의 위치가 없다면 여신의 위치까지 도달할 수 없으므로 끝냄.
			while (sSize-- > 0) {
				sCur = sQueue.poll();
				for (int d = 0; d < 4; d++) {
					nr = sCur[0] + dr[d];
					nc = sCur[1] + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {// 경계 벗어나지 않고
						// 평범한 지역이나 여신의 위치만 감(악마가 이미 지나간 위치나 자신이 이미 지나온 위치나 돌맹이는 안감)
						if (map[nr][nc] == '.') {
							map[nr][nc] = 'S'; // 자신의 흔적을 표시(visited 처리 효과)
							sQueue.offer(new int[] { nr, nc });
						} else if (map[nr][nc] == 'D') {// 여신의 위치에 도착하면 끝냄.
							result = cnt;
							break L;
						}
					}
				}
			}

		}

		return result > -1 ? Integer.toString(result) : "GAME OVER";

	}

}
