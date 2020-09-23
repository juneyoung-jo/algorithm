package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class 나머지_3052 {
	static int arr[];
	static final int div = 42;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(sc.nextInt()%42);
		}
		
		System.out.println(set.size());
	}
}
