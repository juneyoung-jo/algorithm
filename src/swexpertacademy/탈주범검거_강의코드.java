package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 탈주범검거_강의코드 {
    private static int N, M, R, C, L;
    private static int[][] map, visited;
    //상좌우하 : 0123
    static String[] type = {
            null,
            "0312", //1
            "03", //2
            "12", //3
            "02", //4
            "32", //5
            "31", //6
            "01" //7
    };
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            map = new int[N][M];        
            visited = new int[N][M];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }
             
            dfs(R,C,1);     
            System.out.println("#" + t + " "+getCount());
        }
    }
 
    private static void dfs(int r, int c, int time) {
        visited[r][c] = time;
        if(time == L) return;
         
        String info = type[map[r][c]]; //03
        int dir,nr,nc;
        for (int d = 0; d < info.length(); d++) {
            dir = info.charAt(d)-'0';
            nr = r + dr[dir];
            nc = c + dc[dir];
            if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=0
                    && type[map[nr][nc]].contains(Integer.toString(3-dir)) 
                    && visited[nr][nc] > time
                    ){
                 
                dfs(nr,nc,time+1);
            }
        }
    }
 
    private static int getCount() { //시간동안 지나온 모든 위치개수 카운트
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] != Integer.MAX_VALUE) ++count;
            }
        }
        return count;
    }
}