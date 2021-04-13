package swexpertacademy;

import java.util.Scanner;
import java.io.*;

class 최대부분배열_3819
{
    static int T,N,arr[],sum[],dp[],ans;
   public static void main(String args[]) throws Exception
   {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        
        for( int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            arr = new int[N];
            sum = new int[N];
            dp = new int[N];
            
            for(int i = 0;  i < N; i++){
                arr[i] = sc.nextInt();
            }
            
            ans = arr[0];
            
            sum[0] = arr[0];
            // 구간총합 만들기
            for(int i = 1; i< N; i++){
                sum[i] = arr[i]+sum[i-1]; 
            }
            
            dp[0] = arr[0];
            for(int i = 2; i<N;i++){
                dp[i] = Math.max(dp[i-1],0)+arr[i];
                if ( ans < dp[i]) ans = dp[i];
            }
            
             System.out.printf("#%d %d\n",tc,ans);
        }
        
      
      
   }
}
