package baekjoon;

import java.io.*;
import java.util.*;

public class 상어초등학교_21608 {

    private static int N;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static HashMap<Integer, Integer[]> friendsMap = new HashMap<>();

    private static class Seat implements Comparable<Seat> {

        int fav, empty, r, c;

        public Seat(int fav, int empty, int r, int c) {
            this.fav = fav;
            this.empty = empty;
            this.r = r;
            this.c = c;
        }


        @Override
        public int compareTo(Seat o) {
            if (this.fav != o.fav) return o.fav - this.fav;
            if (this.empty != o.empty) return o.empty - this.empty;
            if (this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int friend = Integer.parseInt(st.nextToken());
            Integer[] friendList = new Integer[4];
            for (int j = 0; j < 4; j++) {
                friendList[j] = Integer.parseInt(st.nextToken());
            }
            friendsMap.put(friend, friendList);
            sit(friend);
        }

        System.out.println(calSatisfaction());
    }

    private static void sit(int friend) {
        List<Seat> seats = new ArrayList<>();
        Integer[] friends = friendsMap.get(friend);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] != 0) continue;
                int fav = 0;
                int empty = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                        fav += calFav(nr, nc, friends);
                        empty += calEmpty(nr, nc);
                    }
                }
                seats.add(new Seat(fav, empty, r, c));
            }
        }

        Collections.sort(seats);
        Seat seat = seats.get(0);
        map[seat.r][seat.c] = friend;
    }

    private static int calEmpty(int nr, int nc) {
        if (map[nr][nc] == 0) return 1;
        return 0;
    }

    private static int calFav(int nr, int nc, Integer[] friends) {
        for (Integer friend : friends) {
            if (map[nr][nc] == friend) return 1;
        }
        return 0;
    }

    private static int calSatisfaction() {
        int result = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int fav = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                        fav += calFav(nr, nc, friendsMap.get(map[r][c]));
                    }
                }
                result += calResult(fav);
            }
        }
        return result;
    }

    private static int calResult(int fav) {
        if (fav == 1) return 1;
        if (fav == 2) return 10;
        if (fav == 3) return 100;
        if (fav == 4) return 1000;
        return 0;
    }
}
