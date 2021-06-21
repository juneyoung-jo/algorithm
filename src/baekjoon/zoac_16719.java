package baekjoon;
import java.util.*;
import java.io.*;

public class zoac_16719 {
	
	static String str;
	static String[] ans;
	static PriorityQueue<String> q = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		str= sc.next();
		
		ans = new String[str.length()];
		ans[0] = str;
		for(int i =1; i< ans.length; i++) {
			ans[i] = cal(ans[i-1]);
		}
		
		for(int i = ans.length-1; i>=0; i--) {
			sb.append(ans[i]+"\n");
		}
		
		System.out.println(sb);
		
	}
	private static String cal(String s) {
		q.clear();
		for(int i = 0; i<s.length(); i++) {
			if(i == 0) {
				q.add(s.substring(i+1));
			} else {
				q.add(s.substring(0,i)+s.substring(i+1));
			}
		}
		return q.poll();
	}

}
