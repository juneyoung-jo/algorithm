package programmers;
import java.util.*;

public class 카드짝맞추기_2021KAKAO_BLIND_REC {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static Queue<Point> q = new LinkedList<>();
    static int count, arr[], answer, map[][];
    static boolean flag[], v[][];
    static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] board, int r, int c) {
        map = new int[4][4];
        v = new boolean[4][4];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] != 0) count = Math.max(count,board[i][j]);
            }
        }

        arr = new int[count];
        flag = new boolean[count + 1];

        permutation(0, board, r, c);

        return answer;
    }

    public static Point cal(int r, int c, int card) {
        q.clear();
        int result = 0;
        v[r][c] = true;
        q.add(new Point(r,c,0));
        Point p = null;

        // 1
        while(!q.isEmpty()) {
            p = q.poll();

            if(map[p.r][p.c] == card) {
                result = p.cnt+1;
                map[p.r][p.c] = 0;
                break;
            }

            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(new Point(nr,nc,p.cnt+1));

                if(map[nr][nc] != 0) continue;
                while(true) {
                    nr+= dr[k];
                    nc+= dc[k];
                    if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) {
                        nr -= dr[k];
                        nc -= dc[k];
                        v[nr][nc] = true;
                        q.add(new Point(nr,nc,p.cnt+1));
                        break;
                    };
                    if(map[nr][nc] == 0) continue;
                    if(v[nr][nc]) continue;
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc,p.cnt+1));
                }
            }
        }
        System.out.println("result1 : " + result + " : " + card);
        // 2 짝 맞추기
        q.clear();
        clearV();
        v[p.r][p.c] = true;
        q.add(new Point(p.r,p.c,0));
        while(!q.isEmpty()) {
            p = q.poll();
            // System.out.println(p.r + " : " + p.c + " : " + p.cnt);
            if(map[p.r][p.c] == card) {
                result += (p.cnt +1);
                map[p.r][p.c] = 0;
                break;
            }

            for(int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4 || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(new Point(nr,nc,p.cnt+1));

                if(map[nr][nc] != 0) continue;
                while(true) {
                    nr+= dr[k];
                    nc+= dc[k];
                    if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) {
                        nr -= dr[k];
                        nc -= dc[k];
                        v[nr][nc] = true;
                        q.add(new Point(nr,nc,p.cnt+1));
                        break;
                    };
                    if(map[nr][nc] == 0) continue;
                    if(v[nr][nc]) continue;
                    v[nr][nc] = true;
                    q.add(new Point(nr,nc,p.cnt+1));
                }
            }
        }
        System.out.println("result2 : " + result);
        Point resultP = new Point(p.r,p.c,result);
        return resultP;
    }


    public static void permutation(int idx, int[][] board,int r, int c) {
        if(idx == count) {
            int result = 0;
            copyBoard(board); // 보드 초기화
            int row = r;
            int col = c;
            for(Integer card : arr) {
                clearV();
                Point p = cal(row,col,card);
                result += p.cnt;
                row = p.r;
                col = p.c;
                if(result > answer) return;
            }
            System.out.println(result);
            answer = Math.min(answer,result);
            return;
        }

        for(int i = 1; i <= count; i++) {
            if(flag[i]) continue;
            arr[idx] = i;
            flag[i] = true;
            permutation(idx+1, board, r, c);
            flag[i] = false;
        }
    }

    public static void clearV(){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                v[i][j] = false;
            }
        }
    }

    public static void copyBoard(int[][] board){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                map[i][j] = board[i][j];
            }
        }
    }
}