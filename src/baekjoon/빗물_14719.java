package baekjoon;

import java.io.*;
import java.util.*;

/**
 * link: https://www.acmicpc.net/problem/14719
 */
public class 빗물_14719 {
    private static int H, W;
    private static int[] heights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        heights = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(calTotalAmount());

    }

    /**
     * 1) 양끝점 제외
     * 2) 현재 위치에서 왼쪽에 가장 높은 높이 구하기
     * 3) 현재 위치에서 오른쪽에 가장 높은 높이 구하기
     * 4) 왼쪽,오른쪽중 작은값 - 현재 높이 = 차오르는 물의 양
     */
    private static int calTotalAmount() {
        int result = 0;
        for (int i = 1; i < W - 1; i++) {
            int leftMaxHeight = 0;
            int rightMaxHeight = 0;

            // 왼쪽
            for (int left = 0; left < i; left++) {
                leftMaxHeight = Math.max(leftMaxHeight, heights[left]);
            }

            // 오른쪽
            for (int right = i + 1; right < W; right++) {
                rightMaxHeight = Math.max(rightMaxHeight, heights[right]);
            }

            if (heights[i] < leftMaxHeight && heights[i] < rightMaxHeight) {
                result += Math.min(leftMaxHeight, rightMaxHeight) - heights[i];
            }
        }

        return result;
    }
}
