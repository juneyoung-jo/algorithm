package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 크게만들기_2812_deque {
	
	static int K, N, total;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		total = K - N;

		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			while (N > 0 && !dq.isEmpty() && dq.peekFirst() < str.charAt(i)-'0') {
				N--;
				dq.pollFirst();
			}
			
			dq.addFirst(str.charAt(i)-'0');
		}
		
		while(total-->0) {
			sb.append(dq.pollLast());
		}

		System.out.println(sb);

	}

}
