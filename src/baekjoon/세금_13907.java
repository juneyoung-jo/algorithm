package baekjoon;
import java.util.*;
import java.io.*;

public class 세금_13907 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, K, S, D, arr[], dis[][];
    static ArrayList<Point>[] list;
    static PriorityQueue<Point> q = new PriorityQueue<>();
    static class Point implements Comparable<Point>{
        int end, dist, cnt;

        public Point(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        public Point(int end, int dist, int cnt) {
            this.end = end;
            this.dist = dist;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dis = new int[N+1][N];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine()," ");
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            list[start].add(new Point(end,cnt));
            list[end].add(new Point(start,cnt));
        }

        arr = new int[K];
        for(int i = 0 ; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 다익스트라
        for(int i = 0; i <= N; i++) {
            Arrays.fill(dis[i],INF);
        }

        dis[S][0] = 0;
        q.add(new Point(S,0,1));
        Point p = null;
        while(!q.isEmpty()) {
            p = q.poll();

            if(p.cnt >= N) continue;

            L:for(Point next : list[p.end]){

                for(int i = 0; i < p.cnt; i++) {
                    // 거쳐온 노드 개수가 작은데 현재값이 더 클경우. 더이상 고려할 필요 없음.
                    // ex) 1번 거쳐서 도착할 경우 10인데, 2번 거쳐서 11이면 세금이 올라도 의미가 없음.
                    if(p.dist + next.dist > dis[next.end][i]) continue L;
                }

                if(p.dist + next.dist < dis[next.end][p.cnt]) {
                     dis[next.end][p.cnt] = p.dist + next.dist;
                     q.add(new Point(next.end,dis[next.end][p.cnt],p.cnt + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int result = INF;
        for(int j = 0; j < dis[D].length; j++){
            if(result > dis[D][j]) result = dis[D][j];
        }
        sb.append(result + "\n");
        for(int i = 0; i < arr.length; i++){
            result = INF;
            for(int j = 0; j < dis[D].length; j++){
                if(dis[D][j] == INF) continue;
                else dis[D][j] += (j *arr[i]);
                if(result > dis[D][j]) result = dis[D][j];
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
