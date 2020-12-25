package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
	static int n, ans;
	static HashMap<String,Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine());
			ans = 1;

			map = new HashMap<String,Integer>();

			String name = "";
			String kind = "";

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				name = st.nextToken();
				kind = st.nextToken();
				
				if(map.get(kind) != null) map.put(kind, map.get(kind)+1);
				else map.put(kind,1); 
			}
			
			for (String str : map.keySet()) {
				 ans *= (map.get(str) +1);
			}
			
			System.out.println(--ans);
		}

	}


}
