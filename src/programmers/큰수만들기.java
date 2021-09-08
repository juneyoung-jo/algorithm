package programmers;
import java.util.*;

public class 큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(number);


        int index = 0;
        // if(number.length() == 1 && k==1) return "";
        while(k-->0) {
            if(index == sb.length()-1) {
                sb.deleteCharAt(index);
                index--;
            } else if(index == 0) {
                if(sb.charAt(index) < sb.charAt(index+1)) {
                    sb.deleteCharAt(index);
                }else{
                    index++;
                    k++;
                }
            }else {
                if(sb.charAt(index) < sb.charAt(index+1)) {
                    sb.deleteCharAt(index);
                    index--;
                }else{
                    index++;
                    k++;
                }
            }

        }

        return sb.toString();

    }
}
