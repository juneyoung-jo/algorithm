package programmers;

import java.util.*;

public class 보석쇼핑 {
	static int arr[], v[],size;
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		String[] gems = {"A", "B", "A", "A", "A", "C", "A", "B"};
		System.out.println(Arrays.toString(solution(gems)));
	}

	public static int[] solution(String[] gems) {

//        int size = 0;
        arr = new int[gems.length];
		
		for (String str : gems) map.computeIfAbsent(str, key -> size++);
		for (int i = 0; i < gems.length; i++) arr[i] = map.get(gems[i]);
        
        v = new int[size];
		int vSize = 0;
		int ansSize = gems.length;
		int right = arr.length - 1;
		int a_left = 0;
		int a_right = arr.length - 1;

		for (int i = arr.length - 1; i >= 0; i--) {
          
			if (v[arr[i]] == 0) vSize++;
			v[arr[i]]++;
          
			if (vSize == size) {
				while (i <= right) {
					if (v[arr[right]] >= 2) {
						v[arr[right]]--;
						right--;
					} else  break;
				}
				
				if (ansSize >= right - i + 1) {
					a_left = i;
					a_right = right;
					ansSize = right - i + 1;
				}

			}
		}

		int[] answer = { a_left + 1, a_right + 1 };
		return answer;
	}

}
