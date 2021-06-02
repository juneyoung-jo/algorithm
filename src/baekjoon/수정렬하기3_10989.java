package baekjoon;
import java.io.*;
import java.util.*;

public class 수정렬하기3_10989 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		for(int i = 0; i < num; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i < 10001; i++) {
			while(true) {
				if(arr[i] == 0) break;
				bw.write(Integer.toString(i)+"\n");
				arr[i]--;
				
			}
		}
		
		
		br.close();
		bw.close();
	}

}
