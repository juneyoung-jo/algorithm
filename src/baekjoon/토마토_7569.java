package baekjoon;

import java.io.*;
import java.util.*;

public class 토마토_7569 {

    private static int[] dr = {-1, 1, 0, 0, 0, 0};
    private static int[] dc = {0, 0, -1, 1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, -1, 1};
    private static int M, N, H, result = -1;
    private static int[][][] map;
    private static boolean[][][] v;
    private static Queue<Tomato> q = new LinkedList<>();

    private static class Tomato {
        int h, r, c, cnt;

        public Tomato(int h, int r, int c, int cnt) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        v = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if (map[h][r][c] == 1) {
                        v[h][r][c] = true;
                        q.add(new Tomato(h, r, c, 0));
                    } else if (map[h][r][c] == -1) {
                        v[h][r][c] = true;
                    }
                }
            }
        }

        bfs();
        System.out.println(cal());
    }

    private static int cal() {
        // 모두 익지 않았을 경우
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[h][r][c] == 0) {
                        return -1;
                    }
                }
            }
        }

        // 모두 익었을 경우 계산한 값
        return result;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Tomato now = q.poll();
            result = Math.max(now.cnt, result);

            for (int dir = 0; dir < 6; dir++) {
                int nh = now.h + dh[dir];
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if (nh >= 0 && nr >= 0 && nc >= 0 && nh < H && nr < N && nc < M
                        && map[nh][nr][nc] == 0 // 안 익은 토마토
                        && !v[nh][nr][nc] // 방문 가능한 위치
                ) {
                    map[nh][nr][nc] = 1;
                    q.add(new Tomato(nh, nr, nc, now.cnt + 1));
                }
            }
        }
    }
}
