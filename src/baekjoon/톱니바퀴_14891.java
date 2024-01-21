package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
    private static int[][] gears = new int[5][8];
    private static int K;
    private static Queue<Point> q = new LinkedList<>();

    private static class Point {
        int gear, dir;

        public Point(int gear, int dir) {
            this.gear = gear;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                gears[i][j] = temp.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            cal(gear, dir);
        }

        System.out.println(calResult());
    }

    // 1, 2 <-> 2, 6
    // 2, 2 <-> 3, 6
    // 3, 2 <-> 4, 6
    private static void cal(int gear, int dir) {
        q.clear(); // 재사용을 위한 초기화
        q.add(new Point(gear, dir)); // 현재 톱니바퀴
        // 양옆 체크
        int tempDir = dir; // 이동할 톱니바퀴의 방향을 결정하는 변수
        for (int i = gear; i > 0; i--) { // 왼쪽 체크
            tempDir = tempDir * -1;
            if (gears[i][6] == gears[i - 1][2]) break;
            q.add(new Point(i - 1, tempDir));
        }

        tempDir = dir;
        for (int i = gear; i < 4; i++) { // 오른쪽 체크
            tempDir = tempDir * -1;
            if (gears[i][2] == gears[i + 1][6]) break;
            q.add(new Point(i + 1, tempDir));
        }

        while (!q.isEmpty()) {
            Point current = q.poll();
            moveGear(current.gear, current.dir);
        }
    }

    private static void moveGear(int gear, int dir) {
        if (dir == 1) { // 시계 방향
            int temp = gears[gear][7];
            for (int i = 7; i > 0; i--) {
                gears[gear][i] = gears[gear][i - 1];
            }
            gears[gear][0] = temp;
        } else { // 반시계 방향
            int temp = gears[gear][0];
            for (int i = 0; i < 7; i++) {
                gears[gear][i] = gears[gear][i + 1];
            }
            gears[gear][7] = temp;
        }
    }

    /**
     * 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
     * 2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
     * 3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
     * 4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
     */
    private static int calResult() {
        int result = 0;
        if (gears[1][0] == 1) result += 1;
        if (gears[2][0] == 1) result += 2;
        if (gears[3][0] == 1) result += 4;
        if (gears[4][0] == 1) result += 8;
        return result;
    }

}
