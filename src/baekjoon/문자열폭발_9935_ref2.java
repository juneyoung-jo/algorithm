package baekjoon;

import java.util.*;
import java.io.*;

public class 문자열폭발_9935_ref2 {

	static String str, bomb;
	static char[] ans;
	static int size, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		bomb = br.readLine();
		ans = new char[str.length()];
		size = bomb.length();
		
		int idx = 0;
		for(int i = 0; i < str.length(); i++) {
			ans[idx] = str.charAt(i);
			if(cal(idx)) idx -= size;
			idx++;
		}
		
		if(idx == 0) System.out.println("FRULA");
		else System.out.println(String.valueOf(ans, 0, idx));		
		

	}

	private static boolean cal(int idx) {
		if(idx < size -1) return false;
		
		for(int i = 0; i < size; i++) {
			if(bomb.charAt(i) != ans[idx-size+1+i]) return false;
		}
			
		return true;
	}

}
