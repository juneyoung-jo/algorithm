package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		int card;
		for (int i = 0; i < n; i++) {
			card = Integer.parseInt(br.readLine());
			q.add(card);
		}
		
		int A,B,sum;
		if(q.size()>1) {
			while (!q.isEmpty()) {
				A = q.poll();
				B = q.poll();
				sum = A+B;
				ans += sum;
				if(q.size()==0) break;
				q.add(sum);
			}
		}
		
		System.out.println(ans);
	}

}
