package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 프로세서연결하기_강의코드 {

	public static int map[][], N, max, min, totalCnt;
	public static ArrayList<int[]> list;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>(); // 처리해야할 가장자리가 아닌 코어들을 저장할 리스트
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					// 가장 자리에 있지 않은 코어 리스트에 추가
					if ((i == 0 || j == 0 || i == N - 1 || j == N - 1) && map[i][j] == 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			} // end input
			go(0, 0);
			System.out.printf("#%d %d\n", tc, min);

		} // end TC

	}// end Main

	private static void go(int idx, int cCnt) { // idx : 처리할 코어의 idx, cCnt : 직전까지 포함된 코어수
		if (idx == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이를 계산
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) { // 최대 코어개수가 같다면 최소길이의 전선으로.
				if (min > res) {
					min = res;
				}
			}

			return;
		}

		int[] cur = list.get(idx);
		int r = cur[0];
		int c = cur[1];
		// 해당 코어 선택
		// 4방향의 직선으로 전선 놓아보는 시도
		for (int k = 0; k < 4; k++) {
			// 해당 방향으로 전선 놓는게 가능한지 체크
			if (isAvailable(r, c, k)) {
				// 가능하다면 전선 놓기 : 멕시노스 판에 2로 세팅
				setStatus(r, c, k, 2);
				// 다음 코어로 넘어가기
				go(idx + 1, cCnt + 1);
				// 놓았던 공간 지우기(되돌리기) : 멕시노스 판에 0으로 세팅
				setStatus(r, c, k, 0);
			}
		}

		// 해당 코어 비선택
		// 아무런 전선도 놓지 않고 다음 코어로 넘어가기
		go(idx + 1, cCnt);
	}

	// 현 코어의 위치에서 해당 방향으로 전선을 놓는게 가능한지 체크
	private static boolean isAvailable(int r, int c, int k) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[k];
			nc += dc[k];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break; // 가장자리까지 전선을 다 놓을수 있는 상황
			if (map[nr][nc] >= 1)
				return false; // 1: 코어 2: 전선

		}
		return true;
	}

	// 현 코어의 위치에서 해당방향으로 전선을 놓거나 지우는 세팅
	private static void setStatus(int r, int c, int k, int s) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[k];
			nc += dc[k];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;
			map[nr][nc] = s;
		}

	}

	private static int getLength() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 2)
					cnt++;
			}
		}

		return cnt;
	}

}
