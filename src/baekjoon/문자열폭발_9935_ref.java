package baekjoon;
import java.util.*;
import java.io.*;

public class 문자열폭발_9935_ref {

	static String str, boom;
	static int size, cnt;
	static Map<Character, Integer> v = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		boom = br.readLine();
		
		for (int i = 0; i < boom.length(); i++) v.putIfAbsent(boom.charAt(i),size++);
		
		char[] ans = new char[str.length()+1];
		int maxSize = str.length();
		int idx = 1;
		for(int i =0; i < maxSize; i++) {
			ans[idx] = str.charAt(i);
			cal(ans[idx]);
			
			if(cnt == size) {
				idx-=size;
				cnt = 0; // cnt 초기화
				
				if(i+1 < maxSize && v.containsKey(str.charAt(i+1)) 
						&& idx >= v.get(str.charAt(i+1))) {
					int popCnt = v.get(str.charAt(i+1));
					for(int j = idx-popCnt+1; j <= idx; j++) {
						cal(ans[j]);
					}
				}
				
			}
			idx++;
		}
		
		
		if(idx == 1) System.out.println("FRULA");
		else {
			for(int i = 1; i < idx; i++) sb.append(ans[i]);
			System.out.println(sb);			
		}

	}

	private static void cal(char c) {
		if(v.containsKey(c)) {
			int idx = v.get(c);
			if(idx == 0) cnt = 1;
			else if(idx == cnt) cnt++;
			else cnt = 0;
		} else cnt = 0;
	}

}