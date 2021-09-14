package programmers;

public class 도둑질 {
    public int solution(int[] money) {
        int size = money.length;
        int[][] dp = new int[2][money.length];

        dp[0][1] = dp[0][0] = money[0];
        dp[1][1] = money[1];
        for(int i = 2; i < size; i++) {
            dp[0][i] = Math.max(dp[0][i-2] + money[i], dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2] + money[i], dp[1][i-1]);
        }

        return Math.max(dp[0][size-2],dp[1][size-1]);
    }
}
