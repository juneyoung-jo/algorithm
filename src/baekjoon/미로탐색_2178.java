package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

    /**
     * 입력:
     * 4 6
     * 101111
     * 101010
     * 101011
     * 111011
     * <p>
     * 출력:
     * 15
     */
    private static int N, M;
    private static boolean[][] maze; // 미로 && 방문배열
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};

    private static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String cols = br.readLine();
            for (int c = 0; c < M; c++) {
                maze[r][c] = cols.charAt(c) == '0';
            }
        }

        System.out.println(cal());
    }

    private static int cal() {
        // bfs
        Queue<Point> q = new LinkedList<>();
        int result = Integer.MAX_VALUE;

        // 시작 지점
        maze[0][0] = true;
        q.add(new Point(0, 0, 1));

        while (!q.isEmpty()) {
            Point now = q.poll();
            // 결승 지점인 경우
            if (now.r == N - 1 && now.c == M - 1) {
                result = Math.min(result, now.cnt);
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M
                        && !maze[nr][nc]) {
                    maze[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }

        return result;
    }
}
