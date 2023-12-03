package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {

    private static int T, H, W, N, r, c;
    private static char[][] field;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            field = new char[H][];

            // init field
            for (int row = 0; row < H; ++row) {
                field[row] = br.readLine().toCharArray();
                for (int col = 0; col < W; ++col) {
                    char component = field[row][col];
                    if (component == '^' || component == 'v' || component == '<' || component == '>') {
                        r = row;
                        c = col;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String commands = br.readLine();

            // solved
            for (int n = 0; n < N; ++n) {
                execute(commands.charAt(n));
            }

            // answer
            sb.append("#" + tc + " ");
            printField();
        }
        System.out.println(sb);
    }

    private static void execute(char command) {
        int nr, nc;
        switch (command) {
            case 'U':
                nr = r + dr[0];
                nc = c + dc[0];
                move(nr, nc, '^');
                break;
            case 'D':
                nr = r + dr[1];
                nc = c + dc[1];
                move(nr, nc, 'v');
                break;
            case 'L':
                nr = r + dr[2];
                nc = c + dc[2];
                move(nr, nc, '<');
                break;
            case 'R':
                nr = r + dr[3];
                nc = c + dc[3];
                move(nr, nc, '>');
                break;
            case 'S':
                shoot();
                break;
        }
    }

    private static void move(int nr, int nc, char command) {
        // 방향 변경
        field[r][c] = command;

        // 이동
        if (!isEdge(nr, nc)
                && isFlat(field[nr][nc])) {
            field[r][c] = '.';
            field[nr][nc] = command;
            r = nr;
            c = nc;
        }
    }

    private static boolean isFlat(char component) {
        return component == '.';
    }

    private static boolean isEdge(int row, int col) {
        return row < 0 || col < 0 || row >= H || col >= W;
    }

    private static void shoot() {
        switch (field[r][c]) {
            case '^':
                for (int row = r - 1; row >= 0; --row) {
                    if (field[row][c] == '#') {
                        break;
                    }
                    if (field[row][c] == '*') {
                        field[row][c] = '.';
                        break;
                    }
                }
                break;
            case 'v':
                for (int row = r + 1; row < H; ++row) {
                    if (field[row][c] == '#') {
                        break;
                    }
                    if (field[row][c] == '*') {
                        field[row][c] = '.';
                        break;
                    }
                }
                break;
            case '<':
                for (int col = c - 1; col >= 0; --col) {
                    if (field[r][col] == '#') {
                        break;
                    }
                    if (field[r][col] == '*') {
                        field[r][col] = '.';
                        break;
                    }
                }
                break;
            case '>':
                for (int col = c + 1; col < W; ++col) {
                    if (field[r][col] == '#') {
                        break;
                    }
                    if (field[r][col] == '*') {
                        field[r][col] = '.';
                        break;
                    }
                }
                break;
        }
    }

    private static void printField() {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                sb.append(field[r][c]);
            }
            sb.append("\n");
        }
    }
}
