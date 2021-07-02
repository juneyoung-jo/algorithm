package baekjoon;
import java.util.*;
import java.io.*;

public class 문자열폭발_9935_ref3 {

	static String str, boom;
	static int size, cnt;
	static Map<Character, Integer> v = new HashMap<>();
	static Stack<Character> st = new Stack<>();
	static Stack<Character> addStack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		boom = br.readLine();
		
		for (int i = 0; i < boom.length(); i++) v.putIfAbsent(boom.charAt(i),size++);

		Character c = null;
		int maxSize = str.length();
		for(int i =0; i < maxSize; i++) {
			c = str.charAt(i);
			cal(c);
			
			if(cnt == size) {
				while(cnt-->0) st.pop();
				cnt = 0; // cnt 초기화
				
				if(i+1 < maxSize && v.containsKey(str.charAt(i+1)) && st.size() >= v.get(str.charAt(i+1))) {
					int popCnt = v.get(str.charAt(i+1));
					while(popCnt-->0) addStack.add(st.pop());
					while(!addStack.isEmpty()) cal(addStack.pop());
				}
				
			}
		}
		
		
		if(st.size() == 0) System.out.println("FRULA");
		else {
			while(!st.isEmpty()) sb.append(st.pop());
			System.out.println(sb.reverse());
		}

	}

	private static void cal(Character c) {
		st.push(c);
		if(v.containsKey(c)) {
			int idx = v.get(c);
			if(idx == 0) cnt = 1;
			else if(idx == cnt) cnt++;
			else cnt = 0;
		} else cnt = 0;
	}

}
