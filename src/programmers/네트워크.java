package programmers;

public class 네트워크 {
    static boolean[] v;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[computers.length];

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            answer++;
            dfs(i, computers);
        }

        return answer;
    }

    void dfs(int idx, int[][] computers) {
        if (v[idx]) return;
        v[idx] = true;
        for (int i = 0; i < computers.length; i++)
            if (computers[idx][i] == 1) dfs(i, computers);
    }
}
