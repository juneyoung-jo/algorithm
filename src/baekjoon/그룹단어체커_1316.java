package baekjoon;

import java.util.Scanner;

public class 그룹단어체커_1316 {
	static int N,ans,alpa[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			
			alpa = new int[200]; 
			String str = sc.next();
			alpa[str.charAt(0)] = 1;
			boolean flag = false;
			
			for (int j = 1; j < str.length(); j++) {
				if(str.charAt(j-1) == str.charAt(j)) continue;
				if(alpa[str.charAt(j)] != 0) {
					flag = true;
					break;
				}
				alpa[str.charAt(j)] = 1;
			}
			if(!flag) ans++;
		}
		
		System.out.println(ans);
		
	}

}
