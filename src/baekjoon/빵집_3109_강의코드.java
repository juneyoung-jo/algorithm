package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_3109_강의코드 {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1 };
//	static int[] dc = { 1, 1, 1 }; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		makePipe();
		System.out.println(cnt);

//		print(map);

	}

	private static void makePipe() {
		// 0열의 나기부씨 식당의 모든 행의 위치에서 파이프 놓기 시작
		for (int r = 0; r < R; r++) {
			v[r][0] = true;
			go(r, 0);
		}
	}

	// 현 위치에서 오른쪽 대각선 위, 오른쪽 , 오른쪽 대각선 아래 순서적으로 파이프 연결 시도
	private static boolean go(int r, int c) {
		if (c == C - 1) { // 나야나씨 식당까지 파이프가 연결된 상황
			cnt++;
			return true;
		}

		int nr, nc = c + 1;
		for (int k = 0; k < 3; k++) {
			nr = r + dr[k];

			if (nr < 0 || nr >= R || v[nr][nc] || map[nr][nc] == 'x')
				continue;
			v[nr][nc] = true; // 파이프를 놓는 작업
			// 다음 칸으로 이동후 진행 결과가 끝까지 연결이 가능했다면
			// 현위치에서 다른 방향으로 파이프 놓기 시도를 중단하고 이전 위치로 돌아감
			if (go(nr, nc))
				return true;
		}

		return false;

	}

	private static void print(char[][] map) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
