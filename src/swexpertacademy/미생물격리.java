package swexpertacademy;

import java.io.*;
import java.util.*;

public class 미생물격리 {
    static int T, N, M, K, map[][][];
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static Queue<Point> q = new LinkedList<Point>();

    static class Point {
        int r, c, val, dir;

        public Point(int r, int c, int val, int dir) {
            this.r = r;
            this.c = c;
            this.val = val;
            this.dir = dir;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 배열
            M = Integer.parseInt(st.nextToken()); // 이동 시간
            K = Integer.parseInt(st.nextToken()); // 군집 개수
            q.clear();

            map = new int[N][N][3];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                q.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for (int idx = 0; idx < M; idx++) {
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    int nr = p.r + dr[p.dir];
                    int nc = p.c + dc[p.dir];

                    // 가장자리
                    if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                        map[nr][nc][0] = p.val / 2;
                        if (p.dir == 1) map[nr][nc][1] = 2;
                        else if (p.dir == 2) map[nr][nc][1] = 1;
                        else if (p.dir == 3) map[nr][nc][1] = 4;
                        else if (p.dir == 4) map[nr][nc][1] = 3;
                        continue;
                    }

                    // 같은 공간에 들어갈 경우
                    if (map[nr][nc][0] != 0) {
                        if (map[nr][nc][2] < p.val) { // [][][2] 방향을 정하는 기준이 됨.
                            map[nr][nc][1] = p.dir;
                            map[nr][nc][2] = p.val;
                        }
                        map[nr][nc][0] += p.val;
                        continue;
                    }

                    map[nr][nc][0] = p.val;
                    map[nr][nc][1] = p.dir;
                    map[nr][nc][2] = p.val;

                }

                // 다시 큐에 저장
                for (int r = 0; r < N; r++)
                    for (int c = 0; c < N; c++)
                        if (map[r][c][0] > 0) q.add(new Point(r, c, map[r][c][0], map[r][c][1]));

                // 맵 초기화
                if (idx == M - 1) break;
                clearMap();
            }
            System.out.printf("#%d %d\n", tc, cal());
        }
    }

    private static void clearMap() {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                for (int k = 0; k < 3; k++)
                    map[i][j][k] = 0;
    }

    private static int cal() {
        int result = 0;
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                result += map[i][j][0];

        return result;
    }

}
