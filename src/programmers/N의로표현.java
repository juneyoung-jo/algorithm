package programmers;

public class N의로표현 {
    static int index, answer = 9;
    public int solution(int N, int number) {
        index = number;
        int num = 0;

        dfs(N, 0, 0);

        return answer == 9 ? -1 : answer;
    }

    public void dfs(int n, int num, int count) {
        if (count > 8) {
            return;
        }

        if (num == index) {
            answer = Math.min(answer, count);
            return;
        }
        dfs(n, num + 1, count + 2);
        dfs(n, num - 1, count + 2);

        int makeNum = n;
        for (int i = 0; i < 8 - count; i++) {
            dfs(n, num + makeNum, count + i + 1);
            dfs(n, num - makeNum, count + i + 1);
            dfs(n, num * makeNum, count + i + 1);
            dfs(n, num / makeNum, count + i + 1);
            makeNum = cal(makeNum, n);
        }
    }

    public int cal(int num, int n) {
        return num * 10 + n;
    }
}
