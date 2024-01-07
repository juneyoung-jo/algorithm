package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    /**
     * 입력:
     * 2
     * 10 8 17
     * 0 0
     * 1 0
     * 1 1
     * 4 2
     * 4 3
     * 4 5
     * 2 4
     * 3 4
     * 7 4
     * 8 4
     * 9 4
     * 7 5
     * 8 5
     * 9 5
     * 7 6
     * 8 6
     * 9 6
     * 10 10 1
     * 5 5
     * <p>
     * 출력
     * 5
     * 1
     */
    private static int T, M, N, K;
    private static boolean[][] map;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];

            // map 초기화
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = true; // 배추 심어 놓은 곳
            }

            // 정답
            System.out.println(cal());
        }
    }

    private static int cal() {
        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c]) {
                    dfs(r, c);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(int row, int col) {
        map[row][col] = false;
        for (int dir = 0; dir < 4; dir++) {
            int nr = row + dr[dir];
            int nc = col + dc[dir];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M
                    && map[nr][nc])
                dfs(nr, nc);
        }
    }
}
