package programmers;
import java.util.*;

public class 순위검색_2021KAKAO_BLIND_REC {
    static Map<String,List<Integer>> map = new HashMap<>();
    static String[] language = {"-","cpp", "java", "python"};
    static String[] job = {"-","backend","frontend"};
    static String[] career = {"-","junior","senior"};
    static String[] food = {"-","chicken","pizza"};
    static int[] answer;
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        genKey();
        StringTokenizer st = null;

        for(String inf : info) {
            String[] infItem = inf.split(" ");
            map.get(infItem[0] + infItem[1] + infItem[2] + infItem[3])
                    .add(Integer.parseInt(infItem[4]));
        }

        map.forEach((key,value) -> Collections.sort(value));

        int index = 0;
        for(String q : query) {
            String[] queryItem = Arrays.stream(q.split("and")).map(String::trim).toArray(String[]::new);
            st = new StringTokenizer(queryItem[3]," ");
            queryItem[3] = st.nextToken();
            addValue(queryItem,Integer.parseInt(st.nextToken()),0,"",index);
            index++;
        }

        return answer;
    }

    public void addValue(String[] queryItem, int score, int idx, String q, int index){
        if(idx == 4) {
            List<Integer> list = map.get(q);
            int size = map.get(q).size();
            int start = 0;
            int end = size;
            while(start < end) {
                int mid = (start+end)/2;
                if(list.get(mid) < score) start = mid + 1;
                else end = mid;
            }
            answer[index] += size - start;
            return;
        }

        if(!queryItem[idx].equals("-")) addValue(queryItem, score, idx+1, q + queryItem[idx],index);
        else{
            for(int i = 1; i < 4; i++) {
                if(i == 3 && idx != 0) continue;
                if(idx == 0) addValue(queryItem, score, idx+1, q + language[i],index);
                else if(idx == 1) addValue(queryItem, score, idx+1, q + job[i],index);
                else if(idx == 2) addValue(queryItem, score, idx+1, q + career[i],index);
                else if(idx == 3) addValue(queryItem, score, idx+1, q + food[i],index);
            }
        }
    }

    public void genKey(){
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    for(int l = 0; l < 3; l++)
                        map.put(language[i] + job[j] + career[k] + food[l],new ArrayList<>());
    }
}
