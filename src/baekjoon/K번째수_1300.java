package baekjoon;
import java.util.*;
import java.io.*;

public class K번째수_1300 {
    static int N, K, ans;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());


        int start = 0;
        int end = K;

        while(start <= end) {
            int mid = (start + end) / 2;

            long cnt  = 0;
            for(int i = 1; i <= N; i++) {
                cnt += Math.min(mid/i,N);
            }

            if(cnt >= K) {
                end = mid - 1;
                ans = mid;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(ans);

    }
}
