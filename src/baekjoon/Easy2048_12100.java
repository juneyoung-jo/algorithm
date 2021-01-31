package baekjoon;
import java.io.*;
import java.util.*;

public class Easy2048_12100 {
	
	  static int N, map[][], dir[], ans;
	   static int[] dr = { 1, -1, 0, 0 }; // 하 상 우 좌
	   static int[] dc = { 0, 0, 1, -1 };

	   public static void main(String[] args) throws Exception {
	      // 2048 (Easy)_ 12100
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      N = Integer.parseInt(br.readLine());

	      map = new int[N][N];

	      for (int i = 0; i < N; i++) {
	         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	         for (int j = 0; j < N; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	         }
	      }

	      dir = new int[5];

	      // 알고리즘
	      cal(0);
	      System.out.println(ans);

	   }

	   private static void cal(int idx) {
	      if (idx == 5) {
	         // 계산
	         int[][] nMap = new int[N][N];
	         copy(nMap);
	         for (Integer i : dir) {
	            go(i, nMap);
	         }

	         maxCal(nMap);

	         return;
	      }

	      for (int j = 0; j < 4; j++) {
	         dir[idx] = j;
	         cal(idx + 1);
	      }

	   }

	   private static void maxCal(int[][] nMap) {

	      for (int i = 0; i < nMap.length; i++) {
	         for (int j = 0; j < nMap[i].length; j++) {
	            if (ans < nMap[i][j])
	               ans = nMap[i][j];
	         }
	      }

	   }

	   private static void go(Integer i, int[][] nMap) {

	      boolean[][] v = new boolean[N][N];
	      switch (i) {
	      case 0:
	         // 하
	         for (int r = N - 2; r >= 0; r--) {
	            int idx = r;

	            while (true) {
	               if (idx == N - 1)
	                  break;
	               for (int c = 0; c < nMap.length; c++) {
	                  if (nMap[idx][c] == 0)
	                     continue;
	                  if (nMap[idx][c] != nMap[idx + 1][c] && nMap[idx + 1][c] != 0)
	                     continue;
	                  if (v[idx][c])
	                     continue;
	                  if (nMap[idx + 1][c] != 0) {
	                     v[idx][c] = true;
	                     v[idx + 1][c] = true;
	                  }
	                  nMap[idx + 1][c] += nMap[idx][c];
	                  nMap[idx][c] = 0;
	               }
	               idx += 1;
	            }

	         }
	         break;
	      case 1:
	         // 상
	         for (int r = 1; r < N; r++) {
	            int idx = r;
	            while (true) {
	               if (idx == 0)
	                  break;
	               for (int c = 0; c < nMap.length; c++) {
	                  if (nMap[idx][c] == 0)
	                     continue;
	                  if (nMap[idx][c] != nMap[idx - 1][c] && nMap[idx - 1][c] != 0)
	                     continue;
	                  if (v[idx][c])
	                     continue;
	                  if (nMap[idx - 1][c] != 0) {
	                     v[idx][c] = true;
	                     v[idx - 1][c] = true;
	                  }
	                  nMap[idx - 1][c] += nMap[idx][c];
	                  nMap[idx][c] = 0;
	               }
	               idx -= 1;
	            }

	         }
	         break;
	      case 2:
	         // 우
	         for (int r = N - 2; r >= 0; r--) {
	            int idx = r;

	            while (true) {
	               if (idx == N - 1)
	                  break;
	               for (int c = 0; c < nMap.length; c++) {
	                  if (nMap[c][idx] == 0)
	                     continue;
	                  if (nMap[c][idx] != nMap[c][idx + 1] && nMap[c][idx + 1] != 0)
	                     continue;
	                  if (v[c][idx])
	                     continue;
	                  if (nMap[c][idx + 1] != 0) {
	                     v[c][idx] = true;
	                     v[c][idx + 1] = true;
	                  }
	                  nMap[c][idx + 1] += nMap[c][idx];
	                  nMap[c][idx] = 0;
	               }
	               idx += 1;
	            }

	         }
	         break;
	      case 3:
	         // 좌
	         for (int r = 1; r < N; r++) {
	            int idx = r;
	            while (true) {
	               if (idx == 0)
	                  break;
	               for (int c = 0; c < nMap.length; c++) {
	                  if (nMap[c][idx] == 0)
	                     continue;
	                  if (nMap[c][idx] != nMap[c][idx - 1] && nMap[c][idx - 1] != 0)
	                     continue;
	                  if (v[c][idx])
	                     continue;
	                  if (nMap[c][idx - 1] != 0) {
	                     v[c][idx] = true;
	                     v[c][idx - 1] = true;
	                  }
	                  nMap[c][idx - 1] += nMap[c][idx];
	                  nMap[c][idx] = 0;
	               }
	               idx -= 1;
	            }

	         }
	         break;
	      }

	   }

	   private static void copy(int[][] nMap) {
	      for (int i = 0; i < N; i++) {
	         for (int j = 0; j < N; j++) {
	            nMap[i][j] = map[i][j];
	         }
	      }

	   }


}
