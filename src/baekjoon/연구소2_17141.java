package baekjoon;

import java.io.*;
import java.util.*;

public class 연구소2_17141 {
    static int N, M, result, safeCnt;
    static int[][] array;
    static List<Point> safe;
    static Point[] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();

    public static class Point {
        int x, y, cnt = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][N];
        safe = new ArrayList<>();
        arr = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if (array[i][j] == 2) {
                    safe.add(new Point(i, j));
                    safeCnt += 1;
                } else if (array[i][j] == 0) {
                    safeCnt += 1;
                }
            }
        }

        result = Integer.MAX_VALUE;
        comb(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
    }

    private static void comb(int idx, int start) {
        if (idx == M) {
            // 바이러스 바이러스 위치 체크
            result = Math.min(result, bfs());
            return;
        }

        for (int i = start; i < safe.size(); i++) {
            arr[idx] = safe.get(i);
            comb(idx + 1, i + 1);
        }
    }

    private static int bfs() {
        visited = new boolean[N][N];
        int count = 0;
        int maxTime = 0;

        for (Point point : arr) {
            q.add(point);
            visited[point.x][point.y] = true;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            count++;
            if (maxTime < p.cnt) maxTime = p.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny] && array[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, p.cnt + 1));
                    }
                }
            }
        }

        if (count == safeCnt) return maxTime;
        return Integer.MAX_VALUE;
    }
}
