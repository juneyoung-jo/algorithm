package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LCS2_9252 {
	static int ans, dp[][];
	static int[] dr = { -1, -1, 0 };
	static int[] dc = { -1, 0, -1 };
	static String str1, str2;
	static StringBuilder sb;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str1.length() + 1][str2.length() + 1];

		sb = new StringBuilder();

		// dp 배열
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (ans < dp[i][j]) {
						ans = dp[i][j];
					}
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}

		}

		// 역추적
		cal();

		System.out.println(ans);
		if(ans == 0) System.exit(0);
		System.out.println(sb.reverse());

	}

	private static void cal() {

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(str1.length(), str2.length()));
		

		Point p = null;
		while (!q.isEmpty()) {
			p = q.poll();

			if (dp[p.r][p.c] == 0) break;
			
			if(str1.charAt(p.r-1) == str2.charAt(p.c-1)) {
				sb.append(str1.charAt(p.r-1));
				int nr  = p.r + dr[0];
				int nc  = p.c + dc[0];
				q.add(new Point(nr,nc));
			}else {
				int nr  = p.r + dr[1];
				int nc  = p.c + dc[1];
				int nnr  = p.r + dr[2];
				int nnc  = p.c + dc[2];
				
				if(dp[nr][nc] < dp[nnr][nnc]) {
					q.add(new Point(nnr,nnc));
				}else {
					q.add(new Point(nr,nc));
				}
			}

		}

	}

}
