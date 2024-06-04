package softeer;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 장애물인식프로그램 {
    static int N, cnt = 0;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !v[i][j]) {
                    cnt++;
                    answer.add(dfs(i, j, 1));
                }
            }
        }
        System.out.println(cnt);
        answer.sort(Comparator.comparingInt(i -> 1));
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int dfs(int r, int c, int count) {
        if (r < 0 || c < 0 || r >= N || c >= N || map[r][c] == 0 || v[r][c]) return 0;
        v[r][c] = true;
        for (int dir = 0; dir < 4; dir++) {
            count = Math.max(dfs(r + dr[dir], c + dc[dir], count + 1), count);
        }
        return count;
    }
}
