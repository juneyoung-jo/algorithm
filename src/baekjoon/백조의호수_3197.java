package baekjoon;
import java.util.*;
import java.io.*;

public class 백조의호수_3197 {
    static int R,C,ans, resultR, resultC;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] v;
    static boolean check;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> iceQ = new LinkedList<>();
    static Queue<Point> swanQ = new LinkedList<>();
    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        v = new boolean[R][C];

        for(int i =0 ; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '.' || map[i][j] == 'L') {
                    iceQ.add(new Point(i,j));
                }
                if (map[i][j] == 'L' && swanQ.size() == 0) {
                    v[i][j] = true;
                    swanQ.add(new Point(i,j));
                }
                if (map[i][j] == 'L' ) {
                    resultR = i;
                    resultC = j;
                }

            }
        }

        while(true) {
            swanGo();
            if(check) break;
            ans++;
            melt();
        }

        System.out.println(ans);

    }

    public static void melt() {
        while(!iceQ.isEmpty()) q.add(iceQ.poll());

        Point p  = null;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int k = 0; k < 4; k++) {

                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(map[nr][nc] == 'X') {
                    map[nr][nc]  = '.';
                    iceQ.add(new Point(nr,nc));
                }

            }
        }

    }

    public static void swanGo() {
        while(!swanQ.isEmpty()) q.add(swanQ.poll());

        Point p = null;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C || v[nr][nc]) continue;

                if(map[nr][nc] == '.') {
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc));
                }else if(map[nr][nc] == 'X') {
                    v[nr][nc] =true;
                    swanQ.add(new Point(nr,nc));
                }else if(nr == resultR && nc == resultC) {
                    check = true;
                    return;
                }
            }
        }
    }
}
