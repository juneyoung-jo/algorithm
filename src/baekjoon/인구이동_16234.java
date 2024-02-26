package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_16234 {

    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] v;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static Queue<Country> moveQ = new LinkedList<>();
    private static Queue<Country> resultQ = new LinkedList<>();

    private static class Country {
        int row, col;

        public Country(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(calMove());

    }

    private static int calMove() {
        int moveCount = 0;
        while (isPopulationMoved()) {
            moveCount++;
        }
        return moveCount;
    }

    /**
     * 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
     * 위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
     * <p>
     * 1. 국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
     * 2. 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
     * 3. 연합을 해체하고, 모든 국경선을 닫는다.
     */
    private static boolean isPopulationMoved() {
        init();
        int moveCnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!v[r][c]) {
                    moveCnt++;
                    bfs(r, c);
                }
            }
        }
        return moveCnt != N * N;
    }

    private static void init() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                v[r][c] = false;
            }
        }
    }

    private static void bfs(int r, int c) {
        int cnt = 0; // 연합한 나라의 수
        int sum = 0; // 연합의 총 인원 수
        v[r][c] = true;
        moveQ.add(new Country(r, c));

        // 연합
        while (!moveQ.isEmpty()) {
            Country country = moveQ.poll();
            sum += map[country.row][country.col];
            cnt++;
            resultQ.add(country);

            for (int dir = 0; dir < 4; dir++) {
                int nr = country.row + dr[dir];
                int nc = country.col + dc[dir];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N
                        && !v[nr][nc]
                        && Math.abs(map[country.row][country.col] - map[nr][nc]) >= L
                        && Math.abs(map[country.row][country.col] - map[nr][nc]) <= R) {
                    v[nr][nc] = true;
                    moveQ.add(new Country(nr, nc));
                }
            }
        }

        // 연합 인구이동 계산 및 갱신
        while (!resultQ.isEmpty()) {
            Country country = resultQ.poll();
            map[country.row][country.col] = sum / cnt;
        }
    }
}
