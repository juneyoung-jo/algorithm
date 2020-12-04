package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 수정이의타일자르기_강의코드 {
	private static class Rectangle implements Comparable<Rectangle>{
        int max, min;
        public Rectangle(int width, int height) {
            min = Math.min(width, height);
            max = Math.max(width, height);
        }
        @Override
        public int compareTo(Rectangle o) {
            // TODO Auto-generated method stub
            return o.min - this.min;
        }
    }
     
    private static int N, M, size[], cnt;
    private static PriorityQueue<Rectangle> pq;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            size = new int[N];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                size[i] = Integer.parseInt(st.nextToken());
            }
            cut();
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
 
    private static void cut() {
        //만들고자 하는 크기가 큰 타일부터 처리
        Arrays.sort(size);
        pq = new PriorityQueue<Rectangle>();
        pq.offer(new Rectangle(M, M));//타일 1장 사고 시작
        ++cnt; //타일 개수 증가
         
        for (int i = N-1; i >= 0; i--) {
            go(1<<size[i]); //sift 연산할 경우 1번씩 할 때마다 2의 배수
        }
    }
 
    private static void go(int size) {
        //자투리 타일중에 min변의 크기가 최대인 것과 비교
        Rectangle r = pq.poll();
        //원한느 크기의 타일을 만들 수 있다면 만들고 잘라낸 2개의 자투리 타일을 다시 보관
        if(r.min >= size) {
            pq.offer(new Rectangle(r.min-size, size));
            pq.offer(new Rectangle(r.min, r.max-size));
        } 
        //원하는 크기의 타일을 만들 수 없다면 새로 타일을 구매해서 잘라내고(이때, 구매한 타일개수 카운트 증가)
        //                                                 , 잘라낸 2개의 자투리 타일을 다시 보관
        //                                                 , 꺼내고 사용하지 않은 타일 다시 보관
        else {
            ++cnt;
            pq.offer(r);
            pq.offer(new Rectangle(M-size, size));
            pq.offer(new Rectangle(M-size, M));
        }
    }
}











