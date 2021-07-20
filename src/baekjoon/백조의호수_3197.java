package baekjoon;
import java.util.*;
import java.io.*;

public class 백조의호수_3197 {
    static int R,C,ans, resultR, resultC;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static char[][] map;
    static boolean[][] iceV;
    static boolean[][] swanV;
    static boolean check;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> holdQ = new LinkedList<>();
    static Queue<Point> swanQ = new LinkedList<>();
    static Queue<Point> holdSwan = new LinkedList<>();
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
        iceV = new boolean[R][C];
        swanV = new boolean[R][C];

        for(int i =0 ; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '.' || map[i][j] == 'L') {
                    iceV[i][j] = true;
                    holdQ.add(new Point(i,j));
                }
                if (map[i][j] == 'L' && holdSwan.size() == 0) {
                    swanV[i][j] = true;
                    holdSwan.add(new Point(i,j));
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
            iceGo();
        }

        System.out.println(ans);

    }

    public static void iceGo() {
        q.clear();
        q.addAll(holdQ);
        holdQ.clear();

        Point p  = null;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int k = 0; k < 4; k++) {

                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C || iceV[nr][nc]) continue;
                if(map[nr][nc] == 'X') {
                    iceV[nr][nc] = true;
                    map[nr][nc]  = '.';
                    holdQ.add(new Point(nr,nc));
                }

            }
        }

    }

    public static void swanGo() {
        swanQ.clear();
        swanQ.addAll(holdSwan);
        holdSwan.clear();

        Point p = null;
        while(!swanQ.isEmpty()) {
            p = swanQ.poll();

            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C || swanV[nr][nc]) continue;

                if(map[nr][nc] == '.') {
                    swanV[nr][nc] = true;
                    swanQ.add(new Point(nr,nc));
                }else if(map[nr][nc] == 'X') {
                    swanV[nr][nc] =true;
                    holdSwan.add(new Point(nr,nc));
                }else if(nr == resultR && nc == resultC) {
                    check = true;
                    return;
                }
            }
        }
    }
}
