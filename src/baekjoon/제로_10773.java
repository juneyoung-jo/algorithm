package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {
	static int K,ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		Stack<Integer> list = new Stack<Integer>();
		int num;
		for (int i = 0; i < K; i++) {
			num = Integer.parseInt(br.readLine());
			if(num == 0 ) list.pop();
			else list.push(num);
		}
		
		while(!list.isEmpty()) {
			ans += list.pop();
		}
		
		System.out.println(ans);
		
	}

}