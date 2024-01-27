package baekjoon;

import java.util.Scanner;

public class 영만들기_7490 {

    private static char[] signs = {' ', '+', '-'};
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            dfs(1, n, "");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int end, String acc) {
        acc += start;
        if (start == end) {
            if (isZero(acc.replace(" ", ""))) {
                sb.append(acc).append("\n");
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            dfs(start + 1, end, acc + signs[i]);
        }
    }

    // TODO: 구현부 다른방법으로 시도해볼 것 - 240128
    private static boolean isZero(String expression) {
        String[] operands = expression.split("[+-]");
        String[] operators = expression.split("[0-9]+");

        int result = Integer.parseInt(operands[0]);

        for (int i = 1; i < operands.length; i++) {
            int operand = Integer.parseInt(operands[i]);
            if (operators[i].equals("+")) {
                result += operand;
            } else if (operators[i].equals("-")) {
                result -= operand;
            }
        }

        return result == 0;
    }
}
