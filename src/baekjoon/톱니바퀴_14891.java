package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 톱니바퀴_14891 {
    private static int[][] gears = new int[5][8];
    private static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                gears[i][j] = temp.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());

    }

}
