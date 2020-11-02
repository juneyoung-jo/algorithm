package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전_강의코드 {
	static int[] dx = { 0, 0, 1, 0, -1 };
    static int[] dy = { 0, -1, 0, 1, 0 };
    static int M, aCnt;
    static int[] pathA, pathB, playerA, playerB;
    static int[][] ap;
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = gifs(in.readLine());
        
        
        StringTokenizer st = null;
        playerA = new int[2];
        playerB = new int[2];
        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(in.readLine());
            M = gifs(st.nextToken());
            aCnt = gifs(st.nextToken());
 
            // 두 플레이어의 초기 위치
            playerA[0] = playerA[1] = 1;
            playerB[0] = playerB[1] = 10;
            ap = new int[aCnt][4];
 
            pathA = new int[M + 1]; // 0초 즉, 처음 출발위치에서도 처리 가능하도록 M+1
            pathB = new int[M + 1];
 
            String charsA = in.readLine();
            String charsB = in.readLine();
 
            for (int c = 0; c < M; c++) {
                pathA[c + 1] = charsA.charAt(c * 2) - '0';
                pathB[c + 1] = charsB.charAt(c * 2) - '0';
            }
 
            for (int a = 0; a < aCnt; a++) {
                st = new StringTokenizer(in.readLine(), " ");
                ap[a][0] = gifs(st.nextToken());
                ap[a][1] = gifs(st.nextToken());
                ap[a][2] = gifs(st.nextToken());
                ap[a][3] = gifs(st.nextToken());
            }
 
            System.out.println("#" + t + " " + move());
        } // end TC
    }// end main
 
    private static int move() { // 매시간마다 두 플레이어 충전량의 합의 최대값 구하고 모든 시간동안 누적
        int totalSum = 0;
        int time = 0;
        while (time <= M) {
            // 두 플레이어를 해당 시간의 이동정보에 맞게 이동
            playerA[0] += dx[pathA[time]];
            playerA[1] += dy[pathA[time]];
            playerB[0] += dx[pathB[time]];
            playerB[1] += dy[pathB[time]];
 
            totalSum += getCharge();
            ++time;
        }
        return totalSum;
    }
 
    // 중복 순열
    private static int getCharge() {
        int max = 0;
        for (int a = 0; a < aCnt; a++) { // 플레이어 A의 충전소
            for (int b = 0; b < aCnt; b++) { // 플레이어 B의 충전소
                int sum = 0;
                int amountA = check(a, playerA[0], playerA[1]);
                int amountB = check(b, playerB[0], playerB[1]);
                if(a != b) sum = amountA + amountB;
                else       sum = Math.max(amountA, amountB);
                if(max < sum) max = sum;
            }
        }
        return max;
    }
 
    // x, y좌표에서 a충전소에 충전이 가능한지 판단하여 충전가능하다면 충전량 리턴, 아니면 0 리턴
    private static int check(int a, int x, int y) {
        return Math.abs(ap[a][0] - x) + Math.abs(ap[a][1] - y) <= ap[a][2] ? ap[a][3] : 0;
    }
 
    private static int gifs(String s) {
        return Integer.parseInt(s);
    }
}
