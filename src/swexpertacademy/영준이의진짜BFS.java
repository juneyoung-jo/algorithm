package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 영준이의진짜BFS {
	static int T,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer>[] list = new ArrayList[N+1];
			
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 2; i <= N; i++) {
			}
			
		}
		
		
		
	}

}
