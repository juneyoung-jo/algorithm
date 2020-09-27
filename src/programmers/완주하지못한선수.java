package programmers;

import java.util.HashMap;

public class 완주하지못한선수 {
	
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav","ana"};
		String[] completion= {"stanko", "ana","mislav"};
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < participant.length; i++) {
			if(map.get(participant[i]) == null) {
				map.put(participant[i], 1);
			}else {
				map.put(participant[i],map.get(participant[i])+1);
			}
		}
		
		for (int i = 0; i < completion.length; i++) {
			map.put(completion[i],map.get(completion[i])+1);
		}
		
		String ans = "";
		for (String string : map.keySet()) {
			if(map.get(string) %2 == 1) {
				ans = string;
			}
		}
		
		System.out.println(ans);
	}

}
