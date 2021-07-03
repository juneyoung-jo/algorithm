package softeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 참거짓 {
	static Map<Character,Integer> map = new HashMap<>();
	static int count, arr[];
	static ArrayList<Integer>[] list;
//	static String[] input = {"AC", "CE", "EA", "AB", "BC", "BE"}; // EA
	static String[] input = {"AB","BC","AC","CA"};
//	static String[] input = {"RB", "AR", "NR", "NB" ,"QA", "BQ", "KR", "QN"};
	
//	["AB","BC","AC","CA"] CA
//	["ZB", "BC", "CZ", "ZC"] CZ
//	["RB", "AR, "NR", "NB" ,"QA", "BQ", "KR", "QN"] BQ
	
	static String ans;
	public static void main(String[] args) {
		
		for(String str : input) 
			for(int i = 0; i < 2; i++) 
				map.computeIfAbsent(str.charAt(i), (key)->count++);
		
		cal();
		System.out.println(ans);
	}
	private static void cal() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < input.length; i++) {
			arr = new int[count];
			list = new ArrayList[count];
			q.clear();
			
			for (int j = 0; j < count; j++) 
				list[j] = new ArrayList<>();
			
			for (int j = 0; j < input.length; j++) {
				if(i == j) continue;
				int start = map.get(input[j].charAt(0));
				int end = map.get(input[j].charAt(1));
				arr[end]++;
				list[start].add(end);
			}
			
			// 위상 정렬
			for (int j = 0; j < count; j++) 
				if (arr[j] == 0) q.add(j); // 시작지점 담기
			
			while (!q.isEmpty()) {
				int p = q.poll();
				int size = list[p].size();
				for (int j = 0; j < size; j++) {
					int end = list[p].get(j);
					arr[end] -= 1;
					if (arr[end] == 0)  q.add(end);
				}
			}
			
			if(check()) {
				ans = input[i];
				return;
			}
			
		}
	}
	
	private static boolean check() {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 1) return false;
		}
		
		return true;
	}

}
