package baekjoon;

import java.io.*;
import java.util.*;

public class 생태학_4356 {
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        for (; ; count++) {
            String name = br.readLine();
            if (name == null || name.isBlank()) break;
            map.merge(name, 1, Integer::sum);
        }

        map.keySet()
                .stream()
                .sorted()
                .forEach(k -> convertPercent(k, map.get(k)));

        System.out.println(sb);
    }

    public static void convertPercent(String key, Integer value) {
        sb.append(key + " " + String.format("%.4f", ((double) value / (double) count) * 100) + "\n");
    }

}
