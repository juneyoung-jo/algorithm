package softeer;


public class n_Q3 {
	
	static String s, t;
	static char[] ans;
	static int size, cnt, result;
	
	public static void main(String[] args) throws Exception {
		s = "aaaaabbbbb";
		t = "ab";
		ans = new char[s.length()];
		size = t.length();
		
		int idx = 0;
		for(int i = 0; i < s.length(); i++) {
			ans[idx] = s.charAt(i);
			if(cal(idx)) idx -= size;
			idx++;
		}
		
		System.out.println(result);		
		

	}

	private static boolean cal(int idx) {
		if(idx < size -1) return false;
		
		for(int i = 0; i < size; i++) {
			if(t.charAt(i) != ans[idx-size+1+i]) return false;
		}
		
		result++;
		return true;
	}

}
