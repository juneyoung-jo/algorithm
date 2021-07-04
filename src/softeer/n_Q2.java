package softeer;

import java.util.*;

public class n_Q2 {

	
	public static void main(String[] args) {
		
		String s = "abcdef";
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		
		int size = s.length();
		int end = s.length()-1;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if(i >= end) break;
			if(s.substring(start,i+1).equals(s.substring(end,size))) {
				list.add(s.substring(start,i+1));
				start = i+1;
				size = end;
			}
			end--;
		}
		
		String[] answer = null;
		int lSize = list.size();
		
		if(start == size) {
			answer = new String[lSize*2];
			int index = list.size()*2-1;
			
			for(int i = 0; i < lSize; i++) {
				answer[i] = list.get(i);
				answer[index] = list.get(i);
				index--;
			}
			
		}else if(lSize != 0) {
			answer = new String[lSize*2+1];
			int index = list.size()*2;
			for(int i = 0; i < lSize; i++) {
				answer[i] = list.get(i);
				answer[index] = list.get(i);
				index--;
			}
			answer[lSize] = s.substring(start,size); 
		}else {
			answer = new String[1];
			answer[0] = s.substring(start,size);
		}
		
	}
}
