package swexpertacademy;

import java.io.*;
import java.util.*;

public class 점심식사시간_1 {

    static int T, N, pCount, map[][], ans;
    static List<Point> pList, sList;

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ans = Integer.MAX_VALUE;
            pList = new ArrayList<>();
            sList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) pList.add(new Point(i, j, 0));
                    else if (map[i][j] > 1) sList.add(new Point(i, j, map[i][j]));
                }
            }

            pCount = pList.size();
            powerSet();

            System.out.printf("#%d %d\n", tc, ans);

        }

    }

    private static void powerSet() {
        for (int i = 0; i < 1 << pList.size(); i++)
            cal(i);
    }


    private static void cal(int num) {
        List<Point> one = new ArrayList<>();
        List<Point> two = new ArrayList<>();
        for (int i = 0; i < pCount; i++) {
            if ((num & (1 << i)) != 0) one.add(pList.get(i));
            else two.add(pList.get(i));
        }

        int oneTime = calTime(one, 0);
        if(oneTime >= ans) return;
        int twoTime = calTime(two, 1);
        if(twoTime >= ans) return;

        ans = Math.min(ans, Math.max(oneTime, twoTime));
    }

    private static int calTime(List<Point> list, int idx) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        list.forEach(p -> pq.add(Math.abs(p.r - sList.get(idx).r) + Math.abs(p.c - sList.get(idx).c)));
        Queue<Integer> q = new LinkedList<>();

        int result = 0;
        int sLength = sList.get(idx).cnt;
        while (!pq.isEmpty()) {
            if (q.size() < 3) q.add(pq.poll() + sLength + 1);
            else {
                int end = q.poll();
                int hold = pq.poll();
                if (end <= hold) q.add(hold + sLength + 1);
                else q.add(end + sLength);
            }
        }

        while (!q.isEmpty()) result = q.poll();
        return result;
    }

}
