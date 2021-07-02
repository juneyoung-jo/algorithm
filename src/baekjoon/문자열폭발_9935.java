package baekjoon;

import java.util.*;
import java.io.*;

public class 문자열폭발_9935 {

	static String str, boom;
	static int size;
	static Map<Character, Integer> v = new HashMap<>();
	static Stack<Character> st = new Stack<>();
	static Deque<Character> deq = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		boom = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			deq.add(str.charAt(i));
		}
		
		for (int i = 0; i < boom.length(); i++) {
			v.putIfAbsent(boom.charAt(i),size++);
		}

		int cnt = 0;
		Character c = null;
		while(!deq.isEmpty()) {
			c = deq.poll();
			st.push(c);
			if(v.containsKey(c)) {
				int idx = v.get(c);
				if(idx == 0) cnt = 1;
				else if(idx == cnt) cnt++;
				else cnt = 0;
			} else cnt = 0;
			
			if(cnt == size) {
				while(cnt-->0) {
					st.pop();
				}
				cnt++;
				
				if(!deq.isEmpty() && v.containsKey(deq.peek()) 
						&& st.size() >= v.get(deq.peek())) {
					int pollCnt = v.get(deq.peek());
					while(pollCnt-->0) {
						deq.addFirst(st.pop());
					}
				}
			}
		}
		
		if(st.size() == 0) System.out.println("FRULA");
		else {
			while(!st.isEmpty()) sb.append(st.pop());
			System.out.println(sb.reverse());
		}
		

	}

}
