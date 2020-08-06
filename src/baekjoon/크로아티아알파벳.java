package baekjoon;

import java.util.Scanner;

public class 크로아티아알파벳 {
	static String str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str = sc.next(); 
		
		//알고리즘 : 정해진 문자를 1로 바꿈(문자 하나로 보기 때문) 
		str = str.replace("c=", "1").replace("c-", "1").replace("dz=", "1").replace("d-", "1").replace("lj", "1")
				.replace("nj", "1").replace("s=", "1").replace("z=", "1");
		
		//길이 출력
		System.out.println(str.length());
	}

}
