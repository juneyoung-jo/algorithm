package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장dp_강의코드 {
	static int T, cost[], day[], ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			cost = new int[4];
			day = new int[13];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.printf("#%d %d\n",tc,plan());

		}

	}

	private static int plan() {
		
		int D[] = new int[13];
		for (int i = 1; i <= 12; i++) {
			// 1일권
			D[i] = D[i-1] + day[i]*cost[0];
			// 1달권
			if(day[i]>0) D[i] = Math.min(D[i], D[i-1]+cost[1]);
			// 3달권
			if(i>=3) D[i] = Math.min(D[i], D[i-3] + cost[2]);
			
		}
		
		return Math.min(D[12], cost[3]);
		
	}

}
