package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 탈옥_9376 {
    static int T, h, w, ans, v[][][];
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] map;
    static Point[] pList = new Point[2];
    static PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            v = new int[4][h + 2][w + 2]; // 0. 나, 1. A->B, 2. B -> A, 3. answer
            int pCount = 0;
            for (int i = 1; i <= h; i++) {
                String str = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = str.charAt(j - 1);
                    if (map[i][j] == '$') pList[pCount++] = new Point(i, j, 0);
                }
            }

            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    Arrays.fill(v[i][j], -1);
                }
            }

            // algo
            cal(new Point(0, 0, 0), 0);
            cal(pList[0], 1);
            cal(pList[1], 2);

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < v[0].length; i++) {
                for (int j = 0; j < v[0][i].length; j++) {
                    v[3][i][j] = v[0][i][j] + v[1][i][j] + v[2][i][j];
                    if (map[i][j] == '#') v[3][i][j] -= 2;
                    if(v[3][i][j] >= 0 && ans > v[3][i][j]) ans = v[3][i][j];
                }
            }

            System.out.println(ans);

        }
    }

    public static void cal(Point start, int idx) {
        v[idx][start.r][start.c] = start.cnt;
        q.add(start);

        Point p = null;
        while (!q.isEmpty()) {
            p = q.poll();

            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if (nr < 0 || nc < 0 || nr >= h + 2 || nc >= w + 2 || v[idx][nr][nc] != -1 || map[nr][nc] == '*') continue;
                if (map[nr][nc] == '#') {
                    v[idx][nr][nc] = p.cnt + 1;
                    q.add(new Point(nr, nc, p.cnt + 1));
                } else {
                    v[idx][nr][nc] = p.cnt;
                    q.add(new Point(nr, nc, p.cnt));
                }
            }
        }

    }
}
