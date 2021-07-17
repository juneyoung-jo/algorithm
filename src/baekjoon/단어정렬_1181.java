package baekjoon;

import java.util.*;
import java.io.*;

public class 단어정렬_1181 {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str;
		}
		
		StringBuilder sb = new StringBuilder();
		Arrays.stream(arr).distinct().sorted((a,b)->{
			if(a.length() == b.length()) return a.compareTo(b);
			return a.length()-b.length();}).forEach(s -> sb.append(s+"\n"));
		
		System.out.println(sb);

	}

}
