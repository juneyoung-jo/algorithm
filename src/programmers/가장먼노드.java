package programmers;

import java.util.*;
public class 가장먼노드 {
    ArrayList<Integer>[] list;
    int[] v;
    class Point{
        int r,cnt;
        
        public Point(int r,int cnt){
            this.r = r;
            this.cnt = cnt;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list = new ArrayList[n+1];
        v = new int[n+1];
        
        for(int i=1; i<= n; i++){
            list[i] = new ArrayList<>();
        }
        
        int start,end;
        for(int i = 0; i< edge.length; i++){
            start = edge[i][0];
            end = edge[i][1];
            
            list[start].add(end);
            list[end].add(start);
        }
        
        bfs(1,1);
        int max = -1;
        for(int i = 1; i <= n; i++){
            if(max < v[i]) max = v[i];
        }
        
        for(int i = 1; i <= n; i++){
            if(max == v[i]) answer++;
        }
        
        
        return answer;
    }
    
    public void bfs(int idx, int len){
        
        Queue<Point> q = new LinkedList<>();
        v[idx] = -1;
        q.add(new Point(idx,len));
        
        Point p = null;
        while(!q.isEmpty()){
            p = q.poll();
            int size = list[p.r].size();
            for(int i = 0; i<size; i++){
                if(v[list[p.r].get(i)] != 0) continue;
                v[list[p.r].get(i)] = p.cnt;
                q.add(new Point(list[p.r].get(i),p.cnt+1));
            }
            
        }      
       
    }
}