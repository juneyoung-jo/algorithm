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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; ++tc) {
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
            for (int n = 0; n < N; ++n) {
                char command = commands.charAt(n);
                execute(command);
            }
        }
        printField();
    }

    private static void execute(char command) {

        switch (command) {
            case 'U':
                process(dr[0], dc[0], '^');
                break;
            case 'D':
                process(dr[1], dc[1], 'v');
                break;
            case 'L':
                process(dr[2], dc[2], '<');
                break;
            case 'R':
                process(dr[3], dc[3], '>');
                break;
            case 'S':
                break;
        }

    }

    private static void process(int dr, int dc, char command) {
        int nr = r + dr;
        int nc = c + dc;
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

    private static void printField() {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
