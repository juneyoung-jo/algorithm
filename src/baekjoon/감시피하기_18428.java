package baekjoon;

import java.io.*;
import java.util.*;

public class 감시피하기_18428 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static char[][] map;
    static ArrayList<Point> tr;
    static Point[] list = new Point[3];
    static boolean result;

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        tr = new ArrayList<>();
        ArrayList<Point> sd = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') tr.add(new Point(i, j));
                else if (map[i][j] == 'X') sd.add(new Point(i, j));
            }
        }

        combination(sd, 0, 0);

        System.out.println(result ? "YES" : "NO");

    }

    private static boolean move() {
        for (int k = 0; k < tr.size(); k++) {
            for (int i = 0; i < 4; i++) {
                int row = tr.get(k).x;
                int col = tr.get(k).y;
                while (true) {
                    row += dx[i];
                    col += dy[i];
                    if (0 <= row && row < n && 0 <= col && col < n) {
                        if (map[row][col] == 'S') return false;
                        else if (map[row][col] == 'O') break;
                    } else break;
                }
            }
        }

        return true;

    }

    static void combination(ArrayList<Point> array, int idx, int start) {
        if (result) return;
        if (idx == 3) {
            for (Point p : list) {
                map[p.x][p.y] = 'O';
            }

            if (move()) result = true;

            for (Point p : list) {
                map[p.x][p.y] = 'X';
            }

            return;
        }

        for (int i = start; i < array.size(); i++) {
            list[idx] = array.get(i);
            combination(array, idx + 1, i + 1);
        }
    }
}
