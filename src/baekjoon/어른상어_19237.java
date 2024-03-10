package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 어른상어_19237 {

    private static int N, M, k, result = 0, MAX_RESULT_COUNT = 1000;
    private static Shark[][] map;
    private static final int[] dr = {0, -1, 1, 0, 0};
    private static final int[] dc = {0, 0, 0, -1, 1};
    private static int[][][] priorityDir;

    private static Queue<Shark> moveQ = new LinkedList<>();
    private static Queue<Shark> temp = new LinkedList<>(); // 임시 저장소

    private static class Shark {
        int idx, r, c, dir, k;

        public Shark(int idx, int r, int c, int dir, int k) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        priorityDir = new int[M + 1][5][5];
        int[][] sharkInfos = new int[M + 1][3]; // r, c, dir


        map = new Shark[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int sharkIdx = Integer.parseInt(st.nextToken());
                if (sharkIdx != 0) {
                    sharkInfos[sharkIdx][0] = r;
                    sharkInfos[sharkIdx][1] = c;
                }

            }
        }

        // init map
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= M; idx++) {
            int dir = Integer.parseInt(st.nextToken());
            int row = sharkInfos[idx][0];
            int col = sharkInfos[idx][1];
            Shark shark = new Shark(idx, row, col, dir, k);
            map[row][col] = shark;
            moveQ.add(shark);
        }


        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 4; k++) {
                    priorityDir[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while (checkResult()) {
            result += 1; // 1초 증가
            calK(); // 냄새 계산
            getTmepMoveShark(); // 상어가 이동할 좌표 계산
            move();
        }

        System.out.println(result > MAX_RESULT_COUNT ? -1 : result);
    }

    private static void move() {
        while (!temp.isEmpty()) {
            Shark shark = temp.poll();
            if (map[shark.r][shark.c] == null ||
                    (map[shark.r][shark.c] != null && map[shark.r][shark.c].k < k)) {
                map[shark.r][shark.c] = shark;
                moveQ.add(shark);
            }
        }
    }

    // map 돌면서 k 관리하는 기능
    private static void calK() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] != null) {
                    int k = map[r][c].k;
                    // k가 0인 경우, 냄새 제거
                    // 그외 k += -1
                    if (k == 0) {
                        map[r][c] = null;
                    } else {
                        map[r][c].k -= 1;
                    }
                }
            }
        }
    }

    // 이동
    private static void getTmepMoveShark() {
        while (!moveQ.isEmpty()) {
            Shark shark = moveQ.poll();
            List<Integer> availableMove = new ArrayList<>(); // 이동 가능한 장소

            // 먼저 인접한 칸 중 아무 냄새가 없는 칸의 방향으로 잡는다.
            for (int dir = 1; dir <= 4; dir++) {
                int nr = shark.r + dr[dir];
                int nc = shark.c + dc[dir];
                if (isNotEdge(nr, nc)) {
                    if (map[nr][nc] == null) {
                        availableMove.add(dir);
                    }
                }
            }

            // 자신의 냄새가 있는 칸의 방향으로 잡는다.
            // 이때 가능한 칸이 여러 개일 수 있는데, 그 경우에는 특정한 우선순위를 따른다.
            if (availableMove.isEmpty()) {
                for (int dir = 1; dir <= 4; dir++) {
                    int nr = shark.r + dr[dir];
                    int nc = shark.c + dc[dir];
                    if (isNotEdge(nr, nc)) {
                        if (map[nr][nc] != null
                                && map[nr][nc].idx == shark.idx) {
                            availableMove.add(dir);
                        }
                    }
                }
            }

            // 방향별 우선 순위에 따라 이동할 장소 탐색
            L:
            for (int i = 1; i <= 4; i++) {
                int priority = priorityDir[shark.idx][shark.dir][i];
                for (int j = 0; j < availableMove.size(); j++) {
                    if (availableMove.get(j) == priority) {
                        int r = shark.r + dr[priority];
                        int c = shark.c + dc[priority];
                        temp.add(new Shark(shark.idx, r, c, priority, k));
                        break L;
                    }
                }
            }
        }
    }

    private static boolean isNotEdge(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr <= N - 1 && nc <= N - 1;
    }

    private static boolean checkResult() {
        if (moveQ.size() == 1) return false;
        return result <= 1000;
    }
}
