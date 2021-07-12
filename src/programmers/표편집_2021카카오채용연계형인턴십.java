package programmers;
import java.util.*;

public class 표편집_2021카카오채용연계형인턴십 {
	
	static Stack<Integer> st = new Stack<>();    
    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < cmd.length; i++) {
            int c = cmd[i].charAt(0);
            if(c == 'Z'){
                int idx = st.pop();
                n++;
                if(k >= idx) k++; 
            }else if(c == 'C'){
                st.push(k);
                n--;
                if(k == n) k -= 1;
            }else{
                int num = Integer.valueOf(cmd[i].substring(2));
                if(c == 'U') k -= num;
                else k += num;
            }
            
        }
        
        for(int i = 0; i < n; i++) {
            sb.append("O");
        }
        while(!st.isEmpty()){
            sb.insert(st.pop(),"X");
        }
        
        return sb.toString();
    }

}
