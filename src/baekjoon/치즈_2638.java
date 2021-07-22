package baekjoon;
import java.util.*;
import java.io.*;

public class 치즈_2638 {
    static int N,M, map[][],time, cheese, count;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static boolean[][] v;
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> hold = new LinkedList<>();
    static class Point{
        int r,c, check;

        public Point(int r,int c,int check) {
            this.r = r;
            this.c = c;
            this.check = check;
        }

        public Point(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        v = new boolean[N+2][M+2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }

        // algo
        v[0][0] = true;
        hold.add(new Point(0,0));
        while(count != cheese) {
            time++;
            meltCheese();
        }

        System.out.println(time);
    }

    public static void meltCheese() {
        while(!hold.isEmpty()) q.add(hold.poll());

        Point p = null;
        while(!q.isEmpty()) {
            p = q.poll();

            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr>= N+2 || nc >= M+2 || v[nr][nc]) continue;
                v[nr][nc] = true;
                if(map[nr][nc] == 1) hold.add(new Point(nr,nc));
                else q.add(new Point(nr,nc));
            }
        }

        while(!hold.isEmpty()){
            p = hold.poll();
            int air = 0;
            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 1 || nc < 1 || nr>= N+1 || nc >= M+1) continue;
                if(map[nr][nc] == 0 && v[nr][nc]) air++;
            }
            if(air >= 2) q.add(new Point(p.r,p.c,1));
            else q.add(new Point(p.r,p.c,0));
        }

        while(!q.isEmpty()){
            p = q.poll();
            if(p.check == 1) {
                count++;
                map[p.r][p.c] = 0;
                hold.add(p);
            } else v[p.r][p.c] = false;
        }
    }
}
